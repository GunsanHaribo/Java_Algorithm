package Vacation.week12_Greedy;


import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class baekjoon_1931_회의실배정 {
    //comparotor 이중 배영ㄹ 엌캐함
    //hashmap은 중복 없애 버려서 안되는데
    //회의실배정 - 클래스만들어서하지
    public static void main(String[] args) throws IOException {
        //가정..확신...??
        //종료시간 빠른거
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int max_number = Integer.parseInt(br.readLine());

        int[][] d_arry = new int[max_number][2];


        StringTokenizer st;
        for(int i = 0; i<max_number; i++){
            st = new StringTokenizer(br.readLine());
            d_arry[i][0] = Integer.parseInt(st.nextToken());
            d_arry[i][1] = Integer.parseInt(st.nextToken());
        }

        //비교
        //min찾고 save랑 비교해서 얖에숫자보다 큰지 비교??
        //sort??
        //크면 배열의 숫자에서
        //그리고 종료 숫자는 다시 저장

        //sort한번 갈기고

        Arrays.sort(d_arry, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1]- o2[1];
            }
        });

//        for(int i=0; i< d_arry.length; i++){
//            System.out.println(d_arry[i][1]);
//        }

        //종료시점이 짧은 것부터 가져온다// 처음부터 가져오기
        //그 종료지점 저장해야됨 새로운 시작점으로
        int save = 0;
        int count = 0;
        for(int i =0; i<max_number; i++){
            if(save<=d_arry[i][0]){
                save = d_arry[i][1];
                count +=1;
            }

        }
//        System.out.println();
        bw.append(count+"");
        bw.close();

    }


}

