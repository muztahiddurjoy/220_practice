package binary_search_tree;

public class BinarySearchTree {
    Node root = null;

    public BinarySearchTree(){
        root = null;
    }
    public void insert(int key){
        root = insertRec(root, key);
    }
    public Node insertRec(Node root, int key){
        if (root==null) {
            return new Node(key);
        }
        if(key< root.key){
            root.left = insertRec(root.left, key);
        }
        if(key>root.key){
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    public Node search(int key){
        return searchRec(root,key);
    }

    public Node searchRec(Node node, int key){
        if(node==null){
            return null;
        }
        if(node.key==key){
            return node;
        }
        if(key<node.key){
            return searchRec(node.left, key);
        }
        if(key>node.key){
            return searchRec(node.right, key);
        }
        return null;
    }

    public void inOrder(){
        inOrderRec(root);
        System.out.println();
    }
    public void inOrderRec(Node node){
        if(node!=null){
            inOrderRec(node.left);
            System.out.print(node.key+"->");
            inOrderRec(node.right);
        }
    }
    public void deleteKey(int key){
        root = deleteRec(root,key);
    }

    private Node deleteRec(Node node, int key){
        if(node==null){
            return null;
        }
        if(key < node.key){
            node.left = deleteRec(node.left, key);
        }
        else if(key>node.key){
            node.right = deleteRec(node.right, key);
        }
        else{
            if(node.left==null){
                return node.right;
            }
            else if(node.right==null){
                return node.left;
            }

            Node successor = findMin(node.right);
            node.key = successor.key;
            node.right = deleteRec(node.right, successor.key);
            
        }
        return node;
    }

    private Node findMin(Node node){
        Node current = node;
        while(current.left!=null){
            current = current.left;
        }
        return current;
    }
}
