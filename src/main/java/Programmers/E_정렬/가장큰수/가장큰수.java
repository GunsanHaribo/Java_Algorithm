package Programmers.E_정렬.가장큰수;

import java.util.ArrayList;
import java.util.Collections;


public class 가장큰수 {

    static ArrayList<String> combination;
    public static void main(String[] args) {

        int[] arr = new int[]{6, 10, 2};
        // 이거 어레이리스트로 바꿔

        // 이거 중요
        ArrayList<String> arr_set = new ArrayList<>();

        for(int i : arr){
            arr_set.add(i+"");
        }

        combination = new ArrayList<>();


        find_allCombination("", arr_set);
        System.out.println(combination);


        Collections.sort(combination);
        int last_index  = combination.size()-1;

        System.out.println(combination.get(last_index));
    }

    public static void find_allCombination(String current_combination, ArrayList<String> current_numbers){

        if(current_numbers.size() ==0){
            // 여기서 array에 더한다
            combination.add(current_combination);
            return;
        }

        // 문제는 여기
        for(int i =0 ; i< current_numbers.size(); i++){
            StringBuilder sb = new StringBuilder(current_combination);
            sb.append(current_numbers.get(i));

            // 이게 맞는데 그렇다면...sb도 초기화
            ArrayList<String> sendArr = new ArrayList<>(current_numbers);
//            System.out.println("건너나?" + sendArr);
            sendArr.remove(i); // remove를 어떻게 해줘야되지

            // 여기서 살짝 다양한 경우 케이스를 복사본 처럼 들고 있어야 ㅗ디는것 같은데
            find_allCombination(sb.toString(), sendArr);
        }


    }



}
