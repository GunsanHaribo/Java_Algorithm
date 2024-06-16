package Programmers.네이버코테.G_해시.완주하지못한선수1;


// 요구사항 : 참가자와 완주자가 주어질때 완주하지 못한 사람을 구하시오
// 변수 : 참가자, 완주자

import java.util.*;

// 흐름:
// 1. Map을 통해서 (이름과 인원수)를 담는다
public class 완주하지못한선수 {
    public static void main(String[] args) {

        String[] particitant = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] complete = new String[]{"stanko", "ana", "mislav"};

//        Set<String> particitant_s = new HashSet<>(List.of(particitant));
//        Set<String> complete_s = new HashSet<>(List.of(complete));
        // 동명 이인 있을 수 있다, 이러면 S

//        Set<String> copy_p = new HashSet<>(particitant_s);

        // 잠만.. 이터레이터 돌리던가 해야되는데 이거 인덱스 없어서
//        for(String s : complete_s){
//            if(particitant_s.contains(s)){
//                particitant_s.remove(s);
//            }
//        }
//
//        System.out.println(particitant_s);

        Map<String, Integer> particitant_M = new HashMap<>();
        List<String> arr = new ArrayList<>(List.of(complete));

        for(String s: particitant){
            if(particitant_M.containsKey(s)){
                int get_value = particitant_M.get(s);
                particitant_M.put(s, get_value+1);
            }else{
                particitant_M.put(s, 1);
            }
        }


        for(String s : arr){
            if(particitant_M.containsKey(s)){
                int get_value = particitant_M.get(s);
                particitant_M.put(s, get_value-1);
            }
        }

        Set<String> keyset = particitant_M.keySet();
        String answer = "";
        for(String s : keyset){
            int value = particitant_M.get(s);
            if(value !=0){
                answer = s;
            }
        }

        System.out.println(answer);

    }

}
