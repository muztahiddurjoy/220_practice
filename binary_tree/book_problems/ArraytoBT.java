package binary_tree.book_problems;

import java.util.LinkedList;
import java.util.Queue;

import binary_tree.Node;

public class ArraytoBT {

    public static void main(String[] args) {
        Integer[] arr = {null, 15,25,35,10,35,15,18,null,null,null,33,null,5,null,19,null,null,null,16};
        Node root = constructTree(arr, 1);
        
        printVertical(root);
    }
    public static Node constructTree(Integer[] arr, int index){
        if(index>=arr.length || arr[index]==null){
            return null;
        }
        Node root = new Node(arr[index]);
        root.left = constructTree(arr, index*2);
        root.right = constructTree(arr, (index*2)+1);
        return root;
    }

    public static void printBreadth(Node root){
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node elem = queue.poll();
            System.out.print(elem.value + " ");
            if (elem.left != null) {
                queue.add(elem.left);
            }
            if (elem.right != null) {
                queue.add(elem.right);
            }
        }       
    }

   public static void printVertical(Node root) {
        if (root == null) {
            System.out.println("(Empty Tree)");
            return;
        }

        int height = getHeight(root);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;
        
        // Run BFS, but stop when we reach the max height 
        // (to avoid infinite loops with our dummy null nodes)
        while (!queue.isEmpty() && level <= height) {
            int nodesInCurrentLevel = queue.size();
            
            // Math magic to calculate spaces based on the current level and max height
            int leadingSpaces = (int) Math.pow(2, height - level + 1) - 1;
            int betweenSpaces = (int) Math.pow(2, height - level + 2) - 1;

            // 1. Print the leading spaces for this row
            printSpaces(leadingSpaces);

            // 2. Process all nodes at the current level
            for (int i = 0; i < nodesInCurrentLevel; i++) {
                Node current = queue.poll();

                if (current != null) {
                    System.out.print(current.value);
                    // Add children to the queue
                    queue.add(current.left);
                    queue.add(current.right);
                } else {
                    // If node is null, print a placeholder (we use spaces)
                    System.out.print("  "); 
                    // Add dummy nulls to keep the spacing of the level below perfectly aligned
                    queue.add(null);
                    queue.add(null);
                }

                // 3. Print the spaces between nodes
                printSpaces(betweenSpaces);
            }
            
            // Move down to the next row
            System.out.println();
            level++;
        }
    }

    // Helper method to print a specific number of blank spaces
    private static void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    // Helper method to find the height of the tree (which you learned earlier!)
    private static int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}