package lecture_23_graph_1;
import java.util.Scanner;

/*
Problem statement
Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), check if there exists any path between them or not. Print true if the path exists and false otherwise.

Note:

1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
2. E is the number of edges present in graph G.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
0 <= V <= 1000
0 <= E <= 1000
0 <= a <= V - 1
0 <= b <= V - 1
0 <= v1 <= V - 1
0 <= v2 <= V - 1
Time Limit: 1 second
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
true
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :
false
 */
public class Has_Path {
    public static boolean hasPathHelper(int[][] edges,boolean[] visited,int start,int end)
    {
        if(start==end) {
            System.out.println(start+" "+end);
            return true;
        }
        int n=edges.length;
        visited[start]=true;

        for(int i=0;i<n;i++)
        {
            if(edges[start][i]==1&&!visited[i])
            {
                if (hasPathHelper(edges, visited, i, end)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args)  {
        int n;
        int e;
        Scanner s=new Scanner(System.in);
        n=s.nextInt();
        e=s.nextInt();
        int[][] edges=new int[n][n];

        for(int i=0;i<e;i++)
        {
            int fv=s.nextInt();
            int sv=s.nextInt();
            edges[fv][sv]=1;
            edges[sv][fv]=1;
        }

        int sk=s.nextInt();
        int ek=s.nextInt();
        boolean[] visited=new boolean[n];
        boolean ans=hasPathHelper(edges,visited,sk,ek);
        if(ans)
        {
            System.out.print("true");
        }
        else{
            System.out.print("false");
        }

    }
}
