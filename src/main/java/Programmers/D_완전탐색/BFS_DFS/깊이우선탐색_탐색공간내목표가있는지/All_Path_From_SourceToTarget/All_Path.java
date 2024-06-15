package Programmers.D_완전탐색.BFS_DFS.깊이우선탐색_탐색공간내목표가있는지.All_Path_From_SourceToTarget;


// 요구사항 : 그래프를 통해서 이동할 수 없는 곳까지 이동한 뒤에 경로를 반환해라
// 변수 : 노드 그래프

// 흐름 : DFS 사용, Stack 사용 ->그니깐 상태별로 가지고 있는 path 기록이 있었으면 좋겠다
// 1. 해당 인덱스에서 이동할 수 있는 곳 스택에 넣는다
// 2. 스택에서 꺼내면서 방문했는지 체크
// 3. 안했으면 스택에 넣어주기
// 4. 만약 해당 인덱스에서 갈 곳이 없으면 종료하고, 결과를 리스트에 넣어둔다
// 5. 경로 중복은 지금 내생각에는 발생할 수 있는 방법이 없다 -> 중복되는건 스킵



// 이게참... 적긴 적는데... 맞았다고 하기가 조금 힘든데

import java.util.ArrayList;
import java.util.Stack;

public class All_Path {
    public static void main(String[] args) {
//        int[][] graph = new int[][]{{1,2},{3},{3},{}};

        int[][] graph   = new int[][]{{4,3,1},{3,2,4},{3},{4},{}};
        // 0으로 들어가서 그렇구나
        // 그럼 비어이쓰
        //  아.. 이게 초기화가... 0 으로되니깐 채워진걸로 인식을해버리네...
        // 그럼 빈거 -1로 다 바꿔야 되는데....

        Stack<State> st = new Stack<>();
        boolean[] visit = new boolean[graph.length];

        // State를 리스트로 다뤄야 되나? 근데 이건 왜 안되는거?
        st.add(new State(0));
        visit[0] = true;


        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        while(!st.isEmpty()){
            State state = st.pop();

            int length = state.VisitRecord.size();

            int current_node = state.VisitRecord.get(length-1);
            int graph_possible_pathSize = graph[current_node].length;


            if(current_node == graph.length-1){
//                System.out.println("들어옴, 초기화는 0으로 되지만  ");
                answer.add(state.VisitRecord);
            }

            // current_node
            for(int i =0; i< graph_possible_pathSize; i++){
                int next_node = graph[current_node][i];
                System.out.print("c_node:"+current_node+" "+ "n_node:"+next_node+
                        " possible_pathSize:"+graph_possible_pathSize+"  ");

//                if(visit[next_node]){
//                    // 여기서
//                    // 3을 visit한걸로 처리해서 갈 수가 없음
//                    continue;
//                }
//
//                visit[next_node] = true;

                // visit이 필요없는 이유가 있나?

                //상태 전이할떄 이렇게 하면 ㅈ됌, 숫자만 따로 넣는다던가.. 이건 좀
                // 아.. 그냥 리스트만 넣는게 맞았는듯
                ArrayList<Integer> ne = new ArrayList<>(state.VisitRecord);

                ne.add(next_node);
                st.add(new State(ne));
            }


            // 갈 수 있는거 넣는다
            System.out.println();
        }


        System.out.println(answer.size());
        for(int i =0; i < answer.size(); i++){
            System.out.println( answer.get(i));
        }


    }


    // 새로운 상태로 갈때 새로객체를 만들어줘야된다
    public static class State{
        ArrayList<Integer> VisitRecord  = new ArrayList<>();

        public State(int  visit_nodeNumber) {
            VisitRecord.add(visit_nodeNumber);
        }

        // 리스트에 addALL 해줘야됨
        public State(ArrayList<Integer>  visit_nodeNumber) {
            VisitRecord.addAll(visit_nodeNumber);
        }

    }


}
