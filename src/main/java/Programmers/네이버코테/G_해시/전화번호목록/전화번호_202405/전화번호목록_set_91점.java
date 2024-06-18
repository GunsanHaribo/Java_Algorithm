package Programmers.네이버코테.G_해시.전화번호목록.전화번호_202405;


// 요구사항 :한번호가 다른 번호의 접두어인 경우가 있는지 체크
// 독립변수 : 요구사항, (문자, 다른 문자의 접두사인지 아닌지)
// 접두어 : 그 앞에 달려있는지
// 흐름


// set이든 map이든 사용해야 될것 같은데
// 중복된 문자가 있는지 찾으면 되나? 3까지?

import java.util.*;

// 1. length대로 sort하고 -> 정렬
// 2. 해당 원소의 length를 기준으로 나머지 것들을 length 기준으로 짤라서 비교한다 -> length 자르기

// 3. prefix 비교
//


// 시간 복잡도를 줄여야되는데


// 어떤 집합에 존재하는지, 중복제거
public class 전화번호목록_set_91점 {
    public static void main(String[] args) {
        String[] dd= new String[]{"119", "97674223", "1195524421"};
        Arrays.sort(dd, (v1,v2) -> v1.length() -v2.length());

        System.out.println(check2(dd));
    }
    public static boolean check2(String[] dd){

        Set<String> s = new HashSet<>(List.of(dd));

        for(int i= 0; i<dd.length; i++) {
            int i_len = dd[i].length();
            s.add(dd[i]);
            for (int j = i + 1; j < dd.length; j++) {
                String d = dd[j].substring(0, i_len);

                if (s.contains(d)) {
                    return false;
                }

            }
        }

        return true;
    }

}