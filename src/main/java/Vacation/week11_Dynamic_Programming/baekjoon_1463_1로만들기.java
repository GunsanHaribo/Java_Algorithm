package Vacation.week11_Dynamic_Programming;

import java.io.*;

import static java.lang.Math.min;

public class baekjoon_1463_1로만들기 {

    //BFS로도 풀수 있으나 DP로 풀어보자
    static int[] arr_table;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max_number = Integer.parseInt(br.readLine());

        arr_table= new int[1_000_005];
        arr_table[1] = 0;

        for(int i=2; i< arr_table.length; i++){
            arr_table[i] = arr_table[i-1] +1;
            if(i%3 ==0){
                arr_table[i] = min(arr_table[i], arr_table[i / 3] + 1);
            }if(i%2 ==0){
                arr_table[i] = min(arr_table[i], arr_table[i / 2] + 1);
            }
        }

        bw.append(String.valueOf(arr_table[max_number]));
        bw.close();
    }

}
