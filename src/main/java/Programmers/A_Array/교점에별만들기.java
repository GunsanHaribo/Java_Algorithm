package Programmers.A_Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;

public class 교점에별만들기 {


    public static void main(String[] args) {
        // 배열에 배열 넣어서 만든다
        int[][] lines = new int[5][5];

//        lines[0] = new int[]{2, -1, 4};
//        lines[1] = new int[]{-2, -1, 4};
//        lines[2] = new int[]{0, -1, 1};
//        lines[3] = new int[]{5, -8, -12};
//        lines[4] = new int[]{5, 8, 12};

        // 여기서 틀린다
        lines[0] = new int[]{0, 1, -1};
        lines[1] = new int[]{1, 0, -1};
        lines[2] = new int[]{1, 0, 1};

//        lines[0] = new int[]{1, -1, 0};
//        lines[1] = new int[]{2, 1, 0};
        List<int[]> crossPoint = getCrossPoint(lines);

//        System.out.println(Arrays.deepToString(crossPoint));
        for(int[] i : crossPoint){
            System.out.println("x좌표: " + i[0] + " y좌표: "+ i[1]);
        }
        // 교점 구하기 완료

        // fixNumericAmount
        // 최대 좌표에서 나누기 2를 하고  x좌표 = x+ max, y좌표 =  max  - (y)
        //이 max가 근데 절댓값 max인것 같은데;
        int max = 0;
        for(int[] i : crossPoint){
            for(int j : i){
                if(max < abs(j)){
                    max = abs(j);
                }
            }
        }
        System.out.println(max);

        // 좌표 구성  //[*.*, ..., ...]
        // 여기서 좌표 만들떄 범위를 좀.. 잘설정해야 되는데...다음 값이 없으면 좀 숫자르 날린다 던가...
        String[][] result = new String[2*max+1][2*max+1]; // 전체 배열 초기화 해야되는데
        //

        for(String[] st : result){
            Arrays.fill(st, ".");
        }

        for(int[] i : crossPoint){
            int trans_x = i[0]+ max;
            int trans_y = max - i[1] ;
            result[trans_y][trans_x] = "*";
        }

        System.out.println(Arrays.deepToString(result));

        String[] finalResult = new String[result.length];

        StringBuilder sb;
        for(int i  = 0; i< finalResult.length; i++){
            sb = new StringBuilder();
            for(int j = 0; j< finalResult.length; j++){
                sb.append(result[i][j]);
            }
            finalResult[i] = sb.toString();
        }

        System.out.println(Arrays.deepToString(finalResult));

    }
    // fixNumericAmount




    // 함수를 만들어서 교점 추출 리스트반환
    public static List<int[]>  getCrossPoint(int[][] lines){

        List<int[]> result = new ArrayList<>();

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
                        finalPoint[x] = (int) floatPoint[x];
                        finalPoint[y] = (int) floatPoint[y];

                        result.add(finalPoint);
                    }

                }

            }
        }

        return result;
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




