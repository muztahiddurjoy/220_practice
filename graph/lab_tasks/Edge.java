package graph.lab_tasks;


public class Edge{
    public int value;
    public Edge next;
    public int weight;
    
    public Edge(int value, int weight){
        this.value = value;
        this.weight = weight;
    }

    public Edge(int value, int weight, Edge next){
        this.value = value;
        this.weight = weight;
        this.next = next;
    }
}