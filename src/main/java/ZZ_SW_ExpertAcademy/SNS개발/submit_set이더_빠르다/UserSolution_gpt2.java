package ZZ_SW_ExpertAcademy.SNS개발.submit_set이더_빠르다;

import java.util.*;

public class UserSolution_gpt2 {
    static final int MAXL = 5; // 친구 추천은 5를 넘지 않는다
    static final int MAXF = 10; // 서로 친구가될 친구의 수

    HashMap<Integer, Set<Integer>> friendInformation;

    public void init(int N) {
        friendInformation = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            friendInformation.put(i, new HashSet<>());
        }
    }

    public void add(int id, int F, int ids[]) {
        if(F>MAXF){
            System.out.println("F가 10보다 커요");
        }
        Set<Integer> mainIdSet = friendInformation.get(id);
        for (int i = 0; i < F; i++) {
            int target = ids[i];
            if (target == id) continue;

            mainIdSet.add(target);
            friendInformation.get(target).add(id);
        }
    }

    public void del(int id1, int id2) {
        friendInformation.get(id1).remove(id2);
        friendInformation.get(id2).remove(id1);
    }

    public int recommend(int id, int list[]) {
        Set<Integer> mainIdSet = friendInformation.get(id);

        Map<Integer, Integer> rank = new HashMap<>();
        for (int otherId : friendInformation.keySet()) {
            if (otherId == id || mainIdSet.contains(otherId)) continue;

            Set<Integer> targetIdSet = friendInformation.get(otherId);
            int count = 0;
            for (int friend : mainIdSet) {
                if (targetIdSet.contains(friend)) {
                    count++;
                }
            }
            if (count > 0) {
                rank.put(otherId, count);
            }
        }

        if (rank.size() == 0) {
            return 0;
        }


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
}
