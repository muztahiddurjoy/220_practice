package binary_tree.book_problems;

import binary_tree.Node;

public class PrintAncestor {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.left.left = new Node(7);

        printAncestors(root, 7);
    }

    public static boolean printAncestors(Node root,int elem){
        if(root==null){
            return false;
        }
        if(root.value==elem){
            return true;
        }
        boolean left = printAncestors(root.left, elem);
        boolean right = printAncestors(root.right, elem);
        if(left||right){
            System.out.println(root.value);
            return true;
        }
        return false;
    }
}
