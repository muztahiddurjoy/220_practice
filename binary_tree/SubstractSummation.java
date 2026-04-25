package binary_tree;
public class SubstractSummation {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(substract_summation(root));
    }

    public static int substract_summation(Node root){
        if(root==null){
            return 0;
        }
        int leftSum = summation(root.left);
        int rightSum = summation(root.right);
        return leftSum-rightSum;
    }
    public static int summation(Node root){
        if(root==null)
            return 0;
        int leftSum = summation(root.left);
        int rightSum = summation(root.right);
        return root.value + leftSum+rightSum;
    }
}
