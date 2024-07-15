package ZZ_SW_ExpertAcademy.문방구패턴_맞추기게임;

import java.util.Scanner;

class Solution {

    private static final int UP		= 0;
    private static final int RIGHT	= 1;
    private static final int DOWN	= 2;
    private static final int LEFT	= 3;

    private static final UserSolution usersolution = new UserSolution();

    private static int[][] orgBoard = new int[5][5]; // 배열로 구현했네
    private static int[][] orgPattern = new int[3][3]; // 3*3
    private static int emptyY, emptyX;
    private static int callCnt;

    public static boolean swap(int dir) {

        int dy[] = { -1, 0, 1, 0 };   // 배열 중심 상우하좌
        int dx[] = { 0, 1, 0, -1 };

        ++callCnt;  // 한번 옯기때마다 카운트 +1

        if (dir < UP || dir > LEFT) {  // dir은 0~4사이의 값
            return false;
        }

        int newY = emptyY + dy[dir];   // 초기 Y,X를 기준으로 이동하는 새로운 값(빈칸 기준 )
        int newX = emptyX + dx[dir];

        if (newY < 0 || newY >= 5 || newX < 0 || newX >= 5) { // 새로운 좌효가 5*5밖으로 나가면 종료한다 ㄴ
            return false;
        }

        // swap
        orgBoard[emptyY][emptyX] = orgBoard[newY][newX]; // 전에 블럭에 있던 색칠된 값을 내린다
        orgBoard[newY][newX] = 0;  // 블럭이 있던 좌표에 0(빈칸 위치 변경)
        emptyY = newY;
        emptyX = newX;

        return true;
    }

    private static boolean run(Scanner sc) {
        int[][] board = new int[5][5];
        int[][] pattern = new int[3][3];
        int callCntLimit;

        callCntLimit = sc.nextInt();  // 500

        // 5*5 정답 좌표를 채운다
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {
                orgBoard[i][j] = board[i][j] = sc.nextInt(); // 보드에 하나씩 숫자를 체운다 1~6과 빈칸 0

                if (board[i][j] == 0) {  // 빈칸 좌표를 저장해 놓는다
                    emptyY = i;
                    emptyX = j;
                }
            }
        }

        // 3*3 정답 블록을 채운다
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                // 두개 배열이 서로 다른 주소에 저장된다
                orgPattern[i][j] = pattern[i][j] = sc.nextInt();
            }
        }

        callCnt = 0;
        // solve 함수 근데 swap을 아지 않넣네 아무튼 5*5 3*3, callLimit를 매개변수로
        usersolution.solve(board, pattern, callCntLimit);
        // 안넘었으면 true
        boolean isCorrect = (callCnt <= callCntLimit);
        // 패턴 맞는지 체크
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (orgBoard[i + 1][j + 1] != orgPattern[i][j]) {
                    isCorrect = false;
                }
            }
        }
        // callCntLimit 안넘고
        // 3*3 패턴 맞으면 true 반환
        return isCorrect;
    }

    public static void main(String[] args) throws Exception {
        int test, T;

         System.setIn(new java.io.FileInputStream("/Applications/Spring/ProgrammerCodingTest/src/main/java/ZZ_SW_ExpertAcademy/문방구패턴_맞추기게임/input5.txt"));

        Scanner sc = new Scanner(System.in);

        T = sc.nextInt(); // 테스트 케이스의 갯수
        // 성공하면(true 반환시)  100 아니면 0반환
        for (test = 1 ; test <= T ; ++test) {
            if (run(sc)) {
                System.out.println("#" + test + " 100");
            } else {
                System.out.println("#" + test + " 0");
            }
        }
    }

}