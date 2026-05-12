package graph.final_questions;

import graph.lab_tasks.Edge;

/**
 * This program simulates an airport network and analyzes the in-degree and out-degree
 * (number of incoming and outgoing connections) for each airport.
 * 
 * EXAMPLE SIMULATION:
 * We have 4 airports labeled 0, 1, 2, 3 (nodes in a directed graph)
 * All airports are fully connected - meaning every airport has direct routes to all others
 * 
 * Network structure:
 *     Airport 0 ←→ Airport 1
 *        ↕         ↕
 *     Airport 2 ←→ Airport 3
 * 
 * From Airport 0: can fly to Airport 1, 2, 3 (3 outgoing routes)
 * From Airport 1: can fly to Airport 0, 2, 3 (3 outgoing routes)
 * From Airport 2: can fly to Airport 0, 1, 3 (3 outgoing routes)
 * From Airport 3: can fly to Airport 0, 1, 2 (3 outgoing routes)
 * 
 * Expected output:
 * 3 3  (Airport 0: 3 incoming, 3 outgoing)
 * 3 3  (Airport 1: 3 incoming, 3 outgoing)
 * 3 3  (Airport 2: 3 incoming, 3 outgoing)
 * 3 3  (Airport 3: 3 incoming, 3 outgoing)
 */
public class AirportNetwork {
    public static void main(String[] args) {
        // Create an adjacency list for 4 airports (nodes)
        Edge[] adjL  = new Edge[4];
        
        // Build outgoing routes from Airport 0
        LeastTrafficPath.createEdge(adjL, 0, 1, 1);  // Route: 0 → 1
        LeastTrafficPath.createEdge(adjL, 0, 2, 1);  // Route: 0 → 2
        LeastTrafficPath.createEdge(adjL, 0, 3, 1);  // Route: 0 → 3

        // Build outgoing routes from Airport 1
        LeastTrafficPath.createEdge(adjL, 1, 0, 1);  // Route: 1 → 0
        LeastTrafficPath.createEdge(adjL, 1, 2, 1);  // Route: 1 → 2
        LeastTrafficPath.createEdge(adjL, 1, 3, 1);  // Route: 1 → 3

        // Build outgoing routes from Airport 2
        LeastTrafficPath.createEdge(adjL, 2, 0, 1);  // Route: 2 → 0
        LeastTrafficPath.createEdge(adjL, 2, 1, 1);  // Route: 2 → 1
        LeastTrafficPath.createEdge(adjL, 2, 3, 1);  // Route: 2 → 3

        // Build outgoing routes from Airport 3
        LeastTrafficPath.createEdge(adjL, 3, 0, 1);  // Route: 3 → 0
        LeastTrafficPath.createEdge(adjL, 3, 1, 1);  // Route: 3 → 1
        LeastTrafficPath.createEdge(adjL, 3, 2, 1);  // Route: 3 → 2
        
        // Analyze the network: calculate incoming and outgoing connections for each airport
        int[][] result = netWorkCheck(adjL);
        
        // Print the results in a table format
        // Each row: [incoming_connections] [outgoing_connections]
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * Analyzes the airport network to determine the in-degree and out-degree of each airport
     * 
     * @param al - adjacency list representing the airport network (directed graph)
     * @return 2D array where edges[i] = [incoming_count, outgoing_count] for airport i
     * 
     * STEP-BY-STEP EXAMPLE for Airport 0:
     * 1. Count outgoing routes: Airport 0 → 1, 0 → 2, 0 → 3 = 3 outgoing
     * 2. Count incoming routes: 1 → 0, 2 → 0, 3 → 0 = 3 incoming
     * 3. Store in edges[0] = [3, 3]
     */
    public static int[][] netWorkCheck(Edge[] al){
        // Create result array: rows = number of airports, columns = [incoming, outgoing]
        int[][] edges = new int[al.length][2];
        
        // Process each airport
        for (int i = 0; i < al.length; i++) {
            int incoming = 0;      // Counter for incoming routes to airport i
            int outgoing = 0;      // Counter for outgoing routes from airport i
            
            // COUNT OUTGOING ROUTES FROM AIRPORT i
            // Traverse the linked list of edges starting from airport i
            Edge temp = al[i];
            while (temp!=null) {
                outgoing++;  // Each edge in the list is an outgoing route
                temp = temp.next;
            }
            
            // COUNT INCOMING ROUTES TO AIRPORT i
            // Check all other airports to see if they have a route to airport i
            for (int j = 0; j < al.length; j++) {
                if (j==i) {
                    continue;  // Skip checking airport i itself
                }
                
                // Traverse the edge list of airport j
                Edge temp1 = al[j];
                while (temp1!=null) {
                    // If an edge from j points to i (temp1.value == i), it's an incoming route
                    if(temp1.value==i){
                        incoming++;  // Count this incoming route to airport i
                    }
                    temp1 = temp1.next;
                }
            }
            
            // Store the results for airport i
            edges[i][0] = incoming;      // Incoming connections
            edges[i][1] = outgoing;      // Outgoing connections
        }
        
        return edges;
    }
}
