package Programmers.네이버코테.J_구현.네이버_부스트캠프기출.First.구름기초.Map사용;

import java.util.*;

public class Map정렬 {
    public static void main(String[] args) {

        String[] arr = new String[]{"황지환", "김승우", "김선호", "홍상화","김혁","김지선","나는포로"};
        List<String> Arr = new ArrayList<>(List.of(arr));


        String[] I = new String[]{"황지환", "김승우", "나탈리"};
        Set<String> ITM = new HashSet<>(List.of(I));
        String[] G = new String[]{"이수호", "이상진", "김선호"};
        Set<String> GTM = new HashSet<>(List.of(G));
        String[] GD = new String[]{"김혁", "김지선", "홍상화"};
        Set<String> GDSC = new HashSet<>(List.of(GD));

        Map<String, Integer> map= new HashMap<>();


        map.put("ITM", 0);
        map.put("GTM", 0);
        map.put("GDSC", 0);
        map.put("미분류", 0);

        for(String s: Arr){

            if(ITM.contains(s)){
                int check  = map.get("ITM");
                map.put("ITM", check+1);
            } else if (GTM.contains(s)) {
                int check  = map.get("GTM");
                map.put("GTM", check+1);
            } else if (GDSC.contains(s)) {
                int check  = map.get("GDSC");
                map.put("GDSC", check+1);
            }else{
                int check  = map.get("미분류");
                map.put("미분류", check+1);
            }

        }

        Set<String> key = map.keySet();

        // Entry 사용이 안되는데? -> 이것도 선언, 편집 공부해야된다
        //
        for(String s: key){
            System.out.println("key: " +s + "값: "+map.get(s));

        }

        // 정렬해야되는데
        // 정렬 아이디어 -> value 다 담는다 컬렉션에
        // 그리고 sort 한다?
        // Map자체에서 sort할 수 있는 기능은 없나? -> 안되는 듯하다

        // 일단 keyset을 MapValue에 따라 오른차순정렬
        // 주어진 keyset으로 다시 오름차순 정렬

        /// 키셋

//        List<String> key_list = new ArrayList<>(key);
//
//        // 이거 람다식말고
//        key_list.sort((v1,v2) -> map.get(v2) - map.get(v1));
//        System.out.println(key_list);
//
//        for(String s : key_list){
//            System.out.println("key: " +s + "값: "+map.get(s));
//        }


        // Entry
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());

//        entryList.sort(Map.Entry.comparingByValue().reversed());
        // 값을 기준으로 내림차순 정렬
        entryList.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        System.out.println(entryList);

//        entryList.sort((v1, v2) -> v2.getValue() - v1.getValue());
//        System.out.println(entryList);


    }
}
