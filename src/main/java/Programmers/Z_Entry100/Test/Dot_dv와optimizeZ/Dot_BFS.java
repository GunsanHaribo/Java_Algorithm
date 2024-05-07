package Programmers.Z_Entry100.Test.Dot_dv와optimizeZ;

import java.io.*;
import java.util.*;

import static java.lang.Math.pow;

//Math.sqrt
//인접행렬
public class Dot_BFS {
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

        int count = 0;
        //BFS로 풀어보기 //queue
        Queue<Pair> queue = new LinkedList<>();
        //모든걸 순회하는데
        //여기서 모든게 k+n으로 가는건가?
        //가능한 상하좌우를 모두 큐에 넣어준다
        //여기서는 k*1을 큐에 넣어준다
        //그리고 들어갔을때 제곱이 d를 넘으면 따로 그 수를 저장하지 않고 빠져 나온다
        queue.add(new Pair(0,0));


        int[][] map = new int[100][100];
        //여기서 갔던 점들만 2,2 갔다 그러면 해당하는 점
        // 1로 바꾼다

        //상하좌우로 안해도 되고 상우만 해도 된다
        //0,1,2
        while(!queue.isEmpty()){
            Pair ele = queue.poll();
            int first = ele.x;
            int second = ele.y;
            long compare = (long) (pow(first,2) + pow(second, 2));

            //한번 갔던 길은 가면 안되는데
            //그러기 위해서는 갔던길을 그린 지도가 필요하다
            //이차원 배열로 합시다
            if(compare <= pow(d,2) && map[first][second] == 0){
//                System.out.println(ele);
                map[first][second] = 1;
                count +=1;
                //여기서 판단해서 넣을지 말지 결정하자
                //다믕 2개의 숫자들의 제곱합이 모두 넘지 않는다면  추가한다

                queue.add(new Pair(ele.x + k, ele.y));
                queue.add(new Pair(ele.x, ele.y+k));
            }
        }
        System.out.println(count);
    }
}
