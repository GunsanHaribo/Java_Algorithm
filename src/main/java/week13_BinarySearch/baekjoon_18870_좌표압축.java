package week13_BinarySearch;

import java.io.*;
import java.util.*;


public class baekjoon_18870_좌표압축 {
    //[i]보다 작은 수 출력
    //시간초과
    //그러면 중복제거후 남는 초기화 0인 숫자들은 어떻게하고?
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //어레이 리스트 한개(중복제거) //Sorting 필수
        //+그냥 리스트 한개 answer 순서 맞춰야됨
//        ArrayList<Integer> NO_Duplication= new ArrayList<Integer>();
        int max_number = Integer.parseInt(br.readLine());

        int[] answer_sequence = new int[max_number];

        st = new StringTokenizer(br.readLine());

//        int[] NO_Duplication = new int[max_number];
        //이걸 어떻게 처리해야 되나

        HashMap<Integer, Integer> NO_Duplication = new HashMap<Integer, Integer>();

        //contains에서 시간이 많이 걸리는가보다...아닌가...??
        for(int i=0; i<answer_sequence.length; i++){
            answer_sequence[i] = Integer.parseInt(st.nextToken());
        }
        int[] answer_sequence2 = answer_sequence.clone();

//        for(int i :answer_sequence){
//            if(!NO_Duplication.contains(i)) {
//                NO_Duplication.add(i);
//            }
//        }
        //아니 이러면 비잖아
        //그냥 다 넣어도 상관 없긴함
        Arrays.sort(answer_sequence);


        int rank =0;
        for(int i=0; i<max_number; i++){
            if(!NO_Duplication.containsKey(answer_sequence[i])){
                NO_Duplication.put(answer_sequence[i], rank++);
            }

        }
        //


//        System.out.println();
//        Collections.sort(NO_Duplication);
//        for(int k : NO_Duplication){
//            System.out.print(k+" ");
//        }

//        System.out.println();
       //함수를 통해서 몇번쨰인지 찾고 br.append



        for(int i: answer_sequence2){
//            bw.write(NO_Duplication.get(i));
//            System.out.print(NO_Duplication.get(i) + " ");
            bw.write(NO_Duplication.get(i)+" ");
        }


        br.close();
        bw.close();

    }
//    static int min=0;
//    static int max;
//    static int mid;

    //끝부분들이 틀림
//    static int BinarySearch(int [] d_array, int target){
//        max=d_array.length-1;
//
//        while(min<=max){
//            mid = (min+max)/2;
//            if(d_array[mid] == target){
//                return mid;
//            }else if(d_array[mid]<target){
//                min= mid+1;
//            }else{
//                max = mid-1;
//            }
//        }
//        //없으면
//        return 0;
//    }
}
