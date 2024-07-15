package ZZ_SW_ExpertAcademy.SNS개발;

import ZZ_SW_ExpertAcademy.SNS개발.submit.UserSolution_Set2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    private final static int MAXL = 5;
    private final static int MAXF = 10;

    private final static int INIT = 1;
    private final static int ADD = 2;
    private final static int DEL = 3;
    private final static int RECOMMEND = 4;

    private static int N, M;

//    private final static UserSolution usersolution = new UserSolution();
    private final static UserSolution_Set2 usersolution = new UserSolution_Set2();


    private static boolean run(BufferedReader br) throws Exception {
        int cmd;
        int id, F;
        int ids[] = new int[MAXF];
        int id1, id2;
        int len, len_a;
        int list[] = new int[MAXL];
        int list_a[] = new int[MAXL];

        boolean okay;

        okay = false;

        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken()); // 이게 두번째줄

        for (int k = 0; k < M; ++k) {
            st = new StringTokenizer(br.readLine(), " "); // 이게 함수 보함

            cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case INIT:
                    N = Integer.parseInt(st.nextToken());
                    usersolution.init(N);
                    okay = true;
                    break;
                case ADD:
                    id = Integer.parseInt(st.nextToken());
                    F = Integer.parseInt(st.nextToken());
                    for (int i = 0; i < F; ++i) // 파싱
                        ids[i] = Integer.parseInt(st.nextToken());
                    if (okay) // 초기화가 됬으면  추가
                        usersolution.add(id, F, ids);
                    break;
                case DEL:
                    id1 = Integer.parseInt(st.nextToken());
                    id2 = Integer.parseInt(st.nextToken());
                    if (okay)
                        usersolution.del(id1, id2);
                    break;
                case RECOMMEND:
                    id = Integer.parseInt(st.nextToken()); // 아이디
                    len_a = Integer.parseInt(st.nextToken()); // 이건 뭔데?
                    for (int i = 0; i < len_a; ++i)
                        list_a[i] = Integer.parseInt(st.nextToken()); // 테스트임 6,8,5
                    if (okay) {
                        len = usersolution.recommend(id, list);
                        if (len != len_a) // 테스트 답지와 값이 같지 않으면  false
                            okay = false;

                        for (int i = 0; okay && i < len_a; ++i)
                            if (list[i] != list_a[i]) // 항목들이 같지 않으면 false
                                okay = false;

                    }
//                    System.out.println(Arrays.toString(list));
//                    System.out.println(okay);
//                    System.out.println();
                    // 어디에서 지금 마지막에 false가 나온 것 같은데

                    break;
            }
        }

        return okay;
    }

    public static void main(String[] args) throws Exception {
        int TC, MARK;

        System.setIn(new java.io.FileInputStream("/Applications/Spring/ProgrammerCodingTest/src/main/java/ZZ_SW_ExpertAcademy/SNS개발/sample_input.txt"));


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        TC = Integer.parseInt(st.nextToken()); // 1
        MARK = Integer.parseInt(st.nextToken()); // 100 추천기능이 제대로 작동하면 100

        for (int testcase = 1; testcase <= TC; ++testcase) {
            int score = run(br) ? MARK : 0; // 맞게 반환을 하면 100?
            System.out.println("#" + testcase + " " + score);
        }

        br.close();
    }

}