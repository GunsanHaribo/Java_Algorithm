package Programmers.구현미친듯이풀기.E_정렬.가장큰수;

import java.util.Arrays;
import java.util.Comparator;

public class 가장큰수2 {
    public static void main(String[] args) {
        int[] numbers = new int[]{3, 30, 34, 5, 9};

        // 이거 기억해야됨
        Integer[] integers = Arrays.stream(numbers).boxed().toArray(Integer[]::new);

        Comparator<Integer> cp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // Stringd으로 변환 후 첫글자 뽑기
                String o1_String = o1+"";
                String o2_String = o2+"";

                int o1_first = Integer.parseInt(o1_String.substring(0,1));
                int o2_first = Integer.parseInt(o2_String.substring(0,1));

                int desc_result = o2_first - o1_first;

                // 첫글자로 안갈릴때 어떻게 해야하나...
                //
                if(desc_result == 0){
                    // 두개 길이가 다를때는 어떻게 하지?
                    // 이걸 어떻게 하지?
                    // 10,1  => 110 // 12, 1 => 121
                    // 10, 11 => 1110 // 12, 13 => 1312
//                    int check =  o1_String.length() - o2_String.length();

                    String first = o1 +"" +o2;
                    String second = o2+ "" +o1;

                    int first_int = Integer.parseInt(first);
                    int second_int = Integer.parseInt(second);

                    return second_int-first_int;
                }

                return desc_result;
            }
        };

        //만약 array 0밖에 없으면

        Arrays.sort(integers, cp);

        StringBuilder sb = new StringBuilder();
        for(int i : integers){
            sb.append(i+"");
        }

        // 일단 넣고 숫자로 바꾼다음에 문자로 다시 바꾸던가
        // 앞자리에 0있으면 날려버리던가  일단 0,1 01은 말이 안되서
        // 0000만 없애면 될듯한데
        // 다 0 밖에 없으면 ㅈ되는거다

        String answer = sb.toString().replaceAll("^0+", "0");

        System.out.println(answer);




    }
}
