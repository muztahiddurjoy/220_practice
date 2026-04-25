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
        levelOrder(root);
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
}
