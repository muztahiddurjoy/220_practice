package binary_tree.book_problems;

import binary_tree.Node;

public class TargetPath {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        printTargetPath(root, 5);
    }
    public static void printTargetPath(Node root, int target){
       if(root==null){
        return;
       }
       int[] path = new int[10000];
       findPath(root, path, 0,target);
    }
    public static void findPath(Node root,int[] path, int currentIndex, int target){
        if(root==null){
            return;
        }
        path[currentIndex++] = root.value;
        if (root.value == target) {
            for (int i = 0; i < currentIndex; i++) {
                System.out.print(path[i]+"->");
            }
            System.out.println();
        }
        findPath(root.left, path, currentIndex, target);
        findPath(root.right, path, currentIndex, target);
    }
}
