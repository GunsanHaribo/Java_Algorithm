package week11_Dynamic_Programming;

import java.io.*;

public class baekjoon_9095_1_2_3더하기 {
    static int[] arr_table;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max_number = Integer.parseInt(br.readLine());


        arr_table= new int[1_000_005];
        arr_table[1] = 1;
        arr_table[2] = 2;
        arr_table[3] = 4;

        for(int i=4; i<arr_table.length; i++){
            arr_table[i] = arr_table[i-1]+arr_table[i-2]+arr_table[i-3];
        }

        int input_value;
        for(int i=0; i<max_number; i++){
            input_value = Integer.parseInt(br.readLine());
            bw.append(String.valueOf(arr_table[input_value]));
            bw.append("\n");
        }

        bw.close();


    }

}
