package Programmers.E_정렬;

import java.util.Arrays;

public class K번쨰수 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,5,2,6,3,7,4};
        int[][] command = new int[][]{{2,5,3},{4,4,1},{1,7,3}};

        int[] answer = new int[command.length];


        for(int x = 0; x < command.length; x++){
            int i_index = command[x][0]-1;  // 첫번째부터 시작
            int j_index = command[x][1]-1;
            int k_index = command[x][2]-1; // k번쨰
            // 새로운 배열 만들기
            int[] new_arr = new int[j_index-i_index+1];


            // 배열에 넣고 정렬 후에 특정 위치 값 찾는다
            for(int z = i_index ; z <=j_index; z++){
                // 처음 부터 넣어야 된다
                new_arr[z-i_index] = arr[z];
            }

            Arrays.sort(new_arr);
            // 0,1,2  -> 1,2,3 k번쨰 숫자는 -1 해야한다
            answer[x] = new_arr[k_index];
        }

        System.out.println(Arrays.toString(answer));


    }
}
