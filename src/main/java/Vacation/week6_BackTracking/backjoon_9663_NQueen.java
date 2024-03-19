package Vacation.week6_BackTracking;

public class backjoon_9663_NQueen {
    static boolean[] isUsed_straight;
    static boolean[] isUsed_diagonal;
    static boolean[] isUsed_diagonal_2;
    //isUsed가 3개?
    //isUsed가 3개? 비교는 또 어떻게 하고
    //
    public static void main(String[] args) {

    }

    public static void queen_func(int x, int y, int r){

    }
//
//    let n = Int(readLine()!)!
//    var isUsed1 = [Bool](repeating: false, count: n)  // 열
//    var isUsed2 = [Bool](repeating: false, count: 2 * n)  // / 방향
//    var isUsed3 = [Bool](repeating: false, count: 2 * n)  // \ 방향
//    var cnt = 0
//
//    // k번째 행에 퀸 놓는 함수
//    func solve(_ r: Int) {
//        if r == n {
//            cnt += 1
//            return
//        }
//
//        for c in 0 ..< n {
//            if isUsed1[c] || isUsed2[r + c] || isUsed3[r - c + n] { continue }
//            isUsed1[c] = true
//            isUsed2[r + c] = true
//            isUsed3[r - c + n] = true
//            solve(r + 1)
//            isUsed1[c] = false
//            isUsed2[r + c] = false
//            isUsed3[r - c + n] = false
//        }
//    }
//
//    solve(0)
//    print(cnt)

}
