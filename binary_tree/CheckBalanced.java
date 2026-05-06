package binary_tree;

public class CheckBalanced {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.right = new Node(11);
        root.left =  new Node(9);
        root.left.left = new Node(8);
        // root.left.left.left = new Node(10);
        System.out.println(checkBalanced(root));
        
    }

    public static boolean checkBalanced(Node root){
        if(root==null){
            return true;
        }
        int lh = FindHeight.height(root.left);
        int rh = FindHeight.height(root.right);
        if(Math.abs(lh-rh)>1){
            return false;
        }
        return checkBalanced(root.left) && checkBalanced(root.right);
    }
}
