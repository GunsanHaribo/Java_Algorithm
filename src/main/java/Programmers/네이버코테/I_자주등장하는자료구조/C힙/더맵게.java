package Programmers.네이버코테.I_자주등장하는자료구조.C힙;

// 요구사항 :  모든 음식의 매운 지수를 K이상으로 만들고 싶다, (섞은 매운 지수 : 가장 낮은거+ 그 다음 낮은거*2)
// 변수 ->  음식 매운 지수 , 원하는 스코필 지수, 섞는 횟수

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 흐름
// 1. 어레이 리스트로 바꾸고 sort한다
// 2. 그리고 제일 작은거 그 다음 작은 거 꺼내서 계산한다음
// 3. 0에 넣어준다
// 4. 여기서 첫번쨰 두번째수가 k를 넘으면 그만한다
public class 더맵게 {
    public static void main(String[] args) {
        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        int k = 5;
        // sort를 하고
        List<Integer> ss = new ArrayList<>();
        for(int i : scoville){
            ss.add(i);
        }


        // 그 보고 어떻게 할건데
        while(ss.get(0) >=k && ss.get(1)>=k){



        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);




    }

}
