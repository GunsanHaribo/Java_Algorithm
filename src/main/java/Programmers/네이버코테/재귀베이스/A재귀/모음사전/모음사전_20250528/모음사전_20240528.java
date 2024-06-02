package Programmers.네이버코테.재귀베이스.A재귀.모음사전.모음사전_20250528;


// 요구사항 : 단어하나가 매겨변수로 주어질떄 이 단어가 사전에서 몇번째 단어인지 return 하시오
// 변수 : AEIOU,  단어의 조합, A, AA, AAE 같은 느낌, 그리고 단어를 가지고있는 배열

// 나타낼 수 있는 모든 경우의 수를 다 나타내야 될 것 같은데 이거 어떻게 해야하나

// 어떻게 넣지 이걸

// 흐름 - 순서대로 모든 조합을 넣고 인덱스를 찾는다, 재귀로 간다 -> 반복과 종료조건이 눈에 보여서...다른 이유는 없다
// 1. 상태 : word의 조합,  배열을 줄이지말고 고정한다음 word에 붙인다
// 2. 종료 : 조합된 word의 length가 5일때 그만한다
// 3. 점화식 : word <= word + number[i]

import java.util.ArrayList;

// 배열에 다 넣어 주어야 된다
public class 모음사전_20240528 {
    public static void main(String[] args) {

        String input = "AAAE";
        ArrayList<String> record = new ArrayList<>();

        recursive("", record);

        System.out.println(record);
        int sequence = record.indexOf(input)+1;
        System.out.println(sequence);
    }

    // void 리턴도 괜찮은 것 같은데
    public static void recursive(String word , ArrayList<String> record){

        if(word.length() == 5){
            return ;
        }
        String[] words = "AEIOU".split("");

        for(String s : words){
            String newWord = word+s;
            record.add(newWord);
            recursive(newWord, record);
        }


    }


}
