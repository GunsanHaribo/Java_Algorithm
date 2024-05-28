package Programmers.구현미친듯이풀기.E_정렬.메뉴리뉴얼;

import java.util.*;

public class 메뉴리뉴얼 {
    static Map<String, Integer> save_result;
    static ArrayList<Integer> course_d;
    public static void main(String[] args) {
        //가능한 경우의 수 구하기 // HashMap으로 간다 => Hah 공부 필요
        // 야 그런데 cd랑 cde가 있으면 뭘.....선택해야되냐 cde 3번이면 cd도 3번인데....
        save_result = new HashMap<>(); // => static이 더 나을 수도

        String[] orders = new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};

        int[] course = new int[]{2,3,4};
        course_d = new ArrayList<>();

        for(int i : course){
            course_d.add(i);
        }

//        System.out.println(course_d);

        // char[]로 만들어서 넣어주자.. String 으로도 가능할 수도?
        for(String k : orders){
            String[] kk = k.split("");
            ArrayList<String> changeSet = new ArrayList<>(List.of(kk));
            makePossible("", changeSet);
            System.out.println();
        }

        // 이거 키로할지 아니면 딴걸로 할지 정해야된다. 그라고 만약 1 이면 그냥 없앴으면 좋겠는데


        Comparator<String> com = new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                // 만약에 1이면 없엔다
                // 근데 그게 여기 들어가도 되나?
                return save_result.get(o1) - save_result.get(o2);
            }

        };


        List<String> keySet = new ArrayList<>(save_result.keySet());
        keySet.sort(com);
        // 정렬 후에는 답에 넣어야 되는데.... 그리고 ACD 랑 DCA랑 같은 거여서 이거 관련 처리도 해줘야된다
        // 그니깐 내부적으로 sort해주는 것도 필요하다
        // => 이걸 어떻게 처리야해 하나

        System.out.println(keySet);
        for(String i : keySet){
            System.out.println("key:" + i + "  value:"+ save_result.get(i));
        }


        // 정렬 이후에는 value가 2이상인 것만 출력합니다
        // 아니면 value가 <2미만 인것은 다 버리고 출력하게 하던가
        ArrayList<String> key_final = new ArrayList<>();
        for(int i = 0; i< keySet.size(); i++){
            //0번쨰 key를 가져오는데 만약 2보다 작으면 자른다
            if(save_result.get(keySet.get(i)) >= 2){
                // 돌리고 있는데 지우는게 말이 안됨
                // 그럼 re
                key_final.add(keySet.get(i));
            }
        }

        // 이거 채처럼 걸르는거 있음 filter로 해도됨


        // all로 해서 다시 넣어줘야 될듯합니다
        System.out.println(key_final);  // 이거 badBDDDDDDDDad

        // 이게 DH가 2가 절 떄 나오면안되는데 이게 나와버리네   DG, HD 이것 때문에 그런듯
        for(String i : key_final){
            System.out.println("key:" + i + "  value:"+ save_result.get(i));
        }



    }

    // for이 더 경제적일수도??
    public static void makePossible(String combination, ArrayList<String> char_orders){
        if(char_orders.size() ==0){
            return;
        }
        // 여기서 조합시켜서 넘겨준다 // 이걸 밖으로 뺴면... 재귀를 돌떄 하나로


        for(int i = 0; i< char_orders.size(); i++){
            StringBuilder sb = new StringBuilder(combination);
            sb.append(char_orders.get(i));
            String par_String = sb.toString();
            // 그니깐 내부적으로 sort해주는 것도 필요하다

            // 내부적 sort // ACD, ADC 방지하기 위함
            par_String = par_String.chars()
                        .boxed()
                            .sorted((v1,v2) -> v1-v2)
                                    .collect(StringBuilder::new,
                                            StringBuilder::appendCodePoint,
                                            StringBuilder::append)
                                            .toString();

            // 이게 맞냐 재귀가 미친듯이 돌아가는데
            // 일단 가능한 경우의 수를 생성하는건 해줬어
            check_contain_add(par_String);

//            ArrayList<String> middelSet= new ArrayList<>(char_orders);
//            // 그냥 charorder를 빼버리면 안된다.. 어지러워짐
//            middelSet.remove(i);



//            ArrayList<String> make_new = new ArrayList<>(char_orders);
//            make_new.remove(i);

            char_orders.remove(i);

            //이거 한번 그려봐
            System.out.println("문쟈열"+par_String +"배열:" +char_orders);

//            makePossible("", make_new);

//            ArrayList<String> new_array = new ArrayList<>(char_orders);

            // 처음으로 돌아가서 다시 넣어주면 되야 되는거 아닌가
            // 아... 중복된걸... 어캐 없애지

            // 여기서
//            makePossible("", char_orders); // 여기서 charorders를 사용하면 도중에 한번 까인다는 말이야
            // 여기서 쪼개지는게 하나가 아닌데... charOrders는 어떻게 해야되지
            // 여기서 FG가 한번 더 들어가면 안되는데  // 이런 시발


            // 한 과정에서
            // Ac  ca가 같은 경우로 여겨서 카운트가 안돌아가게 해야한다... gkftn dlTsks....

            makePossible(par_String, char_orders);  // 쭉 올라가는건 이게 맞는 것 같은데
            // 여기서 한번 가능한 경우의 수를 만들어준다음에
            // for 문을 통해서  하나 박아 놓고 다시 세던가
            // 아니 그럴거면 시발 처음부터 그걸로 했지 시발아

            // 아... 형님... Set이 있지 않습니까....


        }
//        System.out.println(); // 아시 트레이스가 안되는데

    }


    public static void check_contain_add(String par_String){

        int string_length = par_String.length();

        if(course_d.contains(string_length)){
            // 만약 있으면 +1 하고 없으면 1만 넣어준다
            if(save_result.containsKey(par_String)){
                int count = save_result.get(par_String);
                save_result.put(par_String, count+1);
            }else{
                save_result.put(par_String, 1);
            }
        }

    }
}
