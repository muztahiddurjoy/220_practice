package graph.final_questions;

/**
 * This program finds the pair of friends that have the most mutual friends
 * in a social network represented as an undirected graph using an adjacency matrix.
 */
public class MutualFriends {
    public static void main(String[] args) {
        // Array of friend names - each index represents a person in the network
        String[] friends = {"Alice", "Harry", "Nimo", "Nimas","Bob","Moana"};
        
        // Adjacency matrix representing the friendship graph
        // am[i][j] = 1 means person i and person j are friends
        // am[i][j] = 0 means person i and person j are NOT friends
        // The matrix is symmetric since friendships are mutual (undirected graph)
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
     * Finds the pair of friends with the maximum number of mutual friends
     * 
     * @param g - adjacency matrix representing the friendship graph
     * @param mapper - array of names corresponding to each person (index)
     */
    public static void maxMutual(int[][] g, String[] mapper){
        // Variables to track the pair with the most mutual friends
        String user1="";        // Name of first friend in the best pair
        String user2="";        // Name of second friend in the best pair
        int mutual = 0;         // Count of mutual friends for the current best pair
        
        // Outer loop: iterate through the first friend (person i)
        for (int i = 0; i < mapper.length-1; i++) {
            
                // Inner loop: iterate through the second friend (person j)
                // Start from i+1 to avoid counting the same pair twice
                for (int j = i+1; j < mapper.length; j++) {
                    int tempMutual = 0;  // Counter for mutual friends between person i and j
                    
                    // Innermost loop: check all other people to find mutual friends
                    // A mutual friend is someone who is friends with BOTH person i and person j
                    for (int k = 0; k < mapper.length; k++) {
                        // If g[i][k]==1, person i is friends with person k
                        // If g[j][k]==1, person j is friends with person k
                        // If both are true, person k is a mutual friend
                        if(g[i][k]==1 && g[j][k]==1){
                            tempMutual++;  // Increment the mutual friend count
                        }
                    }
                    
                    // Check if this pair has more mutual friends than the current maximum
                    if(tempMutual>mutual){
                        mutual = tempMutual;        // Update the maximum count
                        user1 = mapper[i];          // Update first friend name
                        user2 = mapper[j];          // Update second friend name
                    }
                }
        }
        
        // Print the result: the pair with the most mutual friends
        System.out.println(user1+ " and "+user2+" has most mutual friends ("+mutual+")");
    }
}
