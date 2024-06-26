package Programmers.네이버코테.J_구현.네이버_부스트캠프기출.First.구름기초.상품유통;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 상품유통_호제법수정 {
    public static void main(String[] args) {
        int N = 10;
        int R = 1024;

        int[] tax = new int[]{50, 50,50,50,50,50,50,50,100,50};

        long[] sonmom = new long[]{R,1};
        for(int i = 0; i<N; i++){
            long[] tax_rate = new long[]{tax[i], 100};
            sonmom = find_result(sonmom, tax_rate);
        }


        System.out.println(Arrays.toString(sonmom));


    }

    public static long hoJe(long a, long b){

        while(b!=0){
            long temp = b;
            b = a%b;
            a = temp;
        }

        return a;
    }
    public static long LCD(long[] sonmom, long[] R_multipletaxRate){

        long R_mom = sonmom[1];
        long R_mulitple = R_multipletaxRate[1];

        // 최대 공약수 구해주는거 없나?  => null 체크도 해야되고
        long gcd = hoJe(sonmom[0], sonmom[1]); // 여기서 1미만은 안나온다

        long result  = (long) R_mom*R_mulitple /gcd;

        return result;
    }


    // 최대 공약수 구해야된다
    public static long[] find_NotDivide(long[] sonmom){

        // 분모가 0이면 중지

        // 최대 공약수 구해주는거 없나?  => null 체크도 해야되고
        long gcd = hoJe(sonmom[0], sonmom[1]);
        sonmom[0] = sonmom[0]/gcd;
        sonmom[1] = sonmom[1]/gcd;


        return sonmom;
    }





    public static long[] find_result(long[] sonmom, long[] tax_rate){

        //tax_rate 기약분수인지 확인해서 들어갈꺼임
        tax_rate = find_NotDivide(tax_rate);
        // 분수 맞춰서 빼기 -> 최소 공배수 구하기
        long[] sonmom2 = Sub_R_Rtax(sonmom, tax_rate);

        // 기약분수인지 확인하기
        sonmom2 = find_NotDivide(sonmom2);

        return sonmom2;
    }



    public static long[] Sub_R_Rtax(long[] sonmom, long[] tax_rate){


        // R*tax_rate구한다
        long R_son = sonmom[0];
        long R_mom = sonmom[1];

        long tax_rate_son = tax_rate[0];
        long tax_rate_mom = tax_rate[1];


        long[] R_multipletaxRate = find_NotDivide(new long[]{R_son*tax_rate_son, R_mom*tax_rate_mom});
//        System.out.println(Arrays.toString(R_multipletaxRate));

        long same_mom = LCD(sonmom, R_multipletaxRate);
//        System.out.println(same_mom);
        long R_mom_i = same_mom/sonmom[1];
        long tax_mom_i = same_mom/R_multipletaxRate[1];


//        System.out.println(R_mom_multiple);
        long  differ_R =  R_son*R_mom_i;
        long  differ_T = R_multipletaxRate[0]*tax_mom_i;


        long final_son =  (differ_R- differ_T);

//        System.out.println("마지막 분자:"+final_son);
        long[] R_subtaxRate = new long[]{final_son, same_mom};

//        System.out.println(Arrays.toString(R_subtaxRate));


        return R_subtaxRate;
    }









}
