package graph.lab_tasks;

public class Ungraded {
    public static void main(String[] args) {
        EdgeNode[] al = new EdgeNode[11];
        Integer[] powers = {null,500,1400,900,300,80,450,650,2000,650,-1};
        Task1b.createEdge(al, 1, 4, 400);
        Task1b.createEdge(al, 2, 5, 250);
        Task1b.createEdge(al, 3, 6, 300);
        Task1b.createEdge(al, 4, 7, 650);
        Task1b.createEdge(al, 5, 6, 550);
        Task1b.createEdge(al, 6, 7, 50);
        Task1b.createEdge(al, 6, 9, 200);
        Task1b.createEdge(al, 7, 8, 10);
        Task1b.createEdge(al, 8, 10, 25);
        Task1b.createEdge(al, 9, 10, 600);

        laughTale(powers, al, 2, 7000, 1, 3000);   
    }

    public static void laughTale(Integer[] warlods, EdgeNode[] adjL, int sSt, int sP, int lSp, int lP){
        //for shank
        EdgeNode shank = adjL[sSt];
        EdgeNode luffy = adjL[lSp];
        sP-=warlods[sSt];
        lP-=warlods[lSp];
        while(sSt!=10 && lSp!=10){
            //Shank part
                if(sP>0){
                EdgeNode lowestEdgeNodeShank = shank;
                EdgeNode tempShank = shank;
                while(tempShank!=null){
                     if((tempShank.weight+warlods[sSt])<(lowestEdgeNodeShank.weight+warlods[tempShank.value])){
                        lowestEdgeNodeShank = tempShank;
                     }          
                     tempShank = tempShank.next;
                }
                shank = adjL[lowestEdgeNodeShank.value];
                sSt = lowestEdgeNodeShank.value;
                sP-=(warlods[sSt]+lowestEdgeNodeShank.weight);
            }
            //Luffy Part
            if(lP>0){
                 EdgeNode lowestEdgeNodeLuffy = luffy;
                EdgeNode tempShank = luffy;
                while(tempShank!=null){
                     if((tempShank.weight+warlods[lSp])<(lowestEdgeNodeLuffy.weight+warlods[tempShank.value])){
                        lowestEdgeNodeLuffy = tempShank;
                     }          
                     tempShank = tempShank.next;
                }
                luffy = adjL[lowestEdgeNodeLuffy.value];
                lSp = lowestEdgeNodeLuffy.value;
                lP-=(warlods[lSp]+lowestEdgeNodeLuffy.weight);
            }
        }
        if(sSt==10 && lSp == 10){
            System.out.println("Both won");
            return;
        }
        if(sSt==10){
            System.out.println("Shank won!");
        }
        else if(lSp==10){
            System.out.println("Luffy won");
        }
        else{
            System.out.println("no one won");
        }
    }
}
