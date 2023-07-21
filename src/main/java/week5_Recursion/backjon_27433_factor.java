package week5_Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjon_27433_factor {
    public static void main(String[] args) throws IOException {

        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        long number = Integer.parseInt(scanner.readLine());
        System.out.println(fibo(number));
    }

    //함수를 곱한다 n*f(n-1)
    //연역적 젇의
    //f(1) = 1을 리턴한다
    //f(k)일때 k*k-1*k-2*...*1를 출력한다, 그럼 f(k+1)일때 k+1이 곱해지고 k+1*k*k-1이 성랍한다
    //따라서 f(k)는 k부터 1까지 의 곱을 출력하는 함수이다
    public static long fibo(long newElement){
        //base condition
        //0이면 return 0하게
        if(newElement == 0){
            return 1;
        }
        System.out.println("인자값"+newElement);
        System.out.println();

        return newElement*fibo(newElement-1);
    }
}
