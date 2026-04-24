package binary_tree;

public class Second {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        printIntOrder(root);
    }
    public static void printIntOrder(Node root){
        if(root==null){
            return;
        }
        printIntOrder(root.left);
        System.out.println(root.value);
        printIntOrder(root.right);
    }
}
