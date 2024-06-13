package Programmers.네이버코테.J_구현.A백준.level2.색칠_피드백;


// 요구사항 : 과정을 통해서 색칠 되어있지않은 면적을 구하는 프로그램을 작성하시오
// 과정 :
// 1. x=f에 맞춰서 접는다
// 2. 가로로 c+1개의 크기가 동일한 구간으로 나눈다 위에구간 부터 차례로 접는다
// 3. 왼쪽 아래가(x1, y1) , 오른쪽 위가 (x2, y2)인 직사각형 찾아서 칠한다
// 4. 종이를 편다


// 변수 : 좌표
// 1. W - 가로
// 2. H - 세로
// 3. F - 처음 접는 x축
// 4. c - c+1동일한 구간 : c=2이면 3등분
// 5. (x1, y1) -> 색칠할 왼쪽 아래
// 6. (x2, y2) -> 색칠할 오른쪽 위


// 일단 2번째 과정은 c+1개 늘어나는건 알겠어
// 그리고 첫번째 과정은.... 0부터 f까지의 갯수를 구해야 될 것 같은데
// 아니면 축마다의 갯수를 구하자

// (1,1), (3,2) 몇개 있는지 찾아야 한다
// 1~2까지 1개, 2~3까지 1개 있음을 알 수 있다
// 첫번째 y축, 두번째 y축 -> h
// 첫번째 x축, 두번째 y축 -> w
// 축마다 몇개를 가지고 있는지 알 수 있다
//그래서 c+1이면 축당 c+1개 늘어나고 
// 그래서 x=2이면 +3

// 그럴려면 x축이 얼마나 줄어드는가 -> y축이 얼마나 줄어드는가 체크할 필요가 있다
// 기본꺼에서 W에서 x축을 빼준다 -> x좌표
/// c+1을 해준다 y좌표 

// 흐름 
// 1. (x1,y1)  (x2,y2) 바탕으로 축마다 직사각형의 갯수를 삽입한다
// 2. c+1을해서 증가 시킨다 
// 3. x=f값에 따라서 0부터 f축까지의 직사각형의 갯수를 증가시킨다

// 이거 초과해서 접는 상황도 생각해야됨 근데 초과해서 접으면 어떻게되니...?
// 초과한것도 좌표에 들어간다
// 초과하면 겹치는 부분 없어서 하나만 들어간다

import java.io.*;
import java.util.*;

public class 색칠1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] given = br.readLine().split(" ");

        int W =Integer.parseInt(given[0]);
        int H =Integer.parseInt(given[1]);
        int F= Integer.parseInt(given[2]);
        int c = Integer.parseInt(given[3]);

        int x1 = Integer.parseInt(given[4]);
        int y1 = Integer.parseInt(given[5]);

        int x2 = Integer.parseInt(given[6]);
        int y2 = Integer.parseInt(given[7]);


        // 초과 날수도?
        long total = (long) W*H;
        // F가 0이면?, F가 0이 아니면?
        long fill_total_number = 0;
        int fill_square_height = y2-y1;

        long y_multi_number = (long) fill_square_height*(c+1);
        fill_total_number += (long) (x2-(x1+1)+1)*y_multi_number;

        // 넘었는지 안넘었는지 체크 -> 7인가 5인가 5이면 W-F이면 초과한다는거니깐
        // (x1+1)~ W-f까지
        // 아니면 안초과하면 (x1+1)~F까지
        int min = Math.min(W-F, F);

        int dupli_length = 0;

        // 초과한다
        if(min == W-F){
            // 만약 (W-F  - x1)이 0보다 작을 경우
            // 넘었을때
            if((W-F  - x1)>0){

                if((W-F)>=x2){
                    dupli_length = x2-x1;
                }else{
                    dupli_length= (W-F) - x1;
                }

            }
        }else{ // 안넘었을때
            // 만약 F  - x1이 0보다 작을 경우
            if((F - x1) >0){

                if(F>=x2){
                    dupli_length = x2-x1;
                }else{
                    dupli_length= F - x1;
                }
            }

        }


        fill_total_number += (long) dupli_length*y_multi_number;
//        System.out.println(fill_total_number);

        bw.append( total - fill_total_number+"");
        bw.flush();
    }

}
