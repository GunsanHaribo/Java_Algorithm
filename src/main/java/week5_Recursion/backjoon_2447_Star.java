package week5_Recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class backjoon_2447_Star {
    static BufferedReader st = new BufferedReader(new InputStreamReader(System.in));
    static int input_number;

    static {
        try {
            input_number = Integer.parseInt(st.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static String[][] arr = new String[input_number][input_number];

    //main
    public static void main(String[] args) throws IOException {

        star(0,0, input_number);

        for(int i =0; i < input_number; i++){
            for(int j =0; j<input_number; j++){
                if(arr[i][j] == null) {
                    System.out.print(" ");
                }else{
                    System.out.print(arr[i][j]);
                }
//                System.out.print(arr[i][j]);
            }
            System.out.println();
        }

    }
    public static void star(int x, int y, int n){
        //여기서 어떻게 별을 적을 것인가
        //x, y는 좌표고 n은 크기고
        if(n == 1){
            // n이 1이면?
            //여기서 칠하는게 조금 달라져야 할듯
            arr[x][y] = "*";
            return;
        }

        // 3분의 1 나누고
        // 0 -> 1 -> 2 이렇게 가야 되는데
        // 가긴가는데 그 다음이 문제 인데
        // 0 9 18 인데..?
        // 시작x 시작 y 크기인데
        // 0*3^n-1 , 3^n-1  2*3^n-1 //이 순서가 되야 하는데
        //처음 3개 밖에 안되는이유좀
        for(int i =0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(i==1 && j==1){
                    continue;
                }
                //가운데꺼 뺴고 다 칠해야되는데 어떻게 하지
                //9->3->1로 가는데 전체를 다 칠하는게 아니라 그냥 시작점만 바꾸는거 같은데
                //전체를 다 칠하려면 어떻게 해야하지?
                //어디서 부터 어디까지 칠해야하는지 알려줘야되지 않나
                //일단 이거 넘어가는 거 부터 틀리긴함
                star(x+n/3*i,y+n/3*j,n/3);
                // x, y 붙여야하는 이유
                //값들이 계속 초기 (1,0) 이런 위치로 들어간다
            }
        }


    }
}
