package week5_Recursion;

import java.io.*;
import java.util.StringTokenizer;

public class backjoon_1992_쿼드트리 {
    // 일단 박스 크기를 결정하는 인수를 받는다
    // 그리고 한줄한줄 받은걸 배열에 넣는다
    static BufferedReader br;
    static int max_number;
    static int[][] box_arr;
    static BufferedWriter bw ;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        max_number = Integer.parseInt(br.readLine());
        box_arr = new int[max_number][max_number];
        String get_input;
        for(int i =0; i<max_number; i++){
            get_input = br.readLine();
            for(int j=0; j<get_input.length(); j++){
                box_arr[i][j] = Integer.parseInt(String.valueOf(get_input.charAt(j)));
            }
        }

        check_box(0,0,max_number);


        bw.close();

    }

    public static void check_box(int x, int y, int box_size) throws IOException {
        // 쓰읍 조진것 같은데 다 맞다고 처리하는 것 같은데
        //일단 적는거 완성
        //처음 시작할때 찍고
        //같은 크기의 box_size에서는 같은 괄호 안에 있도록
        //box사이즈를 비교해서 찍어야하나? 이게 계속 들어가게 만들어 놔가지고
        System.out.println("box_size"+box_size);

        if(box_size==1){
            bw.append(String.valueOf(box_arr[x][y]));
            return;
        }

        //검사 해야해 1 ,2,3,4 모두 검사 해야하는데
        //이걸 어캐 해야될까
        //검사 하는거랑 탐색하는 거 두개를 쪼갤까?
        //일단 해보자 근데 어캐 검사 할건데 x,y 받으면 box_size까지 검사
        int check_content = box_arr[x][y];
        boolean isValid = true;

        for(int i = x; i<x+box_size; i++){
            //여기서 들어가나 체크해보자
            System.out.println("1번쨰 for문 들어왔다");
            for(int j = y; j<y+box_size; j++){
                System.out.println("2번째 for문 들어왔다");

                if(check_content != box_arr[i][j]){
                    System.out.println("다른거 있는데");
                    //박스에 모든 걸 탐색한다고 하면
                    //어떻게 해야할까
                    //false인데 false가 안나오는 상황이 뭐지?
                    //8 ->4 false 작동잘함
                    isValid = false;
                    break;
                }
            }
            if(isValid ==false){
                break;
            }
        }


        if(isValid==true){
            System.out.println("동일 성공");
            bw.append(String.valueOf(check_content));
            return;
        }else{
            //처음 박스가 쪼개질떄 넣으면 되지 않나?
            //그리고 다 마치면 다시 닫아주고 좋은데...?
            //해당 당사자 더쪼개야됨
            bw.append("(");
            check_box(x,y,box_size/2);
            //2는 새로운 곳으로 넘어가는 부분
            //다음 장소로 넘어가는 것 까지는 아직 안함
            check_box(x,y+box_size/2,box_size/2);
            //3
            check_box(x+box_size/2,y,box_size/2);
            //4
            check_box(x+box_size/2,y+box_size/2,box_size/2);
            bw.append(")");
        }
        //괄호를 어디에다 찍어야하나

    }

}
