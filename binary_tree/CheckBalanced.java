package binary_tree;

public class CheckBalanced {
    public static void main(String[] args) {
        Node root = new Node(10);
        root.right = new Node(11);
        root.left =  new Node(9);
        root.left.left = new Node(8);

        
    }

    public static boolean checkBalanced(Node root){
        if(root!=null){
            return true;
        }
        
    }
}
