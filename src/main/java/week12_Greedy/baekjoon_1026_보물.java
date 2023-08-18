package week12_Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon_1026_보물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max_number = Integer.parseInt(br.readLine());
        int[] array_a = new int[max_number];
        int[] array_b = new int[max_number];

        int input;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int j =0; j<max_number; j++){
             array_a[j]= Integer.parseInt(st.nextToken());
        }

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int j =0; j<max_number; j++){
            array_b[j]= Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(array_a);
        Arrays.sort(array_b);
        int sum = 0;
        for(int i = 0; i<array_b.length; i++){
            sum += array_a[array_b.length-1-i] * array_b[i];
        }

        bw.append(String.valueOf(sum));
        bw.close();
    }
}
