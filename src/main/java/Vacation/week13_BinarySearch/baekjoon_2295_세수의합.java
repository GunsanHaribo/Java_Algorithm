package Vacation.week13_BinarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//문제점 13이 있는데 13을 못 찾는다 => min 재설정하는 곳에서 틀림
// contains는 다뒤진다 => o(n)의 시간 복잡도임
public class baekjoon_2295_세수의합 {
//    arr[x] + arr[y] + arr[z] = arr[k]
//    arr[x] + arr[y] = arr[k] - arr[z]

    //가장 큰 두수의 합과(x+y), k가 존재하는 가장 작은 z 구하기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max_number = Integer.parseInt(br.readLine());
        int[] d_arry = new int[max_number];

        for(int i =0; i<max_number; i++){
            d_arry[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(d_arry);

        ArrayList<Integer> sumOfTwo = new ArrayList<Integer>();

        //자기 자신은 중복선택 못하는데;;
        for(int i = 0; i< d_arry.length; i++){
            for(int j =i; j< d_arry.length; j++){
//                if(!sumOfTwo.contains(d_arry[i]+d_arry[j])){
//                    sumOfTwo.add(d_arry[i]+d_arry[j]);
////                }
                sumOfTwo.add(d_arry[i]+d_arry[j]);
            }
        }

//        for(int i: d_arry){
//            for(int j: d_arry){
//                if(!sumOfTwo.contains(i+j)){
//                    sumOfTwo.add(i+j);
//                }
//            }
//        }

        Collections.sort(sumOfTwo); //2개 합 배열
        // k-z를 바로 찾는다
        //d_arry 뒤에서 부터 찾는다

//        System.out.println(sumOfTwo.toString());

        int answer = -1;
        for(int i = 0; i < d_arry.length ; i++){
            for(int j = 0; j < d_arry.length; j++){
                int compare = d_arry[i] - d_arry[j];
//                System.out.print("i-j "+compare+ " ");
                //j가 가장 큰값..찾아야함
                //x y가 양수 여서;;
                // 왜 못 넘지...??// binary search에서 다 false가 뜨는데
//                System.out.print("참거짓"+BinarySearch(sumOfTwo, compare)+"./ ");
                if(BinarySearch(sumOfTwo, compare) && compare >0){
                    answer = Math.max(answer, d_arry[i]);
//                    System.out.print("최소:"+answer+" ");
                }

            }
//            System.out.println();
        }

        bw.append(answer+"");
        bw.close();



    }
    static boolean BinarySearch(ArrayList<Integer> array, int target){
        int min = 0;
        int max = array.size()-1;

        while(min<=max){
            int mid = (min+max)/2;
            int  check = array.get(mid);
            if(array.get(mid) == target){
                return true;
            } else if (array.get(mid) > target) {
                max = mid -1;
            }else{
                min = mid +1;
            }
        }
        return false;
    }

}
