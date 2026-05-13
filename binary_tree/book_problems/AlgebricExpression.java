package binary_tree.book_problems;

import binary_tree.Node;
import graph.lab_tasks.GraphBasic.edgeN;

class SpecialNode{
    public SpecialNode left;
    public SpecialNode right;
    public String value;

    public SpecialNode(String value){
        this.value = value;
    }
    
}

public class AlgebricExpression {
    public static void main(String[] args) {
        SpecialNode node = new SpecialNode("+");
        node.left = new SpecialNode("*");
        node.right = new SpecialNode("/");
        node.left.left = new SpecialNode("-");
        node.left.right = new SpecialNode("5");
        node.left.left.left = new SpecialNode("10");
        node.left.left.right = new SpecialNode("5");
        node.right.left = new SpecialNode("21");
        node.right.right = new SpecialNode("7");
        System.out.println(findResult(node));
    }
    public static int findResult(SpecialNode root){
        if(root==null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return Integer.parseInt(root.value);
        }
        
        int left = findResult(root.left);
        int right = findResult(root.right);

        return calculate(root.value, left, right);
    }

    private static int calculate(String operator, int left, int right){
        switch (operator) {
            case "+":
                return left+right;
            case "-":
                return left-right;
            case "*":
                return left*right;
            case "/":
                return left/right;
            default:
                return -1;
        }
    }
}
