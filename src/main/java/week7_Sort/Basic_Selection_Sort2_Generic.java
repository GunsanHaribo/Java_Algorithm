package week7_Sort;
import java.util.Arrays;

//앞으로 이런 식으로 코드 짜기
public class Basic_Selection_Sort2_Generic<T extends Comparable<T>> {

    public T[] selectionSort(T[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIdx]) < 0) {  // 2개 비교했을 때 A.compareTo(B) A가 더 작다
                    minIdx = j;
                }
            }
            if (i != minIdx) {
                swap(arr, i, minIdx);
            }
        }

        return arr;
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // 예시로 정수 배열을 사용하는 경우
        Integer[] intArray = {9,1,6,8,4,3,2,0};
        Basic_Selection_Sort2_Generic<Integer> selectionSort = new Basic_Selection_Sort2_Generic<>();
        Integer[] sortedArray = selectionSort.selectionSort(intArray);
        System.out.println(Arrays.toString(sortedArray));
    }
}