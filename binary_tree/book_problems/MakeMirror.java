package binary_tree.book_problems;

import binary_tree.Node;

public class MakeMirror {
    public static void main(String[] args) {
        Node root = new Node(0);
        root.left = new Node(1);
        root.right = new Node(2);
        root.right.right =  new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Node newRoot = convertMirror(root);
    }

    public static Node convertMirror(Node root){
        if(root==null){
            return null;
        }
            Node temp = root.left;
            root.left = convertMirror(root.right);
            root.right = convertMirror(temp);
    
        return root;
    }
}
