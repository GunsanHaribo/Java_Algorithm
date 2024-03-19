package Vacation.week15_Hash;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class baekjoon_9375_신혜빈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase_number = Integer.parseInt(br.readLine());
        for(int i=0; i < testcase_number; i++){
            int cloth_set_number = Integer.parseInt(br.readLine());
            HashMap<String,Integer> cloth_type_number = new HashMap<>();
            for(int k=0; k<cloth_set_number; k++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name= st.nextToken();
                String type = st.nextToken();

                if(!cloth_type_number.containsKey(type)){

//                    System.out.println("새로"+name +"타입"+type);
                    cloth_type_number.put(type, 2);
                }else{
//                    System.out.println("기존"+name +"타입"+type);
                    cloth_type_number.put(type, cloth_type_number.get(type)+1);
                }
            }

            //출력
//            Iterator<String> iterator = cloth_type_number.keySet().iterator();
//            while(iterator.hasNext()) {
//                String key = (String)iterator.next();
//                System.out.print("key = " + key);
//                System.out.println(" value = " + cloth_type_number.get(key));
//            }
//            System.out.println();


            int count2 = 1;
            for(String k: cloth_type_number.keySet()){
                count2 = count2*cloth_type_number.get(k);
            }

            bw.append(count2-1+"").append("\n");

        }


        bw.close();
    }


}


//import java.io.*;
//        import java.util.*;
//
//public class Main {
//    public static void main(String[]args)throws IOException{
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int N = Integer.parseInt(br.readLine());
//
//        for(int i = 0; i < N; i++){
//            int M = Integer.parseInt(br.readLine());
//            HashMap<String, Integer> map = new HashMap<>();
//
//            for(int j = 0; j < M; j++){
//                String[] input = br.readLine().split(" ");
//                map.computeIfAbsent(input[1], key -> new Integer(0));
//                map.put(input[1], map.get(input[1]) + 1);
//            }
//            int count = 1;
//
//            for(String name : map.keySet()){
//                count *= (map.get(name) + 1);
//            }
//            count -= 1;
//            bw.write(count + "\n");
//        }
//        bw.flush();
//    }
//}
