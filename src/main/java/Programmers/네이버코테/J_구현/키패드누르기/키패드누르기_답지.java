package Programmers.네이버코테.J_구현.키패드누르기;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 키패드누르기_답지 {

    // 한 원소 당으로 처리할 생각을 해야한다
    public static void main(String[] args) {
//        int[][] keypad = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-10, 0, -20}};
        int[] numbers = new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};

        String hand = "left";
        Hand right = new Hand("R", hand.equals("right"), 2);
        Hand left = new Hand("L", hand.equals("left"), 0);

        String s = Arrays.stream(numbers)
                .mapToObj(n -> press(n, right, left).hand)
                .collect(Collectors.joining());

        System.out.println(s);
    }

    // Hand를 난왜 클래스로 만들생각을 못했을까..
    // 이유가 뭘까... 왼쪽 오른쪽이면
    private static class Hand{
        // 변수
        private final int baseX;
        public final String hand;
        public final float preference;

        private int x;
        private int y;

        public Hand(String hand, boolean idPreferred, int x) {
            this.hand = hand;
            this.baseX = x;
            this.preference = idPreferred ? 0.5f:0;
            this.x = x;
            this.y = 3;
        }

        // distance
        public float distance(int x, int y){
            if(x == baseX) return 0;
            int distance = Math.abs(x-this.x) + Math.abs(y-this.y);
            return distance - preference;
            // preference 주손이면 0.5 빼준다 그래서 거리가 같다면...0.5낮춘다
            // 거리는 정수단위기 때문에 0.5를 뺀다고 해도 크기 비교에 문제가 없다
        }
        // 이동-move
        public void move(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    private static int getX(int number){
        // 0이 키패드 밑에 위치한다
        if(number ==0) return 1;
        return (number -1) %3;
    }

    private static int getY(int number){
        // 0이 키패드 밑에 위치한다
        if(number ==0) return 3;
        return (number -1)/3;
    }

    // 누르는 로직
    private static Hand press(int number, Hand right, Hand left){
        int x = getX(number);
        int y = getY(number);

        float rDistance = right.distance(x,y);
        float lDistance = left.distance(x,y);

        // 기본 값 right로 설정
        Hand hand = right;
        if(lDistance < rDistance){
            // 왼쪽이 가까우면 왼손 이용한다
            hand = left;
        }

        // 손 움직이기
        hand.move(x,y);
        return hand;
    }



}
