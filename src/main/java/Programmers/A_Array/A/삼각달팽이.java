package Programmers.A_Array.A;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 삼각달팽이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());


        // 3스텝을 해야되는데 이걸 마지막에 어떻게 끊어야 되는가
        // 3스텝을 하면 처음 받았던 n을 줄인다던지 다른게 필요할듯
        // 배열이 이미 0이 아닌 다른 숫자로 차있으면 stop한다

        int[][] answer = new int[n][n];

        int count = 1; // 스태틱으로 돌린다

        //시작
        answer[0][0] = count++;

        //겹치는거 체크
        int check = 0;

        int left = 0;
        int bottom = n-1;
        int right = n-2;

        while(true){
            //좌
            // 한 시이클 돌면 left는 +1, i도 +1 한채로 진행
            // 0이 아니면 그냥 넘겨 뛰면 되나? // 그러면 stop하기가 너무 힘든데
            // 9를 애가 건들면 안되는데
            for(int i = left+1; i <n-left; i++){
                //아 잠만 이거 그냥 기본값으로 넘겨줘서 문제 생긴다
                int target = answer[i][left];
                if(target == 0){
                    answer[i][left] = count++;
                }else{
                    check=1;
                }
            }

            System.out.println("좌 : "+Arrays.deepToString(answer));
            if(check ==1) break;
            left ++;


            //일단 check 1하는게 잘못인것 같기도하다
            //밑
            // bottom은 botton -1해서 진행하면될듯 , j 리미트도 줄여야 된느데 -1 해주면 된다
            // 근데 bottom 숫자랑 같네? 그러면 수고
            // 왜 21이 여기있지? 우쪽에 있어야 되는데 뭔가 for문 숫자가 틀린것 같은데   n - (n-1) => 1, n-1
            // j이고  n-bottom;;
            // 8까지 가면 안된다 //8이전에 끊고
            for(int j = n-bottom; j<=bottom; j++){
                // 만약 해당 숫자가 0이 아니면 칠한다
                // 만약 0이 아니면
                int target = answer[bottom][j];
                if(target == 0){
                    answer[bottom][j] = count++;
                }else{
                    check=1;
                }
            }
            // 이거 뭔데?
            System.out.println("밑 : "+Arrays.deepToString(answer));
            if(check ==1) break;
            bottom--;

            //우
            //다음 사이클에서 right는 한 숫자만 줄이면 된다   left는 1씩 증가하니 딱 맞을지도 = 2     n-right-1 =1
            for(int i =right; i>=left; i--){
                int target = answer[i][i] ;
                if(target == 0){
                    answer[i][i] = count++;
                }else{
                    check=1;
                }
            }
            System.out.println("우 : "+Arrays.deepToString(answer));
            if(check ==1) break;
            right --;
            // right의 끝부분도 증가 시며야 된다
            // 근데 이렇게 한 사이클이 끝나면 n과 i, j를 조정해서 다시 배열을 채워야한다
            // 한 사이클 돌면 추가를 해줘야 되는데...어떻게 추가를 해주지
            // 여기서 한번 좌 -> 밑 -> 우를 해준다
            //그럼 3번쨰 과정이 끝나면 어떻게 가운데
        }


        // 0이 아닌 숫자들을  1차배열 숫자들로 출력
        List<Integer> result = new ArrayList<>();
        for(int[] i : answer){
            for(int j : i){
                if(j !=0){
                    result.add(j);
                }
            }
        }
        System.out.println(result.toString());
    }
}
