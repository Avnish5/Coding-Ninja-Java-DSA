package lecture_23_graph_1;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
Problem statement
Given an undirected graph G(V,E), find and print all the connected components of the given graph G.

Note:

1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
2. E is the number of edges present in graph G.
3. You need to take input in main and create a function which should return all the connected components. And then print them in the main, not inside function.
Print different components in new line. And each component should be printed in increasing order (separated by space). Order of different components doesn't matter.

Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Sample Input 1:
4 2
0 1
2 3
Sample Output 1:
0 1
2 3
Sample Input 2:
4 3
0 1
1 3
0 3
Sample Output 2:
0 1 3
2
 */
public class All_Connected_Components {

    private static ArrayList<Integer> allConnectedComponents(int[][] edges,boolean[] visited,int sv,ArrayList<Integer> list){
       visited[sv]=true;
       list.add(sv);

       for(int i=0;i<edges.length;i++)
       {
           if(edges[sv][i]==1&&!visited[i])
           {
               allConnectedComponents(edges,visited,i,list);
           }
       }

       return list;
    }
    private static ArrayList<ArrayList<Integer>> allConnectedComponents(int[][] edges) {
        int n=edges.length;
        boolean[] visited=new boolean[n];
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                ArrayList<Integer> smallAns=new ArrayList<>();
                allConnectedComponents(edges,visited,i,smallAns);
                Collections.sort(smallAns);
                ans.add(smallAns);
            }
        }
     return ans;
    }
    public static void main(String[] args) {
        int n;
        int e;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        e = s.nextInt();
        int[][] edges = new int[n][n];

        for (int i = 0; i < e; i++) {
            int fv = s.nextInt();
            int sv = s.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }

        ArrayList<ArrayList<Integer>> ans=allConnectedComponents(edges);

        for(ArrayList<Integer> list:ans)
        {
            for(int num:list)
            {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }


}
