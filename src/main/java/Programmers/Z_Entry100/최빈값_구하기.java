package Programmers.Z_Entry100;

import java.util.*;

public class 최빈값_구하기 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 2};

        System.out.println(findMin(arr));
    }

    public static int findMin(int[] arr){
        Map<Integer, Integer> Hm = new HashMap<>();
        for(int i: arr){
            if(Hm.containsKey(i)){
                int value = Hm.get(i);
                Hm.put(i, value+1);
            }else{
                Hm.put(i, 1);
            }
        }

        Set<Integer> key = Hm.keySet();
        List<Integer> ket_list = new ArrayList<>(key);

        // set은 sort가 안된다 -> 이거 이유 찾아야됨
        Collections.sort(ket_list, (v1, v2)-> Hm.get(v2) - Hm.get(v1));

        int max_key = ket_list.get(0);
        int max_value = Hm.get(max_key);
        Hm.remove(max_key);

        if(Hm.containsValue(max_value)){
            return -1;
        }


        return max_key;
    }


}
