package Programmers.D_완전탐색.찐for.카펫.카펫_20240429;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 카펫 {
    public static void main(String[] args) {
        int yellow = 2;
        int brown = 10;

//        int yellow = 24;
//        int brown = 24;



        int[] answer = new int[2];

        // yellow 약수 구하기
        List<Integer> numbers = new ArrayList<>();
        for(int i =1; i<=yellow; i++){
            int check = yellow%i;
            if(check ==0){
                numbers.add(i);
            }
        }

        System.out.println(numbers);

        // 새로 길이만 구하기
        List<Integer> vertical = new ArrayList<>();
        int vertical_len;
        if(numbers.size()%2 ==0){
            vertical_len = numbers.size()/2;
        }else{
            vertical_len = numbers.size()/2 +1;
        }
        System.out.println(vertical_len);

        for(int index = 0; index<vertical_len; index++){
            vertical.add(numbers.get(index));
        }

        System.out.println(vertical);

        // (세로 +2/ 가로+2)- yellow = brown인  세로길이를 구한다
        // 일단 세로 돌리고, 세로로 가로 계산 해서 돌리고
        for(int ver : vertical ){
            int hor = yellow/ver;

            int carpet_ver = ver+2;
            int carpet_hor = hor+2;
            int total_number = (carpet_ver)*(carpet_hor);

            int check_brown = total_number- yellow;
            if(check_brown == brown){
                answer[0] = carpet_hor;
                answer[1] = carpet_ver;
            }
        }

        System.out.println(Arrays.toString(answer));

    }
}
