package Programmers.C_재귀;

public class 점화식 {
    public static void main(String[] args) {
        // 상태  => n,m
        // 종료조건 => n이 1일때 m 과 상관없이 1, n이 0이면 0, m이 0이면 n은 1이다
        // 점화식  => n, m  => n * (n, m-1)
        System.out.println(power(2,2));
    }

    public static int power(int n, int m){
        if(n == 1) return 1;
        if(n == 0) return 1;
        if(m == 0) return 1;

        return n * power(n,m-1);
    }

}
