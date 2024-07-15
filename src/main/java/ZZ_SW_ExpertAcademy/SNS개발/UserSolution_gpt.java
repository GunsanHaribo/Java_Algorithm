package ZZ_SW_ExpertAcademy.SNS개발;

import java.util.*;

public class UserSolution_gpt {
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

        // 랭크 맵의 항목을 리스트로 변환하고 정렬
        List<Map.Entry<Integer, Integer>> rankedList = new ArrayList<>(rank.entrySet());
        rankedList.sort((e1, e2) -> {
            if (e1.getValue().equals(e2.getValue())) {
                return Integer.compare(e1.getKey(), e2.getKey());
            } else {
                return Integer.compare(e2.getValue(), e1.getValue());
            }
        });

        // 상위 MAXL 개의 추천 친구를 리스트 배열에 저장
        int answerLength = Math.min(rankedList.size(), MAXL);
        for (int i = 0; i < answerLength; i++) {
            list[i] = rankedList.get(i).getKey();
        }

        return answerLength;
    }
}
