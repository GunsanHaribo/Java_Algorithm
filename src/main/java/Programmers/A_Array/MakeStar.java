package Programmers.A_Array;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeStar {


    public static void main(String[] args) {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // 배열에 배열 넣어서 만든다
        int[][] lines = new int[5][5];

        lines[0] = new int[]{2, -1, 4};
        lines[1] = new int[]{-2, -1, 4};
        lines[2] = new int[]{0, -1, 1};
        lines[3] = new int[]{5, -8, -12};
        lines[4] = new int[]{5, 8, 12};

//        lines[0] = new int[]{0, 1, -1};
//        lines[1] = new int[]{1, 0, -1};
//        lines[2] = new int[]{1, 0, 1};

//        lines[0] = new int[]{1, -1, 0};
//        lines[1] = new int[]{2, 1, 0};



//        System.out.println(lines.length);
        List<int[]> answer = new ArrayList<>();
        for(int i = 0; i< lines.length; i++){
            for(int j = i+1; j< lines.length; j++){

                if(calculate_dot(lines[i], lines[j]) != null){
                    answer.add(calculate_dot(lines[i], lines[j]));
                }

            }
        }


        for(int[] m : answer){
            System.out.println("처음 : "+m[0]+ ", 다음 :"+m[1]);
        }

        // 최대 값 식별, String 배열로 좌표 만들고 거기에 해당하는 값만 또는
        // 이 값들에 특정 값을 더해서 좌표 형태로 몇개 만들어준다
        //좌표 형태로 안바뀌는데...? 좀더 고민 해봐야 할듯//좌표를 어떻게 문자열로 할까


        //최대 최솟값 구해서 2차원 배열 만든다








    }



    public static int[] calculate_dot(int[] first, int[] second){

        if(first.length != 3  || second.length != 3){
            throw new RuntimeException();
        }

        int x = 0;
        int y = 0;

        try{
            float x1 = (float) (first[1] * second[2] - first[2] * second[1]) /(first[0]*second[1] - first[1]*second[0]);
            float y1 = (float) (first[2] * second[0] - first[0] * second[2]) /(first[0]*second[1] - first[1]*second[0]);


            // 만약에 x,y가 정수 값이 아니면 담지 않는
            //분모 값이 0이거나 그래서 나눈 값이 float 일떄
            if((x1 == (int) x1) && (y1 == (int) y1) ){
                x = (int) x1;
                y= (int) y1;
            }else{
                return null;
            }


        }catch (Exception e){
            System.out.println(e+"다시해");
            return null;
        }

        return new int[]{x,y};
    }

}

