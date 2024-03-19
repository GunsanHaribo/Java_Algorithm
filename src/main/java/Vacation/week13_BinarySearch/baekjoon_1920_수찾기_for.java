package Vacation.week13_BinarySearch;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_1920_수찾기_for {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int  max = Integer.parseInt(br.readLine());
        int[] ob_array = new int[max];

        StringTokenizer st = new StringTokenizer(br.readLine());;

        for(int j = 0; j<ob_array.length; j++){
            ob_array[j] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(ob_array);

//////////////////////////////////////////////////////////////
        int  max2 = Integer.parseInt(br.readLine());
        int[] ele_array = new int[max2];

        StringTokenizer st2 = new StringTokenizer(br.readLine());;

        for(int j = 0; j<ele_array.length; j++){
            ele_array[j] = Integer.parseInt(st2.nextToken());

        }


        for(int ele : ele_array){
            bw.append(binary(ob_array, ele)+"");
            bw.append("\n");
        }

        br.close();
        bw.close();
    }

    public static int binary(int[] ob_array, int ele){
        int min = 0;
        int max = ob_array.length-1;
        int mid ;

        while(max>=min){
            mid = (min+max)/2;
            if(ob_array[mid] == ele){
                return 1;
            } else if(ob_array[mid]<ele){
                min=mid+1;
            } else {
                max = mid-1;
            }
        }

        return 0;
    }
}
