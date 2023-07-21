package week4_BFS_DFS.BFS;

import java.util.Scanner;
import java.util.*;

public class BFS_Picture {
    public static void main(String[] args) {
        //인자 입력
        Scanner scanner = new Scanner(System.in);
        int Row = scanner.nextInt();

        Scanner scanner2 = new Scanner(System.in);
        int Colum = scanner2.nextInt();

        int[][] board = new int[Row][Colum];

        for(int i = 0; i<Row; i++){
            Scanner scanner3 = new Scanner(System.in);
            int Get_Number = scanner3.nextInt();
        }

        int[][] visit = new int[Row][Colum];

        int[] dx= {1,0,-1,0};
        int[] dy= {0,1,0-1};

//        queue<Pair(int,int)> Q;



    }

    class Pair{
        int x,y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
