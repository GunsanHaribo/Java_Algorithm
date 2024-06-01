package Programmers.네이버코테.재귀베이스.B동적프로그래밍.등굣길_중요;

public class 등굣길_재귀답 {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;

        int[][] puddles = new int[][]{{2,2}};

        boolean[][] isPuddle = new boolean[n+1][m+1];
        for(int[] p : puddles){
            isPuddle[p[1]][p[0]] = true;
        }


        System.out.println(count(1,1, m, n, isPuddle));
    }

    public static int count(int x, int y, int w, int h, boolean[][] isPuddle){

        if(x > w || y >h) return 0;
        if(isPuddle[y][x]) return 0;

        if(x == w && y == h) return 1;
        // 만약 목적지에 도착해서 (x+1, y) 1이 나왔어 그리고 (x, y+1)하나는 0이 나왔어
        // 그러면 total이 (x,y)에 대해서 가능한경로 수를 가진다  그걸또 더해주면 되는거고

        // 이거 return문에 있는거랑 밖에 있는거랑 차이 날 것 같은데 => 차이 안난다
        int total = count(x+1 ,y,w,h, isPuddle) + count(x,y+1,w,h,isPuddle); //

//        return (count(x+1 ,y,w,h, isPuddle) + count(x,y+1,w,h,isPuddle)) % 1000000007;
        return total % 1000000007;
    }
}
