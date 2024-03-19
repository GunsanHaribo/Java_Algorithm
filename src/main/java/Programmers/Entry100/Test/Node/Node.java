package Programmers.Entry100.Test.Node;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class Node {
    //BFS 패턴
    public static void main(String[] args) {

        int[][] test = {{3,6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int[] visit = new int[15];  //20005
//        int[][] BFS_lis = new int [7][7]; // add가 안되니 어레이 리스트로 할까

        ArrayList<ArrayList<Integer>> BFS_lis = new ArrayList<>();
        for(int i =0; i<7; i++){
            BFS_lis.add(i, new ArrayList<Integer>());
        }

        // 받은 이중리스트를 돌려서
        // 첫번쨰 두번째 보고 양쪽에 체크해준다
        // 인덱스가 1~6노드임
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i = 0; i< test.length  ;i++){
            BFS_lis.get(test[i][0]).add(test[i][1]);
            BFS_lis.get(test[i][1]).add(test[i][0]);
        }

        //for문 돌리는데
        //queue로 일단은 넣는데, 현재 visit number하고 같이 넣는다
        //그리고 마지막에 max해서 큰수 인덱스를 찾는다
        Queue<Memory> que = new LinkedList<>();

        //1번 노드를 넣는다
        //넣고 visit은 1로 바꾼다

        que.add(new Memory(1,0));
//        visit[1] = 1;

        while(!que.isEmpty()){
            Memory ele = que.poll();
            if(visit[ele.node] !=0) continue;
            visit[ele.node] = ele.visit_accel+1;

            for(Integer i : BFS_lis.get(ele.node)){
                if(visit[i]==0){
                    que.add(new Memory(i, ele.visit_accel+1));
                }
            }
        }

        //스트림 연산 친숙해지기
        for(int i : visit){
            System.out.print(i+" ");
        }

        System.out.println();
        OptionalInt maxV = Arrays.stream(visit).max();
//        System.out.println(max.);

        int  maxInt = maxV.getAsInt();;

        int count = (int) Arrays.stream(visit)
                .filter(h-> h ==maxInt).count();

        System.out.println(count);







    }
}

//생성자에는 class 안 붙인다
class Memory{
    int node;
    int visit_accel;

    public Memory(int node, int visit_accel){
        this.node = node;
        this.visit_accel = visit_accel;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "node=" + node +
                ", visit_accel=" + visit_accel +
                '}';
    }
}
