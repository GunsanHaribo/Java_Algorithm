package Vacation.week15_Hash;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HashFunction_Integer {
    static int m = 13;
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] d_array = {-1, 3, 5,-7, -7, 10};

        for(int i : d_array){
            System.out.println(hashfunction(i));
        }

    }

    private static int hashfunction(int value){

        return (m+ value%m)%m;
    }
}
