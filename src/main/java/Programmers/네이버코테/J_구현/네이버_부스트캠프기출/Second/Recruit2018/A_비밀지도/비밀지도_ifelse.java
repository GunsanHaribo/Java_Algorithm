package Programmers.네이버코테.J_구현.네이버_부스트캠프기출.Second.Recruit2018.A_비밀지도;

// 요구사항 : 비밀지도의 암호를 해독해라, 지도1 + 지도2 -> 비밀지도,  지도는 2진수로 되어있음
// 변수 : 지도(2진수 표현)

// 흐름 :
// 1. row에 해당하는 2진수를 구한다, 1이면 # 0이면 0문자열로 바꾸고 배열에 넣어놓는다. -> 2진수 구하는기능
// 2. 지도1, 지도2를 row마다 비교해서 두개가 같으면 그대로 두고 다르면 #면 채운다 -> 지도 2개 비교하는 기능
// 3. 그렇게해서 최종 보물지도를 만든다


import java.util.Arrays;

public class 비밀지도_ifelse {
    public static void main(String[] args) {

        int[] arr = new int[]{9, 20, 28, 18, 11};
        int[] arr2 = new int[]{30, 1, 21, 17, 28};

        String[] trans_map = translate_map_bi(arr);
        String[] trans_map2 = translate_map_bi(arr2);
//        System.out.println(Arrays.toString(translate_map_bi(arr)));
//        System.out.println(Arrays.toString(translate_map_bi(arr2)));

        String[] answer = combine_twoMap(trans_map,trans_map2);
        System.out.println(Arrays.toString(answer));
    }

    // 몫을 arralylist에 넣는다
    // 분자가 0이 아닐 때까지
    public static String[] translate_map_bi(int[] target){

        String[] tran_result = new String[target.length];
        for(int i= 0; i< target.length; i++){

            int son =target[i];
            int mom = 2;

            // 5글자인데;;
            String[] row = new String[target.length];
            for(int j=0; j<target.length; j++ ){
                int left =son%mom;
                son= son/mom;
                if(left == 0){
                    row[j] = " ";
                }else{
                    row[j] = "#";
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int s = row.length-1; s>=0; s--){
                sb.append(row[s]);
            }
            tran_result[i] =  sb.toString();
        }



        return tran_result;
    }

    public static String[] combine_twoMap(String[] map1, String[] map2){
        String[] final_map = new String[map1.length];


        // 이게 한문장인데
        for(int i = 0; i<map1.length; i++){
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j<map1[i].length(); j++){
                boolean check = map1[i].charAt(j) == map2[i].charAt(j) ; // false면 //한글자 한글자가 같을때
                if(check){
                    sb.append(map1[i].charAt(j));
                }else{
                    sb.append("#");
                }
            }

            final_map[i] = sb.toString();
        }



        return final_map;
    }
}
