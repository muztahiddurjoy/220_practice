package binary_tree.iterative_traversal;

import java.util.Stack;

import binary_tree.Node;

public class PreOrder {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        preOrder(root);
    }

    public static void preOrder(Node root){
        while(root==null){
            return;
        }
        Stack<Node> st = new Stack<Node>();
        st.add(root);
        while(!st.isEmpty()){
            Node node = st.pop();
            System.out.print(node.value+"->");
             if(node.right!=null){
                st.add(node.right);
            }
            if(node.left!=null){
                st.add(node.left);
            }
        }
        System.out.println();
    }
}
