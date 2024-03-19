package Vacation.week2_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class backjon4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> Vps_stack = new Stack<Character>();

        while (true) {
            StringTokenizer st = new StringTokenizer(scanner.readLine(), ".");
            if(!st.hasMoreTokens()){
                break;
            }
            boolean isValid = true;
            while (st.hasMoreTokens()) {
                String TextLine = st.nextToken();
                StringTokenizer char_token = new StringTokenizer(TextLine);
                while (char_token.hasMoreTokens()) {

                    String String_unit = char_token.nextToken();
                    //()[]포함하고 있으면
                    for (int i = 0; i < String_unit.length(); i++) {
                        char Character_unit = String_unit.charAt(i);
                        System.out.println(Character_unit);
                        // 비면 바로 flase break; ㄴㄴ )들어가는데 비었으면이지
                        //문자열 필터링 필요
                        //empty가 문제 => 캐릭터 앞에 정리
                        if ((Character_unit == ')' || Character_unit == ']' )&& Vps_stack.isEmpty()) {
                                isValid = false;
                                break;
                        } else if (Character_unit == '(' || Character_unit == '[') {
                            Vps_stack.push(Character_unit);
                            System.out.println(Vps_stack.size());
                        }else if((Character_unit == ')' && Vps_stack.peek() =='(' )|| (Vps_stack.peek() =='[' && Character_unit == ']')){
                            Vps_stack.pop();
                        }
                    }

                }

                if (Vps_stack.isEmpty() && isValid) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
                Vps_stack.clear();

            }
        }

    }
}