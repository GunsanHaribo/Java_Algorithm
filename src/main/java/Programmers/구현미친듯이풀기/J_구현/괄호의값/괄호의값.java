package Programmers.구현미친듯이풀기.J_구현.괄호의값;


// 요구사항 :
// 1. 올바른 괄호열이 나온다고하면 괄호열을 통해 수치를 뱉어라
// 2. () - >2  [] -> 3
// 3.
// 변수 : 괄호와 괄호를 통해 나오는 값들

// 흐름이 이렇게 흘러갈 것이다 이런게 필요하네

// 흐름
// 1. 올바른 괄호인지 검증한다 -> 문자열을 stack에 넣어보면서 검증, 틀리면 0반환
// 2. 검증을 하면서 닫는 괄호일 떄 stack에 첫번쨰 요소가 숫자면 sum만들어 놓고 더한다
// 3. 그리고 짝이 맞는 여는 괄호가 있으면 sum * para 를 한다

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class 괄호의값 {
    public static void main(String[] args) throws IOException {

//        String value = "(()[[]])([])";
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        String value  = "[][]((])";
        String value = br.readLine();
        String[] v = value.split("");
//        System.out.println(Arrays.toString(v));

        // 숫자인지 확인하는 방법은 문자가 파싱이 가능한지 예외처리로 체크한다
        int answer = calculate_number(v);

        bw.append(answer+"");
        bw.close();
        System.out.println(answer);
    }

    public static int calculate_number(String[] v){

        Stack<String> stack = new Stack<>();
        // 스택에 넣는다
        // 만약 peek해서 짝이 맞으면 숫자로 바꾼다
        for(String s: v){
            switch (s) {
                case "[", "("  -> {
                    stack.push(s);
                    System.out.println(s);
                }
                case "]" -> {
                    int sum = 0;
                    if(stack.isEmpty()){
                        return 0;
                    }
                    String peek = stack.peek();
                    System.out.println(s);

                    // 디지털 아니면 false 여서 true되는데?
                    // 없애는게 맞는데?
                    while (isDigit(peek) && !stack.isEmpty()){
                        // 계속 peek 해줘야함
                        // 여기서 문제가 나오는데
                        if(!stack.isEmpty()){
                            String pop= stack.pop();
                            sum += Integer.parseInt(pop);
                        }

                        if(!stack.isEmpty()){
                            peek = stack.peek();
                        }

                        System.out.println("합게"+sum);

                        // 계산하다여 여기 들어왔을떄
                    }


                    // 만약 디지털이 아니라면 이렇게 한다
                    if(peek.equals("[")) {
                        // 짝이 맞으면
                        String pop= stack.pop();
                        if(sum==0){
                            int cal = 3;
                            stack.push(cal + "");
                            System.out.println("스택 들어감 "+stack.peek());
                        }else{
                            // sum *3 구한다
                            int cal = sum*3;
                            stack.push(cal + "");
                        }
                    }else {
                    // 짝이 안 맞으면
                        return 0;
                    }

                }
                case ")" -> {
                    int sum = 0;
                    // 스택이 비어있으면 retunr 0

                    if(stack.isEmpty()){
                        return 0;
                    }
                    String peek = stack.peek();
                    System.out.println(s);


                    // true일때만 진행
                    while (isDigit(peek) && !stack.isEmpty()){

                        String pop= stack.pop();
                        sum += Integer.parseInt(pop);

                        if(!stack.isEmpty()){
                            peek = stack.peek();
                        }

                        System.out.println("합게"+sum);
                    }

                    // 만약 디지털이 아니라면 이렇게 한다
                    if(peek.equals("(")) {
                        String pop= stack.pop();
                        if(sum==0){
                            int cal = 2;

                            stack.push(cal + "");
                            System.out.println("스택 들어감 "+stack.peek());

                        }else{
                            // sum *3 구한다
                            int cal = sum*2;
                            stack.push(cal + "");
                        }
                    }else {
                        return 0;
                    }


                }
            }



        }
        int answer =0;
        // number 아니면
        while(!stack.isEmpty()){
            String pop = stack.pop();
            if(!isDigit(pop)){
                return 0;
            }
            answer += Integer.parseInt(pop);
        }

        return answer;
    }

    public static boolean isDigit(String k){

//        System.out.println("디지털 들어감 "+k);
        int number =0;
        try{
            number = Integer.parseInt(k);
            //2인데도//
            System.out.println("파싱완료"+number);
        }catch (Exception e){
//            System.out.println("값: "+ number+" 정수아님");
        }

        boolean answer = false;

        if(number != 0){
            answer = true;
        }


        return answer;
    }




}
