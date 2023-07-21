package Week1_Array;
import java.util.*;


public class Remove {
    public static void main(String[] args) {
        //remove 지운다 인덱스 번호로 length 확인 후
        //지우면 이후의 숫자들을 땡긴다
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));

        list = remove_list(2, list);

        System.out.println(Arrays.deepToString(list.toArray()));
    }
    public static ArrayList<Integer> remove_list(int index, ArrayList<Integer> list){

        //인덱스 삭제
        //해당 인덱스 제외하고 나머지는 다른 인덱스에 추가
        //해당 인덱스가 0이면 1부터 0에 추가하는 형식 덮어쓰기로 가자
        //for 사용 인덱스, 해당 인덱스 부터 앞으로 당긴다 마지막은 삭제해야함
        System.out.println("함수진입");

        for(int i = index; i<list.size()-1; i++){
            list.set(i,list.get(i+1));
        }

        ArrayList<Integer> return_list = new ArrayList<Integer>();
        for(int i = 0; i<list.size()-1; i++){
            return_list.add(list.get(i));
        }

        return return_list;
    }
}
