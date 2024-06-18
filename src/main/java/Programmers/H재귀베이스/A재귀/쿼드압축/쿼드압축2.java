package Programmers.H재귀베이스.A재귀.쿼드압축;

import java.util.Arrays;

// Count 객체 만들어서 반환한다
// count만들어 넣고 밑에서 부터 개수는 더해서 올라온다


public class 쿼드압축2 {

    private static class Count{
        public final int zero;
        public final int one;

        public Count(int zero, int one){
            this.zero = zero;
            this.one = one;
        }

        // 여기서 zero랑 one을 추가로 해서 세어 준다
        // 인스턴스 변수끼리 더해서 만들어준다
        public Count add(Count other){
            return new Count(zero+ other.zero, one+ other.one);
        }
    }



    private static Count count(int offsetX, int offsetY, int size, int[][] arr){

        int h = size/2;

        for(int x = offsetX; x< offsetX + size; x++){
            for(int y = offsetY; y< offsetY+size; y++){
                if(arr[y][x] != arr[offsetY][offsetX]){
                    return count(offsetX, offsetY,h, arr)
                            .add(count(offsetX +h, offsetY,h,arr))
                            .add(count(offsetX, offsetY +h,h,arr))
                            .add(count(offsetX +h, offsetY+h, h, arr));
                }
            }
        }

        if(arr[offsetY][offsetX] ==1){
            return new Count(0,1);
        }
        return new Count(1,0);

    }

    public static void main(String[] args) {
        int [][] arr = new int[][]{{1,1,1,1, 1,1,1,1}, {0,1,1,1, 1,1,1,1},
                {0,0,0,0, 1,1,1,1},
                {0,1,0,0, 1,1,1,1}, {0,0,0,0, 0,0,1,1},
                {0,0,0,0, 0,0,0,1},{0,0,0,0, 1,0,0,1},{0,0,0,0, 1,1,1,1}};;
        Count count = count(0,0, arr.length, arr);

        int[] answer = new int[] {count.zero, count.one};
        System.out.println(Arrays.toString(answer));
    }
}
