package Programmers.네이버코테.재귀베이스.B동적프로그래밍.피보나치수;

import java.util.Arrays;

public class 피보나치수_DP후 {

    private static int calls = 0;
    private static int calls2 = 0;
    private static final long[] mem = new long[101];
    private static final long[] mem2 = new long[101];

    private static long fibonacci(int n){
        calls++;
        if(mem[n] != -1) return mem[n];
        if(n ==0 || n==1) return n;

        return mem[n] = fibonacci(n-1) + fibonacci(n-2);
    }

    private static long fibonacci2(int n){
        calls2++;
        if(mem2[n] != -1) return mem2[n];
        if(n ==0 || n==1) return n;

        return mem2[n] = fibonacci2(n-1) + fibonacci2(n-2);
    }

    public static void main(String[] args) {
        Arrays.fill(mem, -1);
        System.out.println(fibonacci(10));
        System.out.println("호출 수 : "+ calls);


        for(int i = 0; i <= 100; i++){
            fibonacci2(i);
        }

        System.out.println(fibonacci2(10));
        System.out.println("호출 수2 : "+ calls2);
    }




}
