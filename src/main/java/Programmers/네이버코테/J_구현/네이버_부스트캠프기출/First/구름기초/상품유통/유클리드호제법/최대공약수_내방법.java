package Programmers.네이버코테.J_구현.네이버_부스트캠프기출.First.구름기초.상품유통.유클리드호제법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class 최대공약수_내방법 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(br.readLine());

        int second = Integer.parseInt(br.readLine());

        // 작은 수 까지 해서 나눈다
        int min = Math.min(first, second);
        int max = Math.max(first, second);
        ArrayList<Integer> same = new ArrayList<>();
        for(int i =1; i<=min; i++ ){

            if((min%i ==0) &&(max%i == 0) ){
                same.add(i);
            }
        }

        int same_max = Collections.max(same);
        System.out.println(same_max);

    }
}
