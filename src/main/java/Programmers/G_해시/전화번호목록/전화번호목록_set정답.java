package Programmers.G_해시.전화번호목록;

import java.util.*;

public class 전화번호목록_set정답 {

    public static void main(String[] args) {
        String[] dd= new String[]{"119", "97674223", "1195524421"};

        System.out.println(check2(dd));
    }
    public static boolean check2(String[] dd){
        Set<String> s = new HashSet<>(List.of(dd));

        for(int i= 0; i<dd.length; i++) {

            for (int j = 0; j < dd[i].length(); j++) {
                String d = dd[i].substring(0, j);

                if (s.contains(d)) {
                    return false;
                }

            }
        }

        return true;
    }
}
