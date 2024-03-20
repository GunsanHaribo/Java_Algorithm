package Programmers.A_Array.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 행렬의곱셈 {
    public static void main(String[] args) {
//        int[][] arr1 = new int[][]{{1,4}, {3,2}, {4,1}};
//        int[][] arr2 = new int[][]{{3,3}, {3,3}};

        int[][] arr1 = new int[][]{{2,3,2}, {4,2,4}, {3,1,4}};
        int[][] arr2 = new int[][]{{5,4,3}, {2,4,1},{3,1,1}};


        int[][] result = new int[arr1.length][arr2[0].length];

        // 더 내려 가야 되나? m까지?
        // n을 유지 해야 겠다
        for(int i  = 0; i< arr1.length; i++){
            for(int n = 0; n< arr1[i].length; n++){
                int value = 0;
                for(int j = 0; j< arr1[i].length; j++){
                    // int value 까지 하고 j는 같으니깐 그냥 진행하고  밖에서 n을 적용한다
                    int first = arr1[i][j] * arr2[j][n];
                    value += first;
                }
                result[i][n] = value;
            }

        }

        System.out.println(Arrays.deepToString(result));


    }
}
