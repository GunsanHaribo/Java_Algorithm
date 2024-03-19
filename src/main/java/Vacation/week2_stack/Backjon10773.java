package Vacation.week2_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Backjon10773 {
    public static void main(String[] args) throws IOException {
        //0이 있으면 최근 쓴수가 날라간다 ==> pop 사용
        Stack<Integer> stack = new Stack<Integer>();
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int max_number = Integer.parseInt(scanner.readLine());
        int sum =0;
        for(int i = 0; i<max_number; i++){
            int get_number = Integer.parseInt(scanner.readLine());

            switch (get_number){
                case 0:
                    stack.pop();
                    break;
                default: stack.push(get_number);
            }

        }
        for(int i=0; i<stack.size(); i++){
            sum += stack.get(i);
        }
        System.out.println(sum);
    }
}
