package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelSum1 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.right = new Node(3);
        root.right.right = new Node(6);
        root.right.left = new Node(5);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        System.out.println(levelSum(root));        
        System.out.println(levelSum(root,0));
    }

    public static int levelSum(Node root){
        int totalSum = 0;
        Queue<Node> q = new LinkedList<>();
        int level = 1;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if(level%2==0){
                    totalSum+=node.value;
                }
                else{
                    totalSum-=node.value;
                }
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            level++;
        }
        return totalSum;
    }

    public static int levelSum(Node root, int level) {
    if (root == null) {
        return 0;
    }
    int value = (int) root.value;
    if (level % 2 == 0) {
        value = -value;
    }
    return value + levelSum(root.left, level + 1)
                 + levelSum(root.right, level + 1);
}
}
