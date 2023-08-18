package week15_Hash;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class baekjoon_1620_나는야이다솜 {
    public static void main(String[] args) throws IOException {
        //1 부터 n까지 들어오고
        // 그 다음 줄에는 문제
        //번호를 말하면 번호 아니면 번호에 해당하는 포켓몬이름
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int pocketmon_number = Integer.parseInt(st.nextToken());
        int quiz_number = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> pocketmon_book = new HashMap<>();
        String[] pocketmon_book_value = new String[pocketmon_number+1];

        for(int i=1; i<pocketmon_number+1; i++){
            String name = br.readLine();
            pocketmon_book.put(name, i);
            pocketmon_book_value[i] = name;
        }

        for(int i = 0; i< quiz_number; i++){

            String input = br.readLine();
            if(isInteger(input)){ //숫자면
                bw.append(pocketmon_book_value[Integer.parseInt(input)]+"\n");

            }else{
                bw.append(pocketmon_book.get(input)+"\n");
            }

        }

        bw.close();


    }

    public static boolean isInteger(String num) {
        if(num == null){
            return false;
        }
        try{
            int i = Integer.parseInt(num);
        }catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }


//    public static <K, V> K getKey(HashMap<K,V> map, V value){
//
//        for (K key : map.keySet()) {
//            if (value.equals(map.get(key))) {
//                return key;
//            }
//        }
//        return null;
//    }
}
