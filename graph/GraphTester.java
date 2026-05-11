package graph;

public class GraphTester {
    public static void main(String[] args) {
        GraphMatrix gh = new GraphMatrix(10);
        gh.add(0, 1);
        gh.add(2, 3);
        gh.add(1, 2);
        gh.printGraph();
    }    
}
