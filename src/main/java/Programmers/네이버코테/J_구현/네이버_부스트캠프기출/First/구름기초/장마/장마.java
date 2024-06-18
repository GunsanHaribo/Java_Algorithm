package Programmers.네이버코테.J_구현.네이버_부스트캠프기출.First.구름기초.장마;

import java.io.*;
import java.util.*;
public class 장마 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] n = input.split(" ");
        int Number_house = Integer.parseInt(n[0]);
        int duration = Integer.parseInt(n[1]);

        String[] watered_house_inputed = br.readLine().split(" ");
        int[] watered_house = new int[Number_house+1];  // 1~N까지로 기록

        for(int k = 0; k< watered_house_inputed.length; k++){
            watered_house[k+1] += Integer.parseInt(watered_house_inputed[k]);
        }

        boolean[] record = new boolean[Number_house+1];  // 1~N까지로 기록

        for(int i = 1; i<= duration; i++ ){
            String[] S_E_Water = br.readLine().split(" ");
            int start = Integer.parseInt(S_E_Water[0]);
            int end = Integer.parseInt(S_E_Water[1]);

            for(int s = start; s<=end; s++){

                watered_house[s] +=1;
                //false면
                if(!record[s]){
                    record[s] =true;
                }

            }
            // 배수 시스템 가동
            if(i%3 ==0){
                //하나더 많아서 그럼
                for(int j=1; j<record.length; j++){
                    boolean wheter = record[j];
                    if(wheter){
                        watered_house[j] -=1;
                    }
                }
                record = new boolean[Number_house+1];
            }
        }



        // System.out.println(Arrays.toString(watered_house));

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<watered_house.length; i++){
            sb.append(watered_house[i]);
            if(i!=watered_house.length-1){
                sb.append(" ");
            }
        }

        // 문자열 배열을 정수 배열로 변환
        String[] stringArray = Arrays.stream(watered_house)
                .mapToObj(String::valueOf)
                .toArray(String[] ::new);


        String result = String.join(" ", stringArray);
        result = result.substring(2,result.length());

        System.out.println(result);


    }

}
