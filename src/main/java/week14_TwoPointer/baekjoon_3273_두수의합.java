package week14_TwoPointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_3273_두수의합 {

    //박스로 하는 풀이도 해보자
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max_capacity = Integer.parseInt(br.readLine());
        int[] d_arry = new int[max_capacity];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<max_capacity; i++){
            d_arry[i] = Integer.parseInt(st.nextToken());
        }
        int target_number = Integer.parseInt(br.readLine());

        Arrays.sort(d_arry);

        int start = 0;
        int end = d_arry.length-1;
        int count = 0;
        while(start<end){
            int sum = d_arry[start]+d_arry[end];
            if(sum == target_number){
                count++;
                end--;
            } else if (sum < target_number) {
                start++;
            }else{
                end--;
            }

        }

        bw.append(count+"");
        bw.close();

    }
}
