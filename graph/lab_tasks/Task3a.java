package graph.lab_tasks;

public class Task3a {
    public static void main(String[] args) {
        int[][] adjM = new int[4][4];
        adjM[0][1] = 5;
        adjM[0][2] = 10;
        adjM[1][3] = 15;
        adjM[0][3] = 20;
        
        System.out.println(findMaximumWeight(adjM));
      
    }

    public static int findMaximumWeight(int[][] am){
        int maxWeight = Integer.MIN_VALUE;
        int maxVertex = -1;

        for (int i = 0; i < am.length; i++) {
            int tempSum = 0;
            for (int j = 0; j < am.length; j++) {
                tempSum+=am[i][j];
            }
            if(maxWeight<=tempSum){
                maxWeight = tempSum;
                maxVertex = i;
            }
        }
        System.out.println("Max vertex is "+maxVertex);
        return maxWeight;
    }
}
