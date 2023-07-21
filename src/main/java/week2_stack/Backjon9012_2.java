package week2_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Backjon9012_2 {
    public static void main(String[] args) throws IOException {
        Stack<Character> Vps_stack = new Stack<>();

        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int num_var = Integer.parseInt(scanner.readLine());

        for (int i = 0; i < num_var; i++) {
            String get_VPS = scanner.readLine();

            boolean isValid = true;

            for (int j = 0; j < get_VPS.length(); j++) {
                char input_value = get_VPS.charAt(j);

                if (input_value == ')' && !Vps_stack.isEmpty()) {
                    Vps_stack.pop();

                } else if (input_value == '(') {
                    Vps_stack.push(input_value);
                } else {
                    // (가 없던가
                    isValid = false;
                    break;
                }
            }
            //다 돌고 나서 valid 체크,,((이면 false
            // 비어있으면 yes 출력 아니면 no 출력
            if (isValid == true && Vps_stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            Vps_stack.clear();
        }

    }
}
