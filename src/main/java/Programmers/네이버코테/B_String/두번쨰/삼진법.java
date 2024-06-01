package Programmers.네이버코테.B_String.두번쨰;

public class 삼진법 {
    public static void main(String[] args) {
        Integer n = 125;

        // 숫자를 3진법 문자열로 변환
        String get3 = Integer.toString(n, 3);

        // 문자열을 한번 뒤집는다 - stringbuilder
        StringBuilder sb = new StringBuilder(get3);
        sb.reverse();
        //
        String sb2 = sb.toString();
        int answer = Integer.parseInt(sb2, 3);

        System.out.println(answer);
    }
}
