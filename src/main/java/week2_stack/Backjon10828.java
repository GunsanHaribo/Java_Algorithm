package week2_stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Backjon10828 {
    public static void main(String[] args) throws IOException {

        Stack<Integer> stack = new Stack<Integer>();
        BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
        int num_var = Integer.parseInt(scanner.readLine());

        for(int i=0; i<num_var; i++){
            StringTokenizer st = new StringTokenizer(scanner.readLine());
            //토큰 해서 만얀 처음이 push면 hasmoretockens()해서 push 해주고
            //나머지는 switch 문으로 해주기
            String get_function = st.nextToken();
            switch(get_function){
                case "pop":
                    System.out.println(stack.pop());;
                    break;
                case "push":
                    int get_input = Integer.parseInt(st.nextToken());
                    stack.push(get_input);
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.empty());
                    break;
                case "top":
                    System.out.println(stack.top());
                    break;
            }
        }



    }

    private static class   Stack<T> {
        ArrayList<T> stack = new ArrayList<T>();
        public  void push(T newElement){
            stack.add(newElement);
        }
        public int pop(){
            if(empty() == 0){
                T remind = stack.get(stack.size()-1);
                stack.remove(stack.size()-1);

                return (int) remind;
            }
            return -1;

        }
        public int size(){

            return  stack.size();
        }
        public int empty(){
            if(stack.size()>0){
                return 0;
            }
            return 1;
        }
        public int top(){
            if(empty()==0){
                return (int) stack.get(stack.size()-1);
            }
            return -1;

        }
    }
}
