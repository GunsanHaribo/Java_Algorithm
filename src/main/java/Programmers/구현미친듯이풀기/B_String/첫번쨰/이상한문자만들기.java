package Programmers.구현미친듯이풀기.B_String.첫번쨰;

public class 이상한문자만들기 {

    // 마지막에 공백있으면 반영을 못하네

    public static void main(String[] args) {
        String input = "try hello world   ";

        //공백 리스트 만들기
        String[] array= input.split(" ",-1);
        // 공백이 2개이여도 짤려야 된다


        // 스트링 빌더
        StringBuilder sb = new StringBuilder();
        // 하나잡고 length for문 해서 홀수, 짝수 구분
        // for문 한번 끝나면 " "넣어준다
        for(int s =0; s< array.length ; s++){
            for(int i = 0 ; i< array[s].length(); i++){
                int check = ((i) % 2);
                String target = array[s].charAt(i)+"";

                //짝수면 소문자
                if(check ==0){
                    target = target.toUpperCase();
                }else{
                    target = target.toLowerCase();
                }
                sb.append(target);
            }
            // 마지막이 아니면
            if(s< array.length-1) {
                sb.append(" ");
            }
            // 마지막꺼 처리해야된다
        }
        // 초
        System.out.println(sb + "22");
    }
}
