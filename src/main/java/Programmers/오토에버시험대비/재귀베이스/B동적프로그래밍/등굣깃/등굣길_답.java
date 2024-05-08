package Programmers.오토에버시험대비.재귀베이스.B동적프로그래밍.등굣깃;

import Vacation.Week1_Array.Main;

import java.util.Arrays;

public class 등굣길_답 {


    private static final int[][] mem = new int[101][101]; // 여기
    public static void main(String[] args) {

        for(int[] row: mem){
            Arrays.fill(row, -1);
        }

        int m  =4;  // x최대
        int n = 3; // y최대

        int[][] puddles = new int[][]{{2,2}};


        boolean[][] isPuddle = new boolean[n+1][m+1];
        for(int[] p: puddles){
            isPuddle[p[1]][p[0]] = true;
        }
        int answer = count(1,1,m,n,isPuddle);
        System.out.println(answer);
    }

    private static int count(int x, int y, int w, int h, boolean[][] isPuddle){


        if(x>w || y>h) return 0;
        if(isPuddle[y][x]) return 0;

        if(mem[x][y] != -1) return mem[x][y];
        if(x ==w && y ==h) return 1;

        //여기
        int total = count(x+1 ,y,w,h, isPuddle) + count(x, y+1,w,h,isPuddle);


        //여기  두개차이점좀  이게 10000000008 +2 면 3  , 1+2하고 같네;;
//        return  total%1000000007;
        return mem[x][y] = total%1000000007;
    }
}
