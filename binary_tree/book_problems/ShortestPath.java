package binary_tree.book_problems;

import binary_tree.Node;

public class ShortestPath {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right =  new Node(5);
        root.left.left.left = new Node(7);

        System.out.println(shortestHeight(root));
    }
    public static int shortestHeight(Node root){
        if(root==null){
            return 0;
        }
        if(root.left == null && root.right==null){
            return 1;
        }
        if (root.left==null) {
            return 1+shortestHeight(root.right);
        }
        if(root.right==null){
            return 1+shortestHeight(root.left);
        }
        return 1+Math.min(shortestHeight(root.left), shortestHeight(root.right));
    }
}
