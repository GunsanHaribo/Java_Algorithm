package Programmers.네이버코테.I_자주등장하는자료구조.B_그래프와트리.트리.길찾기게임_트리;


// 요구사항 :
// 이중 배열을 입력받고 이걸 왼쪽은 x좌표 작게, y좌표가 같으면 같은 레벨이다
// 자식노드의 y값은 항상 부모 노드 보다 작다
// 오른쪽은 크게 해서 이중 트리를 만들고 전위 순회, 후위 순회를 한다
// 독립변수 | 요구사항 : 트리  (x, y) 좌표, 트리 인덱스  | 요구사항 맟추면서 전위, 후위 순회

// 흐름
// 1. 노드 넣어 놓기  x, y,  parent, 노드 인덱스 포함

// 2. 트리 구성
//    2.1 y 좌표 정렬 최댓값부터 그거를 시작으로 트리 넣는것 시작
//    2.2 같은 y축이면 같은 레벨? 이건 어떻게 하는거지? => y축 순서 정렬이후에 하면 가능한듯

// 3. 전위순회
//    3-1. pre  - sout pre(left), pre(right)

// 4. 후위순회
//    4-1. post - post(left), post(right) sout


import java.util.ArrayList;
import java.util.Collections;

public class 길찾기게임_내풀이 {
    public static void main(String[] args) {
        int[][] input= new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};


//        Arrays.sort(input, (v1, v2) -> v2[1] - v1[1]);
//
//
//        for(int[] i : input){
//            System.out.print(Arrays.toString(i) +" ");
//        }

        ArrayList<Node> node_input = new ArrayList<>();

        for(int i =0; i< input.length; i++){
            int[] k = input[i];
            node_input.add(new Node(k[0], k[1] ,i+1));
        }

//        System.out.println(node_input);

        Collections.sort(node_input, (v1, v2) -> v2.y - v1.y);

        System.out.println(node_input);
        // 정렬완료

        // 근데 트리를 담는 자료구조는 뭐가 되어야되지?
        // 트리에 left right parent 배치

        // 쭉들어와야 되는데 이걸 어떻게 하지..
        //

        // n^2인데 무조건..
        // 여기서 했으면 뺴줘야된다
        Node first = node_input.get(0);
        node_input.remove(0);


        for(Node n : node_input){
            add_function(n, first);
        }


        // 노드에 x,y, 인덱스를 넣은 리스트를 만든다
        // sort해버린다
        // 이제 x를 기준으로 전위순회 , 후위순회 하면서
        ArrayList<Integer> pre_record = new ArrayList<>();
        ArrayList<Integer> post_record = new ArrayList<>();

        // null이 나오는데?
        //

        pre(first, pre_record);
        System.out.println(pre_record); // null이 나와버렸다
        post(first, post_record);
        System.out.println(post_record);

        ArrayList<ArrayList<Integer>> ss = new ArrayList<>();
        ss.add(pre_record);
        ss.add(post_record);

        System.out.println(ss);
    }


    // 이거 어레이 리스트 들어가고 비교해준 대상은 없앤다
    public static void add_function(Node n, Node compare){

        // 추가 로직은
        // x,y좌표 내려가서 비교한다, 시작은 무조건 첫번쨰 원소
        int cr_x = compare.x;
        int target_x = n.x;

        if(cr_x > target_x){
            if(compare.left ==  null){
                compare.left = n;
                n.parent = compare;
                return;
            }else{
                // compare를 바꿔야 된다
                add_function(n , compare.left);
            }

        } else if (cr_x < target_x) {
            if(compare.right  == null){
                compare.right = n;
                n.parent = compare;
                return;
            }else{
                add_function(n , compare.right);
            }

        }

        // 만약 left로 가야되는데 있으면 타고 내려가서 비교하고 없으면 left에 추가
        // 만약 right로 가야되는데 있으면 타고 내려가서 비교하고 없으면 right에 추가
    }


    public static void pre(Node n, ArrayList<Integer> pre_record) {
        if(n ==null) return;
        System.out.println(n);
        pre_record.add(n.node_index);
        pre(n.left, pre_record);
        pre(n.right,pre_record);
    }

    public static void post(Node n, ArrayList<Integer> post_record) {
        if(n ==null) return;
        post(n.left, post_record);
        post(n.right,  post_record);
        post_record.add(n.node_index);
        System.out.println(n);
    }


    static class Node{
        int x;
        int y ;
        int node_index;
        Node left =null;
        Node right = null;
        Node parent= null;

        public Node(int x, int y, int node_index) {
            this.x = x;
            this.y = y;
            this.node_index = node_index;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }




        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    ", node_index=" + node_index +
                    '}';
        }
    }

}
