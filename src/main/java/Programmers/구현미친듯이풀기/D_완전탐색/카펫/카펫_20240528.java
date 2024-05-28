package Programmers.구현미친듯이풀기.D_완전탐색.카펫;


// 요구사항 : 갈색 격자수, 노란색 격자수가 주어질때 가로,세로크기를 구하여라
// 갈색은 노란색을 테두리 한줄로 덮고 있다
// 변수 :  갈색 격자수, 노란색 격자수


// 흐름
// 1.. 노란색은 row의 수로 나눴을때 나머지가 없어야된다 - 하나만 튀어 나와있으면 안된다
// 2. 노란색 row의 수를 for로 순회하면서 구한다
// 3. 갈색의 수 = (노란세로 *2) + (노란 가로 *2) +4(모퉁이 수) -> 이조건에 따라 맞는 주어진 갈색에 맞는지 체크

import java.util.Arrays;


public class 카펫_20240528 {
    public static void main(String[] args) {

        int brown = 24;
        int yellow = 24;

        int[] answer = calculate(brown, yellow);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] calculate(int brown, int yellow){

        int[] answer = new int[2];

        // 노란색 순회 나누는 거여서 반절만 해도 될듯

        int length = (int) Math.ceil((float) yellow/2);

        for(int i = 1; i<= length; i++){
            int quarter = yellow%i;
            if(quarter !=0) continue;

            int width = yellow/i;  // 에가 6인데  왜 4에서 못끝었지 쭉가니깐
            int height = i; // 에가 4일떄
            //

            if(check(brown, width, height)){
                answer[0] = width+2;
                answer[1] = height+2;
                break;
            }

        }


        return  answer;
    }

    public static boolean check(int brown, int y_width, int y_height){

        int sum = (y_width+y_height)*2 + 4;

        if(brown ==sum){
            return true;
        }

        return false;
    }

}
