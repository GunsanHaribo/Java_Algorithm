package ZZ_SW_ExpertAcademy.문방구패턴_맞추기게임;

import java.io.FileNotFoundException;
import java.util.*;


class UserSolution {
    // 그니깐 지금 swap을 한다고 해도
    // orgBoard개 solution것이 변경이 되는게 문제
    // 그니깐 지금 여기서 swap을 안하고 지워도 잘 반영이 되긴 할건데
    // 그니깐 지금 userEmptyY, userEmptyX도 solution껄 사용해야된다 지금 전역변수로 있는것들

    // 그럼 board 최신화는 도대체 어떻게 하는거지?
    // 그니깐 argumentBoard가 바뀔떄 같이 바뀌어야 되는게 문제인데

    private static int userEmptyY, userEmptyX;  // 이거는 수정사항 // 이거 다시 설정해줘야 된다
//    private static int EmptyY, EmptyX;  // 이거는 수정사항 // 이거 다시 설정해줘야 된다
    private static int[][] orgBoard = new int[5][5]; // 배열로 구현했네
    private static int[][] orgPattern = new int[3][3]; // 3*3
    private static int callCnt;

    private static final int UP = 0;
    private static final int RIGHT = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;

    private static final int dy[] = {-1, 0, 1, 0};   // 배열 중심 상하우좌
    private static final int dx[] = {0, 1, 0, -1};

    // 아마 이건 게속 사용해도 된다는거 같고 dir은 0~3이다
    // Main API:
    //	  Solution.swap(int dir)


    public static void solve(int[][] board, int[][] pattern, int callCntLimit) {

        // 5*5 정답 좌표를 채운다
        for (int i = 0; i < 5; ++i) {
            for (int j = 0; j < 5; ++j) {

                if (board[i][j] == 0) {  // 빈칸 좌표를 저장해 놓는다
                    userEmptyY = i;
                    userEmptyX = j;
                }
            }
        }


        // 패턴 넣어 주면서
        int boardSize = board.length;
        int patternSize = pattern.length;
        boolean[][] saveFixedYX = new boolean[boardSize][boardSize]; // board 사이즈 기준으로 한다
        // 1. 패턴 for문 :  정해지지 않는 블록을 고름다
        for (int i = 0; i < patternSize; i++) {
            for (int j = 0; j < patternSize; j++) {
//                System.out.println("새로운시작");
                int[] patternYX = new int[]{i, j};
                makePattern(board, pattern, patternYX, saveFixedYX);
                // 만약에 위에 과정을 정상적으로 완료했으면
                // 패턴 y,x 다라서
                saveFixedYX[patternYX[0] + 1][patternYX[1] + 1] = true;
            }
        }


    }

    // 이게 패턴 마다 한 큐로 들어간다
    public static void makePattern(int[][] board, int[][] pattern, int[] patternYX, boolean[][] saveFixedYX) {  // 그래서

        Map<int[], List<int[]>> semiResult = new HashMap<>();
//        List<List<int[]>> semiResult = new ArrayList<>();
        // 1. 3*3 패턴에 있는 블록 중 하나와 같은 색상을 찾는 함수 => 이거는 찾으면 바로 끝내도 된다

        // 이걸 그니깐 색깔 갯수만큼 넣어서 pattern좌표의 색깔에 해당하는 좌표들을 담는다
        // for문으로 원소를 넣고 거기까지 가기위한 너무 쳐맞는다

        // 타겟하는 패턴과 Color들의 location을 찾는다
        List<int[]> sameColorLocation = findSameColorsLocation(board, patternYX, pattern, saveFixedYX);


//        System.out.println("패턴의 위치 YX: "+Arrays.toString(patternYX));
//        System.out.println();

        // 그 location이 target하고 얼마나 떨어져 있는지 계산한다
        for (int[] colorLocation : sameColorLocation) {
            // 역순 사용 금지
            // 패턴이 1,2가 들어간건데
//            System.out.println("같은 칼라 있는 곳들 로케이션" + Arrays.toString(colorLocation));

            // 패턴의 특정 인덱스부터 같은 색깔을 가지는 블락까지의 길을 구한다 그니깐 1,2  -> color를 구한다
//            System.out.println("patternXY" + Arrays.toString(patternYX) + " color의 위치: " + Arrays.toString(colorLocation));
            List<int[]> path = findSameColorPath(colorLocation, board, patternYX, saveFixedYX, "pattern", new int[0]);
            // sameColor가 없을때? 나온다?

//            System.out.println("길반환");
            // path가 0이여서 안된다
            for (int[] j : path) {
//                System.out.println("path 요소 : " + Arrays.toString(j));
            }
//            System.out.println();

            semiResult.put(colorLocation, path);
        }


        Set<int[]> key = semiResult.keySet();
        ArrayList<int[]> keys = new ArrayList<>(key);
        keys.sort((a, b) -> semiResult.get(a).size() - semiResult.get(b).size());

//        System.out.println("키셋: " + keys);


        int[] smallestKey = keys.get(0);
//        semiResult.sort((a,b)-> a.size()- b.size()); // 가장 짧은거 이거 찾야야된다 좌표


        List<int[]> certainColorPath = semiResult.get(smallestKey);
        certainColorPath.remove(0);

        // 출력
        if (certainColorPath == null) {
//            System.out.println("certainColorPath 잘못됨");
        } else {
//            System.out.println("certainColorPath 문제있는지 확인");
            for (int[] i : certainColorPath) {
//                System.out.println("certainColorPath 요소 : " + Arrays.toString(i));
            }
        }


        int[] blankStartYX = {userEmptyY, userEmptyX}; // 바뀌는거 완료
        int[] targetColorLocation = {smallestKey[0], smallestKey[1]};


        int target = pattern[patternYX[0]][patternYX[1]];
//        System.out.println("타겟 숫자:" + target);
//        System.out.println();
        // 여러개가 아마 나올 것 같은데
        for (int[] colorYX : certainColorPath) {

            // 2. 빈칸이 길까지 가는 path
            // 빈칸부터 길의 첫쨰 요소 까지의 path를 구한다
//            System.out.println();
//            System.out.println("colorYX : " + Arrays.toString(colorYX));
//            System.out.println("blankStartYX : " + Arrays.toString(blankStartYX));
//            System.out.println("targeColorLocation: " + Arrays.toString(targetColorLocation));
            List<int[]> blankToColorPath = findSameColorPath(blankStartYX, board, colorYX, saveFixedYX, "targetColorBlockSetted", targetColorLocation);
            // 2,4로 가기 위한 path를 찾는다 빈칸(4,4)하고 비교해서

            // 길이 나오면 path의 좌표를 중심으로
            // 3. 현재 빈칸의 위치하고 빈칸까지 가는 path하고 비교해서 swap 한다
            blankToColorPath.remove(0);
//            int check = 0;
            for (int[] coor : blankToColorPath) {

//                System.out.print("이거: " + Arrays.toString(coor) + ",");

                // 여기서 애러가 하는데
                int dir = findDir(coor); // 상하우좌 결정
//                System.out.println(dir);
                changeBoard(dir, board);
//                System.out.println("수정된 blankStartY : " + userEmptyY + "X" + userEmptyX);
            }
            // 여기서 colorblank 하고 swap 한번 더해야된다
            // 그래야 color 이동시킬수 있음

            // 위에껄 했을때 아래껄 하는게 맞긴해 그니깐
            int blankToTarget = findDir(targetColorLocation);
            // 여기서 바꾸는거 까지는 오케이 근데 경로를 잡을때 target은 건들지 않게 해야된다
            // 그리고 Swap을 하면 targetColor 로케이션도 변경이 되게 해야된다
            // 다 바꾸고 나서? 마지막 할때
            targetColorLocation = new int[]{userEmptyY, userEmptyX}; // 옯기고 나서 blankStart 바꾸는거 완료
//            System.out.println(Arrays.toString(targetColorLocation));
            changeBoard(blankToTarget, board);
//            swap(blankToTarget);
            // 빈칸 옮기고 나서 마지막으로 targetColorBlock하고 Blank하고 바꾸는거 완료
            blankStartYX = new int[]{userEmptyY, userEmptyX}; // 바뀌는거 완료
//            System.out.println(Arrays.toString(blankStartYX));
//
//            System.out.println();
        }

    }

    public static boolean changeBoard(int dir, int[][] board) {

//        swap(dir); // 지금 blank가 바뀌어야하는데 안바뀐다  이거 정이 필요
        Solution.swap(dir);

        // 코드에서 가진 board랑 동기화 시켜준다
        int dy[] = {-1, 0, 1, 0};   // 배열 중심 상우하좌
        int dx[] = {0, 1, 0, -1};

        if (dir < UP || dir > LEFT) {  // dir은 0~4사이의 값
            return false;
        }

        int newY = userEmptyY + dy[dir];   // 초기 Y,X를 기준으로 이동하는 새로운 값(빈칸 기준 )
        int newX = userEmptyX + dx[dir];

        if (newY < 0 || newY >= 5 || newX < 0 || newX >= 5) { // 새로운 좌효가 5*5밖으로 나가면 종료한다 ㄴ
            return false;
        }

        board[userEmptyY][userEmptyX] = board[newY][newX]; // 전에 블럭에 있던 색칠된 값을 내린다
        board[newY][newX] = 0;  // 블럭이 있던 좌표에 0(빈칸 위치 변경)
        userEmptyY = newY;
        userEmptyX = newX;

//        for(){
//            System.out.println(board);
//        }


        return true;
    }

    // 문제점 : board가 지금 같이 바뀌어야되는데 안바뀜
    public static int findDir(int[] pathEleCoor) {

        // 움직여야 될거 뽑는다
        int moveDy = pathEleCoor[0] - userEmptyY;
        int moveDx = pathEleCoor[1] - userEmptyX;
        // 상하우좌
//                private static final int dy[] = { -1, 0, 1, 0 };   // 배열 중심 상우하좌
//                private static final int dx[] = { 0, 1, 0, -1 };

        for (int i = 0; i < dx.length; i++) {
            boolean checkY = (moveDy == dy[i]);
            boolean checkX = (moveDx == dx[i]);

            boolean check = (checkY && checkX);
            if (check) {
//                    System.out.println("들어옴 ;"+ Arrays.toString(pathEleCoor));
                switch (i) {
                    // 상
                    case 0: {
                        return 0;
                    }
                    // 우
                    case 1: {
                        return 1;

                    }
                    // 하
                    case 2: {
                        return 2;
                    }
                    //좌
                    case 3: {
                        return 3;
                    }

                }
            } else {
//                    System.out.println("check가 false일떄");
            }

        }


        return -100;
    }


    public static List<int[]> findSameColorsLocation(int[][] board, int[] patternYX, int[][] pattern, boolean[][] saveFixedYX) {

        int boradSize = board.length;
        int target = pattern[patternYX[0]][patternYX[1]];


//        System.out.println("Y:" + patternYX[0] +"X:" + patternYX[1]);
//        System.out.println("target"+target);
        // 맞음
        List<int[]> sameColorLocation = new ArrayList<>();

        for (int i = 0; i < boradSize; i++) {
            for (int j = 0; j < boradSize; j++) {
                if (saveFixedYX[i][j]) {
                    continue;
                }

                // board를 돌면서 target 과 같은 숫자가 있으면 X,Y 한다
                /////////////// 여기 변경된 보드....
                if (board[i][j] == target) {
                    sameColorLocation.add(new int[]{i, j}); // Y, X
                } else {
                    continue;
                }

            }
        }

//        for(int[] i : sameColorLocation){
//            System.out.println("칼라패스 선택: "+Arrays.toString(i));
//        }

        return sameColorLocation;
    }


    // 길의 첫번째 두번째 부분으로 가는 빈칸의 최단 거리를 구한다

    // 배열의 전체 크기
    // 큐에 언제 더 할게 없어지지? -> 종료 조건
    // 칸의 개수가 언제 최솟값이 되지? -> 이건 밖에서 구한다
    public static List<int[]> findSameColorPath(int[] startYX, int[][] board, int[] pattern, boolean[][] saveFixedYX, String type, int[] targetColorLocation) {
        // 여기에 좌표가 있을 수도 있고~~
        int boradSize = board.length;

        // 여기서 이게 맞나? // 또 전체 board하고 조금 달라서 약간식 처리 해줘야 된다
        // 아마 패턴  0,1이 있으면 -> 이게 맞는게 : 0+1 =>1 , 1+1 => 2 로 한다
        int targetY;
        int targetX;
        if (type.equals("pattern")) {
            targetY = pattern[0] + 1;
            targetX = pattern[1] + 1;
        } else {
            targetY = pattern[0];
            targetX = pattern[1];
        }


        boolean[][] isVisited = new boolean[boradSize][boradSize];

        Queue<StateNode> queue = new LinkedList<>();

        // 스타트좌표 // xy조심하기
        int startY = startYX[0];
        int startX = startYX[1];

        // 초기상태?
        queue.add(new StateNode(startY, startX, new ArrayList<>()));
        isVisited[startY][startX] = true;


        // 탐색
        while (!queue.isEmpty()) {
//            System.out.println("큐 들어옴 ");
            StateNode state = queue.poll(); // 이거 vector될듯 아무튼 i,j 형태임

            // 종료조건 서술, 스탭 및 길 좌표 연결
            // 하나만 가지고 있을 수도 그리고 도착을 하면 return해서 BFS를 끝낸다는이야기
            if ((state.x == targetX) && (state.y == targetY)) {
//                System.out.println("종료됨");
                // 그니깐 큐는 계속
                return state.path;
            }

            // 상하좌우 탐색한 리스트를 반환 하자
            // 근데 이걸 계속해야 되는데
            for (int i = 0; i < dx.length; i++) {
                int ny = state.y + dy[i];
                int nx = state.x + dx[i];

                // 범위 검사
                if (nx < 0 || nx >= boradSize || ny < 0 || ny >= boradSize) {
                    continue;
                }

                // 유효성 검사?? -> 이건 뭔데 장벽 가은 검사
                if (saveFixedYX[ny][nx]) {
                    continue;
                }

                // 중복 검사 -> 이미 방문을 했는가??
                if (isVisited[ny][nx]) {
                    continue;
                }
                // 타겟 color가 정해졌을떄는 우회해서 가야된다
                if (type.equals("targetColorBlockSetted") && (targetColorLocation.length != 0) && ny == targetColorLocation[0] && nx == targetColorLocation[1]) {
                    continue;
                }

                // 방문 처리 -> 큐에 들어가면서
                isVisited[ny][nx] = true;
                // 큐가 안되는 건가?
                queue.add(new StateNode(ny, nx, state.path));
            }
        }

        return null;
    }


    // 이거 x,y 바뀌어야 되잖아 계속 바뀌어야 되는게 오반데
    static class StateNode {
        private int x;
        private int y;

        // 자신의 노드를 생성할때 추가한다?
        // path가 계속 이어져야 되는데 그러면 큐에 새롭게 추가할때 새롭게 전이 되는 path를 추가한다
        private List<int[]> path = new ArrayList<>();

        public StateNode(int y, int x, List<int[]> previousPath) {
            this.x = x;
            this.y = y;
            // 이전 원소를 복사한다
            path.addAll(previousPath);
            path.add(new int[]{y, x});
        }

    }
}
//
//    public static void main(String[] args) throws FileNotFoundException {
//        // 1. StateNode 정상작동
////        List<int[]> ss= new ArrayList<>();
////        ss.add(new int[]{1,2});
////        ss.add(new int[]{3,4});
////        StateNode ss2= new StateNode(6,7, ss);
////
////        for(int[] i : ss2.path){
////            System.out.println(Arrays.toString(i));
////        }
////        int test, T;
//
//        System.setIn(new java.io.FileInputStream("/Applications/Spring/ProgrammerCodingTest/src/main/java/ZZ_SW_ExpertAcademy/문방구패턴_맞추기게임/text.txt"));
//
//        Scanner sc = new Scanner(System.in);
//        // 성공하면(true 반환시)  100 아니면 0반환
//        // input 받기
//        int[][] board = new int[5][5];
//        int[][] pattern = new int[3][3];
//        int callCntLimit;
//
//        callCntLimit = sc.nextInt();  // 500
//
//        // 5*5 정답 좌표를 채운다
//        for (int i = 0; i < 5; ++i) {
//            for (int j = 0; j < 5; ++j) {
//                board[i][j] = sc.nextInt();
//
//                if (board[i][j] == 0) {  // 빈칸 좌표를 저장해 놓는다
//                    EmptyY = i;
//                    EmptyX = j;
//                }
//            }
//        }
//
//        // 3*3 정답 블록을 채운다
//        for (int i = 0; i < 3; ++i) {
//            for (int j = 0; j < 3; ++j) {
//                 pattern[i][j] = sc.nextInt();
//            }
//        }
////////////////  input 끝 ///////////////////
//
////        boolean[][] saveFixedYX = new boolean[board.length][board.length];
//////        saveFixedYX[1][3] = true;
////
////        // 2. findSameColorPath 작동 // saveFixed 하는 것 까지 된다
////        // YX 로 넣어준다
////        int[] colorStartYX = new int[]{4,3};
////        int[] pattern_s = new int[]{1,2};   // 이게 지금 하고자 하는 패턴 2,3 으로 들어감
////        List<int[]> path = findSameColorPath(colorStartYX, board, pattern_s, saveFixedYX, "pattern");
////
////
////        if(path == null){
////            System.out.println("다시해라");
////        }else{
////            for(int[] i: path){
////                System.out.print(Arrays.toString(i) +", ");
////            }
////            System.out.println();
////        }
////        // 4. findSameColorsLocation -> 정상 작동함
////        // 5. findDir -> 상우하좌 -> 정상작동함
//////        int[] coor = {4,5};   // 넣는건 x,y 순으로
//////        System.out.println("dir:"+findDir(coor));  // 이때 3 나오면 됨
////
////
////        // 6.  makePattern // YX 로 좌표를 넣어준다는 가정하에 정답 -> 굳 잘몰아감
////        makePattern(board, pattern, pattern_s, saveFixedYX);
//
//
//
//
//        solve(board, pattern,callCntLimit);
//        // pattern 길이 만큼 출력
//        for (int i = 0; i < 3; ++i) {
//            for (int j = 0; j < 3; ++j) {
////                if (orgBoard[i + 1][j + 1] != orgPattern[i][j]) {
////
////                }
//                System.out.print( board[i + 1][j + 1]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println("콜카운트"+callCnt);
//
//
//    }
//
//    public static boolean swap(int dir) {
//
//        int dy[] = { -1, 0, 1, 0 };   // 배열 중심 상우하좌
//        int dx[] = { 0, 1, 0, -1 };
//
//        ++callCnt;  // 한번 옯기때마다 카운트 +1
//
//        if (dir < UP || dir > LEFT) {  // dir은 0~4사이의 값
//            return false;
//        }
//
//        int newY = EmptyY + dy[dir];   // 초기 Y,X를 기준으로 이동하는 새로운 값(빈칸 기준)
//        int newX = EmptyX + dx[dir];
//
//        if (newY < 0 || newY >= 5 || newX < 0 || newX >= 5) { // 새로운 좌효가 5*5밖으로 나가면 종료한다 ㄴ
//            return false;
//        }
//
//        // swap
//        orgBoard[EmptyY][EmptyX] = orgBoard[newY][newX]; // 전에 블럭에 있던 색칠된 값을 내린다
//        orgBoard[newY][newX] = 0;  // 블럭이 있던 좌표에 0(빈칸 위치 변경)
//        EmptyY = newY;
//        EmptyX = newX;
//
//        return true;
//    }
//
//
//
//}