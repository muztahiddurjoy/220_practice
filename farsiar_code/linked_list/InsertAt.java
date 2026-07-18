package linked_list;


class Node{
    int value;
    public Node next;

    public Node(int value){
        this.value = value;
        this.next = null;
    }
}


public class InsertAt {
    public static void main(String[] args) {
         Node n1= new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n3;
        n3.next = n2;

        //prints the linked list
        System.out.println("Before prepending 5");
        Node temp = n1;
        while(temp!=null){
            System.out.println(temp.value);
            temp = temp.next; //going to the next node
        }
        Node new_node = new Node(5);
        insertAt(n1, new_node, 2);

        //prints the linked list
        System.out.println("Before prepending 5");
        temp = n1;
        while(temp!=null){
            System.out.println(temp.value);
            temp = temp.next; //going to the next node
        }
    }

    public static void insertAt(Node head, Node node, int index){
        if(head==null){
            return;
        }
        int number = 0;
        Node temp = head;
        while(number!=index && head!=null){
            number++;
            temp = temp.next;
        }
        Node next_temp = temp.next;
        temp.next = node;
        node.next = next_temp;
    }
}
