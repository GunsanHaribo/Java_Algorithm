package Programmers.H재귀베이스.A재귀.모음사전.모음사전_20250528;

import java.util.ArrayList;
import java.util.List;


//words.addAll() 가능한 컬렉션 합친다 -> 리스트의 모든요소를 word리스트에 추가
public class 모음사전2 {

    private static final char[] CHARS = "AEIOU".toCharArray();
    public static void main(String[] args) {

        int number = generate("").indexOf("AAAE");
        System.out.println(number);


    }

    private static List<String> generate(String word){
        List<String> words = new ArrayList<>();
        words.add(word); // ""가 들어가서 인덱스가 +1된다

        if(word.length() ==5) return words;

        for(char c :CHARS){
            words.addAll(generate(word+c));
        }

        return words;
    }


}
