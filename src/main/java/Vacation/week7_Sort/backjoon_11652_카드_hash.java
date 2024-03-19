package Vacation.week7_Sort;

import java.io.*;
import java.util.HashMap;

public class backjoon_11652_카드_hash {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int max_number = Integer.parseInt(br.readLine());
        HashMap<Integer,Integer> map1 = new HashMap<Integer,Integer>();

        int input_data;
        for(int i=0; i<max_number; i++){
            input_data = Integer.parseInt(br.readLine());

            if(map1.containsKey(input_data)){

            }else{
                map1.put(input_data,1);
            }
        }


    }

}
