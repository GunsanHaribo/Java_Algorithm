package Programmers.구현미친듯이풀기.E_정렬.H_index;

import java.util.Arrays;

public class H_index_20240527_solution {
    public static void main(String[] args) {
        int[] citations = new int[]{20,21,22,23};

        Arrays.sort(citations);

        System.out.println(Arrays.toString(citations));

        int answer = find(citations);
        System.out.println(answer);
    }

    public static int find(int[] a){

        // 돌리면서
        // H인덱스 값 찾는다
        // 최댓값이니깐 h
//        int h_index = 0;
        // 첫번째 숫자가 h보다 크고 인덱스가 h보다 낮으면

//        int h_index = 0;
        for(int h = a.length; h>=1; h--){
            if(a[a.length-h] >= h) {
                // h를 리턴 해야되는데 이게 최대임을 보장 할 수 있을까?
                return h;
            }
        }

        return 0;
    }
}
