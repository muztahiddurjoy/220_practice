package graph;

public class GraphTester {
    public static void main(String[] args) {
        GraphMatrix gh = new GraphMatrix(10);
        GraphList gl = new GraphList(10);
        gh.add(0, 1);
        gh.add(2, 3);
        gh.add(1, 2);

        gl.addEdge(0, 1);
        gl.addEdge(2, 3);
        gl.addEdge(1, 2);
        System.out.println("Graph Matrix:");
        gh.printGraph();
        System.out.println("Graph List:");
        gl.printGraph();
    }    
}
