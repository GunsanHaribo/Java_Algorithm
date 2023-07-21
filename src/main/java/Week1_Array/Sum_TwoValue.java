package Week1_Array;

import java.util.ArrayList;
import java.util.*;

public class Sum_TwoValue {
    public static void main(String[] args) {
        ArrayList<Integer> candidate_list = new ArrayList<Integer>();
        Scanner set_number = new Scanner(System.in);
        int length_list = set_number.nextInt();

        for (int i = 0; i<length_list; i++){
            System.out.println("for문 진입");
            Scanner scanner = new Scanner(System.in);
            int GetInt = scanner.nextInt();
            candidate_list.add(GetInt);
        }
        System.out.println("변수 입력");
        Scanner sum_number = new Scanner(System.in);
        int reach_sum= sum_number.nextInt();

        System.out.println(check_possible_sum(candidate_list, reach_sum));
    }
    public static int check_possible_sum(ArrayList<Integer> list, int sum){
        // 문자 쌍 추가
        // 13이 되는 수 있으면
        int[] array = new int[sum+1];
        int result = 0;
        for(int i = 0; i < list.size(); i++){
            int compare = sum-list.get(i);
            if(array[compare] == 1){
                result +=1;
            }else{
                array[list.get(i)] = 1;
            }

        }
        return result;
    }
}
