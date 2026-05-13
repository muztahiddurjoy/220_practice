package binary_search_tree.final_questions;

import binary_tree.Node;

public class Internal_Sum {
    
    public static void main(String[] args) {
   
        Node root = buildCompleteTree(1, 31);
        
   
   
    }

   
    public static Node buildCompleteTree(int value, int max) {
        if (value > max) {
            return null;
        }
        Node node = new Node(value);
        node.left = buildCompleteTree(value * 2, max);
        node.right = buildCompleteTree((value * 2) + 1, max);
        return node;
    }

    public static int getInternalSum(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return 0;
        }
        int left = getInternalSum(root.left);
        int right = getInternalSum(root.right);
        return left + right + root.value;
    }

    public static int getExternalSum(Node root){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            return root.value;
        }
        int sum =0;
        sum+=root.value;
        Node lt = root.left;
        while(lt!=null){
            sum+=lt.value;
            lt = lt.left;
        }
        return sum;
        
    }

    public static int sumLeaf(Node root){
        if(root==null){
            return 0;
        }
        int left  = sumLeaf(root.left);
        int right = sumLeaf(root.right);
        if(root.left==null && root.right==null){
            return root.value;
        }
        return left+right;
        
    }

    
  
}