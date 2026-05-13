package binary_tree.book_problems;

import java.util.LinkedList;
import java.util.Queue;

import binary_tree.Node;

public class HIghestNumberInLevel {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);

        root.left.left = new Node(3);
        root.left.right = new Node(7);

        root.right.left = new Node(12);
        root.right.right = new Node(20);
        printHighestInLevel(root);
    }

    public static void printHighestInLevel(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            int semiLargest = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                Node n = queue.poll();
                if(n.value>semiLargest){
                    semiLargest = n.value;
                }
                if(n.left!=null) queue.add(n.left);
                if(n.right!=null) queue.add(n.right);
            }
        System.out.println(semiLargest+" at level "+level++);
        }
    }
}
