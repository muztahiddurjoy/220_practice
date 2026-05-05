package binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FindHeight {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.println(height(root));
        System.out.println(iterativeHeight(root));
    }

    public static int height(Node root, int count){
        if(root==null){
            return count-1;
        }
        int leftCount = height(root.left, count+1);
        int rightCount = height(root.right, count+1);
        return leftCount>rightCount?leftCount:rightCount;
    }

    public static int height(Node root){
        if(root==null){
            return -1;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return 1+Math.max(lh, rh);
    }

    public static int iterativeHeight(Node root){
        if(root==null){
            return 0;
        }
        Stack<Node> st = new Stack<Node>();
        st.add(root);
        int count = -1;
        while(!st.isEmpty()){
            int size = st.size();
            count++;
            for(int i=0;i<size;i++){
                Node n = st.pop();
                if(n.left!=null){
                    st.push(n.left);
                }
                if(n.right!=null){
                    st.push(n.right);
                }
            }
        }
        return count;
    }
}
