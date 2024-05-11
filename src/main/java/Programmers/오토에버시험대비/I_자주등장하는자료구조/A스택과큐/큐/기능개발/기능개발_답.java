package Programmers.오토에버시험대비.I_자주등장하는자료구조.A스택과큐.큐.기능개발;



import java.util.*;

public class 기능개발_답 {
    public static void main(String[] args) {
        int[] progress = new int[]{93, 30, 55};
        int[] speed = new int[]{1, 30, 5};

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i< progress.length; i++){
            q.add(i);
        }

        List<Integer> result = new ArrayList<>();
        int days = 0;
        int count = 0;
        while(!q.isEmpty()){
            int index = q.poll();
            int expiration = (int) Math.ceil(
                    (double) (100 - progress[index]) / speed[index]);

            if(expiration > days){
                if(days !=0){
                    result.add(count);
                    count = 0;
                }
                days = expiration;
            }

            count++;
        }

        result.add(count);
        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(answer));
    }
}
