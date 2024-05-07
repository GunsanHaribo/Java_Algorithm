package Programmers.오토에버시험대비.E_정렬.가장큰수;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 가장큰수3 {
    public static void main(String[] args) {
        int[] numbers = new int[]{6, 10, 2};

        String answer = fun(numbers);
        System.out.println(answer);

    }


    public static String fun(int[] numbers){

        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .sorted((s1, s2) -> {
                    // 첫번째 수 그런거없이 그냥 만들어서 비교하네...
                    int original = Integer.parseInt(s1+s2);
                    int reversed = Integer.parseInt(s2+s1);
                    return reversed - original;
                })
                .collect(Collectors.joining(""))
                .replaceAll("^0+", "0");
    }


}
