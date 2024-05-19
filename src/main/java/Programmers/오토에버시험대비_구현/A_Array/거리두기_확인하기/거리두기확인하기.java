package Programmers.오토에버시험대비_구현.A_Array.거리두기_확인하기;

import java.util.Arrays;

public class 거리두기확인하기 {
    static String[] sample;

    public static void main(String[] args) {
        String[][] basicSetting = new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        // 맨허튼 거리, 본인 (x, y) 좌표에서 가능한 맨허튼 거리에 있는 좌표중 거리가 2이하인 것을 제외한다
        // 탐색 같은 느낌이 있긴한데...
        // x, y를 어떻게 정할 거냐?
        // x는 subString 값으로 0~5까지로 구할 것이고 y는 배열의 인덱스 값으로 구할 거다


        // 문제 푸는 순서 만들고 ---- 해결 했는지 체크하면서 풀기// 단계 별로 테스트하는법 익혀야된다,, 그리고 xy 정하려면 빨리정해;;
        // 1.P인지 식별 P이면 인덱스 기억해놓는다,, => chatAt 사용, {{chat가 세로,,배열이 가로}}
        // 2.그리고 맨허튼거리 <=2인지 탐색한다,,좌표까지 반환한다  => 함수로 뺴서 하는데 좌표 다돌려야 된다 => 좌표 값에 따른 그에대한 상하좌우 값 출력 완료=> 좌표가 살짝씩 틀린데,, y,x 수정완료
        // 심화 - 중간에 가림막이 있다는걸 어떻게 알지?
        // 심1. 2이하인데 중간에 가림막이 있으면 아니라고 한다.
        // 일단 1인 것들은 필요없고  루트 2, 순 2인 것들 중에서 사이에 가림막있으면 괜찮음 테이블이나 사람있으면 버린다테이블이나 사람이 사이에 있는지는 어떻게 알까??
        // 거기 상하좌우에서 거리두기 조건을 지키기 위한건 충분히 구할 수 있다!,,,그럼 조건안에서 파티션인지 보고 아니면 result =1
        // 3.맨허튼거리가 2이하인 지점에서 P가 있으면 거기서 해당 테이블의 result 1로 하고
        // 4.탈출
        int[] result = new int[5];

        // 디버깅후 한번 끝까지 보기
        int check =0;
        for(int x= 0; x< basicSetting.length; x++){
            sample = basicSetting[x];
            for(int i =0; i<sample.length; i++){
//            System.out.println(i);
                String row = sample[i];

                for(int j = 0; j <row.length(); j++){
                    // SubString 사용한다
                    // 2인 점들을 다 찾는다

                    if(row.charAt(j) == 'P'){
//                    System.out.println(i+"   이거"+j);
                        // i,j를 함수에 넘기면 맨허튼 거리 <=2인 지점에서 P가 있는지 없는지를 찾는다

                        // 다 탐색해서 없으면 0반환 있으면 1반환 근데 0이면 굳이 이어갈 필요가 없음
                         check= menCheck(i, j);
                         // 만약에 result가 check이면 안되...나?
                        if(check== 0){
                            break;
                        }
                    }

                }

            }
            result[x] = check;


        }
        System.out.println(Arrays.toString(result));

        // 이게 지금 하나면 넣은 거잖아






    }



    public static int menCheck(int y, int x){

        // 맨허튼 거리 체크
        // 2일떄 (2,0)  (-2,0)  (0,2)  (0,2)
        // 대각선일떄 (1,1), (1, -1), (-1,1), (-1,-1)
        // 1일떄 (1,0), (0,1), (-1,0), (0, -1)
        // 이게 좌표가 마이너스이면 없으니깐 패스한다

        // 상하좌우 움직임
        int[] twoX = new int[]{0,0,-2,2};
        int[] twoY = new int[]{-2, 2, 0,0};

        // 오른쪽 상단부터 돈다
        int[] rootTwoX = new int[]{1, 1, -1, -1};
        int[] rootTwoY = new int[]{-1, 1, 1, -1};

        // 상하좌우
        int[] oneX = new int[]{0, 0, -1, 1};
        int[] oneY = new int[]{-1, 1, 0, 0};

        //        System.out.println("one");
        for(int i = 0; i<4; i++){
            int move_y = y+oneY[i];
            int move_x = x+oneX[i];
            // 0인지 체크
            // 잠만 너무 많이 나왔는데...
            if(move_x >=0 && move_x< sample.length && move_y >=0 && move_y< sample.length){
                char target = sample[move_y].charAt(move_x); //왜캐 많이 나오노 //하나만 테스트 하고 싶은데
//                System.out.print("y:"+move_y + " x:"+move_x+ " 값:" + target+"  ");
                //애는 그냥 옆에 있으면 끝내버린다
                if(target == 'P'){
                    return 0;
                }

            }
        }


        //        System.out.println("rootTwo");
        // 여기는 2개인데...?
        // 일단 상하좌우하고 2개 묶어서 나열하기 여기는 (x, mo_y)   (mo_x, y)
        for(int i = 0; i<4; i++){
            int move_y = y+rootTwoY[i];
            int move_x = x+rootTwoX[i];

            //interval에 있는 숫자 가져온다


            if(move_x >=0 && move_x< sample.length && move_y >=0 && move_y< sample.length){
                char target = sample[move_y].charAt(move_x); //왜캐 많이 나오노 //하나만 테스트 하고 싶은데
//                System.out.print("y:"+move_y + " x:"+move_x+ " 값:" + target+"  ");

                //이게 진짜 사잇값인지 테스트 해야한다
                char target1  = sample[y].charAt(move_x);
                char target2 = sample[move_y].charAt(x);

                if(target == 'P' && target1 !='X' && target2 !='X'){
                    return 0;
                }

            }

        }

        // 사이값들의 x,y좌표를 또 적어줘야된다 여기는 1
        for(int i = 0; i<4; i++){
            int move_y = y+twoY[i];
            int move_x = x+twoX[i];

            // i에 따라서 상하좌우 적어주기
            // i가 0이면 상이다 one에 따라서 진행한다
            int intervalY =  y+oneY[i];
            int intervalX =  x+oneX[i];



            if(move_x >=0 && move_x< sample.length && move_y >=0 && move_y< sample.length){
                char target = sample[move_y].charAt(move_x); //왜캐 많이 나오노 //하나만 테스트 하고 싶은데
//                System.out.print("y:"+move_y + " x:"+move_x+ " 값:" + target+"  ");
                //이게 진짜 사잇값인지 테스트 해야한다
                char target1 = sample[intervalY].charAt(intervalX);

                if(target =='P' && target1 != 'X'){
                    return 0;
                }
            }

        }

        return 1;
    }

}
