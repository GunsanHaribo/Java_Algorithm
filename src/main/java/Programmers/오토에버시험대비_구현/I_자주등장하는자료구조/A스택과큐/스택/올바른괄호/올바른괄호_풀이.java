package Programmers.오토에버시험대비_구현.I_자주등장하는자료구조.A스택과큐.스택.올바른괄호;

import java.util.Stack;

public class 올바른괄호_풀이 {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String s = "(()(";
        boolean check;

        for(char c : s.toCharArray()){
            switch (c){
                case '(' -> stack.push(c);
                case  ')' -> {
                    if(stack.isEmpty()) check =false;
                    stack.pop();
                }
            }
        }

        check = stack.isEmpty();
        System.out.println(check);
    }
}
