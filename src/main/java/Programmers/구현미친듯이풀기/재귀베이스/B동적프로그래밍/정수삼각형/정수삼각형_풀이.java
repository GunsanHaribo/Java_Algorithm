package Programmers.구현미친듯이풀기.재귀베이스.B동적프로그래밍.정수삼각형;

import java.util.Arrays;

public class 정수삼각형_풀이 {

    public static int[][] mem = new int[501][501];
    public static void main(String[] args) {
        for(int[] row : mem){
            Arrays.fill(row, -1);
        }

        int[][] triangle = new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(max(0,0, triangle));
    }


    // 애도 순서가 살짝 납득이 안되는데
    private static int max(int x, int y, int[][] triangle){

        if(y == triangle.length) return 0;

        if(mem[x][y] != -1) return mem[x][y];
        System.out.println("x좌표 : "+x+ " y좌표: "+ y);
        return mem[x][y] = triangle[y][x] + Math.max(max(x, y+1, triangle), max(x+1, y+1, triangle));
    }


}
