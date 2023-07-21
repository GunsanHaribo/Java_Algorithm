package week6_BackTracking;

import java.io.*;

public class backjoon_15649_NandM {
    static int n, m;
    static BufferedReader br;
    static int[] arr=new int[10];
    static BufferedWriter bw;
    static boolean[] isUsed = new boolean[10];
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw= new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        func(0);

        bw.close();
    }

    public static void func(int k) throws IOException {
        if(k==m){
//            System.out.println("bc들어옴");
            for(int i =0; i<m; i++){
//                System.out.println("dfddf");
                bw.append(String.valueOf(arr[i])).append(" ");
            }
            bw.append('\n');
            return;
        }

        for(int i = 1; i<=n; i++){
//            System.out.println("errererer");
            if(!isUsed[i]){
//                System.out.println("rrerererere");
                arr[k] = i;
                isUsed[i] = true;
                System.out.println(arr[k]);
                func(k+1);
                isUsed[i] = false;//이부분은 어떻게 기능 할 수 있는가
                if(!isUsed[i]){
                    System.out.print(i+"기능");
                }
            }
        }

    }


}
