package week13_BinarySearch;



import java.io.*;
import java.util.*;


//hashmap은 들어가는 순서 랜덤이다
class baekjoon_10816_숫자카드2 {

    //같은 값이 나왔을때 min과 max를 어떻게 움직이게 할 것 인가
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int ob_max = Integer.parseInt(br.readLine());
        int[] ob_array = new int[ob_max];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<ob_max; i++){
            ob_array[i] = Integer.parseInt(st.nextToken());
        }

        int find_max = Integer.parseInt(br.readLine());
        int[] find_array = new int[find_max];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i<find_max; i++){
            find_array[i] = Integer.parseInt(st2.nextToken());
        }

        //일단 sorting
        Arrays.sort(ob_array);
//        for(int i : ob_array){
//            System.out.print(i+ " ");
//        }
//        System.out.println();
//        for(int i : find_array){
//            System.out.print(i+ " ");
//        }
//        System.out.println();

        int lower;
        int upper;
        for(int find_ele : find_array){
            lower = LowerBound(ob_array,find_ele);
            upper = UpperBound(ob_array, find_ele);
            bw.append((upper-lower)+" ");
        }
        br.close();
        bw.close();

    }

    public static int LowerBound(int[] d_array, int target){
        int min=0;
        int max = d_array.length;
        int mid;
        while(min<max){
            mid = (min+max)/2;
            // -10 -10 -10 있다고 하고 target과 mid 가 같다고 하면 max가 mid 값으로 계속 내려가서
            //min있는 자리가 max가 된다
            if(d_array[mid]>=target){
                max = mid;
            }else{
                min = mid+1;
            }
        }

        return min;
    }

    public static int UpperBound(int[] d_array, int target){
        int min=0;
        int max = d_array.length;
        int mid;
        while(min<max){
            mid = (min+max)/2;
            //같을 때 max가 내려오면 문제가 생기는데
            //위 와 같이 max가 mid 따라 계속 내려온다
            // -10 -10 -10 4 있다고 하면 계산을 위해서 4를 택해야 되는데
            // -10 이 mid면 (그니깐 target==mid 이면 이떄 min = mid +1 해주면돤다)
            if(d_array[mid]>target){
                max = mid ;
            }else{
                min = mid+1;
            }
        }

        return max;
    }
}
