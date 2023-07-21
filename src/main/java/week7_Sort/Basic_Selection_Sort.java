package week7_Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Basic_Selection_Sort {
    public static void main(String[] args) {
        int[] array = {9,1,6,8,4,3,2,0};
        //최솟값을 찾아서 앞에 놓는다
        //그렇게 정렬되지 않은 부분 앞부분에 하나하나씩 쌓여감
        int min;
        int temp;
        for(int i=0; i<array.length; i++){
            min = array[i];
            for(int j=i; j<array.length; j++){


                if(min>array[j]){
                    System.out.println("index"+i+"change");
                    min=array[j];
                    //스왑시켜줘야지
                    temp = array[i]; // 처음에 바꿀꺼 저장
                    array[i] = min;  // 바꿈
                    array[j] = temp; // 바꾼거 원위치
                }
                System.out.println(Arrays.toString(array));
            }
        }
        System.out.println("최종");
        System.out.println(Arrays.toString(array));

    }
}
