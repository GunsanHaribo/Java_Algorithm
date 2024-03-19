package Vacation.Week1_Array;
import java.util.*;
//나는 그럼 가운데서 박고 움직여보자
public class Insert3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        InsertList(list, 3,70);
        System.out.println(Arrays.deepToString(list.toArray()));
        //인덱스 범위 초과해도 되는 이유// for문안으로 안들어가니깐
    }
    //여기서 제네릭은 같은 변수
    public static <T> void InsertList(ArrayList<T> list, int index, T NewValue){
        //어레이 리스트를 뒤로 한칸씩밀고 그 사이에 넣어보자
        //근데 뒤로 한칸씩 꼭 밀어야 하나? // 뒤에 박은 다음에 돌리면 되지않아?
        if(index<0){
            throw new IndexOutOfBoundsException("Index out of range");
        }

        list.add(NewValue);


        for(int i = list.size()-1; i > index; i--){
            T temp = list.get(i-1); // i-1이여서 0일때 i-1 되면 안됨
            list.set(i-1,list.get(i));
            list.set(i,temp);
        }
    }
}
