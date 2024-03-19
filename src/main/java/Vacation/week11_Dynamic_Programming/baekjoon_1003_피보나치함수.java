package Vacation.week11_Dynamic_Programming;

import java.io.*;

public class baekjoon_1003_피보나치함수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max_number = Integer.parseInt(br.readLine());
        int[][] d_arry = new int[45][2];
        //0
        d_arry[0][0] = 1;
        d_arry[0][1] = 0;
        //1
        d_arry[1][0] = 0;
        d_arry[1][1] = 1;

        //테이블 만들어 놓고 하기
        //잠만 이게 아닌것 같은데;;
        //for 2번 사용해야하나?
        //인자 받는 횟수
        for(int i=2; i<d_arry.length; i++){
            //횟수 하고 이제 다시 for문돌려야 될 듯한데
            d_arry[i][0] = d_arry[i-1][0] + d_arry[i-2][0];
            d_arry[i][1] = d_arry[i-1][1] + d_arry[i-2][1];
        }

        int input_number;
        for(int i = 0; i<max_number; i++){
            input_number = Integer.parseInt(br.readLine());
//            System.out.printf("&d %d %n",d_arry[input_number][0], d_arry[input_number][1]);
            bw.append(d_arry[input_number][0]+" ");
            bw.append(d_arry[input_number][1]+"\n");
        }

        bw.close();

    }
}
