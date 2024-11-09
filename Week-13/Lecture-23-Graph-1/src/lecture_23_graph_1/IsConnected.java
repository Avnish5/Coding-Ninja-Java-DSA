package lecture_23_graph_1;

import java.util.Scanner;
/*
Problem statement
Given an undirected graph G(V,E), check if the graph G is connected graph or not.

Note:

1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
2. E is the number of edges present in graph G.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Time Limit: 1 second
Sample Input 1:
4 4
0 1
0 3
1 2
2 3
Sample Output 1:
true
Sample Input 2:
4 3
0 1
1 3
0 3
Sample Output 2:
false
Sample Output 2 Explanation
The graph is not connected, even though vertices 0,1 and 3 are connected to each other but there isn’t any path from vertices 0,1,3 to vertex 2.
 */
public class IsConnected {

    public static void isConnected(int[][] edges,boolean[] visited,int sv){
        if(edges.length<=0) return;
        visited[sv]=true;

        for(int i=0;i<edges.length;i++)
        {
            if(edges[sv][i]==1&&!visited[i])
            {
                isConnected(edges,visited,i);
            }
        }
    }

    public static void main(String[] args) throws NumberFormatException{
        int n;
        int e;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        e = s.nextInt();
        int[][] edges = new int[n][n];
        boolean[] visited=new boolean[edges.length];

        for (int i = 0; i < e; i++) {
            int fv = s.nextInt();
            int sv = s.nextInt();
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;
        }

        isConnected(edges, visited, 0);
        for(boolean flag:visited)
        {
            if(!flag)
            {
                System.out.print("false");
                return;
            }
        }
        System.out.print("true");
    }
}
