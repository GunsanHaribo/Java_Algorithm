package ZZ_SW_ExpertAcademy.SNS개발.submit;

import java.util.*;

public class UserSolutionReal {

    static final int MAXL = 5; // 친구 추천은 5를 넘지 않는다
    static final int MAXF = 10; // 서로 친구가될 친구의 수

    HashMap<Integer, HashSet<Integer>> friendInformation;

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
        Map<Integer, Integer> rank = new HashMap<>(); // 해시가 더 이득이다

        // 친구의 친구를 카운트 // for문 정렬


        // 핵심 :: 탐색 범위 축소: 첫 번째 코드는 mainIdSet에 포함된 친구의 친구만을 대상으로 하므로, 불필요한 연산이 줄어듭니다.
        // getOrDefault 쉽게 카운터 구할때 사용, 디폴트 0으로 설정 카운트 쉽게 한다

        // 메인 아이디에서 일단 다 돌리는데 id가 친구 추가가 되어 있으면 안된다 => friendOfFriend != id
        // 그 다음 friendOfFriend 친구의 친구가 id의 친구에 등록이 되어 있지않으면
        // rank에 추가한다 // 돌면서 같은거 있음aus getOrDefault 사용해서 ㄱㄱ
        for (Integer friend : mainIdSet) {
            for (Integer friendOfFriend : friendInformation.get(friend)) {
                //
                if (friendOfFriend != id && !mainIdSet.contains(friendOfFriend)) {
                    rank.put(friendOfFriend, rank.getOrDefault(friendOfFriend, 0) + 1);
                }
            }
        }

        // 랭킹에 따라 추천
        // 정렬은 비슷할 듯
        // key로 하는 정렬이 아니라 entry로 할 수도 있네 알아두자ㅐ
        List<Map.Entry<Integer, Integer>> rankedList = new ArrayList<>(rank.entrySet());
        rankedList.sort((entry1, entry2) -> {
            int compare = entry2.getValue().compareTo(entry1.getValue());
            if (compare == 0) {
                return entry1.getKey().compareTo(entry2.getKey());
            }
            return compare;
        });

        int answerLength = Math.min(rankedList.size(), MAXL);
        for (int i = 0; i < answerLength; i++) {
            list[i] = rankedList.get(i).getKey();
        }
        return answerLength;
    }
}
