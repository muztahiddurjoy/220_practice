package graph.final_questions;

public class MutualFriends {
    public static void main(String[] args) {
        String[] friends = {"Alice", "Harry", "Nimo", "Nimas","Bob","Moana"};
        int[][] am = 
        {
            {0,1,1,0,0,0},
            {1,0,1,1,0,0},
            {1,1,0,1,0,0},
            {0,1,1,0,1,0},
            {0,0,0,1,0,1},
            {0,0,0,0,1,0}
        };
        maxMutual(am, friends);
    }

    public static void maxMutual(int[][] g, String[] mapper){
        String user1="";
        String user2="";
        int mutual = 0;
        for (int i = 0; i < mapper.length-1; i++) {
            for (int j = i+1; j < mapper.length; j++) {
                int tempMutual = 0;
                for (int k = 0; k < mapper.length; k++) {
                    if(g[i][k]==1 && g[j][k]==1){
                        tempMutual++;
                    }
                }
                if(tempMutual>mutual){
                    mutual = tempMutual;
                    user1 = mapper[i];
                    user2 = mapper[j];
                }
            }
        }
        System.out.println(user1+ " and "+user2+" has most mutual friends ("+mutual+")");
    }
}
