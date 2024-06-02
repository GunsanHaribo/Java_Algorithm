package Programmers.E_정렬.H_index.H_index_20240430;

import java.util.Arrays;

public class H_index {
    public static void main(String[] args) {
        int[] citation = new int[]{3, 0, 6, 1,5};

        Arrays.sort(citation);

        System.out.println(Arrays.toString(citation));


        int count_overH;
        int Current_cite_number;
        int max_h = Integer.MIN_VALUE; // 이거 숙달 필요

        for(int h=1; h<= citation.length; h++){
            // 여기서 r에  r>= cite[] 인 인덱스가 몇번인지 이걸 찾아야
            // count_overH를 찾는다
            int current_index = 0;
            for(int i = 0; i< citation.length; i++){
                //첫전쨰로 같거나 큰수
                if(citation[i]>=h){
                    current_index = i;
                    break;
                }
            }
            // h아래여서 +1 해줘야 된다? 그런가? 이상이면 밑에수를 왜더해
            // 같으면 +1이 맞지 3< 456   2-0 +1  ,, 2<3 <456
            count_overH = (citation.length -1 - current_index)+1;//이거는 본인을 포함한 숫자 본인이 포함이 안될 수도 있으니

            Current_cite_number = citation[current_index]; // site 수가 아닐수도

            if(count_overH >= Current_cite_number){
                if(max_h < h){
                    max_h = h;
                }
            }


        }
        System.out.println(max_h);



    }
}
