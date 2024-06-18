package Programmers.네이버코테.I_자주등장하는자료구조.B_그래프와트리.트리;

public class 트리_고민필요 {
    public static void main(String[] args) {

        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node H = new Node('H');

        // 트리 구성
        A.addChild(B, true);  // A의 왼쪽 자식으로 B
        A.addChild(C, false); // A의 오른쪽 자식으로 C
        B.addChild(D, true);  // B의 왼쪽 자식으로 D
        C.addChild(E, true);  // C의 왼쪽 자식으로 E
        C.addChild(F, false); // C의 오른쪽 자식으로 F
        E.addChild(H, false); // E의 오른쪽 자식으로 H

//        // 출력해서 트리 구조 확인
//        System.out.println("Root: " + A.data);
//        System.out.println("A's left child: " + A.left.data);
//        System.out.println("A's right child: " + A.right.data);
//        System.out.println("B's left child: " + B.left.data);
//        System.out.println("C's left child: " + C.left.data);
//        System.out.println("C's right child: " + C.right.data);
//        System.out.println("E's right child: " + E.right.data);


        System.out.println();
        in(A);

    }

    // 전위 순회
    public static void pre(Node node){
        if(node == null) return;

        // 노드방문
        System.out.println(node.data);

        pre(node.left);
        pre(node.right);
    }


    // 중위 순회 => 여기서 왜 pre로 가는가?
    public static void in(Node node){
        if(node == null) return;

        in(node.left);

        // 노드 방문하고
        System.out.println(node.data);

        in(node.right);
    }


    // 후위 순회
    public static void post(Node node){
        if(node == null) return;

        post(node.left);
        post(node.right);

        // 노드 방문 => 마지막에
        System.out.println(node.data);
    }


    static class Node{
        char data;
        Node parent;
        Node right;
        Node left;


        public Node(char data) {
            this.data = data;
            this.parent = null;
            this.right = null;
            this.left = null;
        }

        // 자식 노드 추가 메소드 (왼쪽 또는 오른쪽)
        // 이거 생각했어야됨
        public void addChild(Node child, boolean isLeft) {
            if (isLeft) {
                this.left = child;
            } else {
                this.right = child;
            }
            child.parent = this;  // 자식 노드의 부모를 현재 노드로 설정
        }
    }


}
