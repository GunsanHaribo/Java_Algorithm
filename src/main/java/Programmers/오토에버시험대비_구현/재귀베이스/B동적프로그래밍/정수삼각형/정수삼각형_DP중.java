package Programmers.오토에버시험대비_구현.재귀베이스.B동적프로그래밍.정수삼각형;

import java.util.Arrays;

public class 정수삼각형_DP중 {

    public static int[][] mem = new int[501][501];
    static int[][] arr;

    static int[] dx = new int[]{0, 1};
    static int[] dy = new int[]{1, 1};

    static int calls =0;

    public static void main(String[] args) {
        arr = new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        for(int[] k: mem){
            Arrays.fill(k,-1);
        }


        // 이동  두가지 방법으로 이동가능
        int max = triangle(0,0);
        System.out.println("max:"+ max);
        System.out.println("calls : "+calls);
    }

    public static int triangle(int x, int y){

        calls++;
        // mem
        if(mem[y][x] != -1)  return mem[y][x];

        // 종료조건
        if(y >= arr.length){
            return 0;
        }

        System.out.println("x좌표 : "+x+ " y좌표: "+y);

        return mem[y][x] = arr[y][x] + Math.max(triangle(x+ dx[0], y+ dy[0]),
                triangle(x+ dx[1], y+ dy[1]));
    }

}
