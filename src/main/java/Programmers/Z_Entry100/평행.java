package Programmers.Z_Entry100;

import java.util.ArrayList;
import java.util.List;

public class 평행 {

    //ab하면 ad 불가 남은걸로해야죔
    public static void main(String[] args) {

        // 실패가 나오는 이유가 뭐지?

//        int[][] kk = new int[][]
//                {new int[]{1,4}, new int[]{9,2}, new int[]{3,8}, new int[]{11,6}};

        int[][] kk = new int[][]
                {new int[]{3, 5}, new int[]{4, 1}, new int[]{2, 4}, new int[]{5, 10}};


        // 값을 순간적으로 저장해놓고 같은 값이 있는지 찾는다
        // 순간적으로 저장이 힘들다면 다른데 저장해놓고 같은값이 있는지 찾는다

        int result =0;

        // 아니 잠만 ;; -1 이 있네;;  아니 미안  기울기는 정수가 아닐 수 도 있네;;
        // 어레이에 넣어놓고 contain하면 버려
        List<Float> compare = new ArrayList<>();
        int xzero = 0;
        for(int i = 0; i<kk.length; i++){
           int x0 = kk[i][0];
           int y0 = kk[i][1];

            for(int j = i+1; j< kk.length; j++){
                int x1 = kk[j][0];
                int y1 = kk[j][1];

                int nonx = x1-x0;  //0 있는것 같기도 하고 -1 끼리하는건 괜찮잖아 00 0100의 경우도 기울기가 0 이긴하니
                // 기울기가 0인 경우도 생각해 보아야되지않나 그니깐 x값이 같을경우 y값이 같을 경우
                int nonY = y1-y0;

                if(nonx !=0) {
                     float middle_result = ((float) (y1 - y0) / (float) nonx);
                    if(compare.contains(middle_result)){
                        result=1;
                        break;
                    }else{
                        compare.add(middle_result);
                    }
                }else{
                    if(xzero==0) {
                        xzero = 1;
                    }else{
                        result = 1;
                        break;
                    }
                }



            }
            if(result ==1){
                break;
            }
        }

        System.out.println(result);





    }
}
