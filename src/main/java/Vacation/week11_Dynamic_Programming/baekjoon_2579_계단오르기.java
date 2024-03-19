package Vacation.week11_Dynamic_Programming;

import java.io.*;

import static java.lang.Math.max;

public class baekjoon_2579_계단오르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max_number = Integer.parseInt(br.readLine());
        //점수저장
        int[] score = new int[max_number+1];  // 7

        for(int i=1; i<score.length; i++){ //인덱스 1부터 6까지 해야한다
            score[i] = Integer.parseInt(br.readLine());
        }
        //기록
        int[][] record = new int[305][3];

        //이렇게하면 record 1이 없는데...?
        record[1][1] = score[1];
        for(int i=2; i< score.length; i++){
            record[i][1] = max(record[i-2][1], record[i-2][2])+score[i];
            record[i][2] = record[i-1][1] + score[i];
        }

        System.out.println(max(record[max_number][1] , record[max_number][2]));
    }
}
