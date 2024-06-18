package Programmers.네이버코테.J_구현.프로그래머스.키패드누르기;

// 요구사항 | 변수 :
//  1) 각 번호를 누른 엄지 손가락인 왼손인지 오른손인지 나타내라
//  2) 1,4,7 왼손  3,6,9 오른손 2,5,8,0 이면 누를 키패드에서 거리가 가까운 손을 사용하라
// | 위치는 x,y로 계산한다 (왼손위치, 오른손위치), 눌러야 할 숫자, 사용한 손

// 흐름
// 1. 좌표 불러와야 되니깐 hashmap 사용하자그냥 , int[][] 해서
// 2. switch로 한다 | 1,4,7 왼손 | 3,6,9는 오른손 | 2,5,8,0 일떄 눌러야되는 숫자 계산하기
// 3. List  추가하기

import java.util.HashMap;
import java.util.Map;

public class 키패드누르기_내풀이 {
    static int left_hand_position = -10;
    static int right_hand_position = -20;
    public static void main(String[] args) {
        int[][] keypad = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-10, 0, -20}};

        // 키패드 좌표 변환
        Map<Integer, coordiation> Real_KeyPad = new HashMap<>();

        for(int i = 0; i<keypad.length ; i++){
            for(int j=0; j< keypad[i].length; j++){
                Real_KeyPad.put(keypad[i][j], new coordiation(i,j));
            }
        }

        int[] numbers = new int[]{7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        StringBuilder sb = new StringBuilder();


        // position 갱신 되야된다
        // switch문 쓰는법 익혀야됨
        for(int i : numbers){

            if(i == 1 || i== 4 || i == 7){
                sb.append("L");
                left_hand_position = i;
            } else if (i == 3 || i== 6 || i ==9) {
                sb.append("R");
                right_hand_position = i;
            }else{
                //
                String r = calculate(i, hand, Real_KeyPad);
                sb.append(r);
            }

        }

        System.out.println(sb.toString());

    }

    // hand도 받아야됨
    public static String calculate(int i, String hand, Map<Integer, coordiation> Real_KeyPad){

        // distance 구하는거 뺏었어야된다
        // left 계산
        int between_left_x  = Math.abs(Real_KeyPad.get(i).x -  Real_KeyPad.get(left_hand_position).x);
        int between_left_y  = Math.abs(Real_KeyPad.get(i).y - Real_KeyPad.get(left_hand_position).y);
        int between_left = between_left_x + between_left_y;

        // right 계산
        int between_right_x = Math.abs((Real_KeyPad.get(i).x  -  Real_KeyPad.get(right_hand_position).x));
        int between_right_y = Math.abs(Real_KeyPad.get(i).y - Real_KeyPad.get(right_hand_position).y );
        int between_right = between_right_x  + between_right_y;


        int differ_disstance = between_left - between_right;

        // 만약 같으면 잡이체크
        if(differ_disstance<0){
            // 왼쪽이 더 짧으면 외쪽으로 이동
            left_hand_position = i;
            return "L";
        } else if (differ_disstance>0) {
            right_hand_position = i;
            return "R";
        }else{

            if(hand.equals("right")){
                right_hand_position = i;
                return "R";
            }else{
                // 이거
                left_hand_position = i;
                return "L";
            }
        }

    }

    static class coordiation{
        int x;
        int y;
        public coordiation(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
