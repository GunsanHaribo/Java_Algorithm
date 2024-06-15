package Programmers.네이버코테.J_구현.네이버_부스트캠프기출.First.구름기초.회전배열;
import java.io.*;
import java.util.*;

public class 회전배열_Collection_rotate {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] number_M = input.split(" ");
        int M = Integer.parseInt(number_M[1]);

        String input2 = br.readLine();
        String[] arr = input2.split(" ");
        List<String> input_arr = new ArrayList<>();
        for(String s: arr){
            input_arr.add(s);
        }
        // System.out.println(input_arr);
        // System.out.println(M);

        for(int i=0; i<M; i++){

            int first_number = Integer.parseInt(input_arr.get(0));
            List<String> n_list = new ArrayList();
            int size = input_arr.size();

            // 상당히 큰수를 박아 버리는가 본데
            if(first_number >=size){
                first_number = first_number %size;
            }

            // 이거 첫번쨰 M일때
            // 2라면 더한다, 3 더한다

            // deque로 풀어보기
            for(int j =first_number; j< input_arr.size(); j++){
                n_list.add(input_arr.get(j));
            }
            for(int j =0; j< first_number; j++){
                n_list.add(input_arr.get(j));
            }


            input_arr = new ArrayList(n_list);
            // System.out.println(input_arr);
        }

        String answer = input_arr.get(0);
        // System.out.println(input_arr);
        System.out.println(answer);

        // System.out.println("Hello Goorm! Your input is " + input);
    }
}
