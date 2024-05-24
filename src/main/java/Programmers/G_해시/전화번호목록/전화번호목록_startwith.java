package Programmers.G_해시.전화번호목록;

import java.util.Arrays;

// 요구사항 :한번호가 다른 번호의 접두어인 경우가 있는지 체크
// 독립변수 : 요구사항, (문자, 다른 문자의 접두사인지 아닌지)
// 접두어 : 그 앞에 달려있는지
// 흐름
// 1. 완전 탐색을 돌린다
// 2. 접두사 판단 "[^"+ㅇㅇ+"]" . replace All
// 3. 접두사면 return false한다
//
public class 전화번호목록_startwith {
    public static void main(String[] args) {
        String[] dd= new String[]{"119", "97674223", "1195524421"};
        Arrays.sort(dd);

        System.out.println(check(dd));
    }

    // 정규 표현 식은 그러면 뭐지?
    // 해시를 어떻게 써야할까?

    // 어디에 저장해야 되는데...
    public static boolean check(String[] dd){
        for(int i= 0; i< dd.length; i++){
            if(dd[i+1].startsWith(dd[i])){
                return false;
            }
        }
        return true;
    }


}
