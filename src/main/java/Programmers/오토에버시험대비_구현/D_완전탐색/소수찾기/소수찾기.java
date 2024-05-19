package Programmers.오토에버시험대비_구현.D_완전탐색.소수찾기;

import java.util.Arrays;


// 그냥 다 틀렸는데?
// 돌면서 체크하는 느낌이 아님
public class 소수찾기 {

    static int  count  = 0;
    public static void main(String[] args) {
        String numbers = "17";

        String[] spl_numbers = numbers.split("");
        System.out.println(Arrays.toString(spl_numbers));
        // 쪼갬성공
//        int[] visit = new int[spl_numbers.length+1];

        make_combination("", spl_numbers);
        System.out.println( count);

    }




    // word가 들어가야 될것 같은데
    // 이거를 어떻게 문자열로 넣어줘야 되나
    // 효율이 ㅈ 밖기 시작한다
    public static void make_combination(String str, String[] str_array){

        // 추가를 어떻게 하지 이거?
        StringBuilder sb = new StringBuilder(str);
        // 여기서 뭔가 이상한데 // String builder 인덱스 사용가능한가?

        // length 넘으면 stop
        if(sb.length() > str_array.length){
            return;
        }
        // 1 ,7, 17, 71
        // 11은 안되는데?
        // 1,7 이걸로 콤비네이션 해야되는데 ㅈ 됌
        // 본인 제외하고 다 더해야됨

        // 본인
//        for(int i = 0;  i< str_array.length; i++){
//            sb.append(str_array[i]);
//            // 더하고 사용 했으면 // 하나가 들어가면 stop 해야된다
//            // 하나만 들어가면 안되냐
//            sb.
//
//        }


        // 합한후
        // str을 int로 바꾼다
        int target = Integer.parseInt(sb.toString());
        boolean check = true;

        for(int i =1; i< target; i++){

            //몫이 숫자가 있으면 1제외  0이 아니면 소수아님
            int number = target/i;
            if(number != 0){
                check = false;
                break;
            }
        }
        if(check){
            count++;
        }

        make_combination(sb.toString(), str_array);
    }

    // 점점 산으로 가는데
    public class visit{
        int[] visit;

    }

}


