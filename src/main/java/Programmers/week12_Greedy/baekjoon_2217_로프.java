package Programmers.week12_Greedy;

import java.io.*;
import java.util.Arrays;

public class baekjoon_2217_로프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max_number = Integer.parseInt(br.readLine());
        int[] array = new int[max_number];

        for(int i=0; i<max_number; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

//        int max_weight = array[array.length-1];
        int max_weight = array[0];
        int weight;

        for(int i = array.length-1; i>=0; i--){
            weight = array[i]*(array.length -i);
            if(max_weight < weight){
                max_weight = weight;
            }
        }
        bw.append(String.valueOf(max_weight));
        bw.close();

    }
}
