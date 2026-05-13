package binary_tree.book_problems;

import binary_tree.Node;

public class CheckSymmetry {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);
        System.out.println(isSymmetric(root));
    }   

    public static boolean isSymmetric(Node root){
        if(root==null){
            return true;
        }
        return isMirror(root.left, root.right);
    }
    
    public static boolean isMirror(Node t1, Node t2){
        if(t1==null && t2==null){
            return true;
        }
        if(t1==null||t2==null){
            return false;
        }
        return t1.value==t2.value && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }
}
