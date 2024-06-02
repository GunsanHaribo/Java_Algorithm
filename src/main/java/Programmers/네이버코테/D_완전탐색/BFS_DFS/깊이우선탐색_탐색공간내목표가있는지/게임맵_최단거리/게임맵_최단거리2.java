package Programmers.네이버코테.D_완전탐색.BFS_DFS.깊이우선탐색_탐색공간내목표가있는지.게임맵_최단거리;


import java.util.LinkedList;
import java.util.Queue;

public class 게임맵_최단거리2 {
    // visit node or entire
    public static void main(String[] args) {

        Queue<Player> que = new LinkedList<>();
        int[][] map = new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

//        int[][] map = new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};

        // 상 하 좌우
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};
        boolean[][] visit  = new boolean[map.length][map[0].length]; // 수정

        // map은 mapvisit은 visit
        // 방해물 visit으로 표시
        // y, x로 한다
        // 만약 0 인 부분이 있으면 true로한다
//        for(int m_y = 0; m_y< map.length; m_y++){
//            for(int m_x = 0; m_x< map.length; m_x++){
//                if(map[m_y][m_x] ==0){
//                    visit[m_y][m_x] = true;
//                }
//            }
//        }
//        for(boolean[] o : visit){
//            System.out.println(Arrays.toString(o));
//        }// 여기까지는 잘됬다

        // 시작
        que.add(new Player(1,0, 0));


//        ArrayList<Integer> answers = new ArrayList<>();
        int answer = 0;
        // 상하좌우 무빙
        int flag = 0;
        while(!que.isEmpty()){
            Player pop_player = que.poll();

            for(int i = 0; i< dx.length; i++){
                // 뽑아줘야 되긴하는데

                // 도착했으면 끝낸다
                // 도착했어도 안끝날 수도?
                // 이게 여기 들어가면안되나
                if(pop_player.x == map.length-1 && pop_player.y == map.length-1){
                    answer = pop_player.distance_record;
//                    answers.add(pop_player.distance_record);
                    flag =1;
                    break;
                }
                // 도착할 수 없으면 -1

                // 방문했는지 체크 근데 이건 올려주고 해야되는데
                // 제한 사항 있는지 체크 -> 좌표를 통해서
                int next_x = pop_player.x+ dx[i];
                int next_y = pop_player.y+ dy[i];
                int next_record = pop_player.distance_record+1;

                // 좌표
                if(next_x < 0 || next_y<0 ||  next_y>= map.length || next_x>= map[next_y].length ){
                    continue;   // 방문했으면 continue
                }

                // visit에 추가안하고 map으로 처리
                if(map[next_y][next_x] !=1){
                    continue;
                }
                // 조건분리
                if(visit[next_y][next_x]){
                    continue;   // 방문했으면 continue
                }



                visit[next_y][next_x] = true;  // 방문을 ㅁ너저 처리
                que.add(new Player(next_record,next_x,next_y));



            }
        }


        // 도달 못할 조건
        // 큐가 비었고
        // 종료 조건이 아니라면 -1
        if(flag ==0){
            answer =-1;
        }


        System.out.println(answer);


    }

    //
    public static class Player{
        // 거리기록
        int distance_record;
        //현재위치
        int x;
        int y;

        public Player(int record, int x, int y) {
            this.distance_record = record;
            this.x = x;
            this.y = y;
        }
    }

}
