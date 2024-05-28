package Programmers.구현미친듯이풀기.I_자주등장하는자료구조.A스택과큐.스택.괄호회전하기;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 괄호회전하기_재귀연습 {
    public static void main(String[] args) {

        String s1 = "[](){}";
        String[] ss = s1.split("");
        ArrayList<String> sss = new ArrayList<>(List.of(ss));

        Stack<String> st = new Stack<>();
        ArrayList<String> kk = new ArrayList<>();
        kk.add("}");
        kk.add(")");
        kk.add("]");
        int c = count(sss, st, kk);

        // 만들고 그대로 밖는다
        System.out.println(c);

    }


    public static int count(ArrayList<String> given_set, Stack<String> st, ArrayList<String> kk){

        // 스택 구현 해야한다
        if(given_set.size() == 0){
            if(st.isEmpty()){
                return 1;
            }else{
                return 0;
            }
        }

        int length =given_set.size();

        // 하나를 넣었을때 처음이 } 닻는 괄호면 그냥 0 반환해도 됩니다
        // 그리고 가능한 경우 다 만들때 이렇게 했던거 맞았나?
        for(int i = 0 ; i<length; i++){
            String dd = given_set.get(i);
            if(st.isEmpty() && kk.contains(dd)){
                return 0;
            }
            st.push(dd);
            given_set.remove(i);

            ArrayList<String> SA = new ArrayList<>(given_set);
            Stack<String> st2 = new Stack<>();  // 이거 하려면 다 넣어줘야 되는데 가능하긴함 스택 2개로


            // => 스택을 어떻게 해야되나 다시 넣어야되는데 이러면 스택 개손해인데
            // 왜하는거야 시발 !
            // 스택을 그냥 넣어주면 위에서 수정을 해야되는데 아예 clear를 해버리던가
            // 근데 clear를하면  처음부터 다시 시작해야 되는데



            //////////////////////////
            // 이게 뭔데? 가능한 경우를 합치고 싶어 // 근데 for문 안이여서 같이 넘겨줘야 될 것 같은데
            return count(SA, st, kk);
            // 여기서 뭔가 더하는게 있어야되는데 그냥 0 넣어주느게 best일수도
            /////////////////////////////////
            //카운트가 추가가 안될 듯함 이렇게 하면
        }


        // 나는 갯수를 합치고 싶은데 재귀를 통해 합칠 수 있는 방법이 막 생각이 나진 않는다
        return -1;

    }
}
