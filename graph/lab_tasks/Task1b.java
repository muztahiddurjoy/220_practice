package graph.lab_tasks;


class EdgeNode{
    int toV;    
    int weight;
    EdgeNode next;

    public EdgeNode(int toV, int weight){
        this.toV = toV;
        this.weight = weight;
    }

    public EdgeNode(int toV, int weight, EdgeNode next){
        this.toV = toV;
        this.weight = weight;
        this.next = next;
    }
}

public class Task1b {
    public static void main(String[] args) {
        EdgeNode[] adjL = new EdgeNode[4];
        addAL(adjL, 0, 1, 5);
        addAL(adjL, 0, 2, 10);
        addAL(adjL, 1, 3, 15);
        
        // for (int i = 0; i < adjL.length; i++) {
        //     EdgeNode temp = adjL[i];
        //     while(temp!=null){
        //         System.out.println(i+"->"+temp.toV+" weight: "+temp.weight);
        //         temp = temp.next;
        //     }
        // }
        System.out.println(findMaxVertex(adjL));
    }

    public static void addAL(EdgeNode[] al, int v1, int v2, int weight){
    createEdge(al, v1, v2, weight);
    createEdge(al, v2, v1, weight);
    }

    public static void createEdge(EdgeNode[] al, int v1, int v2, int weight){
        EdgeNode temp = al[v1];
        al[v1] = new EdgeNode(v2, weight);
        al[v1].next = temp;
    }

    public static int findMaxVertex(EdgeNode[] al){
        int maxEdges = Integer.MIN_VALUE;
        int maxVertex = 0;

        for (int i = 0; i < al.length; i++) {
            EdgeNode temp =  al[i];
            int tempSum = 0;
            while(temp.next!=null){
                tempSum+=temp.weight;
                temp=temp.next;
            }
            if(maxEdges<tempSum){
                maxEdges = tempSum;
                maxVertex = i;
            }
        }
        System.out.println("Maximum vertex: "+maxVertex);
        return maxEdges;
    }
}
