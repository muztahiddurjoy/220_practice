package graph;

import java.util.LinkedList;

public class GraphList {
    private int V;
    private int E=0;
    private LinkedList<Integer>[] adjList;

    public GraphList(int size){
        this.V = size;
        
        this.adjList = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v1,int v2){
        adjList[v1].add(v2);
        adjList[v2].add(v1);
        E++;
    }

    public void removeEdge(int v1, int v2){
        adjList[v1].remove(v2);
        adjList[v2].remove(v1);
        E--;
    }

    public void printGraph(){
        for (int i = 0; i < adjList.length; i++) {
            LinkedList<Integer> ll = adjList[i];
            System.out.print("Vertex " + i + ": ");
            for (int j = 0; j < ll.size(); j++) {
                System.out.print(ll.get(j) + " ");
            }
            System.out.println();
        }
    }
}
