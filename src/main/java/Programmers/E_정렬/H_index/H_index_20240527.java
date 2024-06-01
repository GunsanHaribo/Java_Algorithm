package Programmers.E_정렬.H_index;

// 요구사항 :  H 인덱스 구하기
// n 편중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면
// h번 이하 인용되었다면 h의 최댓갑이 이 과학자의 H-index 입니다

// 변수 :  citation 수와 h 인덱스 -> h의 범위를 기록하는것도 괜찮을 것 같다

// h는 cite 수가 아니라 배열의 갯수입니다.

// 흐름
// 1. 오름 차순 정렬 -> h번 인용이 h개 있는 h를 찾느다 -> h 최댓값
// 2. 인덱스를 통해 남은 개수 찾기  -> citation 번 된게 (length - i) 이상


import java.util.Arrays;
public class H_index_20240527 {
    public static void main(String[] args) {
        int[] arr = new int[]{20,21,22,23};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        System.out.println(find(arr));
    }

    public static int find(int[] a){
        int h_index = 0;
        for(int i =0; i< a.length; i++){
            int above_number = a.length - i;
            int citation_number = a[i];

//            [20, 21, 22, 23]  -> 이 케이스를 생각못함

            if(above_number <= citation_number){
                h_index = above_number;
            }


        }
        return h_index;
    }
}
