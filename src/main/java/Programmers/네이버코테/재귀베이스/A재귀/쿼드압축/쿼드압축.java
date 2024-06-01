package Programmers.네이버코테.재귀베이스.A재귀.쿼드압축;


import java.util.Arrays;

import static java.lang.Math.pow;


// 배열을 새로 만들어서 넣어준 이유가 뭐지?
// 이 흐름이 필요한 흐름인가??


public class 쿼드압축 {

    static int oneCount = 0;
    static int zeroCount = 0;


    public static void main(String[] args) {

//        int[][] ex_arr = new int[][]{{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        int[][] ex_arr = new int[][]{{1,1,1,1, 1,1,1,1}, {0,1,1,1, 1,1,1,1},
                {0,0,0,0, 1,1,1,1},
                {0,1,0,0, 1,1,1,1}, {0,0,0,0, 0,0,1,1},
                {0,0,0,0, 0,0,0,1},{0,0,0,0, 1,0,0,1},{0,0,0,0, 1,1,1,1}};


        int number =  0;
        int length = ex_arr.length;
        while(length/2 !=0){
            length = length/2;

            number++;
        }

        // => 3,, 8 //////////// 8888나누기 2는 4인데 Pow를 어떻게 하지?
        System.out.println(ex_arr.length+"는"+number);

        compress(number ,ex_arr);


        int[] arr = new int[]{zeroCount, oneCount};
        System.out.println(Arrays.toString(arr));

    }

    // 다음 것을 한다 => 재귀는 스택으로 쌓이니깐 당연히 다음껄로 되지  <= 중요
    // 야 이거 원리 부터 적고 다음에 코드 가야겠다

    public static void compress(int n, int[][] target){

        if(n == 0){
            // 종료조건에서 숫자를 세야한다
            if(target[0][0] == 0){
                zeroCount +=1;
            }else if(target[0][0] == 1){
                oneCount +=1;
            }
            return;
        }


        int total_XY = (int) pow(2,n);
        boolean check = true;
        int compare_number = target[0][0];

        // 이게 어떻게 해야 n=1일때 한글자가 나오는거지?

        // Y축
        for(int Y= 0 ; Y< total_XY; Y++){
            //X 축
            for(int X=0; X< total_XY; X++){
                // 어느 부분에서 target이 틀리지?
                if(compare_number != target[Y][X]){
                    check = false;
                    break;
                }
            }
            if(check == false){
                break;
            }
        }

        // 이것도 근데 안되는데...

        // 만약에 다 돌았으면  n=1로 해서 숫자 넣는다


        // 새로 넣어준다 근데 target이   01 23 의 조합이 있어야된다. 근데 이걸 어떻게 하지

        int[][] fixed_target;

        // 이거 반복 처리해야됨
        if(check == false){
            int next_num =(int) pow(2,n-1);
            fixed_target = new int[next_num][next_num];
            // 만약 1아니라면
            // 0~new_Y,  0~new_X
            for(int new_Y = 0; new_Y < next_num; new_Y++){
                for(int new_X = 0; new_X < next_num; new_X++){
                    fixed_target[new_Y][new_X] =  target[new_Y][new_X];
                }
            }
            compress(n-1, fixed_target);

            // 0~new_Y, new_X~total_XY .... 이걸 같이 진행을 해야되는데...
            for(int new_Y = 0; new_Y < next_num; new_Y++){
                for(int new_X = 0; new_X < next_num; new_X++){
                    fixed_target[new_Y][new_X] =  target[new_Y][new_X+next_num];
                }
            }
            compress(n-1, fixed_target);
            // new_Y~total_XY,  0~new_X
            for(int new_Y = 0; new_Y < next_num; new_Y++){
                for(int new_X = 0; new_X < next_num; new_X++){
                    fixed_target[new_Y][new_X] =  target[new_Y+next_num][new_X];
                }
            }
            compress(n-1, fixed_target);

            // new_Y~total_XY,  new_X~total_XY
            for(int new_Y = 0; new_Y < next_num; new_Y++){
                for(int new_X = 0; new_X < next_num; new_X++){
                    fixed_target[new_Y][new_X] =  target[new_Y+next_num][new_X+next_num];
                }
            }
            compress(n-1, fixed_target);
        } else if (check == true){
            fixed_target = new int[1][1];
            fixed_target[0][0] = compare_number;
            // 만약 길이가 하나일때?
            n=1;
            compress(n-1, fixed_target);
        }



    }


    // 너무 복잡함
    // 상태 : n -> n-1  => 상자 길이, 상자가 크기가 1일 떄 종료한다
    // 종료조건 : n = 0 일때 종료
    // 점화식 :   f(n)=f(n-1, target1)+ f(n-1, target2)+ f(n-1, target3)+ f(n-1, target4)
    // => 여기서 나눠서 넣어주기가 너무 어려워


    //
    // 상태 : 정사각형 범위, 왜 범위를?
    // 종료조건 :
    // 점화식 :
}
