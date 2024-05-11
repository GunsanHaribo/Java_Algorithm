package Programmers.오토에버시험대비.재귀베이스.B동적프로그래밍.등굣길_중요;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 등굣길_DP적용어려움_DFS로풀어서 {

    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    // DP 적용 어려움, visit_count로 1씩 증가시키면서 계산해서
    static int[][] possibleCourse_mem = new int[501][501];
    // 아니 그.. 가능한 경로를 어떻게 알아 미친놈아 이게 언제 끝나는지 어떻게 알아 재귀 탈출하면 끝나겠지 임마
    // 재귀로 하면 알 수 있나?

    // count를 안하고.. 아닌데 이러면 이상한데;; 호출을 2번 하긴하는데
    // 이게 같은 좌표가 호출이 된다고해서 같은 경우의 수(경로)를 가지고 있진 않은데....
    // (2,1) -> (2, 2)
    // (1,2) -> (2, 2)  (2,2)에서 가질 수 있는 모든 경로의 경우의 수를 저장해야된다
    // 그렇게 해야될까?, 근데 문제에서 요구하는거랑 DP랑
    public static void main(String[] args) {
        // mem 채우기
        for(int[] k: possibleCourse_mem){
            Arrays.fill(k, -1);
        }

        int m  =4;  // x최대
        int n = 3; // y최대

        int[][] puddles = new int[][]{{2,2}};

        등굣길_DFS.XY_VisitCOUNT xyvc = new 등굣길_DFS.XY_VisitCOUNT(1,1,0);
        ArrayList<Integer> visit_record = new ArrayList<>();
        find_result(xyvc,puddles, m, n, visit_record);

//        int min = Integer.MAX_VALUE;
        System.out.println(visit_record);

        int min  = Collections.min(visit_record); // 없어버리면

        int min_count = 0;
        for(int k : visit_record){
            if(min == k){
                min_count++;
            }
        }
        // 1000000007 로 나눠야된다
        System.out.println(min_count);
    }



    public static void find_result(등굣길_DFS.XY_VisitCOUNT xyvc, int[][] puddles , int max_x, int max_y, List<Integer> visit_record){


//        if(possibleCourse_mem[xyvc.y][xyvc.x] != -1 ) return possibleCourse_mem[xyvc.y][xyvc.x]

        // 웅덩이 일떄 => 이거 for문 돌려야 된다
        // 웅덩이가 하나가 아닐 수도

        // 답지에서는 이거 boolean으로 반환했는데 좋더라고 특정좌표입력시 웅덩이인지 바로 찾을 수 있게해서
        for(int[] puddle : puddles){
            int p_x = puddle[0];
            int p_y = puddle[1];

            if((p_x == xyvc.x) && (p_y == xyvc.y)){
                System.out.println("puddle x:"+ xyvc.x + " puddle y:"+ xyvc.y);
                System.out.println("puddle에 걸려버림 ");
                System.out.println();
                return;
            }
        }

        // 학교 이탈
        if(xyvc.x >max_x || xyvc.y > max_y) {
            // 학교 도착하면
            System.out.println("이탈해버림");
            System.out.println("이탈자 x:"+ xyvc.x + "이탈자 y:"+ xyvc.y);
            System.out.println();
            return;
            // 이탈하면 끝내고
        }

        // 학교도착 // 아 시발 먼가 잘못된 것 같은데
        if((xyvc.x == max_x) && (xyvc.y == max_y)){
            System.out.println("목적지 도착해버림");
            System.out.println("도착 x:"+ xyvc.x + "도착 y:"+ xyvc.y);
            System.out.println();
            visit_record.add(xyvc.visitCount);
            return;
        }

        // 좌표, visit count  바꿔서 넣어준다
        // 이걸 변수에 넣었어야 되나
        // 근데 count 올리면서 구하니깐 mem 쓸 곳이 안보이긴함
        for(int i=0; i< 2; i++){
            // 이게 살짝 쓰읍.. 같은 걸 넣어주면 안되고 새로 생성해서 넣어주는게 주소가 안이어지게 해서 괜찮을듯
            // 이래 했는데 왜 발작하냐
            등굣길_DFS.XY_VisitCOUNT xyvc_copy = new 등굣길_DFS.XY_VisitCOUNT(xyvc);
            xyvc_copy.x += dx[i];
            xyvc_copy.y += dy[i];
            xyvc_copy.visitCount++;

//            System.out.println(xyvc_copy.toString());
            find_result(xyvc_copy, puddles, max_x, max_y, visit_record);
        }


    }

    public static class XY_VisitCOUNT{
        int x;
        int y;
        int visitCount;

        public XY_VisitCOUNT(int x, int y, int visitCount){
            this.x = x;
            this.y = y;
            this.visitCount = visitCount;
        }

        public XY_VisitCOUNT(등굣길_DFS.XY_VisitCOUNT xyvc2){
            this.x = xyvc2.x;
            this.y = xyvc2.y;
            this.visitCount = xyvc2.visitCount;
        }

        @Override
        public String toString() {
            return "x: "+ x+ "y:"+y;
        }
    }


}
