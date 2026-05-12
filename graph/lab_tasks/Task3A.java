package graph.lab_tasks;

class EdgeNode{
    int value;
    EdgeNode next;
    int weight;
    
    public EdgeNode(int value, int weight){
        this.value = value;
        this.weight = weight;
    }

    public EdgeNode(int value, int weight, EdgeNode next){
        this.value = value;
        this.weight = weight;
        this.next = next;
    }
}


public class Task3A{
    
    public static void addAL(EdgeNode[] al, int start, int end, int weight){
        EdgeNode temp = al[start];
        al[start] = new EdgeNode(end, weight, temp);
        al[start].next = temp;
    }

    public static void findMaximumEdge(EdgeNode[] al){
        int maxEdge = -
    }



    public static void main(String[] args) {
        EdgeNode[] adjL  = new EdgeNode[4];
        
    }
}
