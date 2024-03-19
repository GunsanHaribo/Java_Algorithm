package Vacation.week6_BackTracking;
import java.io.*;
import java.util.*;
public class backjoon_1182_부분수열_해답 {
    static int n, s, sum, numOfCases;
    static int[] numbers;
    static boolean[] isUsed;

    static void fun(int cur, int tot) {
        if (cur == n) {
            if(tot == s) numOfCases++;
            return;
        }
        fun(cur+1, tot);
        fun(cur+1, tot+numbers[cur]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        isUsed = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        fun(0, 0);

        if (s==0) numOfCases--;

        bw.write(String.valueOf(numOfCases));

        br.close();
        bw.flush();
        bw.close();
    }
}