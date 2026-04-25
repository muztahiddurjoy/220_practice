package binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelSum {
    public static void main(String[] args) {
         Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        
        System.out.println(levelSum(root));
    }

    public static int levelSum(Node root){
        if(root==null){
            return 0;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        int oddSum = 0;
        int evenSum = 0;
        while(!q.isEmpty()){
            int levelSize = q.size();
            for (int i = 0; i < levelSize; i++) {
                Node val = q.poll();
                if(level%2==0){
                    evenSum+=val.value;
                }
                else{
                    oddSum+=val.value;
                }
                if(val.left!=null){
                    q.add(val.left);
                }
                if(val.right!=null){
                    q.add(val.right);
                }
            }
            level++;
        }
        return oddSum-evenSum;
    }
}
