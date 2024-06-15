package Programmers.H재귀베이스.B동적프로그래밍.피보나치수;

import java.util.Arrays;

public class 피보나치의수_문제 {

    private static long[] mem = new long[100000001];
    private static long  calls = 0;
    public static void main(String[] args) {
        Arrays.fill(mem, -1);

        int n = 10;

        for(int i = 0; i< n; i++){
            fibo(i);
        }
        long fibo = fibo(n);
        System.out.println(fibo);


//        System.out.println();
    }

    public static long fibo(int n){
        calls++;
        if(mem[n] != -1) return mem[n];

        // fibo가 1일때 1반환, 근데 0일때는 0 반환해야되긴하는데
        // 1일때는.... 어떻게 해야 되나... 바로 리턴하는던데 f(2)일때  =f(1) + f(0)이 되는데
        if(n ==1 || n==0){
            return n;  //
        }

        return mem[n] = (fibo(n-1) +fibo(n-2)) %1234567;   //이걸왜 나눠주지...?
    }


}
