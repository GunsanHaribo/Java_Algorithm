package Vacation.week5_Recursion;

import java.io.*;
import java.util.StringTokenizer;

public class backjon_1629_multiple {
    public static void main(String[] args) throws IOException {
        //이거 공식 어떻게 유도 되는지 알아야해
        //br bw st 무조건 쓰기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int value = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        int divide = Integer.parseInt(st.nextToken());


        bw.write(String.valueOf(multiple_q(value, time, divide)));
        bw.close();
    }


    // (value ^ 11) % 12
    // f(n) = a%c
    // n=1일때 f(1) = ?
    // n=k일떄
    //몇번 했는지는 상관이 없어
    //1 ,2~~~~
    public static long multiple_q(long value, long time, long divide){
        //base condition
        if(time==1){
            return value%divide;
        }
        long result = multiple_q(value,time/2,divide);
        result = result*result%divide;
        //짝수 나누기로
        if(time%2 == 0){
            return result;
        }
        //홀수
//        return ((result*result)*(value%divide))%divide;
        //value에서 divide 한번 더하면 안되는데 해서 틀렸다
        return  result*value%divide;
    }
}
