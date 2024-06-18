package Programmers.D_완전탐색.찐for.수식최대화_우선순위설정.수식최대화기록;

import java.util.ArrayList;
import java.util.List;


// 보자 .. 효율 ㅈ 박는다
// 답이 없네....
public class 수식최대화_20240424 {

    // 문제 정의 : 연산자의 우선 순위를 결정해서 표현식 계산을 하고 결과의 최댓값을 찾아라
    // 문제 변수 정의 :

    // 사용하는 함수 : 추출 할때 이거  메서드 알아야된다
    // 코테 시간 줄이기 => 메소드 닥치고 외워야됨

    public static void main(String[] args) {
        String expression1 = "100-200*300-500+20";
//        String expression2 = "50*6-3*2";

        // 연산자 추출
        // 숫자, 연산자 배열 만든다  => isNUmber 같은걸로 String, number 분리한다
        List<Integer> number = new ArrayList<>();
        List<String> operator = new ArrayList<>();

        // 1. 숫자가 아니면 자르고 인덱스를 기억해서 범위를 자른다 => 연산자를 중복제거해서 뽑는다 그리고 선택한다
        // 2. 연산자 종류 추출 후에 연산자 우선순위를 정하 후 => 연산을 해서 리스트를 혼합한다
        // 3. 각각의 연산결과를 저장한 후에 max 값을 구한다

        int save_start = 0;
        int save_end = 0;
        for(int i = 0; i <expression1.length(); i++){

            // 아니면 숫자인지...
            String check = expression1.substring(i, i+1);

            //숫자면 인덱스 저장
            if(isNumeric(check)){
                save_end = i;
            }else{
                // 숫자가 아니면
                operator.add(check);

                int unit_number = Integer.parseInt(expression1.substring(save_start, i));
                number.add(unit_number);

                // 마지막에 start 초기화 // 다음 수로 간다
                save_start = i+1;
            }
        }

        System.out.println(number.toString());
        System.out.println(operator.toString());

        // 쪼개기 성공 // ㄹㅇㄹㅇ
//        2. 연산자 종류 추출 후에 연산자 우선순위를 정하 후 => 연산을 해서 리스트를 혼합한다
        List<String> distinct_operator = operator.stream().distinct().toList();

        // 중복제거
        System.out.println(operator.toString());

        // 우선 순위 정하기 how? => 리스트 순서대로 정한다
        // -를 고르면 -의 인덱스와 다음 인덱스 숫자를 더해서 {i, (i+1)} 계산한 수를 더해서 넣어준다..?
        // 이거 리스트로 하면 유연하지 않은디... 추출해서 그냥 새로 만들자

        // 경우의 수 구한다
        List<List<Integer>> combination = new ArrayList<>();


        // size에 따라 for문 조합 획수가 달라져야된다  //
//        for(int i =0; i<distinct_operator.size(); i++){
//            List<Integer> save = new ArrayList<>();
//            save.add(distinct_operator.get(i));
//            for(int j = 0; j< distinct_operator.size(); j++){
//
//            }
//        }

        // operator 경우의 생성에서 막힘


        // 경우의 수를 구한다
        // 그건 니 알바고 임마
        for(String i : distinct_operator){
            // 0, 1, 2 의 순서를 어떻게 구현할 것인지... 설명해봐 친구야...
            // 한번 다 돌아야 겠는데..  0-1-2, 0-2-1, 1-0-2, 1-2-0,  2-1-0, 2-0-1
            // visit로 체크한다 -1, +1 해도 하는데... 이거 어떻게 해야되나


        }





    }

    public static boolean isNumeric(String word){

            try {
                int number = Integer.parseInt(word);
            }catch (Exception e){
                return false;
            }

        return true;
    }
}
