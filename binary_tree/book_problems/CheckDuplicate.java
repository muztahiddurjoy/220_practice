package binary_tree.book_problems;

import binary_tree.Node;

public class CheckDuplicate {
    public static void main(String[] args) {
        
    }
    public static boolean hasDuplicate(Node root){
        if(root==null){
            return false;
        }
        if(searchElement(root.left, root.value) || searchElement(root.right, root.value)){
            return true;
        }
        return hasDuplicate(root.left) || hasDuplicate(root.right);
    }

    public static boolean searchElement(Node root,int elem){
        if(root==null){
            return false;
        }
        boolean isFoundL = searchElement(root.left,elem);
        boolean isFoundR = searchElement(root.right,elem);
        
        return root.value.equals(elem) || isFoundL || isFoundR;
    }
}
