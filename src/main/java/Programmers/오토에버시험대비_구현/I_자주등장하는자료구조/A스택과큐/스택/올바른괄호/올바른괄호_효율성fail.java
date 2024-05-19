package Programmers.오토에버시험대비_구현.I_자주등장하는자료구조.A스택과큐.스택.올바른괄호;

import java.util.Stack;

public class 올바른괄호_효율성fail {
    // main은 왜 static일까?
    public static void main(String[] args) {
        Stack<String> st = new Stack<>();

//        String s = "()()";
        String s = "(()(";


        // 배열로
        String[] ss = s.split("");


        boolean check;
        for(String i: ss){
            // 덮는걸로 시작하면 그냥 끝
                if(i.equals("(")){
                    st.add(i);
                } else if (i.equals(")") ) {
                    if(st.isEmpty()) check = false;
//                    st.peek().equals("(");  => 이런 경우는 없다 ) 일때 이미 끝나서
                    st.pop();
                }


        }

        check = st.isEmpty();
        System.out.println(check);

    }
}
