package Vacation.week7_Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//Collection, Stream, lambda
//ArrayList공부필요
public class baekjoon_1181_단어정렬  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> get_Arr = new ArrayList<String>();
        boolean check;
        String input_value;

        int max_number = Integer.parseInt(br.readLine());

        for(int i=0; i<max_number; i++){
            input_value = br.readLine();
            check = get_Arr.contains(input_value);

            if(!check){
                get_Arr.add(input_value);
            }
        }

        Collections.sort(get_Arr, new new_sort_rule());
        for(int i=0; i< get_Arr.size(); i++){
            System.out.println(get_Arr.get(i));
        }

    }

}
class new_sort_rule implements Comparator<String>{
    public int compare(String o1, String o2){// 음수
        if(o1.length() == o2.length()){ //길이 같은거 //알파벳 순서로

            for(int i=0; i<o1.length(); i++){
                if(o1.charAt(i) == o2.charAt(i)){
                    continue;
                }
                return o1.charAt(i) - o2.charAt(i);
            }
        }
        //길이 긴것 //짧은것
        return  o1.length()-o2.length();
    }
}

