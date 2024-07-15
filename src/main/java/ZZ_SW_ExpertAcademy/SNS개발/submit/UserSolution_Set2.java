package ZZ_SW_ExpertAcademy.SNS개발.submit;

import java.util.*;

public class UserSolution_Set2 {

    static final int MAXL		= 5; // 친구 추천은 5를 넘지 않는다
    static final int MAXF		= 10; // 서로 친구가될 친구의 수


    HashMap<Integer, Set<Integer>> friendInformation; // 정렬하는게 귀찮으면 우선순위 큐 쓰던가 같은 자료형들의 모음
    public void init(int N)
    {
        friendInformation = new HashMap<>();
        for(int i=1; i<= N; i++){
            friendInformation.put(i, new HashSet<>());
        }
    }


    public void add(int id, int F, int ids[])
    {
        if(F>MAXF){
            System.out.println("F가 10보다 커요");
        }
        Set<Integer> mainIdSet = friendInformation.get(id);
        // 돌면서 서로 추가를 해줘야한다
        for(int i = 0; i< F; i++){
            int target = ids[i];
            if(target == id) continue;

            mainIdSet.add(target);
            Set<Integer> targetIdList = friendInformation.get(target);
            targetIdList.add(id); // id 추가

        }
    }

    public void del(int id1, int id2)
    {
        friendInformation.get(id1).remove(id2);
        friendInformation.get(id2).remove(id1);
    }



    public int recommend(int id, int list[]) {

        Set<Integer> mainIdSet = friendInformation.get(id);

        Map<Integer, Integer> rank = new HashMap<>();

        List<Integer> noContainList = new ArrayList<>();


        // 이 부분을 최적화 해야된다
        for(int i=1; i<= friendInformation.size(); i++){
            if(i == id) continue;
            Set<Integer> targetIdList = friendInformation.get(i);
            // 여기서 문제인듯
            if(!targetIdList.contains(id)){
                noContainList.add(i);
            }
        }

        for(int otherIds : noContainList){
            Set<Integer> targetIdList = friendInformation.get(otherIds);

            int count =0;
            for(int mainId : mainIdSet){
                boolean isSame = targetIdList.contains(mainId);
                if(isSame){
                    count++;
                }
            }
            if(count > 0){
                rank.put(otherIds, count);
            }

        }
        if(rank.size() != 0){

            Set<Integer> keys = rank.keySet();
            List<Integer> keyList = new ArrayList<>(keys);
            keyList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    int first = rank.get(o1);
                    int second = rank.get(o2);

                    if(first == second){
                        return o1-o2;
                    }

                    return second - first;
                }
            });


            int answerLength = Math.min(keyList.size(), MAXL) ;
            for(int i =0; i<answerLength; i++){
                list[i] = keyList.get(i);
            }
            return answerLength;
        }


        return 0;
    }

}
