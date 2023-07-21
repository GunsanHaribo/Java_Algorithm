package Week1_Array;
import java.util.*;
public class Number_Alpha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String GetValue = scanner.nextLine();

        int[] result = count_Alpha(GetValue);

        for(int i=0; i<result.length; i++){
            System.out.print(result[i]);
        }
    }
    public static int[] count_Alpha(String NewElement){
        //리스트 받아서 알파벳 개수 == 아스키코드 범위로 추정해서 반환
        int[] array = new int[26];
        for(int i =0; i<NewElement.length(); i++){
            char charValue =NewElement.charAt(i);
            if(97 <=charValue && charValue<=122){
                array[charValue-97] = 1;
            }
        }

        return array;
    }
}
