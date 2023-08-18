package week13_BinarySearch;

import java.util.Arrays;

public class binarySearch {
    public static void main(String[] args) {
        int[] A = { 4, 6, 8, 10, 15 };
        int key = 10;

        int index = Arrays.binarySearch(A, key);

        if (index >= 0) {
            System.out.println("Element is found at index " + index);
        } else {
            System.out.println("Element not found in the array");
        }
    }
}
