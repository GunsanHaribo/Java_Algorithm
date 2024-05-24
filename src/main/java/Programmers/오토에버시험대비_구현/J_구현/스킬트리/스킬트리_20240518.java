package Programmers.오토에버시험대비_구현.J_구현.스킬트리;

// 요구사항 : 선행스킬순서와 유저들이 담은  skill_tree가 있을때
// 유저 skill_tree 내용중 가능한 것의 갯수를 보여주세요
// B가 나오려면 C가 선행되야됩니다
// C -> B -> D 이 순서대로 이루어져 있는지 구분해야 됩니다

// 독립변수 : 요구사항 => 스킬트리 원소, 선행스킬순서, 비교방법(큐)


// B가 C보다 앞에있는걸 어떻게 알지 어떻게 아냐고
// B가 나왔는데 C가 앞에 없으면 지금 짤이라는거 잖아

// 그냥 앞에께 안나왔는데 다음께 먼저 나왔으면 틀렸다는것 같은데
// 큐를 사용해 볼까 rne

// 흐름
// 트리가 들어오면 원소를 배열로 바꾼다
// 배열별로 선행트리가 들어간 큐를 사용한다
// 가능한지 판별하는로직 트리가 주어졌을때 ->
// 원소가 skill에 속하고 peek이랑 값이 같으면 pop 후진행 다르면 실패

import java.util.LinkedList;
import java.util.Queue;

public class 스킬트리_20240518 {
    public static void main(String[] args) {
        String compare = "CBD";
        String[] s = compare.split("");
        String[] k = new String[]{"BACDE", "CBADF", "AECB", "BDA"};

        Queue<String> q = new LinkedList<>();
        for(String i: s){
            q.add(i);
        }

        int count =0;
        // for 문돌려서 문자열 넣어준다, 큐도 같이 넣어준다
        for(String i : k){
            Queue<String> q2 = new LinkedList<>(q);
            count +=check_correct(i, q2, compare);
        }
        System.out.println(count);
    }

    // 문자열 넣는다
    public static int check_correct(String i, Queue<String> q, String compare){
        //
        // 배열로 분해
        String[] compare_i = i.split("");

        for(String z : compare_i){
            if(compare.contains(z)){
                // peek하고 같으면 뽑는다
                // 안 같으면 return
                if(q.peek().equals(z)){
                    q.poll();
                }else{
                    return 0;
                }
            }else{
                continue;
            }

        }

        // 비었으면 1다 돈거니깐 1반환한다

        // ㅣ지않고 정상적으로 넘어가기만해도 return 1
//        if(q.isEmpty()){
//            return 1;
//        }

        return 1;
    }



}
