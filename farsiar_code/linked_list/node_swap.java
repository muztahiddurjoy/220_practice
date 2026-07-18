package linked_list;



public class node_swap {
    static class Node{
    int passenger_id;
    int bag_weight;
    public Node next;
    
    public Node(int passenger_id, int bag_weight){
        this.passenger_id = passenger_id;
        this.bag_weight = bag_weight;
    }
}
    public static void main(String[] args) {
        Node head   = new Node(1, 20);
        Node second = new Node(2, 70);
        Node third  = new Node(3, 80);
        Node fourth = new Node(4, 50);
        Node fifth  = new Node(5, 60);
        head.next = second; // Link first node with the second node
        second.next = third; // Link second node with the third node
        third.next = fourth; // Link third node with the fourth node
        fourth.next = fifth; // Link fourth node with the fifth node
        
        Node temp = head;
        System.out.println("Before rearranging passengers:");
        while(temp!=null){
            System.out.println("Passenger ID: " + temp.passenger_id + ", Bag Weight: " + temp.bag_weight);
            temp = temp.next; //going to the next node
        }
        System.out.println("After rearranging passengers:");
        temp = head;
        while(temp!=null){
            System.out.println("Passenger ID: " + temp.passenger_id + ", Bag Weight: " + temp.bag_weight);
            temp = temp.next; //going to the next node
        }
    }

    public static void rearrangePassengers(Node head) {
    if (head == null || head.next == null) {
        return;
    }
    boolean swapped;
    do {
        swapped = false;
        Node current = head;
        while (current.next != null) {
            Node next = current.next;
            if (current.bag_weight > next.bag_weight) {
                // swap contents
                int tempId = current.passenger_id;
                int tempWeight = current.bag_weight;
                current.passenger_id = next.passenger_id;
                current.bag_weight = next.bag_weight;
                next.passenger_id = tempId;
                next.bag_weight = tempWeight;
                swapped = true;
            }
            current = current.next; // ALWAYS advance
        }
    } while (swapped);
}
}
