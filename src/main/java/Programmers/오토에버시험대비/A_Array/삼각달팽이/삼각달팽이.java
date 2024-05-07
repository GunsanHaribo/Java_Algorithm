package Programmers.오토에버시험대비.A_Array.삼각달팽이;

import java.util.ArrayList;
import java.util.List;

public class 삼각달팽이 {
    public static void main(String[] args)  {
        int m = 6;  // 좌표의 limit 3

        //정사각형 배열입니다 자 이러면 규칙을 찾아 볼까요

        //내가 생각했을때 ㄹㅇ n=4일때 그니깐 한 예제에서 규칙을 찾고
        //그 규칙이 맞는지 다른 예제를 통해서 확인해야됨
        //그리고 명칭도 확실하게 정해야된다

        // 준비물 : 상화좌우 이동량 + count
        int[] dy = new int[]{-1, 1,0,0};
        int[] dx = new int[]{0, 0, -1,1};

        int count = 1;

        int[][] result= new int[m][m];

        // 우측  - 하 이동   //리미트는 일단 배열의 최댓값으로 걸어준다
        //result
        int y = 0;
        int x = 0;

        result[0][0] = count++;

        // 여기선 바뀐 x,y그대로 해서  받아서 다시 시작하면 되거든?


        int memory;
        while(true){

            memory = count;
//            System.out.println("못들어감");
            while(true){

                // 리스트가 터질 수도 있다는걸 인지
                // 둘중 하나가 F면 F

                System.out.println("우측루프");
                System.out.println(y+" "+ x);
                y += dy[1];
                x += dx[1];
                // 1,1 인데 2,1이여야되는데 1,0이 왜 나와 시발 !
                System.out.println(y+" "+ x);
                //아근데 왜 1,1에서 2,1로 가야되는데 왜 1,0이 나오지?? 이유가 뭐지??

                // break을 하면안되나? 밑으로 가야되는데 ?  10이 안된다
                if( x>=m || y>=m || result[y][x] != 0){
                    y -= dy[1];
                    x -= dx[1];
                    break;
                }else{
                    System.out.println("count" + count);
                    result[y][x] = count++;
                }
                 // 통과하면 +1 해주는건데 4,0 일때 막히 잖아

            }
            if(memory == count) break;


            // 평행 - 우 이동
            memory = count;
            while(true){
                System.out.println("평행루프");
                y += dy[3];
                x += dx[3];
                // 아니 이러면 당연히 0이 안나오 잖아

                if(x>=m || y>=m || result[y][x] != 0){
                    y -= dy[3];
                    x -= dx[3];
                    break;
                }else{
                    System.out.println(y+" "+ x);

                    result[y][x] = count++;
                    System.out.println(count);
                }


            }
            if(memory == count) break;

            // 위로 이동 - 상좌 이동 // 조건이 2개니 while로 가자
            memory = count;
            while(true){

                System.out.println("상좌이동 루프");
                x +=dx[0]+dx[2];
                y +=dy[0]+dy[2];

                //롤백
                if(x>=m || y>=m || result[y][x] != 0){
                    x -= (dx[0]+dx[2]);
                    y -= (dy[0]+dy[2]);
                    break;
                }else{
                    // 통과하면 +1 해주는건데 4,0 일때 막히 잖아
                    System.out.println(y+" "+ x);
                    System.out.println("count" + count);
                    // 4, 0 나와서 터지는건데 이걸 어떻게 고치지?
                    // 3이 넘어가야되는데 어떻게 넘기지 count를 안하면서?
                    result[y][x] = count++;
                }

                // 여기서 break 안거니깐 y,x가 0, 0이 된다

            }
            if(memory == count) break;
        }


        //만약이게 간거다 하면 stop해야되나 좀 예쁘게 for문으로 조정 안되나?
        // 아마 저 3가지 과정이 전부 들어가야 될 것 같긴한데

        // 1. 정지 조건은 용량을 넘어가거나 좌표가 이미 채워져 있는 경우//
            //  첫번째 돌때 체크해야되는게 용량이고 두번쨰는 안쪽 삼각형이니깐 중복이 되는가 안되는가
        // 2. 근데 두번쨰삼각형 시작은 어떻게 하지?
            // 사이클이 한바퀴 돌면 다시 처음으로 보내야 된다 3사이클을 계속 돌아야되니 while(true)로 만들고 마지막 졸로조건은
            // 더이상 숫자가 count되지 않는다면 사이클 돌기전에 count를 기억해놓았다가 사이클이 돌아도 count가 증가 하지 않는다면 break;



        List<Integer> answer = new ArrayList<>();

        for(int[] i : result){
            for(int j : i){
                if(j != 0){
                    answer.add(j);
                }
            }
        }

        System.out.println(answer);





    }


}
