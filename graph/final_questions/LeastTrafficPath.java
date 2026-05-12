package graph.final_questions;

import graph.lab_tasks.Edge;
import graph.lab_tasks.Task1b;



public class LeastTrafficPath {
    public static void main(String[] args) {
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

    public static String find_minimum(Edge[] al){
        String target = "";
        int traffic = Integer.MAX_VALUE;
        for (int i = 0; i < al.length; i++) {

                int tempTraffic = 0;
            for (int j = 0; j < al.length; j++) {
                if(j==i){
                    continue;
                }
                Edge temp = al[j];
                if(temp==null){
                    continue;
                }
                while(temp!=null){
                    if(temp.value==i){
                        tempTraffic+=temp.weight;
                    }
                    temp=temp.next;
                }
                
            }

                System.out.println("Incoming traffic for "+i+" is "+tempTraffic);
            if(traffic>=tempTraffic){
                    traffic = tempTraffic;
                    target = String.valueOf(i);
                }
        }
        
        return target;
    }

     public static void createEdge(Edge[] al, int v1, int v2, int weight){
        Edge temp = al[v1];
        al[v1] = new Edge(v2, weight);
        al[v1].next = temp;
    }
}
