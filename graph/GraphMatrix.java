package graph;

public class GraphMatrix {
    int[][] mat;
    int V;
    int E;
    
    public GraphMatrix(int size){
        this.V = size;
        this.mat = new int[size][size];
    }

    public void add(int v1, int v2){
        this.mat[v1][v2] = 1;
        this.mat[v2][v1] = 1;
        E++;
    }

    public void delete(int v1,int v2){
        this.mat[v1][v2] = 0;
        this.mat[v2][v1] = 0;
        E--;
    }

    public void printGraph(){
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(mat[i][j]+" ");    
            }
            System.out.println();
        }
    }
}
