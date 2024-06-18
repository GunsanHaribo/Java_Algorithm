package Programmers.그리디알고리즘.조이스틱;

// 요구사항 : name이 주어질 때 조이스틱 조작 횟수의 최솟값을 return 하도록

// 위로 -> 다음 알파벳
// 아래쪽 -> 이전 알파벳
// 왼쪽 -> 커서를 왼쪽으로
// 오른쪽 -> 커서를 오른쪽으로

// 변수 : 알파벳(대문자, 초기 AAAA), 각 방향 조이스틱 이동 횟수

// 흐름 - 지금 상태에서 최소를 찾는다
// 1. 조이스틱 이동 의무 횟수를 찾는 함수
// 절반 넘으면 뒤로가고 절반 안넘으면 앞에꺼에서 뺀다
// 그리고 커서이동시키는거까지 해서 끝낸다
// 위치 이동도... 바로 오른쪽이 A면 왼쪽이동 둘다 A면 그냥 오른쪽 이동


import static java.lang.Math.abs;

public class 조이스틱 {
    public static void main(String[] args) {

        String input = "JAN";

        char[] input_arr = input.toCharArray();

        int count = 0;
        for(int i = 0; i< input_arr.length; i++){
            int tran_value = input_arr[i];
            System.out.println(calculate_move(tran_value));
            count +=calculate_move(tran_value);
            // calculate가 0 이면ㄴ 계산 안함
            // A면 다른 방향으로
            // 만약에 A가 아니라 B면 그 방햐으로 간다
            if(i != input_arr.length-2){
                count++;
            }

        }

        System.out.println(count);


    }


    public static int calculate_move(int value){
        int middle = ((int) 'A' + (int) 'Z') / 2;
        int Start = (int) 'A';
        int End = (int) 'Z';
        int length = End - Start +1;


        int answer = 0;
        if(value > middle){
            answer= abs(value - (middle+1) - length/2) ;
        }else{
            answer  = value - Start;
        }


        return answer;
    }




}
