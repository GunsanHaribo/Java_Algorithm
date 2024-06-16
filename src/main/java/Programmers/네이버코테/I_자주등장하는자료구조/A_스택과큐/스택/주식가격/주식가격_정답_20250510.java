package Programmers.네이버코테.I_자주등장하는자료구조.A_스택과큐.스택.주식가격;

import java.util.Stack;

public class 주식가격_정답_20250510 {
    public static void main(String[] args) {
        int[] prices = new int[]{1,2,3,2,3};
        int[] answer = new int[prices.length];

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i< prices.length; i++){

            // 현재 스택에서 뽑은거...랑
            // 스택꺼랑 for문 돌아가는거랑 비교해서 for문 돌아가는게 더 작으면


            // 스택에서 인덱스 뽑아서 얼마나 안 떨어졌는지 구한다

            // 스택에 있는거랑 다음거랑 비교해서 가격이 떨어진거 찾는다
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }

            // 초기 & 더 큰 원소를 만나면 그냥 스택에 넣어준다
            stack.push(i); // 이거 넣는다
        }

        while(!stack.isEmpty()){
            int index = stack.pop();
            answer[index] = prices.length - index -1; // 인덱스 length를 통한 길이
        }

        System.out.println(answer);
    }
}
