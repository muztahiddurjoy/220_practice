package binary_tree.book_problems;

import binary_tree.Node;

public class PrintSingleMothers {
    public static void main(String[] args) {
        Node root = new Node(2);
        root.left = new Node(3);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.right.left = new Node(8);
        root.right.right = new Node(6);
        root.right.right.right = new Node(10);
        printSingle(root);
    }
    public static void printSingle(Node root){
        if(root==null){
            return;
        }
        if((root.left==null && root.right!=null)|| (root.left!=null && root.right==null)){
            System.out.println(root.value);
            return;
        }
        printSingle(root.left);
        printSingle(root.right);
    }
}
