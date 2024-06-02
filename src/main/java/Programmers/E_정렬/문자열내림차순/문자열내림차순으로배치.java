package Programmers.E_정렬.문자열내림차순;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열내림차순으로배치 {
    public static void main(String[] args) {

        // wrapper class 꼭 이용해야 되나?
        Comparator<Character> compareChar = new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o2 - o1;
            }
        };


//        System.out.println('A'-'B');  // 그냥 빼진다

        String s= "Zbcdefg";
        // sort가 그럼 어디 들어 있어야 되는데
        // String에서 sort가 어디 있지?
        // Array로 만든 다음에 하자
        Character[] split_s = new Character[s.length()];
        // String char로 변환 하는법
        for(int i = 0; i< s.length() ;i++){
            split_s[i] = s.charAt(i);
        }

        // 자기자신이 아닌데... 이거
        Arrays.sort(split_s, compareChar);

        StringBuilder sb = new StringBuilder();
        // 조인이 없어서
        for(char k : split_s){
            sb.append(k);
        }

        System.out.println(sb);


    }
}
