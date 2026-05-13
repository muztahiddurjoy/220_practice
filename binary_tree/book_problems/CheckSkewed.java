package binary_tree.book_problems;

import binary_tree.Node;

public class CheckSkewed {
    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.left.right =  new Node(3);
        root.left.right.left = new Node(2);
        root.left.right.left.right = new Node(1);
        System.out.println(checkSkewed(root)?"Yes":"No");
    }

    public static boolean checkSkewed(Node root){
        if(root==null){
            return true;
        }
        if(root.left!=null && root.right!=null){
            return false;
        }
        return checkSkewed(root.left)&&checkSkewed(root.right);
    }
}
