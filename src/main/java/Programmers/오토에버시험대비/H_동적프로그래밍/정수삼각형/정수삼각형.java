package Programmers.오토에버시험대비.H_동적프로그래밍.정수삼각형;


import java.util.Arrays;

public class 정수삼각형 {

    public static int[] mem = new int[100000001];
    static int[][] arr;

    static int[] dx = new int[]{0, 1};
    static int[] dy = new int[]{1, 1};
    public static void main(String[] args) {
        arr = new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        Arrays.fill(mem,-1);

        // 이동  두가지 방법으로 이동가능
        // 하랑 우하

        int max = triangle(0,0,0);
        System.out.println(max);
    }

    public static int triangle(int x, int y, int sum){

        // y뿐만 아니라 x가 현재
        if(y >= arr.length){
//            System.out.println("x좌표 : "+x+ " y좌표: "+ y);
            return 0;
        }

//        sum+= arr[y][x]; // 재귀는 돌아가는
        System.out.println("x좌표 : "+x+ " y좌표: "+ y);
        System.out.println(sum);
        // sum


        // 여기서 돌려야 되는것 같은데
        // 이건 아닌데...접근법
        return sum +=  arr[y][x] + Math.max(triangle(x+ dx[0], y+ dy[0], sum),
                triangle(x+ dx[1], y+ dy[1], sum));

    }
}
