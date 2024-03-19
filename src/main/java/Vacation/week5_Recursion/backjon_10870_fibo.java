package Vacation.week5_Recursion;

public class backjon_10870_fibo {
    public static void main(String[] args) {
        System.out.println(fibonati(10));
    }



    //n=1일떄 f(0) = 0, f(1) = 1
    //n=k일때 f(k)=f(k-1)+f(k-2)라면
    // f(k+1)는 f(k+1) = f(k)+ f(k-1)이므로
    //f(k)는 k+k-1+k-2+....+1+0이다

    public static long fibonati(long Element){
        //base
        if(Element <= 1){
            return Element;
        }

        //함수기능
        return fibonati(Element-1)+ fibonati(Element-2);
    }
}
