package Programmers.D_완전탐색.수식최대화;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 수식최대화2 {


    // 경우의 수
    private static final String[][] precedences = {
      "+-*".split(""),
      "+*-".split(""),
      "-+*".split(""),
      "-*+".split(""),
      "*+-".split(""),
      "*-+".split("")
    };

    // 계산 기능
    private static  long calculate(long lhs, long rhs, String op){
        return switch(op){
            case "+" -> lhs + rhs;
            case "-" -> lhs - rhs;
            case "*" -> lhs * rhs;
            default -> 0;
        };
    }

    private static long calculate(List<String> tokens, String[] precedence){
        for(String op: precedence){
            for(int i=0; i< tokens.size(); i++){
                if(tokens.get(i).equals(op)){
                    long lhs = Long.parseLong(tokens.get(i-1));
                    long rhs = Long.parseLong(tokens.get(i+1));
                    long result = calculate(lhs, rhs, op);
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.remove(i-1);
                    tokens.add(i-1, String.valueOf(result));
                    i-=2;
                }
            }
        }

        return Long.parseLong(tokens.get(0));
    }
    public static void main(String[] args) {
        String expression1 = "100-200*300-500+20";


        StringTokenizer tokenizer = new StringTokenizer(expression1, "+-*", true);
        List<String> tokens = new ArrayList<>();
        while(tokenizer.hasMoreTokens()){
            tokens.add(tokenizer.nextToken());
        }

        long max = 0;
        for(String[] precedence : precedences){
            long value = Math.abs(calculate(new ArrayList<>(tokens), precedence));
            if(value> max){
                max = value;
            }
        }

        System.out.println(max);
    }
}
