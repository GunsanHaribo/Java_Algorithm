package Programmers.구현미친듯이풀기.재귀베이스.B동적프로그래밍.등굣길_중요;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 등굣길_DFS {

    // 오른쪽, 아래쪽
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};

    public static void main(String[] args) {
        int m  =4;  // x최대
        int n = 3; // y최대

        int[][] puddles = new int[][]{{2,2}};

        XY_VisitCOUNT xyvc = new XY_VisitCOUNT(1,1,0);
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


    // 과연 int일까 반환값이
    public static void find_result(XY_VisitCOUNT xyvc, int[][] puddles , int max_x, int max_y, List<Integer> visit_record){
        // 웅덩이 일떄 => 이거 for문 돌려야 된다
        // 웅덩이가 하나가 아닐 수도
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

        // 학교도착
        if((xyvc.x == max_x) && (xyvc.y == max_y)){
            System.out.println("목적지 도착해버림");
            System.out.println("도착 x:"+ xyvc.x + "도착 y:"+ xyvc.y);
            System.out.println();
            visit_record.add(xyvc.visitCount);
            return;
        }

        // 좌표, visit count  바꿔서 넣어준다
        for(int i=0; i< 2; i++){
            // 이게 살짝 쓰읍.. 같은 걸 넣어주면 안되고 새로 생성해서 넣어주는게 주소가 안이어지게 해서 괜찮을듯
            // 이래 했는데 왜 발작하냐
            XY_VisitCOUNT xyvc_copy = new XY_VisitCOUNT(xyvc);
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

        public XY_VisitCOUNT(XY_VisitCOUNT xyvc2){
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


