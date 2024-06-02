package Programmers.네이버코테.I_자주등장하는자료구조.B그래프와트리.그래프.순위;


public class 순위_답지 {
    public static void main(String[] args) {
        int n = 5;
        boolean[][] graph = new boolean[n][n];
        int[][] results = new int[][]{{4,3},{4,2},{3,2},{1,2},{2,5}};

        for(int[] edge : results){
            int u = edge[0] -1;
            int v = edge[1] -1;
            graph[u][v] = true;
        }

        // 순위 정해긴거 count하기
        int count = 0;
        for(int u = 0; u<n ; u++){
            int wins = countForward(u, graph, new boolean[n]) -1;
            int losses = countBackward(u, graph, new boolean[n]) -1;
            if(wins + losses +1 == n){
                count++;
            }
        }

        System.out.println(count);
    }



    // 앞으로
    // 상태 :
    private static int countForward(int u, boolean[][] graph, boolean[] isVisited){
        int count = 1;

        // 여기서 리스트를 타고 들어간다
        for(int v = 0; v< graph.length; v++){
            if(!graph[u][v] || isVisited[v]) continue;  // 이거 어떻게하나?
            isVisited[v] = true;  // 방문했으면 true
            count += countForward(v, graph, isVisited);  // 일단 들어왔으면 진행 가능한 노드의 개수를 센다
        }
        return count;
    }


    // 뒤로 그니깐 1- > 5 이면
    // 5->1로 분석 열부터 시작해서 분석... 개꿀이네
    private static int countBackward(int u, boolean[][] graph, boolean[] isVisited){
        int count = 1;

        for(int v = 0; v< graph.length; v++){
            if(!graph[v][u] || isVisited[v]) continue;
            isVisited[v] = true;
            count += countBackward(v, graph, isVisited);
        }

        return  count;
    }


}
