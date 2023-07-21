package week5_Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class backjoon_11729_하노이탑 {
//    static String content = "";
    static int count = 0;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {


        BufferedReader st = new BufferedReader(new InputStreamReader(System.in));
        int max_number = Integer.parseInt(st.readLine());


        hanoi(1,3, max_number);
        System.out.println(count);
        System.out.println(sb);
    }

    public static void hanoi(int a, int b, int n){
        //스택 one에 있다면
        //마지막에 stack three에 있어야되고
        //n과 n-1일때 그 차이점이 있을까

        if(n == 1){
//            System.out.println("if문 들어옴");
//           content += "("+a+" "+b+")\n";
           sb.append(a).append(" ").append(b).append("\n");
           count +=1;
           return; // 끝내야하니깐 리턴 넣어준다
        }
//        System.out.println("if문 밖");
        hanoi(a,6-a-b,n-1);
//        content+="("+a+","+b+")\n";
        sb.append(a).append(" ").append(b).append("\n");
        count +=1;
//        System.out.println(content);
        hanoi(6-a-b,b,n-1);


    }

}
