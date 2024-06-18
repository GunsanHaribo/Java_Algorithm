package Programmers.네이버코테.J_구현.A백준.level1.분수찾기;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class 분수찾기_다른사람풀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());

        int A = 1;
        int B = 1;

        int index = 1; // 현재 위치한 인덱스

        int n = 2;
        int increase = 1; // n + 1 씩 올라감  // 이게 무슨 변수지?

        // 난 배열로 찾으려고 했는데 이녀석은 아니네

        // 분수 찾기
        if (X != 1) {
            // 번쨰까지 진행
            for (int i = 1; i <= X - 1; i++) {
                // increase i가 무슨 소리지?
                if (increase == i) {
                    // n + 1씩 올라가는 과정
                    // 이 동시에 사용
                    increase += n;
                    n++;


                    // 업데이트를 오른쪽으로 갈건지
                    // 업데이트를 아래쪽으로 할건지
                    if (index % 2 == 0) {
                        A++;
                    } else {
                        B++;
                    }
                    index++;
                } else {

                    // 대각선으로 업데이트
                    if (index % 2 == 0) {
                        A++;
                        B--;
                    } else {
                        A--;
                        B++;
                    }
                }


            }
        }

        System.out.print(A + "/" + B);
    }
}
