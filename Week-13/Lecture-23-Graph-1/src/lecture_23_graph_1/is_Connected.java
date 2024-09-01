package lecture_23_graph_1;
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
public class is_Connected {

    public static void isConnectedHelper(int edges[][],boolean visited[],int s)
    {  if(edges.length<=0) return;
        visited[s]=true;

        for(int i=0;i<edges.length;i++)
        {
            if(edges[s][i]==1&&!visited[i])
            {
                isConnectedHelper(edges, visited, i);
            }
        }
    }

    public static void isConnected(int edges[][])
    {
        boolean visited[]=new boolean[edges.length];
        isConnectedHelper(edges, visited, 0);

        for(int i=0;i<edges.length;i++)
        {
            if(!visited[i])
            {
                System.out.print(false);
                return;
            }
        }
        System.out.print(true);
    }
}
