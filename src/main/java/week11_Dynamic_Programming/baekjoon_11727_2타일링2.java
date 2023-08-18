package week11_Dynamic_Programming;

import java.io.*;

public class baekjoon_11727_2타일링2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        //d[i]는 테이블을 만드는 방법의수
        //d[i] = (d[i-1] + d[i-2]*2)%10_007
        //초기값 i=1 =>1 i=2 =>3
        int d_arry[] = new int[1_005];

        d_arry[1] = 1;
        d_arry[2] = 3;
        for(int i=3; i<d_arry.length; i++){
            d_arry[i] = (d_arry[i-1] + d_arry[i-2]*2)%10_007;
        }



        int input_number = Integer.parseInt(br.readLine());

        bw.append(d_arry[input_number]+"");
        bw.close();

    }
}
