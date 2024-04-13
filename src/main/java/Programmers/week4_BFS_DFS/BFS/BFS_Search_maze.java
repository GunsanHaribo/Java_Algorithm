package Programmers.week4_BFS_DFS.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_Search_maze {


    public static void main(String[] args) {
        int count = 0;
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


        Queue<Pair> que = new LinkedList<>();
        visit[0][0] =1;
        que.add(new Pair(0,0));
        while(!que.isEmpty()){
//            Pair<int,int> cur = que.front();
        }

    }
    public static class Pair<L, R>{
        L left;
        R right;
        Pair(L x, R y){
            this.left = x;
            this.right = y;
        }
    }
}
