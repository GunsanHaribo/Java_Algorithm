package Programmers.E_정렬;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 두개뽑아서더하기 {
    public static void main(String[] args) {
        // sort 하고
        // 만약 기준 인덱스이동시 인덱스전 숫자랑 비교해서 같으면 continue
        int[] array = new int[]{5,0,2,7};
        Arrays.sort(array);

        int[] visit = new int[array[array.length-1]+array[array.length-1]+1];
        List<Integer> answer = new ArrayList<>();
        for(int i= 0;  i<array.length; i++){
            if(i !=0 && array[i-1] == array[i]){
                continue;
            }

            for(int j = i+1; j< array.length; j++){
                int ad = array[i] + array[j];
                if(visit[ad] ==1){
                    continue;
                }else{
                    answer.add(ad);
                    visit[ad] = 1;
                }
            }
        }

        Collections.sort(answer);

        System.out.println(answer);

    }
}
