package Programmers.E_정렬;

import java.util.Comparator;

public class 문자열내림차순으로배치 {
    public static void main(String[] args) {
        Comparator<Integer> sort = (v1, v2) -> v1 - v2;
        Comparator<Integer> descendingOrder = new Comparator<Integer>() {
            public int compare(Integer v1, Integer v2) {
                return v2 - v1;
            }
        };

        char i = 'A';
        System.out.println((int) i);

        char a = 'a';
        System.out.println((int) a);


    }
}
