package week14_TwoPointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_2230_수고르기 {
    // n번씩 이동해야함
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int array_maxnumber = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] input_array = new int[array_maxnumber];

        for(int i =0; i<array_maxnumber; i++){
            input_array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(input_array);
//        System.out.println(Arrays.toString(input_array));

        //start end 정하기
        //어떻게 움직일 것인가
        //이중 for문
        int answer  = Integer.MAX_VALUE;
//        for(int i =0; i< input_array.length; i++){
//            int start = i;
//            for(int j =start+1; j< input_array.length; j++){
////                System.out.print(i);
////                System.out.print(" "+j+"\n");
//                int end = j;
////                System.out.println(input_array[end] - input_array[start]);
//                if((input_array[end] - input_array[start]) >=m){
//                    answer = Math.min(answer, input_array[end] - input_array[start]);
//                }
//            }
//        }



        int start2 = 0;
        int end2 = start2;
        while(start2<input_array.length && end2 < input_array.length){
//            System.out.println("eeeeeeeeeeee");
            //합이 되지 않으면
            if(input_array[end2]-input_array[start2]<m){
                //작으면 전진
                end2++;// 이거 초기화 안시켜 줘도 되는가 보네
//                //전진하다 도달하면 끝낸다
//                System.out.println(start2);
//                System.out.println(end2);
            }else{
                answer = Math.min(answer, input_array[end2]-input_array[start2]);
                start2++;
            }


        }

        bw.append(answer+"");
        bw.close();

    }

}
