
public class TreePrinter {
    
    // Call this method with (root, 0)
    public static void printSideways(Node root, int space) {
        // Base case
        if (root == null) {
            return;
        }

        // Increase distance between levels
        final int SPACING = 5;
        space += SPACING;

        // 1. Process right child first (prints at the top)
        printSideways(root.right, space);

        // 2. Print current node after spacing
        System.out.println();
        for (int i = SPACING; i < space; i++) {
            System.out.print(" ");
        }
        System.out.print(root.value + "\n");

        // 3. Process left child (prints at the bottom)
        printSideways(root.left, space);
    }
}