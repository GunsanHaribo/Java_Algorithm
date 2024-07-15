// 130~200ms hashmap
package ZZ_SW_ExpertAcademy.SNS개발.submit_set이더_빠르다;

import java.util.*;


class UserSolution
{
    static final int MAXL		= 5; // 친구 추천은 5를 넘지 않는다
    static final int MAXF		= 10; // 서로 친구가될 친구의 수

    HashMap<Integer, List<Integer>> friendInformation;
    public void init(int N)
    {
        friendInformation = new HashMap<>();
        for(int i=1; i<= N; i++){
            friendInformation.put(i, new ArrayList<>());
        }
    }

    public void add(int id, int F, int ids[])
    {
        if(F>10){
            return;
        }
        List<Integer> mainIdList = friendInformation.get(id);

        for(int i = 0; i< F; i++){
            int target = ids[i];
            if(target == id) continue;


            if(!mainIdList.contains(target)){
                mainIdList.add(target);
            }

            List<Integer> targetIdList = friendInformation.get(target);
            if(!targetIdList.contains(id)){
                targetIdList.add(id); // id 추가
            }

        }
    }

    public void del(int id1, int id2)
    {
        List<Integer> firstIdList = friendInformation.get(id1);
        List<Integer> secondIdList = friendInformation.get(id2);
        firstIdList.remove(Integer.valueOf(id2));
        secondIdList.remove(Integer.valueOf(id1)); // 이게 인덱스가 아니라 value인데 인덱스로 인식하네 -> InterValue로 object처리한다
    }


    public int recommend(int id, int list[]) {



        List<Integer> mainIdList = friendInformation.get(id);

        List<Integer> noContainList = new ArrayList<>();

        for(int i=1; i<= friendInformation.size(); i++){
            if(i == id) continue;
            List<Integer> targetIdList = friendInformation.get(i);

            if(!targetIdList.contains(id)){
                noContainList.add(i);
            }
        }

        Map<Integer, Integer> rank = new HashMap<>();

        for(int otherIds : noContainList){

            List<Integer> targetIdList = friendInformation.get(otherIds);

            int count =0;
            for(int i=0; i< mainIdList.size(); i++){
                boolean isSame = targetIdList.contains(mainIdList.get(i));
                if(isSame){
                    count++;
                }
            }
            if(count != 0){
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

            int answerLength = keyList.size();
            for(int i =0; i<answerLength; i++){

                if(i >= MAXL){
                    answerLength = MAXL;
                    break;
                }
                list[i] = keyList.get(i);
            }

            return answerLength;
        }


        return 0;
    }


}

