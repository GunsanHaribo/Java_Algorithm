package Programmers.구현미친듯이풀기.I_자주등장하는자료구조.B그래프와트리.트리.길찾기게임_트리;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 길찾기게임_답지 {
    public static void main(String[] args) {
        int[][] nodeInfo= new int[][]{{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};


        Node[] nodes = new Node[nodeInfo.length];

        for(int i=0; i< nodes.length; i++){
            nodes[i] = new Node(i+1, nodeInfo[i][0],nodeInfo[i][1]);
        }
        Arrays.sort(nodes, (a,b) -> b.y - a.y);

        Node root = constructTree(nodes);

        List<Integer> preorder = new ArrayList<>();
        pre(root, preorder);

        List<Integer> postorder = new ArrayList<>();
        post(root, postorder);

        System.out.println(preorder);
        System.out.println(postorder);

    }

    private static class Node{
        public final int value;
        public final int x;
        public final int y;

        public Node left;
        public Node right;

        public Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }

    // 노드 삽입로직
    public static void insert(Node root, Node node){
        if(node.x < root.x){
            if(root.left == null){
                root.left = node;
            }else{
                insert(root.left, node);
            }
        }else{
            if(root.right ==null){
                root.right = node;
            }else{
                insert(root.right, node);
            }
        }

    }

    private static Node constructTree(Node[] nodes){
        Node root = nodes[0];

        for(int i =1; i < nodes.length; i++){
            insert(root, nodes[i]);
        }

        return root;
    }

    private static void pre(Node node, List<Integer> visits){
        if(node == null) return;

        visits.add(node.value);
        pre(node.left, visits);
        pre(node.right, visits);
    }

    private static void post(Node node, List<Integer> visits){
        if(node == null) return;


        post(node.left, visits);
        post(node.right, visits);
        visits.add(node.value);
    }

}
