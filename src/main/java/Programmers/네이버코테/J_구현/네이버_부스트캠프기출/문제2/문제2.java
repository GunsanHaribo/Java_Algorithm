package Programmers.네이버코테.J_구현.네이버_부스트캠프기출.문제2;


// 요구사항 : 타입을 입력한 순서대로 8바이트 단위로 구분해서 return 해줘라
// 변수 : 지금 들어가고 남은자릿수, 남은데  7이면 short 넣으려면 나머지를 더해주고 그다음에 들어가야됨

// 조건 : 8바이트 보다 작은 타입들이 연속될 경우에는 사이에 패딩을 붙여야한다
// short는 2배수
// Float은 4배수가 되도록 메모리를 할당해야합니다.
// -> Bool다음에 short오면 점하나 더 들어감
// 대신 그 반대면 상관없음


// 흐름 : 애초에 엄청 복잡하거든.. 그래서 흐름을 잘짜야됨.. 연습해야됨..
// 1. 8개까지 배열을 주셈
// 2. 남은 자릿 수 확인하고 지금 들어갈꺼를 나눈 나머지를 더해준다
// 3. 더한 값이 8이면 해당 배열 결과 배열에 넣고 세로운 다음 배열로 넘어간다
// 4. 그렇게해서 그리고 메모리 최대크기 128바이트를 넘으면 halt를 출력한다

// 더한 값이 8을 넘어가면 어떻게 해야되나?
// 8을 넘긴다면? -> 8 초기화 해주고 배열 또는 StrToken초기화해주고 다시시작한다



import java.util.ArrayList;
import java.util.List;

public class 문제2 {
    public static void main(String[] args) {
//        String[] arr = new String[]{"INT", "SHORT", "FLOAT", "INT", "BOOL"};
//                String[] arr = new String[]{"INT", "INT", "BOOL", "SHORT", "LONG"};

//        String[] arr = new String[]{"BOOL","SHORT"};

        String[] arr = new String[]{"BOOL","LONG","SHORT", "LONG", "BOOL",
                "LONG", "BOOL", "LONG", "SHORT", "LONG", "LONG"};

        // 테스트 케이스
//        int byte_length = 8;
//
//        // 스트링하고 리스트는 살짝다른데.. 저게 한번에 들어갈 수도 없고
//        // 이걸 어떻게 해야하나 야 만약에 4가 한번에 들어왔으면 그래도 1개로 치는거야
//        StringBuilder bbb = new StringBuilder();
//        StringBuilder result = new StringBuilder();
//
//        bbb.append("###");
//        int left_size = byte_length- bbb.length();
//
//        fill_blank(left_size, bbb,16);
//        System.out.println("일단 합친거:"+bbb.toString());
//
//        System.out.println();
//        left_size = byte_length- bbb.length();
//        bbb = check_over8(left_size, bbb, result);
//        System.out.println("중간결과 버퍼:"+bbb.toString());
//        System.out.println("전체결과:"+result.toString());


        // 128 /8 -> 16  15개 반점   128+15 -> 143
        String answer = fill_left_make_new(arr);
        if(answer.length()>= 143){
            answer = "HALT";
        }

        System.out.println(answer);

    }

    // 처음 로직이 잘 짜여져야되는데 이러렇게 하려면
    public static String fill_left_make_new(String[] arr){

        int byte_length = 8;
        //이게 아마 전체 배열일거고
        StringBuilder result = new StringBuilder();

        StringBuilder Byte_storage = new StringBuilder();
        for(String s: arr) {
//            System.out.println(s);
            // 밑에 과정을 통해 추가된 바이트를 찾는다


// length바탕으로 배열 초기화, 16이 이걸왜 처음에 두면 안됬는지 분석해야된다
//            Byte_storage = check_over8(left_size, Byte_storage, result);


            int type_capacity = 0;
            switch (s) {
                case "BOOL" -> {
                    type_capacity = 1;
                }
                case "SHORT" -> {
                    type_capacity = 2;
                }
                case "FLOAT" -> {
                    type_capacity = 4;
                }
                case "INT" -> {
                    type_capacity = 8;
                }
                case "LONG" -> {
                    type_capacity = 16;
                }
            }


            // length바탕으로 배열 초기화, 16이 그
            int left_size = byte_length - Byte_storage.length();
//            System.out.println("타입:"+type_capacity+", 버퍼용량:"+Byte_storage.length());

            fill_blank(left_size, Byte_storage, type_capacity);
            Byte_storage = check_over8(left_size, Byte_storage, result);

        }
        // 마지막 byte를 소화를 못시키고 있는데....// #하나 있고 종료되면 어떻게 해야되나이거



//        System.out.println(Byte_storage);
        if(!Byte_storage.isEmpty()){
            int left_size = byte_length - Byte_storage.length();
            if(0<=left_size && left_size<8){
                String blank = ".".repeat(left_size);
                Byte_storage.append(blank);
            }
            left_size = byte_length - Byte_storage.length();
            Byte_storage = check_over8(left_size, Byte_storage, result);
        }


        return result.toString();

    }

    // 잘돌아감
    public static void fill_blank(int left_size, StringBuilder Byte_storage, int type_capacity){
        // 지금 나머지

        int quarter = left_size%type_capacity;
//        System.out.println(type_capacity+  "fill_blank:"+ quarter+"남은공간"+left_size);
        // 나머지를 채운다 : 이건왜 StringBuilder를 했지?
        // 여기서 그냥 리스트에 박아버려

        String number = "#".repeat(type_capacity);
        // 나머지가 있으면 넣는다
        if(quarter>0){
            // 아니 이걸 배열로 놓고 index 에러 나면 출력해야 됨

            String blank = ".".repeat(quarter);
            Byte_storage.append(blank);
        }
        Byte_storage.append(number);

    }


    // 여기서 스트링 빌더 사용
    // 이 흐름 좋은데 밥먹고 다시 잡고 들어가야한다
    public static StringBuilder check_over8(int left_size, StringBuilder Byte_storage, StringBuilder result){
        // 넣은게 8이 넘으면 배열 2개로 해서
        // 그런데 여기서 버퍼가 또 8이상이면 잘라서 넣어야된다
        StringBuilder exist_Byte_storage = new StringBuilder(Byte_storage.toString());
        while(left_size<=0){
//            System.out.println("들어옴");

            // 변수 하나 더 있어얃 될 것 같은데
            String over0_7= exist_Byte_storage.substring(8, exist_Byte_storage.length());
            String exist0_7 = exist_Byte_storage.substring(0, 8);


            // 0~7 결과를 넣어준다 그전에 반점 넣어준다 -> 구분하기 위해서
            if(!result.isEmpty()){
                result.append(",");
            }
            result.append(exist0_7);

            exist_Byte_storage = new StringBuilder(over0_7);
            // 이게 이게 기존의 8이상의 것들
            left_size = 8-exist_Byte_storage.length();
        }


        return exist_Byte_storage;
    }




}
