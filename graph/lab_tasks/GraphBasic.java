package graph.lab_tasks;

public class GraphBasic{
     public static class edgeN{
        int u ; int v; int w ; edgeN next;
        edgeN(int point2, int weight){
            v = point2;
            w = weight;
            next = null;
        }
        edgeN(int point1 , int point2, int weight){
            u = point1;
            v = point2;
            w = weight;
            next = null;
        }
      }
     public static  void addEdgeList(edgeN [] arr , int n, int v, int w){
       edgeN temp = new edgeN(v,w);
    //    if(arr[n]==null){
    //     arr[n] = temp;
    //    }
    //    else {
        edgeN head = arr[n];
        temp.next = head;
        head = temp;
        arr[n] = head;
    //    }
     }
     public static void addEdgeMat(int [][] arr,int n,int v, int w){  
            arr[n][v] = w;
            arr[v][n] = w;
       }
     static void printMatGraph(int [][]arr, int n){
       for(int i = 1;i<= n ; i++){
        System.out.print( i + " : ");
        for(int j = 1;j<= n ;j++){
          if(arr[i][j]!=0){
            System.out.print( j + "  ");
          }
        }

       System.out.println();
       }
     }
     static void printListGraph(edgeN [] arr, int n ,int e){
       for(int i = 1;i<= n ; i++){
        System.out.print(i +  " :  ");
         edgeN temp = arr[i];
         while(temp!=null){
            System.out.print(temp.v + " weight: " + temp.w+"->");
            temp = temp.next;
         }
         System.out.println();
       }
     } 
       static int maxdegree(int [][] ajdm, int num){
        int max = Integer.MIN_VALUE;
         int maxVertex = 0;
        for(int i = 1;i <= num; i++ ){
          int count = 0;
         
         for(int j = 1;j <= num ; j++){
            if(ajdm[i][j] !=0){
                count++;
            }
         }
          if(count>max){
            maxVertex = i; 
            max = count;
          }  
         }
     System.out.println(maxVertex);
        return max;
     }


// public static void maxSum(ADJList , num) {
// int n = num ;
// int max = Integer.MINVALUE;
// for(int i = 1 ; i < = n ; i++){
// int sum = 0;
// edgeNode track ; 
// edgeNode curr = ADJList[i];
// while(curr!=null){
// sum+=curr.v;
//  curr = curr.next;
//  }
// if(sum>max){
// max = sum;
// track = ADJList[i];
//         }
//     }
// }

static void maxWeight(int[][] arr){
    int maxSum = Integer.MIN_VALUE;
    int vertex = -1;

    for (int i = 1; i<arr.length; i++) {
        int temp = 0;
        for (int j = 0; j < arr.length; j++) {
            temp+=arr[i][j];
        }
        if(temp>maxSum){
            maxSum=temp;
            vertex = i;
        }
    }

        System.out.println("Maximum sum: "+maxSum);
        System.out.println("vertex "+vertex);
}

     static int maxdegree(edgeN [] adjL, int num){
        int max = Integer.MIN_VALUE;
         int maxVertex  = 0;
        for(int i = 1;i <= num; i++ ){
          int count = 0;
         
          edgeN curr = adjL[i];
          while(curr!=null){
            count++;
            curr = curr.next;
            }    
          if(count>max){
            maxVertex = i;
            max = count;
          }  
         }
 System.out.println(maxVertex);
        return max;
     }
    public static void main(String [] args){
       int num = 7;
       int edges = 12;
       int [][] adjm = new int [num+1] [num+1];
       edgeN [] adjL = new edgeN[num + 1];
      System.out.println("Making the adjacency list graph : ");
      int[][] edgeData = {
     {1, 2, 2},
     {1, 3, 3},
     {1, 4, 4},
     {2, 3, 5},
     {2, 6, 6},
     {2, 5, 7},
     {3, 4, 8},
     {3, 6, 9},
     {3, 7, 10},
     {4, 7, 11},
     {5, 6, 12},
     {6, 7, 13}
};
     for (int i = 0; i < edges; i++) {
       int u = edgeData[i][0];
       int v = edgeData[i][1];
       int w = edgeData[i][2];
      addEdgeList(adjL, u, v, w);
      addEdgeList(adjL, v, u, w);
        addEdgeMat(adjm,u,v, w);
           }
      System.out.println("========== Task 0b: Adjacency List Representation ==========");
printListGraph(adjL, num, edges);

System.out.println();

System.out.println("========== Task 1b: Maximum Degree using Adjacency List ==========");
int listMaxDegree = maxdegree(adjL, num);
System.out.println("Maximum degree = " + listMaxDegree);

System.out.println();

System.out.println("========== Task 0a: Adjacency Matrix Representation ==========");
printMatGraph(adjm, num);

System.out.println();

System.out.println("========== Task 1a: Maximum Degree using Adjacency Matrix ==========");
int matrixMaxDegree = maxdegree(adjm, num);
System.out.println("Maximum degree = " + matrixMaxDegree);
System.out.println("=====================================================================");
maxWeight(adjm);
        }
    }