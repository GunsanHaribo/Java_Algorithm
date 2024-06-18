package Programmers.네이버코테.J_구현.A백준.level2.색칠_피드백;
import java.io.*;
public class 색칠_틀린풀이_경우의수고려필요 {

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


        // F가 0이면?, F가 0이 아니면?
        // 겹치는 부분이 없는데.... 이걸 어캐해야하나
        // 그냥 갯수 보여준다

        long total = (long) W*H;
        int fill_total_number = 0;
        int fill_square_height = y2-y1;



        long y_multi_number = (long) fill_square_height*(c+1);
        fill_total_number += (long) (x2-(x1+1)+1)*y_multi_number;

        // 넘었는지 안넘었는지 체크 -> 7인가 5인가 5이면 W-F이면 초과한다는거니깐
        // (x1+1)~ W-f까지
        // 아니면 안초과하면 (x1+1)~F까지
        int min = Math.min(W-F, F);
        int length = 0;
        // 넘었을때

        // 위에 풀이와 같이 F가 어디있는지에 따라 달라진다
        // 면수
        if(min == W-F){
            length=(W-F) - x1;
        }else{
            // 넘지 않았을때
            length= F - x1; // 음수 나올 수 있음
        }
        // 겹치는 부분이 0~5

        // 겹치치 않는 부분이 5~6
        fill_total_number += (long) length*y_multi_number;

        bw.append( total - fill_total_number+"");
        bw.flush();
    }
}
