package Programmers.Z_Entry100.Test.Dot_dv와optimizeZ;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.pow;


// 수 범위도 봐야 합니다
//long 으로 하면 된다


//class Solution {
//
//    public int solution(int k, int d) {
//
//        // List<Pair> solution = new ArrayList<Pair>();
//
//        long qua = d/k;
//        int count = 0;
//        // 절반만 돌려도 되지 않나?
//        // 그건 아닌 듯 한데 어떻게 해야하나?
//        for(int i = 0; i<=qua ; i++){
//            for(int j = 0; j<=qua; j++){
//
//                long first = (k*i) ;
//                long second = (k*j);
//                long compare = (long) (pow(first,2) + pow(second,2));
//                if(compare <= pow(d,2)){
////                    System.out.println(compare);
//                    // solution.add(new Pair(k*i,k*j));
//                    count++;
//                }
//
//
//            }
//        }
//
//        int answer = count;
//        return answer;
//
//    }
//
//
//}
//
//




public class Dot {

    public static void main(String[] args) throws IOException {

        List<Pair> solution = new ArrayList<Pair>();
        //
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        //k하고 d가 들어오는데
        //d를 k로 나눠서 나오는 몫을 k를 곱해서 이중 for문으로 n*n해준다
        //하지만 x,y 해서 d를 넘는수 그니깐 원 밖에 있는 수는 제외한다

        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, ",");

        int k = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());



        int qua = d/k;

        // 절반만 돌려도 되지 않나?
        // 그건 아닌 듯 한데 어떻게 해야하나?
        for(int i = 0; i<=qua ; i++){
            for(int j = 0; j<=qua; j++){

                int first = (k*i) ;
                int second = (k*j);
                int compare = (int) (pow(first,2) + pow(second,2));
                if(compare <= pow(d,2)){
//                    System.out.println(compare);
                    solution.add(new Pair(k*i,k*j));
                }
            }
        }


        System.out.println(solution);
        bw.write(Pair.count+"");
        bw.flush();

    }





}

class Pair {
    static int count = 0;
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
        count++;
    }

    //toString override
    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
