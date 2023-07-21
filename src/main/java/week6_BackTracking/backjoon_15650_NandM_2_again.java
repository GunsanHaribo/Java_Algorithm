package week6_BackTracking;

import java.io.*;
// false를 어디에 놓는가가 더 중요한 것 같다
// false가 어디서 작용하는지 알아야
public class backjoon_15650_NandM_2_again {
    static int n,m;
    static BufferedReader br;
    static int[] arr=new int[10];
    static BufferedWriter bw;
    static boolean[] isUsed = new boolean[10];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw= new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        func2(0, 0);

        bw.close();

    }
    public static void func2(int k,int pre) throws IOException{
        if(k==m){
            for(int j =0; j<m; j++){
//                System.out.println("dfddf");
                bw.append(String.valueOf(arr[j])).append(" ");
            }
            bw.append('\n');
            return;
        }

        for(int i = 1; i<=n; i++){
            if(i<pre){continue;}

            if(!isUsed[i]){
                arr[k] = i;
                isUsed[i] = true;
                func2(k+1,i);
                isUsed[i] = false;
            }
        }
    }

}
