package Vacation.week15_Hash;

public class HashFunction_String {
    static int table_size = 23;
    public static void main(String[] args) {

        String input = "나나나나나난나";
        System.out.println(HashFunction(input));

    }
    private static int HashFunction(String value){
        var h =0;
        for(char i: value.toCharArray()){
            //안더해도 이전꺼 영향 받으니깐
            h = (h*1_000 + (int) i) % table_size;
        }
        return h;
    }
}
