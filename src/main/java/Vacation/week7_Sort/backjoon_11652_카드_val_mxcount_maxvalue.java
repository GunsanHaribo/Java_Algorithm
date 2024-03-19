package Vacation.week7_Sort;

import java.io.*;
import java.sql.Array;
import java.util.Arrays;

public class backjoon_11652_카드_val_mxcount_maxvalue {

    static int count;
    //        int count=0;
    static long max_value;
    static int max_count=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max_number = Integer.parseInt(br.readLine());
        long[] long_array = new long[max_number+1];

        for(int i =0; i<max_number; i++){
            long_array[i] = Integer.parseInt(br.readLine());
        }

        long_array[max_number] = Long.MAX_VALUE;
        //마지막에 인트의 가장 큰 값을 추가해주므로써 max랑 count 값이 비교 될 수 있게 해준다
        Arrays.sort(long_array);

        for(int i = 0; i<long_array.length; i++){

            if(i==0) {
                count = 1;
                max_value = long_array[i];
            }
            //여기서 이전수하고 같으면 카운트하는거 해줘야함
            //다르다면 그리고 count 차이가 나면 else
            else if(long_array[i-1]==long_array[i]){
                count+=1;
            }else{
                //여기서 달라질떄
                //뭐여 이건
                //처음에 쌓였다가 다음에 다른 수가 나오면 이제 이 조건이 체크 되야한
                if(max_count<count){
                    max_count = count;
                    max_value=long_array[i-1];
                }
                count=1;
            }

        }

        bw.append(String.valueOf(max_value));
        bw.close();
    }

}
