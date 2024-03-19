package Vacation.Week1_Array;
import java.util.*;

public class Insert_sol {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(10, 20, 30));
        myInsert(arr, 0, 50);
        System.out.println(arr); // [50, 10, 20, 30]
    }

    public static <T> void myInsert(List<T> list, int index, T newElement) {
        //제너릭을 쓰겠다 그리고
        if (index < 0 || index > list.size()) {
            throw new IndexOutOfBoundsException("Index out of range");
        }

        list.add(newElement);

        for (int i = list.size() - 1; i >= index + 1; i--) {
            T temp = list.get(i);
            list.set(i, list.get(i - 1));
            list.set(i - 1, temp);

        }
    }
}
