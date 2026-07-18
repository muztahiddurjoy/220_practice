package linked_list;





class Node{
    int value;
    public Node next;

    public Node(int value){
        this.value = value;
        this.next = null;
    }
}

public class Test1 {
    public static void main(String[] args) {
        Node n1= new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n3;
        n3.next = n2;

        Node temp = n1;
        while(temp!=null){
            System.out.println(temp.value);
            temp = temp.next; //going to the next node
        }

       
    }
}
