package Programmers.네이버코테.I_자주등장하는자료구조.C_힙.열심히_일하는중;


// 요구사항 : 중요도가 높은 일부터 한다
// 하루에 하나의 일만 처리할 수 있으며, 일을 처리한 후 일의 중요도는 M만큼 감소

// 일의 중요도가 K 이하가 되면 그 일은 완료한것 -> K가 뭔데? k를 어떻게 구하는데

// 오늘의 만족감은 전날의 만족감을 Y, 오늘 할 일의 중요도를 P -> ([y/2] + p)와 같다// ㄹ이렇게 하면서

// 하루에 하나의 일을 한다

// 해야 할 일의 개수 N, 일을 처리했을 떄 감소하는 중요도 M, 완료한 것으로 간주하는 중요도의 최댓값 K가 주어짐
// i번일의 중요도 가 주어진다

// 요구사항 : 하루당 중요도 별로 수행하고 일별로 느낀 만족감을 출력하자, 필요한것
// 변수 :
// 1. 전날의 만족감 -> Y
// 2. 오늘 할일의 중요도 -> 오늘 할일 중요도- M
// 3. 일을 완료했을때 감소하는 중요 -> M
// 3. 일(자체)의 중요도 -> 일의 개수에 따라 주어진다
// 4. 완료한 것으로 간주하는 일자체의 최댓값 -> 일의 중요도가 K가 되면 해당일을 완료하고 다음일로 넘어간다


// 흐름
// 1. 중요도 높은 일부터 일단 한다
// 2. 오늘 중요도 구하는 기능   ([y/2] + p)
// 3. 일의 중요도에서 고정값 뺴주는기능
// 4. K가 낮아지면

import java.io.*;
import java.util.*;

public class 열심히_일하는중 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] answer = br.readLine().split(" ");

        int numberOfWork = Integer.parseInt(answer[0]);
        int M = Integer.parseInt(answer[1]);
        int K= Integer.parseInt(answer[2]);

        // 일당 중요도 //이거 배열에 넣고 정렬해야된다
        List<Integer> given = new ArrayList<>();

        for(int i = 0; i< numberOfWork; i++){
            given.add(Integer.parseInt(br.readLine()));
        }


//        System.out.println(given);
        // 여기서 부터 로직 인데
        List<Integer> answer2 = new ArrayList<>();
        int today_satify = 0;
        int count =0;
        while(!given.isEmpty()){
            // 정렬로직
            // 이걸 계속 해서 그런가?
            // 계속 틀리네
            // 시간 초과가 발생함
            Collections.sort(given, (v1, v2) -> v2 -v1);

            // 정렬을 계속해주는게 문제인가?

            // 첫번째꺼 끌어다 쓴다
            int today_work_important = given.get(0);
            // 만족감 구한다 ([y/2] + p)
            today_satify = (int) (today_satify/2)  + today_work_important;
            answer2.add(today_satify);

            // 업데이트
            today_work_important -= M;
            // 여기서 3이하면 제거해주고
            // 3 초과면 다시 넣어준다
            if(today_work_important>K){
                given.set(0, today_work_important);
            }else{
                given.remove(0);
            }
            ++count;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.append(count+"");
//        System.out.println(count);
        for(int i : answer2){
//            System.out.println(i);
            bw.append("\n"+i);
        }
        bw.flush();



    }



}
