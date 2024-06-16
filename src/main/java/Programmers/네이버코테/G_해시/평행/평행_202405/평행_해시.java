package Programmers.네이버코테.G_해시.평행.평행_202405;

// 요구사항 : 두 직선이 평행이 되는 경우 구하기
//
// 독립변수 | 요구사항 =  x,y 좌표, 를 통해서 기울기가 0이 되는 두 직선을 구하자
// 흐름
// 1. 탐색ㅇ르 하면서 구한다 -> 이거 맞는데? 근데 이게 왜 hash?
// 2.

import java.util.HashSet;
import java.util.Set;

public class 평행_해시 {
    public static void main(String[] args) {
        int[][] dots = new int[][]{{1,4}, {9,2}, {3,8}, {11,6}};

        // 할수 잇ㅆ는데 ㅗ치선은 아닌것같고

        System.out.println(sol(dots));

    }

    public static double getSlope(int x1, int y1, int x2, int y2){
        return (double) (y2-y1)/ (x2-x1);
    }

    public static int sol(int[][] dots){
        Set<Double> slopes = new HashSet<>();
        for(int i=0; i< dots.length; i++){
            for(int j = i+1; j< dots.length; j++){
                double slope = getSlope(dots[i][0], dots[i][1], dots[j][0], dots[j][1]);

                // 같은 거 나오면 1반환
                if(slopes.contains(slope)){
                    return 1;
                }
                slopes.add(slope);
            }
        }

        return 0;
    }

}
