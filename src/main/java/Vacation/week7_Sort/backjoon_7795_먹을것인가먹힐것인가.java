package Vacation.week7_Sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon_7795_먹을것인가먹힐것인가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int test_max_number = Integer.parseInt(br.readLine());
        String set_max_number;

        int[] first_set;
        int first_set_max;
        int[] second_set;
        int second_set_max;
        int count;

        for(int i =0; i<test_max_number; i++){
            count=0;
            set_max_number = br.readLine();
            st = new StringTokenizer(set_max_number);

            first_set_max = Integer.parseInt(st.nextToken());
            first_set = new int[first_set_max];

            for(int j = 0; j<Integer.parseInt(st.nextToken()); j++){
                st = new StringTokenizer(set_max_number);
                //여기 수정해야함
                first_set[j] = Integer.parseInt(br.readLine());
            }

            second_set_max = Integer.parseInt(st.nextToken());
            second_set = new int[second_set_max];

            for(int k = 0; k<Integer.parseInt(st.nextToken()); k++){
                second_set[k] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(first_set);
            Arrays.sort(second_set);

            //first 마지막이랑 second 마지막이랑 비교
            //1대1로 계속 비교하면 시간 초과
//            for(int p = 0; p<first_set.length; p++){
//                for(int k=0; k<second_set_max-1; k++){
//                    if(first_set[i]>second_set[i]){
//                        count+=1;
//                    }
//                }
//            }

            //같으면 다음걸로 넘어 가게 커팅하도록


        }



    }
}
