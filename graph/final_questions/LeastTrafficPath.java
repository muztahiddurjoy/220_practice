package graph.final_questions;

import graph.lab_tasks.Edge;
import graph.lab_tasks.Task1b;



public class LeastTrafficPath {
    public static void main(String[] args) {
        // Build a directed weighted graph using adjacency-list nodes.
        // Each edge stores: destination vertex + traffic weight.
        // Example: createEdge(al, 0, 1, 20) means 0 -> 1 with traffic 20.
        Edge[] al = new Edge[4];
        createEdge(al, 0, 1, 20);     
        createEdge(al, 0, 2, 30);

        createEdge(al, 1, 0, 70);
        createEdge(al, 1, 2, 35);
        createEdge(al, 1, 3, 20);

        createEdge(al, 2, 0, 55);
        createEdge(al, 2, 1, 25);
        createEdge(al, 2, 3, 55);

        createEdge(al, 3, 1, 40);
        createEdge(al, 3, 2, 60);
        
        System.out.println(find_minimum(al));
    }

    /**
     * Finds the vertex with the smallest total incoming traffic.
     *
     * Example use:
     * If vertex 2 receives traffic from several other vertices, all of those
     * incoming edge weights are added together. The vertex with the lowest
     * total is returned.
     */
    public static String find_minimum(Edge[] al){
        // target stores the vertex index with the least incoming traffic.
        String target = "";
        int traffic = Integer.MAX_VALUE;
        
        // Check each vertex as a possible destination.
        for (int i = 0; i < al.length; i++) {

            // Sum all incoming edge weights for vertex i.
            int tempTraffic = 0;
            for (int j = 0; j < al.length; j++) {
                // Skip scanning the same vertex's outgoing list for itself.
                if(j==i){
                    continue;
                }
                
                // al[j] is the head of the outgoing edges from vertex j.
                Edge temp = al[j];
                if(temp==null){
                    continue;
                }
                
                // Walk through the linked list of edges.
                while(temp!=null){
                    // If an edge ends at i, it contributes to i's incoming traffic.
                    if(temp.value==i){
                        tempTraffic+=temp.weight;
                    }
                    temp=temp.next;
                }
                
            }

            // Helpful trace output while studying the example graph.
            System.out.println("Incoming traffic for "+i+" is "+tempTraffic);
            if(traffic>=tempTraffic){
                traffic = tempTraffic;
                target = String.valueOf(i);
            }
        }
        
        return target;
    }

    /**
     * Adds a new directed edge to the front of the adjacency list for v1.
     *
     * Example use:
     * createEdge(al, 1, 3, 20) creates an edge from 1 to 3 with weight 20.
     */
     public static void createEdge(Edge[] al, int v1, int v2, int weight){
        Edge temp = al[v1];
        al[v1] = new Edge(v2, weight);
        al[v1].next = temp;
    }
}
