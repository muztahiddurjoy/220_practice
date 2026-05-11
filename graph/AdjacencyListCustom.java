package graph;


class Node{
    Node next;
    int elem;
    public Node(int elem, Node next){
        this.next = next;
        this.elem = elem;
    }

    public Node(int elem){
        this.elem = elem;
    }
}

public class AdjacencyListCustom {
    private int V;
    private int E=0;
    private Node[] adjList;

    public AdjacencyListCustom(int V){
        this.V = V;
        this.adjList = new Node[V+1];
    }

    //addEdge(1,3)
    public void addEdge(int v1, int v2){
        //one direction edge
        if(adjList[v1]==null){
            adjList[v1] = new Node(v2);
        }
        else{
            Node temp = adjList[v1];
            adjList[v1] = new Node(v2, temp);
        }
        //second direction edge
        if(adjList[v2]==null){
            adjList[v2] = new Node(v1);
        }
        else{
            Node temp = adjList[v2];
            adjList[v2] = new Node(v1, temp);
        }
    }

    public void removeEdge(int v1, int v2){
        if(adjList[v1]!=null){
            Node temp = adjList[v1];
            while(temp.next!=null || temp.next.elem != v2){
                temp = temp.next;
            }
            if (temp.next.elem==v2) {
                temp.next = temp.next.next;
            }
        }
    }
}