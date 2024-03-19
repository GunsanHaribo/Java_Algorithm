package Vacation.week7_Sort;

import java.util.Arrays;

public class Basic_Insertion_Sort {
    //두번쨰부터 앞에꺼랑 그 사이꺼랑 비교하면서 넣는다
    public static void main(String[] args) {
        int[] array = {11, 12, 31, 25, 12, 22, 11};

        // 두번째꺼 부터 앞에꺼랑 이제 비교하면서 어디에 들어갈지 찾는다?
        // 앞에꺼보다 크고 뒤에꺼보다 작다 그러면 그 사이에 삽입 인덱스는 뒤로 미룬다
        int temp;
        for(int i =0; i< array.length; i++){
            //숫자 하나를 잡고 비교해서 넣는다..?
            for(int j =0; j<i; j++){
                //여기서 대소비교
                //작다면 앞으로가고 크면 뒤로가는데
                //가장 작은 부분과 크지 않은 부분이 있을텐데
                //아님그냥 맨뒤로 들어가서 계속 swap 해줘도 된다\
                if(array[j]>array[i]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        System.out.println("최종");
        System.out.println(Arrays.toString(array));

    }
}
