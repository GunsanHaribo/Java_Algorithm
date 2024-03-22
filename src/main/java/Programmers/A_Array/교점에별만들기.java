package Programmers.A_Array;

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
//
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
        // 여기서 좌표 만들떄 범위를 좀.. 잘설정해야 되는데...다음 값이 없으면 좀 숫자를 날린다 던가...


        // 좌표 설정을 cross y,x의 범위로 설정하자
        String[][] result = new String[2*max+1][2*max+1]; // 전체 배열 초기화 해야되는데
        //아마 max 1일때가 문제가 되는 듯한데 이게 좌표들은 다 맞는데 밑에 값들이 없으니깐
        //출력을 안하는게 맞긴하다.. 출력을 안하는 기준을 세우기가 애매하네

        for(String[] st : result){
            Arrays.fill(st, ".");
        }

        ArrayList<Integer> x_set = new ArrayList<>();
        ArrayList<Integer> y_set = new ArrayList<>();

        for(int[] i : crossPoint){
            int trans_x = i[0]+ max;
            x_set.add(trans_x);
            int trans_y = max - i[1];
            y_set.add(trans_y);
            result[trans_y][trans_x] = "*";
        }

        System.out.println(Arrays.deepToString(result));




        // 어레이 리스트에서 최솟값 찾는법
        int min_x = Collections.min(x_set);
        int max_x =Collections.max(x_set);

        int min_y=Collections.min(y_set);
        int max_y =Collections.max(y_set);

        // y의 범위만 넣어준다
        int interval_y = (max_y - min_y)+1;
        String[] finalResult = new String[interval_y];
        // 왜 안되지?

        StringBuilder sb;
        for(int i  = min_y; i<= max_y; i++){
            sb = new StringBuilder();
            for(int j = min_x; j<= max_x; j++){
                sb.append(result[i][j]);
            }
            finalResult[i] = sb.toString();
        }

        System.out.println(Arrays.deepToString(finalResult));
        // 처음부터 자르지 말고 x,y 범위에 맞는 배열만 출력합니다
//        [*.*, null, null]


    }


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




