package Week1_Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i<4; i++){
            System.out.println("for문 진입");
            Scanner scanner = new Scanner(System.in);
            int GetInt = scanner.nextInt();
            list.add(GetInt);
            System.out.println("list에 넣음");
        }

        System.out.println("출력");
        System.out.println(isSumOver100(list));
    }
    public static boolean isSumOver100(ArrayList<Integer> list) {
//        ArrayList<Integer> compare_list = new ArrayList<Integer>();
        int[] compare_list = new int[101];  //0~99까지 그러면 0부터 100 까지
        System.out.println("gk");
        for (int i = 0; i < list.size(); i++) {
//            sum += Integer.parseInt(list.get(i));
            int compare = (100 - list.get(i));  // 실제 얻은 수에서 1 뺴줘야함 그러면 0이 날라가는데
            if(compare_list[compare] ==1){
                System.out.println("인덱스"+ list.get(i));
                return true;
            }else{
                compare_list[list.get(i)]=1;
            }
        }
        return false;
        //list에 i를 숫자에 해당하는 인덱스에 넣어수고 0~100이라고 할떄
        //해당 숫자가 있는지 체크를 해서 10 -ㅑ 가 있으면 true 반환

    }
}