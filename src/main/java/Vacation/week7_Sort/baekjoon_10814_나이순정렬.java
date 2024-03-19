package Vacation.week7_Sort;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

//sort
//음수 왼쪽
//양수 오른쪽
public class baekjoon_10814_나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max_number = Integer.parseInt(br.readLine());
        ArrayList<Person> Array_Person= new ArrayList<Person>();

        StringTokenizer st;
        int input_age;
        String input_name;
        for(int i =0; i<max_number; i++){
             st = new StringTokenizer(br.readLine());
             input_age = Integer.parseInt(st.nextToken());
             input_name = st.nextToken();
            Array_Person.add(new Person(input_age,input_name));
        }

        Collections.sort(Array_Person, new Person_CompareNewRule());

        for(int i =0; i<Array_Person.size(); i++){
            System.out.println(Array_Person.get(i).toString());
        }

    }
}

class Person_CompareNewRule implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {

        return o1.age - o2.age ;
    }
}


class Person {
    int age;
    String name;

    Person(int age, String name){
        this.age = age;
        this.name = name;
    }
    public String toString(){
        return  this.age + " " + this.name ;
    }

}
