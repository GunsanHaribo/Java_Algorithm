package Programmers.D_완전탐색.BFS_DFS.깊이우선탐색_탐색공간내목표가있는지.타겟넘버;


// 접근을 못하겠다....답지 분석으로 간다
// 요구사항 : 숫자에 - + 를 사용해서 목표숫자가 나오는 조합을 구하라
// 변수 :  숫자와  -+, 숫자 담긴 배열, stack(저장소)



// 어떻게 스택이 DFS를 할 수 있지?
// 흐름
// 1. 숫자에서 자식 노드에 해당하는 -, + 로 이동한다
// 2. 근데...이동하면 어떻게 되는거지?



import java.util.Stack;

public class 타겟넘버_20240530 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1,1,1,1,1};
        int target = 3;

        Stack<State> s = new Stack<>();
        s.push(new State(0,0));

        int count = 0;

        while(!s.isEmpty()){
            State state = s.pop(); // 뽑는다

            if(state.index == numbers.length){
                if(state.acc == target) count ++; // target이 나오면
                continue;
            }
            // +를 선택한 경우 ?, - 아닌가? //
            s.push(new State(state.index +1, state.acc - numbers[state.index] ));

            // -를 선택한 경우, + 아닌가?
            s.push(new State(state.index +1, state.acc + numbers[state.index] ));
        }


    }

    // 이거 정의가 어려운데
    // 이런 생각 못하겠는데
    // 왜 index랑 acc를 가지지?.. 어떻게 이런 생각을하지...
    private static class State{
        public final int index;
        public final int acc; // 지금까지 누적값 저장

        public State(int index, int acc) {
            this.index = index;
            this.acc = acc;
        }
    }


}
