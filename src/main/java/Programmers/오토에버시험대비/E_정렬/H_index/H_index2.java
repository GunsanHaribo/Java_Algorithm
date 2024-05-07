package Programmers.오토에버시험대비.E_정렬.H_index;

import java.util.Arrays;

public class H_index2 {
    public static boolean isValid(int[] citations, int h){
        int index = citations.length - h;
        return citations[index] >=h;
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
