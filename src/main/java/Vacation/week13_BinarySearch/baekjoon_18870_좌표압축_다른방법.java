package Vacation.week13_BinarySearch;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_18870_좌표압축_다른방법 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //어레이 리스트 한개(중복제거) //Sorting 필수
        //+그냥 리스트 한개 answer 순서 맞춰야됨
//        ArrayList<Integer> NO_Duplication= new ArrayList<Integer>();
        int max_number = Integer.parseInt(br.readLine());

        int[] input_array = new int[max_number];
        int[] answer_sequence;
        int[] no_duplication = new int[max_number];
        StringTokenizer st = new StringTokenizer(br.readLine());

        //클론 뜨고 넣고 sort하고
        for(int i=0; i<input_array.length; i++){
            input_array[i] = Integer.parseInt(st.nextToken());
        }

        answer_sequence = input_array.clone();
        Arrays.sort(input_array);


        //pre 변수 만들고 이전값이랑 다르면 리스트에 넣고
        int pre= input_array[0];
        no_duplication[0] = input_array[0];
        int len =1;
        for(int i =1; i<input_array.length; i++){
            if(pre==input_array[i]){
                pre=input_array[i];
                continue;
            }
            pre=input_array[i];
            no_duplication[len++] = input_array[i];
        }


        //마지막으로 탐색 해서 bw 출력
        for(int i: answer_sequence){
            bw.write(BinarySearch(no_duplication, i, len)+" ");
        }
        bw.close();
        br.close();


    }



    static int BinarySearch(int [] d_array, int target, int len){
        int min=0;
        int max= len-1;
        int mid;

        while(min<=max){
            mid = (min+max)/2;
            if(d_array[mid] == target){
                return mid;
            }else if(d_array[mid]<target){
                min= mid+1;
            }else{
                max = mid-1;
            }
        }
        //없을 수가 없으니깐
        //mid 뜬 min이든 반환해야되는데

        return 0;
    }
}
