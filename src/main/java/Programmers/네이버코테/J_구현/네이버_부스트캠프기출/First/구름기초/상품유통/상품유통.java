package Programmers.네이버코테.J_구현.네이버_부스트캠프기출.First.구름기초.상품유통;


// 요구사항 : 모든 나라를 차례로 지난 후 남아있는 천연 자원의 양을 출력하는 프로그램을 작성하시오, 기약분수 꼴로 출력해야합니다
// 변수 :
// N -> 철수가 방문하게 될 나라의 수를 나타내는 10이상의 자연수
// R -> 철수가 가장 초기에 보유하고 이는 천연자원의 양을 나타낸다

// 문제 -> 기약 분수로 어떻게 나타내야되나?
// 분모가 분자로 나뉘는지 체크하는게 필요한듯 하다
// 첫번째 줄은 N, R
// 두번째줄은 N개의 반입세율

// 단위를 int로 가되
// R -> 갱신 필요
// 빼야되는 양 = R* (?/100)%  ->  1. 분모 맞추고 분수로 표현 2. 분모가 분자로 나뉘는지 체크
// R - 빼야되는양 -> 분모 맟추고 분수로 표현

// 흐름
// 1. 세금뺴고 남은 R을 계산하는 기능
    //1. 빼야되는 양 = R* (?/100)%  ->  1. 분모 맞추고 분수로 표현 -> 최소 공배수 구하기
    //2. result = R- 빼야되는양
    //3. 기약분수로 된 R 반환 -> 분모가 분자로 나뉘는지 체크 -> 최대 공약수 구하기


import java.util.*;

public class 상품유통 {
    public static void main(String[] args) {

//        int[] ss = new int[]{6,15};
//        int[] sss = new int[]{6,30};
//        System.out.println(Arrays.toString(find_max_divideone(ss)));
//        // 처음 R을 분수로 선언  -> 2인데.... 넘으면... 어쩌라는거야///
//
//        System.out.println(find_min_same_multiple(ss, sss)); // 성공

        // 144/ 3125
        // 0/1
        // 20007/ 200

        // 이 세가지 틀린다

        int N = 10;
        int R = 1024;

        int[] tax = new int[]{50, 50,50,50,50,50,50,50,100,50};

        int[] sonmom = new int[]{R,1};
        for(int i = 0; i<N; i++){
            int[] tax_rate = new int[]{tax[i], 100};
            sonmom = remain_R(sonmom, tax_rate);
        }


        System.out.println(Arrays.toString(sonmom));



    }

    public static int[] remain_R(int[] sonmom, int[] tax_rate){

        //tax_rate 기약분수인지 확인해서 들어갈꺼임
        tax_rate = find_max_divideone(tax_rate);
//        System.out.println(Arrays.toString(tax_rate));

//        System.out.println(Arrays.toString(sonmom));
        // 분수 맞춰서 빼기 -> 최소 공배수 구하기
        sonmom = calculate_matching_mom(sonmom, tax_rate);
//        System.out.println(Arrays.toString(sonmom));
//        System.out.println();

        // 기약분수인지 확인하기
        sonmom = find_max_divideone(sonmom);


        return sonmom;
    }

    public static int[] calculate_matching_mom(int[] sonmom, int[] tax_rate){

        // 분모가 0이면 중지
        if(sonmom[1] == 0) {
            return sonmom;
        }

//        else if(sonmom[0] ==0 ){
//            return sonmom;
//        }

        // 여기서 기본형은 이제 변경이 안되고 따로 유지된다
        // sonmom[0]이거는 힙에 있는 주소를 가지고와서 변경이 되는건가?

        // R*tax_rate구한다
        int R_son = sonmom[0];
        int R_mom = sonmom[1];

        int tax_rate_son = tax_rate[0];
        int tax_rate_mom = tax_rate[1];


        int[] R_multipletaxRate = new int[]{R_son*tax_rate_son, R_mom*tax_rate_mom};
        R_multipletaxRate = find_max_divideone(R_multipletaxRate);
//        System.out.println(Arrays.toString(R_multipletaxRate));
//        System.out.println(Arrays.toString(sonmom));
//        System.out.println();


        // 최소 공배수 기준으로 곱해준다
        // 여기서 틀렸다  그래서 0이 나오는 듯하다
        int same_multiple = find_min_same_multiple(sonmom, R_multipletaxRate);
//        System.out.println("분모:"+ same_multiple);

        int R_mom_multiple = same_multiple/sonmom[1];
        int tax_mom_mutiple = same_multiple/R_multipletaxRate[1];

//        System.out.println(R_mom_multiple);


        int  differ_R =  R_son*R_mom_multiple;
//        System.out.println(R_son*R_mom_multiple);
//        System.out.println(differ_R);
        int differ_T = R_multipletaxRate[0]*tax_mom_mutiple;


//        System.out.println(sonmom[0]*R_mom_multiple  - R_multipletaxRate[0]);
        long final_son =  (differ_R- differ_T);
//        System.out.println(final_son);
//        System.out.println(same_multiple);

//        System.out.println("마지막 분자:"+final_son);
        int final_mom = (same_multiple);
        int[] R_subtaxRate = new int[]{(int)final_son, final_mom};
//        System.out.println(Arrays.toString(R_subtaxRate));


        return R_subtaxRate; // 이게 tax 뺀거
    }



    public static int find_min_same_multiple(int[] sonmom, int[] R_multipletaxRate){

        int R_mom = sonmom[1];
        int R_mulitple = R_multipletaxRate[1];

        // 공약수 구하는 과정은 밑에 꺼랑 같을듯
        int min = Math.min(R_mom, R_mulitple);
        List<Integer> min_small = new ArrayList<>();
        for(int i=1; i<=min; i++){
            if(min%i ==0){
                min_small.add(i);
            }
        }
//        System.out.println(min_small);

        // 약수가 같은 숫자로 나뉠 수가 있어서
        // 만약에 이게 계속 5라면 5만 나오겠지 근데 아니잖아
        // 최소 공배수 구하는거 해야된다 -> 인간듣고
        List<Integer> same= new ArrayList<>();
        for(int i = 0; i<min_small.size(); i++){
            int check1 = R_mom%min_small.get(i);
            int check2 = R_mulitple%min_small.get(i);

            if(check1 ==0 && check2==0){
                same.add(min_small.get(i));
            }
        }

        // 최대 공약수 구해주는거 없나?  => null 체크도 해야되고
        int max_same = 1;
        if(!same.isEmpty()) {
            max_same = Collections.max(same);
        }



        int result  = (R_mom*R_mulitple)/max_same;

        return result;

    }


    // 최대 공약수 구해야된다
    public static int[] find_max_divideone(int[] sonmom){

        // 분모가 0이면 중지
        if(sonmom[1] == 0) {
            return sonmom;
        }
//        else if(sonmom[0] ==0 ){
//            return sonmom;
//        }

        int min = Math.min(sonmom[0], sonmom[1]);
        List<Integer> min_small = new ArrayList<>();
        for(int i=1; i<=min; i++){
            if(min%i ==0){
                min_small.add(i);
            }
        }

        List<Integer> same= new ArrayList<>();
        for(int i = 0; i<min_small.size(); i++){
            int check1 = sonmom[0]%min_small.get(i);
            int check2 = sonmom[1]%min_small.get(i);

            if(check1 ==0 && check2==0){
                same.add(min_small.get(i));
            }
        }

        // 최대 공약수 구해주는거 없나?  => null 체크도 해야되고
        int max_same = 0;
        if(!same.isEmpty()) {
            max_same = Collections.max(same);
            sonmom[0] = sonmom[0]/max_same;
            sonmom[1] = sonmom[1]/max_same;
        }


        return sonmom;
    }




}
