package Programmers.네이버코테.J_구현.네이버_부스트캠프기출.문제1;

import java.util.*;

// 24분 -> 수정 필요
// Set에서 Map으로 갈 수 있는 또다른 방법 있거나
// 밑에 방법을 간단하게 할 방법있으면 찾아서 넣는다
public class 문제1 {
    // 요구사항 : Map,Set 활용가능
    // 중복되어 나타나는 숫자들 중복횟수를 계산해서 배열로 return 하도록하세요
    // 중복이 없으면 -1리턴 하도록하세요
    // 그... 근데.. 반화노디는 순서는 어떻게하나?-> 먼저 들어간서 가져온다
    // 변수 : 배열에 있는 수


    // 흐름 :
    // Set으로 Map에 넣는다 -> 초기값은 0
    // 배열을 돌면서 있으면 +1한다

    // 마지막에 Set순서 대로 해서 ArrayList에 값들을 넣는다 -> 0이 아닐 경우에
    // 만약 ArrayList가 비어있으면 -1출력한다
    public static void main(String[] args) {


        int[] arr = new int[]{3,5,9,1};

//        int[] arr = new int[]{1,2,3,3,3,3,4,4};
//        int[] arr2 = new int[]{3,2,4,4,2,5,2,5,5};
        int[] answer = find_duplicate(arr);
        System.out.println(Arrays.toString(answer));

    }

    public static int[] find_duplicate(int[] arr){
        List<Integer> answer = new ArrayList<>();

        Set<Integer> s = new HashSet<>();
        for(int i: arr){
            s.add(i);  // 근데 이게 들어간 순서가 유지가 되나?
        }


        Map<Integer, Integer> m = new HashMap<>();
        for(int i : arr){
            if(m.containsKey(i)){
                // 그러게 이거 무조건 가지고 있을텐데
                int value = m.get(i);
                m.put(i, value+1);
            }else{
                m.put(i, 1);
            }
        }

        // 리스트에 담을거 담는다
        for(int i: s){
            int value_m = m.get(i);
            if(value_m!=1){
                answer.add(value_m);
            }
        }


        // 아무것도 없으면
        if(answer.isEmpty()){
            answer.add(-1);
        }


        int[] result = new int[answer.size()];
        for(int i = 0; i<result.length; i++){
            result[i] = answer.get(i);
        }

        return result;
    }
}
