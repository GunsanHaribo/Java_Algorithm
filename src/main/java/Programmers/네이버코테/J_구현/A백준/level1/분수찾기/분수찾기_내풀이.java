package Programmers.네이버코테.J_구현.A백준.level1.분수찾기;

// 요구사항 : X가 주어졌을때 x번째 분수를 구하는 프로그램 작성, 번호매기는건 는 지그재그로 들어갑니다
// 변수 :  좌표,  X(번째)

// 흐름
// 1. 배열을 지그재그로 카고 넘어가야됨
// 2. 지그재그를 구현하라

// 번쨰는 count를 해서 들어간다
// 넘어 갈꺠 숫자 변화를 어떻게 주어야 되는지 생가해야된다

// 구현은 흐름잡고 기능분리 흐름기능 이렇게 계속 세부적으로 들어가야됨

// 지그재그 흐름
// 1. (x, y) 순차적으로 올리는 기능
// 2. 증가했으면 큰거에서 작은 걸로 1씩 보내준다
// 3. 둘중하나가 1이면 -> (x,y) 선택 기능 다시 사용

// 구성하는 기능이 뭔지 잘 살펴야됨

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Math.abs;

public class 분수찾기_내풀이 {

    static int count = 1;
    static int target_number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X  = Integer.parseInt(br.readLine());
        target_number = X;

        int[] given = new int[]{1,1};
        ArrayList<Integer> c_given = new ArrayList<>();
        c_given.add(given[0]);
        c_given.add(given[1]);

//        go_middle(c_given);
        // 1,2일떄  3,1일떄 확인함
//        int choice = 1;
//
//        choice = change_upload(c_given, choice);
//        System.out.println(choice);  // 이건 0으로 바뀌어야되고
//        System.out.println(c_given); // 이놈은 1->2로 바뀐 채로 출력되어야한다


        zigzag(c_given);
        String answer = c_given.get(0)+"/"+c_given.get(1);
        System.out.println(answer);

    }

    // 지그재그
    public static void zigzag(List<Integer> target){

        // X, Y 올릴지 선택하는 기능
        // choice가  1이면 y방향으로 이동 0이면 x방향으로 이동-> 간단해서 그냥 zigzag
        int choice = 1;

        // target_number -> 이거 어떻게 해야되나?
        // 3 >2
        while(target_number > count){
            // 여기서도 입력시텨야하낟?
            // 작을때까지하고
            // 여기서 바꾸고
//            System.out.println(target);
            choice = change_upload(target, choice);
            // 도착하고 //넘었으면 리턴한다
            if(count ==target_number){
//                System.out.println("after_choice");
                // 여기로 들어왔으면 두번 리턴할수 있나?
                return ;
            }
            go_middle(target);
            if(count ==target_number){
//                System.out.println("after_go_midde");
                // 여기로 들어왔으면 두번 리턴할수 있나?
                return;
            }

        }

//        return target;
    }


    // X,Y 선택해서 올리는 기능
    public static int change_upload(List<Integer> target, int choice){
        // 카운트가 같으면 종료한다
        // 이 기능을 하면 count를 올린다, 올리고 한다

        int value =-10;
        if(choice ==1){
            value = target.get(choice);
            target.set(choice, value+1);
        }else{
            value = target.get(choice);
            target.set(choice, value+1);
        }
        // 실행시 count를 올린다
        count++;
//        System.out.println(target);

        if(count ==target_number){
//            System.out.println("chcoi_pup");
            // 여기로 들어왔으면 두번 리턴할수 있나?
            return 1-choice;
        }

        // 여기서 어떻게 해야되나?
        // 여기로 들어가야 되는데
        return 1-choice;
    }


    // 중간에 이동하는거 테스트 케이스 통과  1,2 -> 2,1로 통과함
    // 만들때 마다 테스트 케이스를 만들어서 동작하는지 판단해야된다
    // 일단 성공
    public static List<Integer> go_middle(List<Integer> target){
        // 둘 중 1보다 큰 수의 값을 찾고 -> index
        int index = 0;

        int other_indexs_value = target.get(1);
        if(other_indexs_value>1){
            index = 1;
        }

        // 인덱스를 기반으로 index가 1이 될때까지 해당 수를 인가해준다
        // 여기서 하다가 번째수에 맞는 숫자가 나오면 취소하고 return
        for(int v = target.get(index)-1; v >=1; v--) {
            // 큰거임 이동하니깐 -1해주면서 시작한다
            target.set(index, v);

            int real_other_index =1-index;
            int real_other_index_value = target.get(real_other_index);

            target.set(real_other_index, real_other_index_value+1);

//            System.out.println(target);
            count++;
            if(count ==target_number){
//                System.out.println("go_midde");
                return  target;
            }
        }

        // 이건 음... 1,1일떄 그냥 그대로 반환하는 느낌 이랄까?
        // 암튼 1.1 일때만 주의해야합니다

        // 근데 이거 만들고 테스트를 해야되나?
        // 그러면 테스트 케이스가 있어야 되는데?
        return target;
    }




}
