package graph.final_questions;

/**
 * This program finds the pair of people who share the most mutual friends
 * in a social network represented as an undirected graph.
 *
 * Example use:
 * If Alice and Harry both know Nimo, then Nimo is a mutual friend of that pair.
 * The program compares every pair and prints the pair with the highest count.
 */
public class MutualFriends {
    public static void main(String[] args) {
        // Names for each node in the graph.
        // Index 0 means Alice, index 1 means Harry, and so on.
        String[] friends = {"Alice", "Harry", "Nimo", "Nimas","Bob","Moana"};
        
        // Adjacency matrix for the friendship graph.
        // am[i][j] = 1 means person i is directly connected to person j.
        // Because the graph is undirected, the matrix is symmetric.
        // Example: am[0][1] = 1 means Alice and Harry are friends.
        int[][] am = 
        {
            {0,1,1,0,0,0},      // Alice (0): friends with Harry, Nimo
            {1,0,1,1,0,0},      // Harry (1): friends with Alice, Nimo, Nimas
            {1,1,0,1,0,0},      // Nimo (2): friends with Alice, Harry, Nimas
            {0,1,1,0,1,0},      // Nimas (3): friends with Harry, Nimo, Bob
            {0,0,0,1,0,1},      // Bob (4): friends with Nimas, Moana
            {0,0,0,0,1,0}       // Moana (5): friends with Bob
        };
        
        // Find and print the pair of friends with the most mutual friends
        maxMutual(am, friends);
    }


    /**
     * Finds the pair of people with the maximum number of mutual friends.
     *
     * How it works:
     * 1. Pick one pair of people.
     * 2. Scan all other people.
     * 3. Count how many are friends with both members of the pair.
     * 4. Keep the pair with the highest count.
     * 
     * @param g - adjacency matrix representing the friendship graph
     * @param mapper - array of names corresponding to each person (index)
     */
    public static void maxMutual(int[][] g, String[] mapper){
        // Store the best pair found so far.
        String user1="";
        String user2="";
        int mutual = 0;
        
        // Try every pair once: (0,1), (0,2), ..., (n-2,n-1).
        for (int i = 0; i < mapper.length-1; i++) {
            
            // Choose the second person in the pair.
            // Start from i + 1 so the same pair is not checked twice.
            for (int j = i+1; j < mapper.length; j++) {
                int tempMutual = 0;
                
                // Check every person as a possible mutual friend.
                // A person counts only if they are connected to both i and j.
                for (int k = 0; k < mapper.length; k++) {
                    if(g[i][k]==1 && g[j][k]==1){
                        tempMutual++;
                    }
                }
                
                // Keep the pair with the largest mutual-friend count.
                if(tempMutual>mutual){
                    mutual = tempMutual;
                    user1 = mapper[i];
                    user2 = mapper[j];
                }
            }
        }
        
        // Example output:
        // "Harry and Nimo has most mutual friends (2)"
        System.out.println(user1+ " and "+user2+" has most mutual friends ("+mutual+")");
    }
}
