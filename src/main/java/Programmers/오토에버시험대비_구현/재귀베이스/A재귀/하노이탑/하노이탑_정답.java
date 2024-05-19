package Programmers.오토에버시험대비_구현.재귀베이스.A재귀.하노이탑;

import java.util.ArrayList;
import java.util.List;

public class 하노이탑_정답 {
    static int share;
    public static void main(String[] args) {
        int n=2;
        hanoi(n,1,3).toArray(new int[0][]);
    }

    private static List<int[]> hanoi(int n, int from, int to){
        // 종료 조건, 점화식 구현
        if(n ==1) return List.of(new int[] {from, to});

        // 점화식 구현
        int empty = 6- from -to;

        List<int[]> result = new ArrayList<>();
        result.addAll(hanoi(n-1, from, empty));
        result.addAll(hanoi(1, from, to));
        result.addAll(hanoi(n-1, empty, to));

        return result;
    }
}
