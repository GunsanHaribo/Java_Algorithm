package Programmers.오토에버시험대비_구현.D_완전탐색.소수찾기;

//
//상태 : 구성 숫자, 현재 사용할 수 있는 숫자, 소수 카운트
//        종료조건 : 현재 사용할수 있는 숫자가 없을때 종료합니다
//        점화식 : 구성 숫자 : 이전 구성숫자 + 현재사용할수있는 숫자  => 만약 소수면 count++ 해준다

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class 소수찾기2_분석필요 {
    public static void main(String[] args) {

        String nums = "17";


        List<Integer> numbers = nums.chars()// 문자열을 intStream 변환
                .map(c->c -'0')
                .boxed() // Int를 integer로 변환
                .collect(Collectors.toList()); // Stream을 컬렉션으로

        System.out.println(getPrimes(0,numbers).size());
    }

    private static Set<Integer> getPrimes(int acc, List<Integer> numbers){
        if(numbers.isEmpty()){
            System.out.println(numbers);
            if(isPrime(acc)) return Set.of(acc);
            return Set.of();
        }

        // 원소를 모드 구해서
        Set<Integer> primes = new HashSet<>();
        if(isPrime(acc)) primes.add(acc);

        // 아근데 이게..
        // 중간에 0이들어가뭐 0-> 0 -> 0>0 ->1->01 ->2->01 이런 느낌인것 같은데
        for(int i = 0; i< numbers.size(); i++){
            int nextAcc = acc*10 + numbers.get(i);
            List<Integer> nextNumbers = new ArrayList<>(numbers);
            System.out.println(nextNumbers);
            nextNumbers.remove(i);
            primes.addAll(getPrimes(nextAcc, nextNumbers));  // addAll에서 어떻게 실행되는지?
        }

        return primes;
    }

    private static boolean isPrime(int n){
        if(n<=1) return false;
        for(int i =2; i*i <=n; i++){
            if(n%i ==0) return false;
        }
        return true;
    }

}
