package binary_tree.book_problems;

import binary_tree.Node;

public class CheckBalanced {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        System.out.println(isBalanced(root));
    }
    public static boolean isBalanced(Node root){
        if(root==null){
            return true;
        }
        return Math.abs(getHeight(root.left)-getHeight(root.right))<=1;
    }

    public static int getHeight(Node node){
        if(node==null){
            return -1;
        }
        return 1+Math.max(getHeight(node.left), getHeight(node.right));
    }
}
