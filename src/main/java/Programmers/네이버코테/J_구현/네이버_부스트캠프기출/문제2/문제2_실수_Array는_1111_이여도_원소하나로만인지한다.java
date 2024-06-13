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

public class 문제2_실수_Array는_1111_이여도_원소하나로만인지한다 {
    public static void main(String[] args) {
        String[] arr = new String[]{"INT", "INT", "BOOL", "SHORT", "LONG"};

        int byte_length = 8;
        List<String> n = new ArrayList<>();
        n.add("###");
        System.out.println(byte_length);
        System.out.println(n.size());

        // 스트링하고 리스트는 살짝다른데.. 저게 한번에 들어갈 수도 없고
        // 이걸 어떻게 해야하나 야 만약에 4가 한번에 들어왔으면 그래도 1개로 치는거야
        StringBuilder sb = new StringBuilder();
        sb.append("###");
        System.out.println(sb.length());

        int left_size = byte_length- n.size();
        System.out.println(left_size);
        fill_blank(left_size, n,4);
        System.out.println(n);

    }

    public static void fill_left_make_new(String[] arr){

        int byte_length = 8;
        //이게 아마 전체 배열일거고
        List<String> result = new ArrayList<>();

        for(String s: arr){
            // 여기서 안채워진 length길를 알 수가 있나?
            List<String> Byte_storage = new ArrayList<>(); // 이게 계속 채워지는 배열이고
            // 스트링 빌더가 맏다

            int left_size = byte_length- Byte_storage.size();


            switch(s){
                case "BOOL" ->{
                    int type_capacity = 1;


                }

                case "SHORT" -> {
                    int type_capacity = 2;

                }

                case "FLOAT" ->{
                    int type_capacity = 4;

                }
                case "INT" ->{
                    int type_capacity = 8;


                }
                case "LONG" ->{
                    int type_capacity = 16;

                }
                default -> {

                }


            }
        }

    }

    public static void fill_blank(int left_size, List<String> Byte_storage, int type_capacity){

        // 지금 나머지
        int quarter = left_size%type_capacity;

        // 나머지를 채운다 : 이건왜 StringBuilder를 했지?
        // 여기서 그냥 리스트에 박아버려

        String number = "#".repeat(type_capacity);
        if(quarter>0){
            // 아니 이걸 배열로 놓고 index 에러 나면 출력해야 됨

            String blank = ".".repeat(quarter);

            Byte_storage.add(blank);
        }
        Byte_storage.add(number);

    }



    public static List<String> check(int left_size, List<String> Byte_storage){
        // 근데 이게 넣고 나서보니 8의용량이 충분히 초과될 수 있거든?
        // 그러면 0~7까지
        //   8부터 ~~까지 해서 분리시켜서 리스트에 넣어야된다
        List<String> New_Byte_storage = new ArrayList<>();
        if(left_size <=0) {
            for(int i=7; i<Byte_storage.size(); i++){
                New_Byte_storage.add(Byte_storage.get(i));
            }
        }

        return New_Byte_storage;
    }




}
