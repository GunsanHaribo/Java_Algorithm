package Programmers.오토에버시험대비_구현.A_Array.교점에별만들기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.lang.Math.abs;



public class 교점에별만들기 {


    public static void main(String[] args) {
        // 배열에 배열 넣어서 만든다
        int[][] lines = new int[5][5];

        lines[0] = new int[]{2, -1, 4};
        lines[1] = new int[]{-2, -1, 4};
        lines[2] = new int[]{0, -1, 1};
        lines[3] = new int[]{5, -8, -12};
        lines[4] = new int[]{5, 8, 12};

        // 여기서 틀린다
//        lines[0] = new int[]{0, 1, -1};
//        lines[1] = new int[]{1, 0, -1};
//        lines[2] = new int[]{1, 0, 1};

//        lines[0] = new int[]{1, -1, 0};  //
//        lines[1] = new int[]{2, 1, 0};
        List<List<Integer>> crossPoint = getCrossPoint(lines);

//        System.out.println(Arrays.deepToString(crossPoint));
//        for(int[] i : crossPoint){
//            System.out.println("x좌표: " + i[0] + " y좌표: "+ i[1]);
//        }

        for(int i= 0; i<crossPoint.get(0).size(); i++){
            System.out.println("x좌표: " + crossPoint.get(0).get(i)+ " y좌표: "+ crossPoint.get(1).get(i));
        }

        // 여기서 왜 max를 왜 구하는거지?? 그냥 바로 가면 안되나??
        // 여기서  최댓값을 한번에 구해야된다
//        int max = 0;
//        for(int[] i : crossPoint){
//            for(int j : i){
//                if(max < abs(j)){
//                    max = abs(j);
//                }
//            }
//        }
//        System.out.println(max);
        // 좌표 설정을 cross y,x의 범위로 설정하자 => 죄표 설정을  딱맞춰서 할 필요가있다
        List<Integer> x_set = crossPoint.get(0);
        List<Integer> y_set = crossPoint.get(1);

        // 이거 떄문에 그런가?
        int min_x = Collections.min(x_set);
        int max_x = Collections.max(x_set);

        int min_y= Collections.min(y_set);
        int max_y = Collections.max(y_set);

        // 여기서 한번에 max 값을 해야되는데
        int interval_x = (max_x - min_x)+1;
        int interval_y =(max_y - min_y)+1;

        // 이것도 이중배열말고 한번에 스트링으로
        String[][] result = new String[interval_y][interval_x]; // 전체 배열 초기화 해야되는데

        // 두번 도는것 같은데.. 이거 뭔데
        for(String[] st : result){
            Arrays.fill(st, ".");
        }

        for(int  i =0; i< x_set.size(); i++){
            int trans_x = x_set.get(i) + max_x;
            int trans_y = max_y - y_set.get(i);
            result[trans_y][trans_x] = "*";
        }

        System.out.println(Arrays.deepToString(result));

//        // 이제 벼열을 하나의 좌표로 해서 보내야 되는데 이제 배열만 뽑아내면 된다
        String[] finalResult = new String[interval_y];

        // 왜 안되지?
        StringBuilder sb;
        for(int i  = 0; i < interval_y; i++){
            sb = new StringBuilder();
            for(int j = 0; j < interval_x; j++){
                sb.append(result[i][j]);
            }
            finalResult[i] = sb.toString();
        }

        System.out.println(Arrays.deepToString(finalResult));
//        // 처음부터 자르지 말고 x,y 범위에 맞는 배열만 출력합니다
    }


    // x, y로 쪼개서 반환 리스트로 반환
    public static List<List<Integer>>  getCrossPoint(int[][] lines){

        List<Integer> cross_X = new ArrayList<>();
        List<Integer> cross_Y = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();


        for(int nowline=0; nowline< lines.length-1; nowline++){
            for(int nextLine = nowline+1; nextLine < lines.length; nextLine++){
                // 교점을 구한다
                int A = lines[nowline][0];
                int B = lines[nowline][1];
                int E = lines[nowline][2];

                int C = lines[nextLine][0];
                int D = lines[nextLine][1];
                int F = lines[nextLine][2];

                float low = (A*D- B*C);
                float x_top = B*F - E*D;
                float y_top = E*C - A*F;

                float[] floatPoint  = new float[2];
                int[] finalPoint = new int[2];


                int x =0;
                int y = 1;
                if(low == 0){
                    continue;
                }else {
                    floatPoint[x] = x_top / low;
                    floatPoint[y] = y_top / low;
                    boolean checkInt = checkPointInt(floatPoint[x], floatPoint[y]);
                    if(checkInt){
                        cross_X.add((int) floatPoint[x]);
                        cross_Y.add((int) floatPoint[y]);
                    }

                }

            }
            // 쌍으로 내지말고 x는x y는 y로 계산
        }

        result.add(cross_X);
        result.add(cross_Y);

        return   result;
    }

    // 의문 1. static 이거 밖에하면 안되는이유 찾아야됩니다
    // 의문 cs. 만약에 int float이랑 크기 차이가 나면 => 근데 아마 1.0 이랑 1이랑 cs 때문에 다르게 찍힐 것 같은데
    public static boolean checkPointInt(float x , float y){
        boolean check = true;

        int x1 = (int) x;

        int y1 = (int) y;

        if(x != x1 || y1 != y){
            check = false;
        }

        return check;
    }

}




