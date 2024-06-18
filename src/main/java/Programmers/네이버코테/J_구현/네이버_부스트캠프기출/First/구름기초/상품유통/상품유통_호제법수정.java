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

        int[] sonmom = new int[]{R,1};
        for(int i = 0; i<N; i++){
            int[] tax_rate = new int[]{tax[i], 100};
            sonmom = find_result(sonmom, tax_rate);
        }


        System.out.println(Arrays.toString(sonmom));


    }

    public static int hoJe(int a, int b){

        while(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
        }

        return a;
    }
    public static int LCD(int[] sonmom, int[] R_multipletaxRate){

        int R_mom = sonmom[1];
        int R_mulitple = R_multipletaxRate[1];

        // 최대 공약수 구해주는거 없나?  => null 체크도 해야되고
        int gcd = hoJe(sonmom[0], sonmom[1]); // 여기서 1미만은 안나온다

        int result  = (R_mom*R_mulitple)/gcd;

        return result;
    }


    // 최대 공약수 구해야된다
    public static int[] find_NotDivide(int[] sonmom){

        // 분모가 0이면 중지
        if(sonmom[1] == 0) {
            return sonmom;
        }


        // 최대 공약수 구해주는거 없나?  => null 체크도 해야되고
        int gcd = hoJe(sonmom[0], sonmom[1]);
        sonmom[0] = sonmom[0]/gcd;
        sonmom[1] = sonmom[1]/gcd;


        return sonmom;
    }





    public static int[] find_result(int[] sonmom, int[] tax_rate){

        //tax_rate 기약분수인지 확인해서 들어갈꺼임
        tax_rate = find_NotDivide(tax_rate);
        // 분수 맞춰서 빼기 -> 최소 공배수 구하기
        sonmom = Sub_R_Rtax(sonmom, tax_rate);

        // 기약분수인지 확인하기
        sonmom = find_NotDivide(sonmom);

        return sonmom;
    }



    public static int[] Sub_R_Rtax(int[] sonmom, int[] tax_rate){

        // 분모가 0이면 중지
        if(sonmom[1] == 0) {
            return sonmom;
        }

        // R*tax_rate구한다
        int R_son = sonmom[0];
        int R_mom = sonmom[1];

        int tax_rate_son = tax_rate[0];
        int tax_rate_mom = tax_rate[1];


        int[] R_multipletaxRate = find_NotDivide(new int[]{R_son*tax_rate_son, R_mom*tax_rate_mom});
//        System.out.println(Arrays.toString(R_multipletaxRate));

        int same_mom = LCD(sonmom, R_multipletaxRate);
//        System.out.println(same_mom);
        int R_mom_i = same_mom/sonmom[1];
        int tax_mom_i = same_mom/R_multipletaxRate[1];


//        System.out.println(R_mom_multiple);
        int  differ_R =  R_son*R_mom_i;
        int  differ_T = R_multipletaxRate[0]*tax_mom_i;


        int final_son =  (differ_R- differ_T);

//        System.out.println("마지막 분자:"+final_son);
        int[] R_subtaxRate = new int[]{final_son, same_mom};

//        System.out.println(Arrays.toString(R_subtaxRate));


        return R_subtaxRate;
    }









}
