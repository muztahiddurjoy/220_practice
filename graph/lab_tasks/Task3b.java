package graph.lab_tasks;

public class Task3b {
    public static void main(String[] args) {
        EdgeNode[] al = new EdgeNode[5];
        Task1b.createEdge(al, 0, 1, 10);
        Task1b.createEdge(al, 0, 2, 20);
        Task1b.createEdge(al, 1, 2, 30);
        System.out.println(findMaximumVertex(al));
    }

    public static int findMaximumVertex(EdgeNode[] al){
        int maxWeight = Integer.MIN_VALUE;
        int maxVertex = -1;
        for (int i = 0; i < al.length; i++) {
            EdgeNode temp = al[i];
            int tempSum = 0;
            while(temp!=null){
                tempSum+=temp.weight;
                temp=temp.next;
            }
            if(maxWeight<tempSum){
                maxWeight = tempSum;
                maxVertex = i;
            }
        }
        System.out.println("Maximum edge weight sum "+maxWeight);
        return maxVertex;
    }
}
