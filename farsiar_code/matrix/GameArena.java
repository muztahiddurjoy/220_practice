package farsiar_code.matrix;


public class GameArena {

    private static boolean isTwo(int[][] arena, int r, int c) {
        int row = arena.length;
        int col = arena[0].length;
        if ((r<0||r>=row)||(c< 0||c >= col)) {
            return false;
        }
        return arena[r][c] == 2;
    }

    public static String gameArena(int[][] arena) {
        int row=arena.length;
        int col=arena[0].length;
        int points=0;

        for (int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (arena[i][j]>0&&arena[i][j]%50==0) {
                    if(isTwo(arena,i-1,j)){
                        points+=2;
                    }
                    if(isTwo(arena,i+1,j)){
                        points+=2;
                    }
                    if(isTwo(arena,i,j-1)){
                        points+=2;
                    }
                    if(isTwo(arena,i,j+1)){
                        points+=2;
                    }
                }
            }
        }

        if (points>=10) {
            return "Points Gained: "+points+". Your team has survived the game.";
        } else {
            return "Points Gained: "+points+". Your team is out.";
        }
    }

    public static void main(String[] args) {
       
        int[][] arena1 = {
            { 0,  2,  2, 0 },
            { 50, 1,  2, 0 },
            { 2,  2,  2, 0 },
            { 1,  100,2, 0 }
        };

        int[][] arena2 = {
            { 0, 2,   2, 0, 2   },
            { 1, 50,  2, 1, 100 },
            { 2, 2,   2, 0, 2   },
            { 0, 200, 2, 0, 0   }
        };

        System.out.println(gameArena(arena1));   // expect 6, out
        System.out.println(gameArena(arena2));   // expect 14, survived
    }
}