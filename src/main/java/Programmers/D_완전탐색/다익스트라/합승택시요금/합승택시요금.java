package Programmers.D_완전탐색.다익스트라.합승택시요금;

// 요구사항 : 합습 여부를 고려해서 A,B의 전체 택시 요금을 구하여라
// 무지, 어피치 택시 합승 적절히 하면 얼마나 택시 요금 아낄 수 있어?
// 아낄 수 있으면 같이 타자~
// 변수 : 노드, 노드 각각의 간선(고정됨), 출발 지점 S, 도착지점 A,B

// 그럼 어떨때 분리가 되는거지?
// 이게 최소최소최소를 선택하면 당연히 최소가 되는게 맞는데...
// B까지의 최소가 뭔지 어떻게 알아 마냥 최소만 찾다가 이상한 곳으로 빠질 수 있음
// -> 이게 후보 3개가있으면 다른 노드로 갔을떄 도착지까지의 비용을 미리 계산해야됨

// 근데 그러면 모든 경우의 수를 다 계산 해줘야 되는데 이거 어떻게하지? -> 약간 충분히 비 효율적 일 수 있기 떄문에
// 이게 타고 들어가면서 B가 있으면 등록을 하는 형식인데... 좋지 않다


// 흐름 :
// 1. 일단 노드를 어느정도 이을 필요가 있다 -> 인접리스트로가자

// 2. 다익스트라 구현
// 2-1. 최소 비용 저장할 배열 -> dist
// 2-2. 우선 순위 큐로 최소 가중치 가지는 노드를 뽑는다 -> PriorityQueue
// 2-3. 우선순위 큐가 비지 않을때 까지 -> while(pq)
// 2-3-1. 최단 거리가 가장 짧은 노드 꺼내기 -> PriorityQueue
// 2-3-2. 이미 방문한 노드면 건너뛴다 => 방문한 노드면 이미 처리했으니깐 최소를 구했으니깐 건너뛴다 -> w 거리계산
// 2-3-3. 인접 노드 탐색 -> 더 짧은 경로 발견한 경우 거리 업데이트, 우선순위 큐에 추가

// 3. 최단거리 반환 -> 어떻게 최댄 거리를 반환하지? 목적지의 인덱스 반환하면 된다,, 근데 여기서는

// 근데 여기서 2개 잖아
// 가면서는 못할 것 같고 A,B 따로 구해서 겹치는 부분이 있으면 비용 구할때 공통된 부분은 뺴줍니다
// (A, B) - 공통된 부분 => path를 리턴해야된다 Path는 일단 배열인데..

// 야이걸 어떻게 디버깅하냐?
// ㄹㅇ 고통인데

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 합승택시요금 {
    public static void main(String[] args) {

        int n =6;
        int a = 6;
        int b =2;
        int s = 4;
        int[][] fares = new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41},
                {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        // 그래프 만들기


        List<List<Node_vector>> graph = new ArrayList<>();

        for(int i = 0; i<=n ; i++){
            graph.add(new ArrayList<>());
        }

        // 배열 보다는 리스트가 맞고요 이유는 내가 일일이 넣기 싫어서요
        for(int i = 1; i<=n ; i++){
            for(int[] f: fares){
                // 앞에 넣는다
                if(f[0] ==i){
                    graph.get(f[0]).add(new Node_vector(f[1], f[2]));
                }
                // 뒤에 넣는다
                if(f[1] ==i){
                    graph.get(f[1]).add(new Node_vector(f[0], f[2]));
                }

            }
        }

        for(List<Node_vector> NL : graph){
            for(Node_vector NV : NL){
                System.out.print(NV +" ");
            }
            System.out.println();

        }


        // 이거 뭐지?
        int[] A_dist_min_cost = new int[graph.size()];
        int[] B_dist_min_cost =  new int[graph.size()];

        int[] A_PATH = Dijkstra(graph, A_dist_min_cost, s);
        int[] B_PATH = Dijkstra(graph, B_dist_min_cost, s);

        String B_PATH_s = "";
        String A_PATH_s = "";
        // 공통된 부분이 있으면


    }

    // 이것까지만 하고 다시 내일 하자
    // 재귀로 들어가야 되는데?
    // DFS로? 최대 깊이 정해져 있고
    // 그대로 들어가면 되겠네 // 아님 다른 자료 구조 있나?
    // 이것 경로 구하는 것도 다시해야됨
    public static String calculate_PATH(int Start, int End, int[] PATH){
        // 갈 수 있는거 구한다 -> End에서 부터 Start까지 갈 수 있는거 반환,  그니깐 연결이 되있어야된다
        // 이걸 어떻게 알지
        // 4부터 들어가는데

        // 반복문으로 돌려야 되나? 해서 멈췄는데 End가 아니면 버린다?

        /// 아니면 리스트 받아놓고
        // 3에서 갈 수 있는


        return " ";
    }


    // 목적지가 없는데?...? 그럼뭐 4까지만 하냐? 이건 아니잖아
    // 이거 모든 노드의 최단 거리를 구하는 거 아닌가? 이렇게 하면?
    // 이거 모든 경우의 수 구하는거임
    public static int[] Dijkstra(List<List<Node_vector>> graph,  int[] dist_min_cost, int Start){
        //
        int[] Path = new int[graph.size()]; // => 출발해서 도착한 것 까지 저장
//        dist_min_cost = new int[graph.length];

        for(int i = 0; i< graph.size(); i++ ){
            dist_min_cost[i] = Integer.MAX_VALUE;
        }
        // 시작노드
        dist_min_cost[Start] = 0;
        PriorityQueue<Node_vector> pq = new PriorityQueue<>((v1,v2) -> v1.line_cost - v2.line_cost);


        while(!pq.isEmpty()){
            Node_vector pq_poll =  pq.poll();
            int node = pq_poll.number;
            int line_cost = pq_poll.line_cost;

            // 작으먄 이전에 탐색한거.. 안작으면 다시 해야 될 수도? -> 다시하는게
            if(dist_min_cost[node] < line_cost) continue; // 재방문 할 수도 있는거 아닌가?

            // 탐색
            for(int i = 0; i<graph.size(); i++ ){
                for(Node_vector n : graph.get(i)){
                    int next_v =  n.number;
                    int next_w =  n.line_cost;

                    if(line_cost+next_w<dist_min_cost[next_v]){
                        dist_min_cost[next_v] = line_cost+next_w;
                        pq.add(new Node_vector(next_v, dist_min_cost[next_v]));
                        Path[next_v] = node;
                    }

                }
            }

        }
        return Path;
    }

    public static class Node_vector{
        int number ;
        int line_cost ;

        public Node_vector(int number, int line_cost) {
            this.number = number;
            this.line_cost = line_cost;
        }

        @Override
        public String toString() {
            return "Node_vector{" +
                    "number=" + number +
                    ", line_cost=" + line_cost +
                    '}';
        }
    }


}
