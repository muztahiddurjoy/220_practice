package binary_tree;

public class LCA {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.left.left = new Node(8);
        root.right.right = new Node(5);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(7);

        System.out.println(findlca(root, 7, 8));
    }

    public static Integer findlca(Node root, int num1, int num2){
        if(root==null){
            return null;
        }
        if(root.value==num1 || root.value == num2){
            return root.value;
        }
        
        Integer leftResult = findlca(root.left, num1, num2);
        Integer rightResult = findlca(root.right, num1, num2);

        if(leftResult!=null&&rightResult==null){
            return leftResult;
        }
        else if(rightResult!=null&&leftResult==null){
            return rightResult;
        }
        else if(rightResult!=null && leftResult!=null){
            return root.value;
        }
        else{
            return null;
        }
    }
}
