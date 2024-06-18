package Programmers.네이버코테.J_구현.네이버_부스트캠프기출.First.구름기초.회전배열;
import java.io.*;
import java.util.*;
public class 회전배열_리스트 {

    // 일단 배열 다 돌리지 말고 포인터 쓰는 방법 고려

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] number_M = input.split(" ");
        int M = Integer.parseInt(number_M[1]);

        String input2 = br.readLine();
        String[] arr = input2.split(" ");
        List<String> input_arr = new ArrayList<>(List.of(arr));

        for(String s: arr){
            input_arr.add(s);
        }
        // System.out.println(input_arr);
        // System.out.println(M);


        for(int i=0; i<M; i++){

            int first_number = Integer.parseInt(input_arr.get(0));
//            List<String> n_list = new ArrayList();

            int size = input_arr.size();

            // 상당히 큰수를 박아 버리는가 본데
            if(first_number >=size){
                first_number = first_number %size;
            }

            Collections.rotate(input_arr, -first_number);

        }

        String answer = input_arr.get(0);
        // System.out.println(input_arr);
        System.out.println(answer);
    }

}


