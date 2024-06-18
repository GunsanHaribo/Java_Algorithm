package Programmers.네이버코테.J_구현.네이버_부스트캠프기출.First.구름기초.상품유통.유클리드호제법;

public class 유클리드호제법 {
    public static void main(String[] args) {
        int a = 6;
        int b = 18;

        System.out.println(gcd(6,18));


    }

    // GCD(a,b) = GCD(b,r)
    // r이 0일때 a를 반환한다
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
