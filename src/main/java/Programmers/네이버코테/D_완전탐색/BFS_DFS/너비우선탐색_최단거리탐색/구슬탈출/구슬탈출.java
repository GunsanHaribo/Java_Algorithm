package Programmers.네이버코테.D_완전탐색.BFS_DFS.너비우선탐색_최단거리탐색.구슬탈출;

// 요구사항 : 기울임의 최소한 몇번 만에 빨간 구슬을 구멍을 통해 빼낼 수 있는지?
// 10 번 초과로 움직이면 안한다

// 가장 바깥의 행과 열은 모두 막혀져 있고
// 빨간 구슬을 구멍을 통해 뺴내는 것
// 파란 구슬이 구멍에 들어가면 안된다

// 구슬은 손으로 건드릴 수는 없고 중력을 이용해서 이리저리 굴려야한다
// 상하좌우로 기울일 수 있음  -> 얼마나 움직이는데?
// 제한사항
// 1. 동시에 움직인다
// 2. 파란 구슬이 구멍에 빠지면 실패
// 3. 동시에 빠져도 실패
// 4. 같은 칸에 있을 수가 없다

// 변수 : (빨간 구슬 , 파란 구슬 위치 ), ////고정 (상하좌우 기울임 좌표, 구멍 위치)


// 최소를 어떻게 잡지? -> BFS 느낌
// 가능한 경우의 수를 모두 생각해야되나?
// 흐름
// 1. 일단 각각의 위치를 받는다
//  '. -> 빈칸',  '# -> 벽 또는 방해물',  'R -> 빨강', 'B-> 파랑', '0 -> 구멍'
// 2. 상하 좌우 이동이 좌표가 어떻게 변화하는지 적는다
// 3. 최소찾기 -> 구멍 좌표랑 r좌표랑 비교한다, 그리고 얼마나 움직여야 되는지 출력한다 -> 이거는 걸림
// 4. BFS를 통해서 찾아야되는데... BFS를 아직 잘 모릅니다.....

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 구슬탈출 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] row_coumme = br.readLine().split(" ");

        int row = Integer.parseInt(row_coumme[0]);
        int column = Integer.parseInt(row_coumme[1]);

       // 겹



    }


}
