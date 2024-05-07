package Programmers.오토에버시험대비.B_String.첫번쨰;

import java.util.Arrays;
import java.util.OptionalInt;

public class 문자열압축 {
    public static void main(String[] args) {
//        String input = "aabbaccc";
//        String input = "abcabcdede";
        String input = "xababcdcdababcdcd";

        int[] record = new int[input.length()+1];
        record[0] = 10_000000;

        // 청크 length,, 개수니깐 1부터 시작한다
        for(int chunk = 1; chunk< input.length()+1; chunk++){
            // 여기서 새로운 String을 만드는데
            StringBuilder sb = new StringBuilder();
            int count = 1;


            int repeat_number = (input.length()/chunk);

            // 청크 당 돌리는 방법 => length/chunk  // 첫 chunk 담는다
            String compare = input.substring(0, chunk);


            for(int repeat = 1; repeat < repeat_number; repeat++){
                // 마지막을 처리해 줘야 되는데 => 7이 들어가는데 (7+1) 인데... 인덱스가 날라가긴한다
                // count - 3까지 가야되는데 d
                int start = chunk*repeat;
                int end = chunk*(repeat+1);

                String target = input.substring(start, end);
                // compare => ++되면

                if(compare.equals(target)){
                    // 같으면 count
                    count++;
                }else{
                    // 다르면 저장하고
                    if(count >1){
                        sb.append(count + compare);
                    }else{
                        sb.append(compare);
                    }
                    // 초기화
                    compare = target;
                    count = 1;
                }

            }
            // 만약 남아있으면 count랑 compare를 flush 해준다
            if(count >1){
                sb.append(count + compare);
            }else{
                sb.append(compare);
            }

            int repeat_last  = (input.length()%chunk);

            if(repeat_last != 0){
                String last_q = input.substring(input.length()-repeat_last,input.length());
                sb.append(last_q);
            }

            record[chunk] = sb.toString().length();
        }

//        String compare = "ds";
//        System.out.println(compare.substring(0,1)); // subString은  미만 입니다

        OptionalInt min = Arrays.stream(record).min();

        System.out.println(min.getAsInt());

    }


}
