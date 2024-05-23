package Programmers.오토에버시험대비_구현.재귀베이스.C.BFS_DFS.깊이우선탐색_탐색공간내목표가있는지;

import java.util.Stack;

public class 스택DFS {
    public static void main(String[] args) {
        int N = 100;
        int[] getNextStates = new int[]{};

        //(1) 방문 검사 배열
        boolean[] isVistited = new boolean[N];

        Stack<Integer> stack = new Stack<>();
        //(2) 초기상태
        stack.add(/* intialState */ 0);

        //(3) 탐색 진행
        while(!stack.isEmpty()){
            int state = stack.pop();

            //(4) 중복 검사
            if(isVistited[state]) continue;
            isVistited[state] = true;

            //(5) 현재 상태 처리
            /* 현재 상태 state 처리 */

            //(6) 전이상태 생성
            for(int next : getNextStates){
                //(7) 범위 검사
                if(!true/* 범위 검사 조건*/){
                    // 문제 범위를 벗어나는 상태는 제외 합니다
                    continue;
                }

                // (8) 유효성 검사
                if(!false/*유효성 검사 조건*/){
                    // 문제의 조건을 어기는 상태는 제외합니다.
                    continue;
                }

                //(9) 상태전이
                stack.push(next);
            }

        }



    }
}
