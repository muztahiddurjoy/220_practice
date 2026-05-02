package binary_tree.path;
import java.util.ArrayList;
import java.util.List;

import binary_tree.Node;

public class PrintPath {
    public static void main(String[] args) {
       Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       List<String> list = new ArrayList<>();
       

        
    }
    public static void printPaths(Node root,List<String> allPath){
       if (root==null) {
            return;
       }
       List<String> path = new ArrayList<>();
          
    }

    public static void addPath(){
        
    }


}
