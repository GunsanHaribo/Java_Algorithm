package week12_Greedy;

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_11047동전 {
    public static void main(String[] args) throws IOException {
        //문제를 읽어보고 greedy말고 다른 걸로도 풀 수 있지만
        //greedy로 빨리 풀 수 있지 않을까?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int coin_number = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int count =0;
        int[] coin = new int[coin_number];

        for(int i =0; i<coin.length; i++){
           coin[i] = Integer.parseInt(br.readLine());
        }

        //money가 안되는 값을 찾아야된다
        //그러고 찾으면 money값에서 빼주기
        while(money !=0){
            for(int i= coin.length-1; i>=1; i--){
                //조건 수정
                if(money>=coin[i]){
                    money=money-coin[i];
                    count+=1;
                    break;
                }

            }
        }

        bw.append(count+"");
        bw.close();

    }
}
