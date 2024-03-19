package Vacation.week14_TwoPointer;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


//10 10
//        1 1 1 1 1 1 1 1 1 1

//10 9
//        1 1 1 1 1 1 1 1 1 1 8

//불가능할떄 0처리
//10 100
//        1 1 1 1 1 1 1 1 1 1

public class baekjoon_1806_부분합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int array_capacity = Integer.parseInt(st.nextToken());
        int object_number = Integer.parseInt(st.nextToken());

        int[] d_array = new int[array_capacity];
        StringTokenizer st2  = new StringTokenizer(br.readLine());
        for(int i = 0; i<array_capacity; i++){
            d_array[i] = Integer.parseInt(st2.nextToken());
        }

//        Arrays.sort(d_array);  // 수열 순서 바꾸면 안됨

        int start=0 , end = 0;
        int sum = 0;
        int answer = Integer.MAX_VALUE;
        //end< a+1해주면 필요없는 계산이 너무많다
        //end가 10 일때 [9]를 더한다고 임마 => 뭔 개소리야
        while(end<array_capacity+1 && start<array_capacity){
            //start는 9까지가야해 왜냐면 그냥 8일때도 생각해줘야 하니깐 2를 뺴줄 일이 있는거지
            //근데 여기서 작으니깐 ++end를 해버리면 없거든 이제 더할게 그럼이제 밑으로 내려간다고하면
            //살짝 문제가 있는거 같기도하고 end를 9까지만 받아버리면 이제 end나 start에 변화가 없어서 무한 루프 빠질 것 같은데

            //그니깐 지금 해야될 건 end를 고정시키고 start만 움직여서 끝낼 방법이 필요한거
            //그리고 sum이 작아도 start를 움직여야됨 => 전체를 한번 다 훑기위함..? sum이 미달이면 뺴줄게 없으니깐 stop해도 되는데
            //그니깐 end가 9인데 sum이 미달이면 start 더이상 빼줄 필요 없다고 멈춰도됨
            //그니깐 2, 8 상황에서 멈춰도됨 sum이 10 이니깐 그 뒤 계산은 필요가 없다 => end 10일떄 else들어갈 필요없이 종료 시키면된다


            //10인데 지금 같이 못 들어가는 경우
            if(sum>=object_number){
                answer = Math.min(answer,end-start);
                sum-=d_array[start++];
            }else{
                if(end==array_capacity){

                    //끝까지 도달 했을 떄 목표값에 도달할 수 없는 값일때
                    //모두다 더해도 sum이 작을때 저기서 start가 0일 경우만
                    if(start ==0){
                        answer=0;
                        break;
                    }
                    //끝까지 도달 했는데 값이 작을떄 start로 마무리처리
                    sum-=d_array[start++];

                }else{
                    sum+=d_array[end++];
                }
                //9인데 지금 10 15보다 작아서 들어올 수 밖에 없는데
                //사실 들어올 필요가 없는거지 그래서....그냥 end ++ 하자...
                //end++은 10이 9번쨰를 나타냄
            }
        }

        bw.append(answer+"");
        bw.close();

    }
}
