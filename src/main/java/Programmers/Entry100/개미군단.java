package Programmers.Entry100;

public class 개미군단 {
    // 장군개미 = 5
    // 병정개미 =3
    // 일개미 = 1
    // 최소한의 병력
    public static void main(String[] args) {
        int hp = 999;

        int[] ant =new int[]{5, 3, 1};

        int count = 0;

        // 계속 나눈다 //5로 나눴을때 몫이 0이면 3으로 아니면 계산
        // x, y z를 바꿔 가면서 해야되는데....
        int index = 0;

        while(hp != 0){
            int q = hp%ant[index];
            int number = hp / ant[index]; //q로 해야된다
            //0이면 안나위는 거니깐 이렇게 해야 될 것 같긴한데
            if(number == 0){
                index += 1;
            }else{
                count +=number;
                hp = q;
            }

        }
        System.out.println(hp);
        System.out.println(count);
        //0이 나올 떄까지 계산 hp를 몫으로 남기고 y로 넘어간다

    }
}
