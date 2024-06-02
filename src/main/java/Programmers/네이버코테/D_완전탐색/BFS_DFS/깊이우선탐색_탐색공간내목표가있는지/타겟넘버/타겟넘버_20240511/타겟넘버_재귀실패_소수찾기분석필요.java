package Programmers.네이버코테.D_완전탐색.BFS_DFS.깊이우선탐색_탐색공간내목표가있는지.타겟넘버.타겟넘버_20240511;

// 요구사항 | 변수
// 1. number 원소를 -, +를 통해서 target숫자로 만들 수 있는 방법을 구하라
// 변수 : number, (-,+)  target숫자

// 흐름 - 처음 부터 3을 만들려고 하지말고 number로 -, + 조합시킨다
// 상태 : 부호+숫자, numbers배열
// 종료 : number=0, 숫자가 3이면 카운드를 추가한다
// 점화식 : (부호 +숫자) + (부호 숫자), (numbers - (숫자))


// 왜 재귀를 점화식으로 풀지?  :  재귀로 풀려면.. 순서가 달라도 같은 숫자로 인식하게 해야됨

import java.util.*;

public class 타겟넘버_재귀실패_소수찾기분석필요 {

//    static int number =0;
    public static void main(String[] args) {
        // int는 바로 안된다 String은 바로 됬었는데
        int[] numbers = new int[]{4,1,2,1};
        ArrayList<Integer> s = new ArrayList<>();
        for(int i : numbers){
            s.add(i);
        }

        System.out.println(s);

        int target = 4;
        ArrayList<Integer> trace = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        recursion(s, target, 0, trace, set);
        System.out.println(set.size());

    }

    // 중간에 변수에 total 쓰는거 어떻게 하는거야....
    // 같은 방법들이 나오는 것 같아서 set을 사용해야한다

    // 모든 경우의수 -> set사용 중복되는조합이 있을 수 밖에 없다
    public static void recursion(ArrayList<Integer> k, int target, int result, ArrayList<Integer> trace,  Set<List<Integer>> set){

        if(k.isEmpty()){
            // 값이 target과 같으면 1을 반환한다
//            System.out.println(result);
            if(result == target){
//                number ++;
                set.add(trace);
            }
            // 4개를 다 안뽑았어도 어떻게 0이 나오지?
            // 말이 안되는데
            System.out.println(trace +" " +k.size() +" "+result+" "+ System.identityHashCode(k));
            return ;
        }


//        int length =k.size();
        // 이건 도대체왜 7이 나오는건지
        // 이거 일단 버
        for(int i=0; i<k.size(); i++){
            int new_number = k.get(i);

            ArrayList<Integer> s = new ArrayList<>(k);
            s.remove(i);
//            System.out.println(s);

            //시발 왜 안되는데
            // tnstj
            ArrayList<Integer> trace1 = new ArrayList<>(trace);
            trace1.add(-new_number);
            recursion(s, target, result - new_number , trace1, set);

            ArrayList<Integer> trace2 = new ArrayList<>(trace);
            trace2.add(+new_number);
            recursion(s, target, result + new_number, trace2, set);

        }





    }


}
