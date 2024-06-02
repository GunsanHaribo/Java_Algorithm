package Programmers.네이버코테.B_String.첫번쨰;

import java.util.Arrays;

public class 자연수뒤집어배열로만들기 {
    public static void main(String[] args) {
//        StringBuilder azBuilder = new StringBuilder();
//        for(char c = 'a'; c<= 'z'; c++){
//            azBuilder.append(c);
//        }
//        String az = azBuilder.toString();
//        System.out.println(az);


        long n = 12345;

        // 나눠버렸
        // O(n)
        StringBuilder sb = new StringBuilder();
        while(n !=0){
            sb.append(n % 10);
            n = n / 10;
        }
        //O(n)
        int[] result = new int[sb.length()];
        // 아 스트링 에서는 foreach문이 안돌아가는 거구나?
        for(int i = 0; i<sb.length(); i++){
            result[i] =  sb.charAt(i)-'0';
        }
        System.out.println("처음꺼: "+Arrays.toString(result));

        long n3 = 12345;
        //처음부터 변환해버렷
        String n1 = Long.toString(n3);
        String s2 = new StringBuilder(n1).reverse().toString();

        char[] arr = s2.toCharArray();

        int[] result2 = new int[arr.length];

        for(int i = 0; i<arr.length; i++){
            result2[i] = arr[i] -'0';
        }
        System.out.println("두번쨰꺼"+Arrays.toString(result2));

    }
}
