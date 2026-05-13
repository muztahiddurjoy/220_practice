
package binary_tree.book_problems;

import binary_tree.Node;

public class SumValue {

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(10);
        // root.right = new Node(10);
        System.out.println(isSum(root));
    }

    public static boolean isSum(Node root){
        if(root==null || (root.left==null && root.right==null)){
            return true;
        }
        int leftNum = root.left == null ? 0 : root.left.value;
        int rightNum = root.right == null ? 0 : root.right.value;
        if(root.value==(leftNum+rightNum)){
            return isSum(root.left) && isSum(root.right);
        }
        else{
            return false;
        }
    

    }
}