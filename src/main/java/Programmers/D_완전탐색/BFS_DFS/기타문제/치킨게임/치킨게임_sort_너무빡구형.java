package Programmers.D_완전탐색.BFS_DFS.기타문제.치킨게임;

// 요구사항 모든 거리의 치킨 거리의 합
// x1, y1  -> x2, y2  => |x1- x2| + |y1 - y2|
// 가장 수익을 많이 낼 수 있는 치킨집

// 도시의 치킨거리 : 모든 치킨 거리의 합
// 독립변수 : 집마다 치킨거리의 최솟값
// 그 치킨집의 좌표 - 선택 받았으면 count 한다 : 이거는 아마 이중 배열로 저장할듯

// 흐름
// 배열을 순회 하다가 집이면 거기를 기준으로 최단거리를 가지는 2를 찾는다
// 배열 순회, 집하고 치킨집하고 좌표 뽑아놓는다
// 1로 돌리면서 최솟값이랑 해당 치킨집 적어 놓는다

// 최소가 가장 많이 찍히는 치킨집 좌표부터 살리고.. 나머지는 버린다 => 리스팅
// 그리고 다시 치킨 거리를 구한다

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Math.abs;

public class 치킨게임_sort_너무빡구형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] first = br.readLine().split(" ");
        int row_number= Integer.parseInt(first[0]);
        int survive_number= Integer.parseInt(first[1]);


        ArrayList<Save> one = new ArrayList<>();
        ArrayList<Save> two = new ArrayList<>();


        // 받으면 그대로 넣어준다
        int[][] location = new int[row_number][row_number];
        for(int i=0; i< row_number; i++){
            String[] row = br.readLine().split(" ");
            for(int j = 0; j< row.length; j++){

                // 만약에 1과 2면 좌표를 따로 저장한다
                if(row[j].equals("1")){
                    one.add(new Save(i,j));
                }else if (row[j].equals("2")){
                    two.add(new Save(i,j));
                }
                location[i][j] = Integer.parseInt(row[j]);
            }
        }


        // 인자 제대로 받음
        for(int[] j : location){
            System.out.println(Arrays.toString(j));
        }

        // 2를 통해서 1까지의 거리의 최솟값을 저장 많이
        int[][] record = new int[location.length][location.length];

        // 여기서 최대값을 뽑아야된다
        // sort해서 survive 등수를 만든다
        // 2를 통해서 최솟값이 나오는 좌표를 반환한다
        Set<Save> ss = new HashSet<>();
        for(Save t : two){
            int min = Integer.MAX_VALUE;
            Save find_min = new Save();
            for(Save o: one){
                // 여기서 최솟값을 만든다
                int cal = abs(t.x- o.x) + abs(t.y-o.y);
                if(cal<min){
                    min = cal;
                    // 좌표 저장하고
                    find_min.setMin_distance(cal);
                    find_min.setX(o.x);
                    find_min.setY(o.y);
                }
            }

            // 최종 최솟값, 좌표를 을 가져온다
            record[find_min.y][find_min.x] +=1;
            ss.add(find_min);
        }


        // 개같네
        // 구현
        // record 정렬 때린다
        // 근여 여기서 sort하면 x,y 섞일 텐데
        // max 순으로 5개만 뽑는다

//        Arrays.sort();




    }
    public static class Save{
        int x;
        int y;

        int min_distance;

        public Save() {

        }
        public Save(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setMin_distance(int min_distance) {
            this.min_distance = min_distance;
        }
    }

    // 집과 가까운 치킨집 까지의 거리
}

