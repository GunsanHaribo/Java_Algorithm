package week6_BackTracking;

import java.io.*;
import java.util.StringTokenizer;
//n과 m에서  m의 갯수만 증가 하면 되는거 아닌가
//n뽑는거랑 m개 뽑는거 + 횟수
public class backjoon_1182_부분수열 {
    static boolean[] isUsed;
    static int[] save_arr;
    static int[] box_arr;
    static int wish_sum;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        int max_arr = Integer.parseInt(st.nextToken());
        wish_sum = Integer.parseInt(st.nextToken());

        box_arr = new int[max_arr+1]; // 6이 맞긴 한데 0 1 2 3 4 5 여서 1~5만 떼가 볼까

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 1; i<=max_arr; i++){
            box_arr[i]= Integer.parseInt(st2.nextToken());
//            System.out.println("입력");
        }
//        System.out.println(Arrays.toString(box_arr));


        save_arr = new int[max_arr];
        isUsed = new boolean[max_arr+1];

        for(int i=1; i<=max_arr; i++){
            Part(0,0,i);
        }

//        bw.close();
        System.out.println(count);
    }



    public static void Part(int k, int pre, int max) throws IOException {
        if(k == max){
            int sum=0;
            for(int j =0; j<max; j++){
//                System.out.println("dfddf");
//                bw.append(String.valueOf(save_arr[j])).append(" ");
                sum+=save_arr[j];
            }
//            bw.append('\n');
            if(sum==wish_sum){
                count+=1;
            }
            return;
        }


        for(int i = 1; i<box_arr.length; i++) {

            if(i<pre){continue;}

            if(!isUsed[i]){
//                System.out.println(i);
                save_arr[k] = box_arr[i]; //저장된 배열 출력
                isUsed[i] = true;
                Part(k+1,i,max);
                isUsed[i] = false;
            }
        }

    }


}
