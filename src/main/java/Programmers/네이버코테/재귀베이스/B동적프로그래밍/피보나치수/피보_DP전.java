package Programmers.네이버코테.재귀베이스.B동적프로그래밍.피보나치수;

public class 피보_DP전 {

    private static int calls = 0;
    public static void main(String[] args) {
        long fibonacci = fibonacci(10);
        System.out.println(fibonacci);
        System.out.println("호출수:"+ calls);
    }

    private static long fibonacci(int n){
        calls++;

        if(n == 0 || n==1) return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}
