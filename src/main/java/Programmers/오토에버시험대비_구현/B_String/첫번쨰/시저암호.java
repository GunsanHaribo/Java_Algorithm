package Programmers.오토에버시험대비_구현.B_String.첫번쨰;

public class 시저암호 {

    public static void main(String[] args) {
//        System.out.println(length);

//        String input = "AB";

//        String input = "z";

        String input = "a B z";
        int input_number = 4;

        StringBuilder sb = new StringBuilder();

//        char g = 'A'; // 65  이게 먼저다
//        System.out.println(g +1);
        // 하나를 꺼내서 char로 만들고 이거를 숫자를 더 한다음
        // 숫자가 최대값을 벗어나면 length를 뺴준다
        for(int i = 0; i < input.length(); i++){
            char ele = input.charAt(i);
//            char ele2 = input.charAt(i+1);
            int value = ele + input_number; //value//

            // z거나 다른거
            // Z거나? //공백은 생략하고 //공백을 어떻게 생략하지?
            // 공백이면 그냥 생략
            if(ele != ' ') {
                if(ele<='Z'){
                    //대문자일떄
                    if(value >'Z'){
                        value = 'A' +value - 'Z'-1;
                    }

                }else{

                    // 소문자일때
                    if(value > 'z'){
                        // 1이 아니라 첫번쨰꺼를 줘야 되니깐 // 마지막 꺼를 줘야되긴하는데
                        //
                        value = 'a' + value - 'z' -1;
                    }
                }
                sb.append((char) value);
            }else{
                sb.append(' ');
            }
        }

        String answer = sb.toString();
//        System.out.println("d");
        System.out.println(answer);


    }


}
