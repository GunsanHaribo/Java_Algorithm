package Programmers.G_해시.의상;


// 변수 | 요구사항 =  의상종류와 이름 | 이것들의 가능한 경우의 수를 찾아라
// 제약 한 종류만가능  다른의상 겹치지 않거나 의상을 추가로 착용한 경우 서로 다른 방법으로 옷을 찾음
// 흐름 - 일단 배열 저장 -> 경우의 수를 어떻게 빨리 계산 할 수 있을까?
// 1. 아니면.. Set에 따로따로 다 넣어놓고 갯수를 이용해서 경우의 수를 계산한다
// face에 2개 head gear에 1개면 3+ 2*1
// 의상 종류가 안 주어졌다

// 1. Map에 담는다  같은 종류가 있으면  count+1을 한다, 초기는 0


import java.util.HashMap;
import java.util.HashSet;
import java.util.*;

public class 의상 {
    public static void main(String[] args) {

        String[][] given = new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};

        Map<String, Integer> record = new HashMap<>();
        // Map으로 타입의 갯수 저장
        for(int i = 0; i< given.length; i++){
            String type = given[i][1];

            if(record.containsKey(type)){
                int count = record.get(type);
                record.put(type, count+1);
            }else{
                record.put(type, 1);
            }
        }

//        System.out.println(record.toString());

        // 키셋 꺼낸다
        Set<String> stringSet = record.keySet();
        // 같은 값일 경우 생각해야된다
        // 3+1일 순 없어 value를 0으로
        int value = 1;
        for(String k : stringSet){
            value *= (record.get(k)+1);
        }
        // 없을 경우를 생각해야한다
        //

        int answer = value-1;
        System.out.println(answer);
         // 종류가 안 주어지는데?
        // 그러면 일단 다 담아봐
    }
}
