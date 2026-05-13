package binary_tree.book_problems;

import binary_tree.Node;

public class IsIdentical {

    public static void main(String[] args) {
        Node root = new Node(70);
        root.left = new Node(50);
        root.right = new Node(90);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        root.right.left = new Node(80);
        root.right.right = new Node(95);
        root.right.right.right = new Node(99);
        root.right.left.left = new Node(75);
        root.right.left.right = new Node(85);
        root.left.left.left = new Node(20);
        System.out.println(isIdentical(root, root));
    }

    public static boolean isIdentical(Node root1, Node root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }
        return root1.value.equals(root2.value) && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }
}