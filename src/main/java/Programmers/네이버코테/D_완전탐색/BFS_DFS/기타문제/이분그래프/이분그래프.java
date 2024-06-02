package Programmers.네이버코테.D_완전탐색.BFS_DFS.기타문제.이분그래프;


// 정점 끼리는 서로 인접하지 안도록 => 이분 그래프
// 이분 그래프인지 아닌지 판변하는 프로그램을 작성하시오

// 요구사항 : 정점끼리 서로 인접하지 체크해라(이분 그래프인지 아닌지 판별하라)
// => 인접이 뭔데?, 인접의 기준이 뭔데?

// 독립변수 | 요구사항 => (정점의 집합) , (정점에 연결된 간선) | 정점이 간선으로 연결되어 있는지 체크한다

// 정점의 개수 V와 간선의 개수 E가 빈 칸을 사이에 두고 순서대로 주어진다
// 테스트 케이스 개수 k, 정점의 개수 , 산선의 개수

// 흐름 : 필요한 기능 찾기 - 인접행렬
// 1. 정점들을 2개의 집합으로 분할한다=> set으로 해서? 나올 수 있는 모든 경우의 수를 뽑아준다?= >
// 가능한 경우의 수를 어떻게 뽑아줄 것인다 1,2,3 있으면 12랑 , 3  1/ 23 이랑 다르잖아
// 근데 이거 완탐으로 하면 안될 것 같은데 일단 그러면 재귀로 돌리는데 set으로 만들어 놓고 있을까?
// 근데 3개의 조합을 보는게 아니라
// 2. 인접리스트를 통해서 서로 원소가 연결 되어있는지 체크한다 -> 그래프


import java.io.*;
import java.util.Arrays;

public class 이분그래프 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i< n; i++){
            String[] noed_line = br.readLine().split(" ");
            int node_number = Integer.parseInt(noed_line[0]);
            int line_number = Integer.parseInt(noed_line[1]);

            // 배열 만들어 준다   첫재행,렬은 편의를 위해서 비운다
            boolean[][] node_line_information = new boolean[node_number+1][node_number+1];
            for(boolean[] l :node_line_information ){
                Arrays.fill(l, false);
            }

            // 인접행렬 만들어준다
            for(int j =0; j< line_number; j++){
                String[] line_infomation = br.readLine().split(" ");
                int first_node = Integer.parseInt(line_infomation[0]);
                int second_node = Integer.parseInt(line_infomation[1]);
                node_line_information[first_node][second_node] = true;
                node_line_information[second_node][first_node] = true;
            }
            // 일단 인접행렬 잘 나옴
            for(boolean[] l :node_line_information ){
                System.out.println(Arrays.toString(l));
            }

            // 만든 후 이제 조합 쪼개고 쪼갠 조합에서 원소끼리 연결 되는지를 찾는다
            // 일단 완전 탐색은 시간 복잡도 초과 될 것 같고...그렇다면 인접행렬인데..
            // 재귀까지 사용할 필요가 있을까?

            // 조합을 구한 다음 근데 자르는걸 (1,3) (2,2) 이렇게 나눠서 해야되는데
            // 재귀로 어떻게 하게  1,2,3,4가 있으면
            // 1 -> 2,3,4   : 2 -> 1,3,4
            // n개 집합해서 k개를 뽑는다는 생각


            // 상태(n,k) : n개 집합에서 k개를 뽑는다, 거기서 k랑 n-k랑 비교해서 두개가 연결이 안되있는지 찾는다
            // 종료 : n==k거나  두집합이 간선이 없은 경우
            // 점화식 : k-> k+1

            // k를 뽑는 과정을 어떻게 할 것인가

        }




    }
    // 아니여 stack은 너무 길다
    // 다 연결 되어 있는가? - 인접한가 - 간선이 있는가
    // 그러면 간선이 없는건 어떻게 찾을 수 있는가(찾을 수는 있음)

    // 간선이 없는 경우만 뽑아볼까 간선을 끊을 방법이 있는가?
    // 간선이 있으면 찢고, 없으면  근데 node를 set으로 구성해서 중복 없애도록
    // 1,2,3 주어지면 완전 탐색을 통해서 가능한 조합을 만들기
    // 이건 아닌것 같다 간선이 없는 조합이 어딜 들어가기가 애매해

    // 그럼 1부터 해서 간선 없는 것만 합칠까?
    // 가능한 조합 구하기가 ㄹㅇ 너무빡셈
    // 123, 132, 213이렇게 구하는건 가능한데
    // 그리고 애초에 간선 없는데 2개 밖에 없고
    // 원소가 4개인데 3개가 연결되어있으면 아니잖아
    // 원소가 4개인데 2개만 연결되어있다고하면 가능인데
    // 3개인데 2개 연결되있는건 근데 가능한데? 근데 이건 한 원소가 고림된서 그러고
    // 갯수로 해야겠다

    //
    // 원소가
    public static void combination(int k, int[] set){

    }



}
