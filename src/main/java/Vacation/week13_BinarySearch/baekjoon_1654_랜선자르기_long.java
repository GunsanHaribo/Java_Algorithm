package Vacation.week13_BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_1654_랜선자르기_long {
//    4 4
//            802
//            743
//            457
//            539
//  여기서 에러 나온다

//2 3
//        3
//        2

//    1 1
//            2147483647


    //이진 탐색 어떻게 수정할지는
    // 예시를 적어보고 min max min while 조건 세워봐야아나?
    // 이거 계속 진행 될때 까지 어캐하누
    // 랜선 길이가 x 일때 11개 만들수 있어? 몇개까지 만들 수 있어?
    static int need_number;
    static int[] ropes;

    public static void main(String[] args) throws IOException {

        //하나 차이 나는 걸로 생각
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int max_input = Integer.parseInt(st.nextToken());
        need_number = Integer.parseInt(st.nextToken());
        ropes = new int[max_input];

        for (int i = 0; i < max_input; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes);

        int max_rope = ropes[ropes.length - 1];

        //mid값으로 수를 나눴을때 몫의 합이 11개 이면 가능?
        //이걸 하나하나옮겨줘야 되는게 문제긴한데 일단 max 값으로 802를 보존해야됨 딱 1개 나올 수 있게
        //일단 max 값을 기준으로 모든 원소들 나눠주다가
        //숫자가 작으면 기준길이가 너무 크다는거니깐 max = mid-1
        //숫자가 크면 기준길이가 너무 짧다는거니깐 min = mid +1

        //인자를 계속 넣어 줘야 되는데 parmatric search에
        //199가 나오는 이유가 뭘까??
        //어캐 돌아가는지 뜯어봐야 될 것 같은데

        bw.append(ParmatricSearch(max_rope) + "");
        bw.close();

    }

    static long count_rope_number(long length) {

        long sum = 0;
        for (long i : ropes) {
            sum += i / length;
        }

        if (sum == need_number) {
            return 0;
        } else if (sum > need_number) {
            //sum이크면 더 작게 잘린것
            return -1;
        }
        //더 크게 잘린것 더 작게 잘라야함
        return 1;
    }

    //여기서 틀린 것 같은데..뭘 해야 성공하지
    //n개보다 많이 만드는것도 n개로 생각한다 그러면 최대값맞는데
    static long ParmatricSearch(long max_rope_length) {
        long min = 1;
        long max = max_rope_length+1;
        long save=0;

        while (min < max) {
            long mid = (min + max) / 2;
            long check = count_rope_number(mid);
            //여기서 바로 리턴하면 안되고
            //최대값을 찾고 리턴해줘야 된다
            //어캐하누... 만약 최대 값이면 리턴한다..이게 되야되는데
            //그러면 해당하는 값이 있어도 max로 계속 가야함 상한 값으로
            //같은 값중에서 상한 값으로가는 법 upperbound를 찾자
            //리턴이 안되서 종료 불가 해당하는 값에 들어오면 그냥 계속 머무르는 듯 => x
            //mid가 752에서 바뀌지가 않아서 진행불가 그러면 어캐 해줘야 되나 802에서 어디에서 stop해줘야 되지
            //2 를 예시로 들어보자
            if (check <= 0) {
                min = mid + 1;
                save = mid;
            } else {
                max = mid;
            }
        }
        return save;
    }
}