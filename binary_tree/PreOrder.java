package binary_tree;

public class PreOrder {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        printPreOrder(root);
    }

    public static void printPreOrder(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.value);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
}
