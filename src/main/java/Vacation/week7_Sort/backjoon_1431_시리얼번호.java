package Vacation.week7_Sort;

import java.io.*;
import java.util.Comparator;

public class backjoon_1431_시리얼번호 implements Comparator<String>{

    static int max_number;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        max_number = Integer.parseInt(br.readLine());
        String input_data;

        String[] array = new String[max_number];

        for(int i=0; i<max_number; i++){
            input_data = br.readLine();
        }



    }

    public int compare(String o1, String o2){

        return 0;
    }

}
