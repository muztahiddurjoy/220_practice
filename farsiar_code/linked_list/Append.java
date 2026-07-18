package linked_list;

class Node{
    int value;
    public Node next;

    public Node(int value){
        this.value = value;
        this.next = null;
    }
}

public class Append {
  public static void main(String[] args) {
     Node n1= new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n3;
        n3.next = n2;
        //prints the linked list
        System.out.println("Before appending 5");
        Node temp = n1;
        while(temp!=null){
            System.out.println(temp.value);
            temp = temp.next; //going to the next node
        }

        Node new_node = new Node(5);
        append(n1, new_node);

        //prints the linked list
         System.out.println("after appending 5");
        temp = n1;
        while(temp!=null){
            System.out.println(temp.value);
            temp = temp.next; //going to the next node
        }

  }  

  public static void append(Node head, Node new_node){
    Node current = head;
    while(current.next!=null){ //the loop iterates until it reaches the last node
        current = current.next; //updates the current node
    }
    current.next = new_node;
  }
  
}
