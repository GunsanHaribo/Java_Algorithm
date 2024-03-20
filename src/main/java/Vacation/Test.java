package Vacation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        //2개 바로 이어져 있어야 토큰의 "."가 먹는다

        while (true) {
            StringTokenizer st = new StringTokenizer(scanner.readLine(), ".");

            System.out.println(st.countTokens());
            if(!st.hasMoreTokens()){
                break;
            }
            while (st.hasMoreTokens()) {
                String TextLine = st.nextToken();
                StringTokenizer String_unit = new StringTokenizer(TextLine);
                System.out.println(TextLine);
                System.out.println();
                while (String_unit.hasMoreTokens()) {

                    String char_token = String_unit.nextToken();
                    System.out.println(char_token);
                    System.out.println();
                }
            }

        }
    }
}
