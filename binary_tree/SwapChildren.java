package binary_tree;

public class SwapChildren {
    public static void main(String[] args) {
         Node root              = new Node('A');
        root.left              = new Node('B');
        root.right             = new Node('C');
        root.left.left         = new Node('D');
        root.left.right        = new Node('E');
        root.right.right       = new Node('F');
        root.left.left.left    = new Node('G');
        root.left.left.right   = new Node('H');
        root.left.right.left   = new Node('I');
        root.right.right.left  = new Node('J');

        System.out.println("Previous");
        printTree(root);
        swapChildren(root, 0, 2);
        System.out.println("After swapping");
        printTree(root);

        
    }    

    public static void swapChildren(Node root, int level, int M){
        if(root==null) return;

        swapChildren(root.left, level+1, M);
        swapChildren(root.right, level+1, M);

        if(level>=M-1){
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        
    }

    static void printNodesAtLevel(Node root, int target, int current){
        if(root==null){
            return;
        }
        if(target==current){
            System.out.print(root.value+ " ");
            return;
        }
        printNodesAtLevel(root.left, target, current+1);
        printNodesAtLevel(root.right, target, current+1);

    }

    static int getHeight(Node root){
        if(root==null){
            return 0;
        }
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        return 1+ (leftH > rightH ? leftH: rightH);
    }

    static void printTree(Node root){
        int height = getHeight(root);
        for (int i = 0; i < height; i++) {
            printNodesAtLevel(root, i, 0);
            System.out.println();
        }
    }
}
