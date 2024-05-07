package Programmers.Z_Entry100.Test.Dot_dv와optimizeZ;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Math.pow;

public class Dot_Greedy {
    // 중요한 건 (maxY,maxX)가 되는가
    // 결정 변수가 무엇인가?
    public static void main(String[] args) throws IOException {

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

        int max = k*qua; // ka <= d

        // k만큼 <= max
        int count = 0;
        for(int x = 0; x <=max; x+= k){
            int maxY = (int) Math.sqrt((pow(d,2) - pow(x,2)));
            //약수+1
            count += maxY/k +1;
        }

        System.out.println(count);
    }
}
