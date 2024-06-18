package Programmers.D_완전탐색.찐for.소수찾기;


// 요구사항 : 문자열 numbers가 주어졌을때 만들수 있는 소수가 몇개인지 적으시오
// 변수 : 숫자,  String배열


// 흐름 - 필요한거 1. 모든 경우의수 만들기   2. 소수체크
// 1. 조합할 수 있는 경우의 수 만들기 -> 어떻게 할까?
// 1-1. 숫자가 중복된게 들어있으면 경우의 수가 겹칠 수 도 set이 필요하다
// 2. 조합이 끝날떄 마다 소수체크, 소수 끝나면 저장

// 조합 만들기 -> 재귀
// 1.상태 : 숫자 , numbers(숫자 담은거)
// 2. 종료조건 numbers 가 0이면
// 3. 점화시 : 숫자+숫자, numbers - 숫자

import java.util.*;

public class 소수찾기 {
    public static void main(String[] args) {
        Set<Integer> prime = new HashSet<>();

        String s = "011";
        String[] li = s.split("");
        List<String> list = new ArrayList<>(List.of(li));


//        소수 재대로 돌아가는지
//        System.out.println(check("1"));    //   (17/2 -> 8로 해야된다)
        make_All("", list, prime);


        System.out.println(prime);
        System.out.println(prime.size());
    }

    public static void make_All(String word, List<String> list, Set<Integer> all){
        if(list.isEmpty()){
            return;
        }
        for(int i=0; i< list.size(); i++){
            String combination = word+list.get(i);
            List<String> new_List = new ArrayList<>(list);
            new_List.remove(i); // 중복된 s가 있으면 뭘 지울지 모르지않나

            // 소수 체크하고 만든게 소수면 Set에 저장한다
            int semi_answer = check(combination);
            if(semi_answer>=0){
                all.add(semi_answer);
            }

            make_All(combination, new_List, all);
        }
    }


    // 0하고 1제외
    public static int check(String s){
        int in = -11;
        // 정수변환
        try{
            in = Integer.parseInt(s);
        }catch(Exception e){
            System.out.println("정수아님");
        }

        // 소수체크, 약수들을 모두 나눠서 나눠지는지 체크

        int half = (int) Math.ceil((double) in / 2);
        System.out.println("반절:"+half);

        boolean flag = false;

        // 0이면 소수 아니니 못들어 오게그니깐 0으로 시작하는게 맞다
        // 1로는 무조건 나뉘잖아

        //
        for(int i= 2; i<=half; i++){
            int q = in%i;

            // 근데0을 나누면 나머지 0이잖아 근데 0이면 소수
            if(q == 0){
                flag= true;
                break;
            }

        }

        if(flag || in ==0 || in ==1){
            return -11;
        }

        return in;
    }


}
