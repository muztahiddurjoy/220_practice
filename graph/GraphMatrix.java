package graph;

public class GraphMatrix {
    int[][] mat;
    int V;
    int E;
    
    public GraphMatrix(int size){
        this.V = size;
        this.mat = new int[size+1][size+1];
    }

    //add(1,3)
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
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                System.out.print(mat[i][j]+" ");    
            }
            System.out.println();
        }
    }
}
