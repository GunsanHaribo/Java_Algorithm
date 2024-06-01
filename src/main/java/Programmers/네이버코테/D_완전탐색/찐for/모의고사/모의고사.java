package Programmers.네이버코테.D_완전탐색.찐for.모의고사;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {
    public static void main(String[] args) {
//        int[] answers = new int[]{1,2,3,4,5};
        int[] answers = new int[]{1,3,2,4,2};
//        int[] answers = new int[]{};

        int[] st1 = new int[]{1,2,3,4,5};
        int[] st2 = new int[]{2,1,2,3,2,4,2,5} ;
        int[] st3 = new int[]{3,3,1,1,2,2,4,4,5,5};

        int[] right= new int[3];
        int[] realAnswer;

        if(answers.length !=0){
            for(int i = 0; i<answers.length; i++){
                int getIndex = (i%st1.length);

                boolean check = (answers[i] == st1[getIndex]);
                if(check){
                    right[0]++;
                }
            }

            for(int i = 0; i<answers.length; i++){
                int getIndex = (i%st2.length);

                boolean check = (answers[i] == st2[getIndex]);
                if(check){
                    right[1]++;
                }
            }

            for(int i = 0; i<answers.length; i++){
                int getIndex = (i%st3.length);

                boolean check = (answers[i] == st3[getIndex]);
                if(check){
                    right[2]++;
                }
            }

            System.out.println(Arrays.toString(right));
            // max 값 구해
            // 같은 값을 가지면 리스트에 넣어
            // sort

            List<Integer> answer = new ArrayList<>();

            int max = -1;
            for(int i : right){
                if(max < i){
                    max = i;
                }
            }

            for(int i = 0; i< right.length; i++){
                if(max == right[i]){
                    answer.add(i+1);
                }
            }

            realAnswer = new int[answer.size()];
            for(int i = 0; i<answer.size(); i++){
                realAnswer[i] = answer.get(i);
            }

            System.out.println(Arrays.toString(realAnswer));
        }else{
            realAnswer = new int[0];
            System.out.println(Arrays.toString(realAnswer));
        }











    }
}
