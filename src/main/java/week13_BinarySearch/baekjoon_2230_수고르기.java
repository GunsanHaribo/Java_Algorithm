package week13_BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class baekjoon_2230_수고르기 {
    //    a[i] - a[j] >= M
    //     이진 탐색 수식 세우기

    //    a[i] - a[j] >= M
    //    a[i] >= M + a[j] ==> LowerBound
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int array_maxnumber = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] input_array = new int[array_maxnumber];

        for(int i =0; i<array_maxnumber; i++){
            input_array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(input_array);


        int answer = Integer.MAX_VALUE;
        for(int i : input_array){
            //지금돌린거랑 이전에 돌린거 최대최소 찾아야함
//            System.out.println("i값: "+ i);
            //i가 인덱스가 아닌가? 3들어가면 어캐되지
            //     ,3+3  => 6
            //여기서 3은 근데 차란 말이야...? m만 만 넣으면 안되나?
            //이게 m을 넘으면
            if(LowerBound(input_array, i+m)<input_array.length){
                answer = min((input_array[LowerBound(input_array, i+m)] - i), answer);
            }

        }

        bw.write( answer+ "");
        bw.close();
        br.close();
    }

    //없는 수가 들어가면 그 수를 제외한 최솟값 출력
    //손으로 돌려보면 알 수 있음
    //lowerbound되는경우 upperbound되는경우 외우기

    public static int LowerBound(int[] d_array, int target){
        int min=0;
        int max = d_array.length;
        int mid;
        while(min<max){
            mid = (min+max)/2;
            // -10 -10 -10 있다고 하고 target과 mid 가 같다고 하면 max가 mid 값으로 계속 내려가서
            //min있는 자리가 max가 된다
            if(d_array[mid]>=target){
                max = mid;
            }else{
                min = mid+1;
            }
        }
//        System.out.println(min);
        return min;
    }

}
