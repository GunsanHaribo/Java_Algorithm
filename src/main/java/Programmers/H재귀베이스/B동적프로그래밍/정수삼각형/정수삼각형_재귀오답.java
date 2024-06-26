package Programmers.H재귀베이스.B동적프로그래밍.정수삼각형;


import java.util.Arrays;

public class 정수삼각형_재귀오답 {

    public static int[] mem = new int[100000001];
    static int[][] arr;

    static int[] dx = new int[]{0, 1};
    static int[] dy = new int[]{1, 1};

    static int calls =0;
    public static void main(String[] args) {
        arr = new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        Arrays.fill(mem,-1);

        // 이동  두가지 방법으로 이동가능
        // 하랑 우하

        int max = triangle(0,0,0);
        System.out.println("max:"+ max);
        System.out.println("calls : "+calls);
    }

    public static int triangle(int x, int y, int sum){


        calls++;
        // y뿐만 아니라 x가 현재
        if(y >= arr.length){
//            System.out.println("x좌표 : "+x+ " y좌표: "+ y);
            return 0;
        }

        System.out.println("x좌표 : "+x+ " y좌표: "+ y);
        System.out.println(sum);

//        sum += arr[y][x];

        return sum +=  arr[y][x]+ Math.max(triangle(x+ dx[0], y+ dy[0], sum),
                triangle(x+ dx[1], y+ dy[1], sum));


//        return sum +=  arr[y][x] + Math.max(triangle(x+ dx[0], y+ dy[0], sum),
//                triangle(x+ dx[1], y+ dy[1], sum));

    }
}
