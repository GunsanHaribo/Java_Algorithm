package Programmers.네이버코테.I_자주등장하는자료구조.A_스택과큐.큐.기능개발;

import java.util.*;

public class 기능개발_내풀이 {
    public static void main(String[] args) {
//        Queue<Integer> queue = new Queue<>(); // 이제는 안하는것 같은데

        Queue<Integer> queue = new LinkedList<>();
        int[] progress = new int[]{93, 30, 55};
        int[] speed = new int[]{1,30,5};
        int fin = 100;
        for(int i = 0; i< progress.length; i++){
            int remain_day  = (fin - progress[i])/speed[i];
            int quatr = (fin - progress[i])%speed[i];
            if(quatr !=0){
                remain_day+=1;
            }
            queue.add(remain_day);
        }
//        System.out.println(queue);
//        System.out.println(count(queue));

        ArrayList<Integer> answer2 = count(queue);
        int length = answer2.size();
        int[] answer = new int[length];
        for(int i  = 0; i< length; i++) {
            answer[i] = answer2.get(i);
        }

        System.out.println(Arrays.toString(answer));
    }

    // 배열하고
    public static ArrayList<Integer> count(Queue<Integer> remain_date){
        int compare  = remain_date.poll();
        System.out.println(compare);
        int count =1;

        ArrayList<Integer> list = new ArrayList<>();

        // 안들어가는데?
        while(!remain_date.isEmpty()){
            System.out.println("dd");
            int next = remain_date.poll();
            System.out.println(next);
            System.out.println(count);
            if(compare >= next){
                count++;
            }else{
                list.add(count);
                compare = next;
                count=1;
            }
        }
        // 마지막 원소
        list.add(count);

//        System.out.println(list);

        return list;
    }
}
