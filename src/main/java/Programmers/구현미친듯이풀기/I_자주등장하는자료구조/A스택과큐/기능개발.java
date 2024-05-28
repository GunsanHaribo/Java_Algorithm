package Programmers.구현미친듯이풀기.I_자주등장하는자료구조.A스택과큐;

// 변수 | 요구사항 : 남은 진행상황=(100-현재진행상황), 남은진행일자/속도 = 배포시 필요한일자  | 각 배포마다 어떤게 같이 배포가 되는지
// 제한사항 : 뒤에꼐 다 진행이 되더라도 앞에 배포가 끝나지 않으면 배포가 먼저되지 않습니다
// 흐름
// 1. 남은 진행일자들을 큐에 넣는다
// 2. 일단 첫번째꺼 꺼내고  다음꺼를 peek을해서 숫자보다 작은지 체크한다
// 3. 작으면  pop 한다음에 count +1을 한다.
// 4. 크면 리스트에 원소 추가한다
// 5. 리스트를 배열로 바꾼다 .Stream.MapToInt().toArray()


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발 {
    public static void main(String[] args) {

        // Math.ceil 이용해서 double 올린다

        int[] progress = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};

        Queue<Integer> q =calculateDate(progress,speeds);


        System.out.println(q);

        ArrayList<Integer> answer = returnDay(q);

        System.out.println(answer);

//        int[] answer2 = new int[answer.size()];
//        for(int i=0; i< answer.size(); i++){
//            answer2[i] = answer.get(i);
//        }
//
//
//

        int[] answer2 = answer.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(answer2));




    }
    // 남은 진행 일자 계산 다 큐에 넣어서 반환
    public static Queue<Integer> calculateDate(int[] progress, int[] speeds){
        Queue<Integer> qe = new LinkedList<>();
        //계산
        for(int i = 0; i< progress.length; i++){
            int last = 100 -progress[i] ;
            double last_perSpeeds = (double) last/ speeds[i];
            int real_last = (int) Math.ceil(last_perSpeeds);  // 여기서 그냥 int 쓰면 안되나
            qe.add(real_last);
        }


        return qe;
    }


    // 배포 일자 계산
    public static ArrayList<Integer> returnDay(Queue<Integer> q){
        ArrayList<Integer> answer = new ArrayList<>();
        int compare = q.poll();

        int count = 1; // 날짜 계산인가?
        while(!q.isEmpty()){
            int peek_N = q.poll();
            System.out.println(peek_N);
            if(compare>=peek_N){
                count+=1;
            }else{
                answer.add(count);
                count=1;
                compare = peek_N;
            }
        }
        // 마지막 카운트 처리
        answer.add(count);

        return answer;
    }


}
