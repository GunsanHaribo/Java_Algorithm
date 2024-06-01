package Programmers.네이버코테.재귀베이스.A재귀.하노이탑;

// 요구사항 : n개의 원판을 최소횟수로 3번 원판으로 올린다
// 한번에 하나의 원판, 큰원판이 작은 원판 위에 있어서는 안된다
// 변수 : (source : dest), 하노이탑 각 층

// 상태 : N ㅣ N번쨰 하노이탑 층 , +)이동할떄마다 리스트에 이동 방향을 기록한다
// 종료 : 마지막으로 원판(n==1)이 3번으로 가면 중지
// 점화식 :   (n- > 3), 다음상태 :  F(n-1번째부터는 3-source으로 이동)
// 리스트에 source, dest 적는다


// 문제 : 최소를 어떻게 확정하는가?, 최소이동횟수가 확정되는 움직임이 있는가?
// 최대 값만 더해서 최대합을 만든다던가...
import java.util.ArrayList;

// 마지막인지 어떻게 알지?
// 최소의 움직임이 뭐지?
public class 하노이탑_오답_20240514 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> save  = new ArrayList<>();

        // 이걸 보낸다
        hanoi(2, 1,3, save);

        System.out.println(save);
    }


    public static void hanoi(int n, int source, int dest, ArrayList<ArrayList<Integer>> save){

        // 종료
        if(n == 1) {
            // 이거 추가 시켜야함
            // source,dest를 어떻게 하지?
            ArrayList<Integer> last = new ArrayList<>();
            last.add(dest);
            last.add(3);
            // 여기 마지막이 다른데
            save.add(last);
            // 맞아 원래 이게 n-1을 나르고 n을 옮겨야 되는데
            // n부터 하니깐 뭔가 갈못 됬어
            return;
        }
        // 리스트에 담거나
        // 리스트 만들고 변수를 담는다.. int[]로 변수를 출력한다

        ArrayList<Integer> record =  new ArrayList<>();
        record.add(source);
        record.add(dest);


        // n번째꺼
        save.add(record);
        // n-1번째꺼까지
        hanoi(n-1, dest, 3- source, save);
    }
}
