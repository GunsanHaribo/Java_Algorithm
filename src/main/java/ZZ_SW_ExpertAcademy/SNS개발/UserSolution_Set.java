package ZZ_SW_ExpertAcademy.SNS개발;

import java.util.*;

public class UserSolution_Set {

    static final int MAXL		= 5; // 친구 추천은 5를 넘지 않는다
    static final int MAXF		= 10; // 서로 친구가될 친구의 수

    // 초기화 하는 로직
    // 1 8, 8반환
    // 리스트가 아니라 Set 사용 한다면 불필요한게 많이 사라지긴 할듯
    HashMap<Integer, Set<Integer>> friendInformation; // 정렬하는게 귀찮으면 우선순위 큐 쓰던가 같은 자료형들의 모음
    public void init(int N)
    {
        friendInformation = new HashMap<>();
        for(int i=1; i<= N; i++){
            friendInformation.put(i, new HashSet<>());
        }
    }

    // 친구 추가하는 로직
    // ids : 현재 친구목록
    // F : 서로 친구가 될 사용자의 수
    // id랑 ids를 통해서 적는다
    // 2 8 1 3
    // 8과 1,3
    public void add(int id, int F, int ids[])
    {
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

    // 친구 삭제하는 로직
    // 각각의 친구 목록에서 서로 삭제가 된다
    // ids에서 삭제가 된다
    // 3 1 6
    public void del(int id1, int id2)
    {
        friendInformation.get(id1).remove(id2);
        friendInformation.get(id2).remove(id1);
        // 이게 인덱스가 아니라 value인데 인덱스로 인식하네 -> InterValue로 object처리한다
    }

    // 친구 추천하는 로직
    // 추천되는 사용자 id를 내림 차순으로 list배열에 저장하고 추천되는 사용자 수를 반환 => list length 반환
    // 최대 친구 추천 수는 5이다
    // 추천할 친구가 없는 경우 0을 반환한다

    // A사용자가 친구가 아닌 사용자 중에서 A랑 비교했을떄 함께 아는 친구가 많은 순서대로
    //4 2 3 6 8 5
    // id = 2, len_a : 2, list_a[] : 6,8,5,
    // 지금 매개변수는 빈 리스트가 들어간다


    // 마지막 껄 못하는데
    // 4 18 5 5 7 8 10 11 : 이 두개를 합친다
    public int recommend(int id, int list[]) {
//        System.out.println("추천시");
//        System.out.println("메인 아이디:"+id+ "리스트:"+ Arrays.toString(list));
//        System.out.println("전체 연결:"+friendInformation);


        // id랑 같은 원소를 가진 걸 찾는다 // 이제 순회를 해야되는데 인접 리스트처럼
        Set<Integer> mainIdSet = friendInformation.get(id);
//        System.out.println(mainIdSet);
        Map<Integer, Integer> rank = new HashMap<>();

        List<Integer> noContainList = new ArrayList<>();
        // 다른 id중에서 친구목록에 id가 없는걸 찾는다 만약에 없으면 번호만 따로 놓는다
        // 여기서 틀리는 것 같은데
        for(int i=1; i<= friendInformation.size(); i++){
            if(i == id) continue;
            Set<Integer> targetIdList = friendInformation.get(i);
            // 여기서 문제인듯
            if(!targetIdList.contains(id)){
                noContainList.add(i);
            }
        }
//        System.out.println(noContainList);
        // 다음 얼마나 같은 걸 가지고 잇는가에 따라 순위를 매긴다
        // 이게 이중 for문으로 할건가 아니면 다른 걸로 할건가에 따라서 달라질 듯

//        System.out.println("noContainList:"+ noContainList);



        // 이중 for문 만약에 noContains가 있다면
        for(int otherIds : noContainList){
//                System.out.println("들어옴 : "+otherIds);
            Set<Integer> targetIdList = friendInformation.get(otherIds);
//                System.out.println(targetIdList);
            int count =0;
            for(int mainId : mainIdSet){
//                List<Integer> mainIdList = new ArrayList<>(mainIdSet);
                boolean isSame = targetIdList.contains(mainId);
                if(isSame){
                    count++;
                }
            }
            if(count != 0){
                rank.put(otherIds, count);
            }

        }
//        System.out.println("키리스트 :"+rank);
        if(rank.size() != 0){

            Set<Integer> keys = rank.keySet();
            List<Integer> keyList = new ArrayList<>(keys);
            // 다음 정렬했어 그럼 그냥 리턴 하면 되지않나 아! 같을떄
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

            // 어레이 리스트를 int[]로 변환
            // 근데 이거...주솟값이 들어왔는데 왜 안바뀌지

//            keyList.stream().mapToInt(Integer::intValue).toArray();
            int answerLength = Math.min(keyList.size(), MAXL) ;
            for(int i =0; i<answerLength; i++){
//                System.out.println("키사이즈"+keyList.size());
//                System.out.println(keyList.get(i));
                list[i] = keyList.get(i);
            }

//            System.out.println(Arrays.toString(list));
            return answerLength;
        }


        return 0;
    }

}
