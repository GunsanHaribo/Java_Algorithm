package Programmers.네이버코테.G_해시.평행.평행_202405;

import java.util.ArrayList;
import java.util.List;

public class 평행_해시안쓰고 {
    public static void main(String[] args) {
        int result =0;
        int[][] dots = new int[][]{{1, 4}, {9, 2}, {3, 8}, {11, 6}};

        // 아니 잠만 ;; -1 이 있네;;  아니 미안  기울기는 정수가 아닐 수 도 있네;;
        // 어레이에 넣어놓고 contain하면 버려
        List<Float> compare = new ArrayList<>();
        int xzero = 0;
        for(int i = 0; i< dots.length; i++){
            int x0 = dots[i][0];
            int y0 = dots[i][1];

            for(int j = i+1; j< dots.length; j++){
                int x1 = dots[j][0];
                int y1 = dots[j][1];

                int non0 = x1-x0;
                if(non0 !=0) {
                    float middle_result = ((float) (y1 - y0) / (float) non0);
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
