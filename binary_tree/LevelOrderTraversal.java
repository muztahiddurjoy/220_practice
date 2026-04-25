package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        levelOrder2(root);
    }

    static void levelOrder(Node root){
       if(root==null){
        return;
       }
       Queue<Node> q = new LinkedList<>();
       q.add(root);
       while(!q.isEmpty()){
        Node val = q.poll();
        System.out.println(val.value);
        if(val.left!=null){
            q.add(val.left);
        }
        if(val.right!=null){
            q.add(val.right);
        }
        
       }
    }

    static void levelOrder2(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Node val = q.poll();
                System.out.print(val.value+" ");
                if(val.left!=null){
                    q.add(val.left);
                }
                if(val.right!=null){
                    q.add(val.right);
                }
            }
            System.out.println();
        }
    }
}
