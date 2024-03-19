package Vacation.week2_stack;

import java.util.ArrayList;
import java.util.Scanner;

public class Backjon9012 {

    public static void main(String[] args) {
        //6입력
        //()쌍 파악
        // isValid를 둬서 flag 체크를 해본다
        //마지막에 isvalid체크해주기 스택 비어있나 아니면 ((만 있나

        Scanner scanner = new Scanner(System.in);
        int num_var = scanner.nextInt();
        Stack<Character> Vps_stack = new Stack<>();


        for (int i = 0; i < num_var; i++) {
            Scanner scanner2 = new Scanner(System.in);
            String get_VPS = scanner2.nextLine();
            boolean isValid = true;

            for (int j = 0; j < get_VPS.length(); j++) {
                char input_value = get_VPS.charAt(j);
//                Stack.push(input_value);
                if (input_value == ')' && Vps_stack.isNotEmpty()) {
                    //push하는데 ) 이고 그 전 값에 (가 있으면
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
            if (isValid == true && !Vps_stack.isNotEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            Vps_stack.clear();
        }


    }

    private static class Stack<T> {
        private ArrayList<T> array = new ArrayList<>();

        int size = array.size();


        public boolean isNotEmpty() {
            return (array.size() != 0);
        }

        public void push(T newElement) {
            array.add(newElement);
        }

        public void pop() {
            array.remove(array.size() - 1);
        }

        public T peek() {
            int position;
            if (array.size() == 0) {
                position = 0;

            } else {
                position = array.size() - 1;
            }
            T top = array.get(position);
            return top;
        }
        public void clear(){
            array.clear();
        }


    }
}