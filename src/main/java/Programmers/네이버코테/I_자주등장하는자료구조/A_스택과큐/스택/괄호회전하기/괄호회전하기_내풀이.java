package Programmers.네이버코테.I_자주등장하는자료구조.A_스택과큐.스택.괄호회전하기;

import java.util.*;

public class 괄호회전하기_내풀이 {
    public static void main(String[] args) {
//        String s1 = "[](){}";

        String s1 = "}}}";
//        String[] ss = s1.split("");
//        ArrayList<String> sss = new ArrayList<>(List.of(ss));

        // 왼쪽으로 회전시키기
//        StringBuilder sb= new StringBuilder();

        Map<String, String> kk = new HashMap<>();
        kk.put(")", "(");
        kk.put("]", "[");
        kk.put("}", "{");
        int total =0;
        for(int i=0; i<s1.length(); i++){
            // subString한걸 붙인다
            String first = s1.substring(0,i);
            String second = s1.substring(i, s1.length());
            String middle = second + first;
            total += checkCorrect(middle, kk);
        }

        System.out.println(total);

    }

    // 주어진 문자열 스택에 넣어서
    public static int  checkCorrect(String middle, Map<String, String> kk){
        String[] middle_set = middle.split("");

        Stack<String> ss= new Stack<>();

        //
        //

        for(String s : middle_set){
            switch (s) {
                case "(", "[", "{"-> ss.push(s);
                case ")", "]", "}" -> {
                    if(ss.isEmpty()) return 0;
                    String top = ss.peek();

                    // 같은게 아니라 대응된다면
                    if(top.equals(kk.get(s))){
                        ss.pop();
                    }else {
                        ss.add(s);
                    }

                } // 괄호에는 세미콜론이 또 없네

            }
        }

        // 한번에 ss.isEmtpy로 true, false 나누지 않고
        if(ss.isEmpty()){
            return 1;
        }

        return 0;
    }



}
