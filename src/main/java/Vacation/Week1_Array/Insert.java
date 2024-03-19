package Vacation.Week1_Array;

//리스트 새로만들어서 주소 바꿔줘야함
public class Insert {
    public static void main(String[] args) {
        // 특정 인덱스에 넣는다
        // 이후의 것들은 밀어
        //arraylist add 구현한다고 생각
        int[] list = {1,2,3,4};

        list = change_list(2,7,list);
        System.out.println(list.length);

        for(int i=0; i<list.length; i++){
            System.out.print(list[i]);
        }
    }
    public static int[] change_list(int index, int value, int[] list){
        //뒤에 인덱스 값 밀고  채우기
        //리스트 새로 만든다 *2
        //이전 인덱스는 그대로 add 하고
        //추가 한 다음
        System.out.println("함수진입");
        int[] new_list = new int[list.length+1];
        for(int i =0; i <index; i++){
            new_list[i] = list[i];
        }
        new_list[index] = value;
        for (int i = index; i < list.length; i++) {
            new_list[i + 1] = list[i];
        }
        return new_list;
    }
}
