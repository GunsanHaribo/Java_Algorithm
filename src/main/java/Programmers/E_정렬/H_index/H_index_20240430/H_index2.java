package Programmers.E_정렬.H_index.H_index_20240430;

import java.util.Arrays;

public class H_index2 {
    public static boolean isValid(int[] citations, int h){
        int index = citations.length - h; // 인덱스 찾기
        // 가능한 h로 비교한다 최대값부터 5가 되는지 4가 되는지
        return citations[index] >=h;  // index citataion 체크
    }


    public static int solution(int[] citation){
        Arrays.sort(citation);
        for(int h = citation.length; h>=1; h--){
            if(isValid(citation, h)){
                return h;
            }

        }
        return 0;
    }
    public static void main(String[] args) {
        int[] citation = new int[]{3, 0, 6, 1, 5};

        int i= solution(citation);
        System.out.println(i);
    }
}
