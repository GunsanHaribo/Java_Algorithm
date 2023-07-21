package week5_Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Recursion_basic_이런식으로안된다 {
    public static void main(String[] args) throws IOException {
        Recursion_Print(20);
        System.out.println("합계");

        BufferedReader st = new BufferedReader(new InputStreamReader(System.in));
        int until = Integer.parseInt(st.readLine());
        Recursion_Sum(1,until,0);

    }
    public static int Recursion_Print(int Element){
        if(Element ==0){
            return 0;
        }
        System.out.println(Element);

        return Recursion_Print(Element-1);
    }

    public static int Recursion_Sum(int newElement, int until, int sum){
        //basecondition
        if(newElement ==until+1){
            System.out.println(sum);
            return 0;
        }
        //함수정의
        sum+=newElement;
        //재귀
        return Recursion_Sum(newElement+1, until, sum);
        // n + f(n)로 해보자
        //콜스택이 어떻게 구성될지 생각해보자 ==> 절차적
    }
}
