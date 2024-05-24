package Programmers.오토에버시험대비_구현.E_정렬.문자열_내_마음대로_정렬하기;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열_내_마음대로정렬하기 {
    public static void main(String[] args) {
//        String[] arr = new String[]{"sum", "bed", "car"};
//        int n = 1;

        String[] arr = new String[]{"abce", "abcd", "cdx"};
        int n = 2;

//        System.out.println("Abb" > "Beee");

        // 아... 파이썬은 그냥 빼면 되는데.//

        Comparator<String> com_chr = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                int sub = o1.charAt(n) - o2.charAt(n);

                if(sub ==0){
                    // 사전순 정렬 아... 대소 문자 왜 안되는데!

                    // 이러면 chart

                    int compare;
                    if(o1.length() > o2.length()){
                        compare = o2.length();
                    } else{
                        compare = o1.length();
                    }
                    for(int i = 0; i< compare; i++){
                        int DictionaryOrder = o1.charAt(i) - o2.charAt(i);
                        if(DictionaryOrder !=0){
                            return DictionaryOrder;
                        }
                    }
                }
                return sub;
            }
        };

        Arrays.sort(arr, com_chr);

        System.out.println(Arrays.toString(arr));







    }



}
