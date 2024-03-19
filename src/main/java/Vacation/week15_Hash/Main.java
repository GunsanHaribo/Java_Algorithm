package Vacation.week15_Hash;

public class Main {
    public static void main(String[] args) {
        Hash_M<Integer, String> test1 = new Hash_M<>();
        test1.put(1,"황");
        test1.put(2,"지");
        test1.put(3,"환");
        System.out.println("키1:"+test1.get(1));
        System.out.println("키1제거:"+test1.remove(1));// remove가 동작을 안함
        System.out.println("키1:"+test1.get(1));
        System.out.println("키2:"+test1.get(2));
        System.out.println("키3:"+test1.get(3));


    }
}
