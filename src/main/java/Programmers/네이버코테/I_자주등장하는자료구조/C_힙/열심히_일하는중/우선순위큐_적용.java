package Programmers.네이버코테.I_자주등장하는자료구조.C_힙.열심히_일하는중;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 지속해서 정렬이 필요할때 사용한다
public class 우선순위큐_적용 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 -v1);

        // 지
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] answer = br.readLine().split(" ");

        int numberOfWork = Integer.parseInt(answer[0]);
        int M = Integer.parseInt(answer[1]);
        int K= Integer.parseInt(answer[2]);

        // 일당 중요도 //이거 배열에 넣고 정렬해야된다
        List<Integer> given = new ArrayList<>();

        // 정렬됨
        for(int i = 0; i< numberOfWork; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }


        // 여기서 부터 로직 인데
        List<Integer> answer2 = new ArrayList<>();
        int today_satify = 0;
        int count =0;
        while(!pq.isEmpty()){

            // 첫번째꺼 끌어다 쓴다
            int today_work_important = pq.poll();
            // 만족감 구한다 ([y/2] + p)
            today_satify = (int) (today_satify/2)  + today_work_important;
            answer2.add(today_satify);

            // 업데이트
            today_work_important -= M;
            // 여기서 3이하면 제거해주고
            // 3 초과면 다시 넣어준다
            if(today_work_important>K){
                pq.add(today_work_important);
            }

            ++count;
        }


        bw.append(count+"");

        for(int i : answer2){
            bw.append("\n"+i);
        }
        bw.flush();

    }
}
