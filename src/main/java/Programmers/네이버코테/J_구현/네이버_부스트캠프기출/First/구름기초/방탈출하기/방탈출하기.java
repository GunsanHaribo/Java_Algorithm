package Programmers.네이버코테.J_구현.네이버_부스트캠프기출.First.구름기초.방탈출하기;

// 요구사항 : 방탈출 하기
// 1. 눈 앞에 보이는 수열을 모두 외운 후에 벽에 있는 버튼을 누른다
// 2. M개의 숫자를 하나씩 보여주면 그 숫자가 수열에 있는지 없는지 바로 대답
// 3. 한번이라도 실패하면 탈출 불가

// 변수 :
// 두 번째줄 : 눈앞에 보이는 수멸, 10
// 네 번쨰줄 : M개의 숫자들


// 흐름 :  10억 이하니깐 long으로 받기
// 1. 인자 받는다
// 2. 잇는지 확인한다 있으면 1 없으면 0 반환한다

import java.io.*;
import java.util.*;


public class 방탈출하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] input_list = br.readLine().split(" ");
        String M = br.readLine();
        String[] M_list = br.readLine().split(" ");

        List<String> result = hascontaint(input_list, M_list);
        System.out.println(result);
    }
    public static List<String> hascontaint(String[] input, String[] Ms){

        List<String> result = new ArrayList<>();
        Set<String> input_S= new HashSet<>(List.of(input));


        System.out.println(input_S);
//        System.out.println(Ms);
        for(String s: Ms){
            if(input_S.contains(s)){
                result.add("1");
            }else{
                result.add("0");
            }
        }

        return result;
    }



}
