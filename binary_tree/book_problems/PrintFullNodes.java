package binary_tree.book_problems;

import binary_tree.Node;

public class PrintFullNodes {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(7);

        printFullNodes(root);
    }
    public static void printFullNodes(Node root){
        if(root==null){
            return;
        }
        if(root.left!=null && root.right!=null){
            System.out.println(root.value);
        }
        printFullNodes(root.left);
        printFullNodes(root.right);
    }
}
