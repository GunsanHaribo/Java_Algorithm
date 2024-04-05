package Programmers.C_재귀;

import java.util.Arrays;
import java.util.Stack;

import static java.lang.Math.pow;

public class 모음사전 {
    static Stack<String> stack = new Stack<>();
    static int count = 0;
    static char[] arr = new  char[]{'A', 'E','I','O','U'};

    public static void main(String[] args) {
        // 변수
        // 변수 종료
        // 변수 관계식
//        String self= "AAAAE";
//
//        //빈칸 있으면 안되는게 맞다, 아랫 것 처럼
//        int answer2 = 1+ (int) pow(5,1) + (int) pow(5,2)+(int) pow(5,3)+(int) pow(5,4);
//        System.out.println(answer2);
//
//        // 등비수열의 합
//        int answer3 = ((int)pow(5,5)-1)/4;
//        System.out.println(answer3);

        // 재귀야 이게 왜

        // 변수 => AA => 알파멧 - 단어 변하니깐

        // 종료조건 => 입력한 문자랑 동일 한 숫자가 나오면

        // 변수 관계식 => 꺼낸 문자를 A, E, I, O,U 적정 문자들을 조합해서 나온 수 중
        // 가장 순서가 느린 것 부터 stack에 넣는다  => 배열에 넣고 sort 하기


        for(int i= arr.length-1; i>=0; i--){
            stack.add(String.valueOf(arr[i]));
        }

        Alpha_Stack("EIO");
        System.out.println(count);



    }

    public static void Alpha_Stack(String target){

        // 1. 만약 count가 0이면 a,e,i,o,u 조합한다
        // 2. 아니면 꺼낸 다음에 count 한다  그 후 꺼낸걸로 조함한다음에
        // 3. 조합 배열에 넣고 sort 뒤에서 부터 넣는다

        // 스택에 처음 부터 박고 시작할까??
        String popString = stack.pop(); // 이거 아마 바로 에러 뜰건데
//        System.out.println(popString); // 그래...이게 안돌아...
        count++;

        // 같은거 찾으면 종료
        if(target.equals(popString)){ // 같은게 왜 안나오지?
            return;
        }

        // 각 문자열은 length5를 넘을 수 없다
        // 만약 넘는다면 다시 재귀로 간다..근데 왜 비지....?
        if(popString.length() >= 5){
            Alpha_Stack(target);
        }else{
            // 조합정한다음 순서정리해서 다시 넣어준다
            String[] combination = new String[5];

            for(int i =0; i< arr.length; i++){
                StringBuilder make= new StringBuilder(popString);
                make.append(arr[i]);
                combination[i] = make.toString();
            }
            Arrays.sort(combination);

            for(int i= combination.length-1; i>=0; i--){
                stack.add(combination[i]);
            }

//        System.out.println(stack.size()); // 9개면 추가로 들어 갔다는건데
            Alpha_Stack(target);
        }



    }


}
