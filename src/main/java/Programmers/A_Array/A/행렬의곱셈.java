package Programmers.A_Array.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// 트라이 : 수많은 런타임 에러와 실패 예시들에는 맞는데

public class 행렬의곱셈 {
    public static void main(String[] args) {
//        int[][] arr1 = new int[][]{{1,4}, {3,2}, {4,1}};
//        int[][] arr2 = new int[][]{{3,3}, {3,3}};


        int[][] arr1 = new int[][]{{2,3,2}, {4,2,4}, {3,1,4}};
        int[][] arr2 = new int[][]{{5,4,3}, {2,4,1},{3,1,1}, {1,2,2}};

        int[][] result = new int[arr1.length][arr2[0].length];

        // for 문 3개로는 안되나? 되는데 이거 한번 쭉 써보고 어디가 어딘지
        //  대상(축)을 정확하게 해야된다
        for(int i  = 0; i< arr1.length; i++){
            for(int n = 0; n< arr2[0].length; n++){ //이게 2로 잡아내야 되는데 어떻게 하지?
                int value = 0;
                for(int j = 0; j< arr1[0].length; j++){
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
