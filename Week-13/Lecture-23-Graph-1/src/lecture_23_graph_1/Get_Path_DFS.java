package lecture_23_graph_1;

import java.util.ArrayList;
import java.util.Scanner;

/*
Problem statement
Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.

Find the path using DFS and print the first path that you encountered.

Note:

1. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1.
2. E is the number of edges present in graph G.
3. Print the path in reverse order. That is, print v2 first, then intermediate vertices and v1 at last.
4. Save the input graph in Adjacency Matrix.
Detailed explanation ( Input/output format, Notes, Images )
Constraints :
2 <= V <= 1000
1 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
0 <= v1 <= 2^31 - 1
0 <= v2 <= 2^31 - 1
Time Limit: 1 second
Sample Input 1:
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1:
3 0 1
Sample Input 2:
6 3
5 3
0 1
3 4
0 3
Sample Output 2:
 */
public class Get_Path_DFS {

    public static ArrayList<Integer> getPathDFS(int[][] edgges,boolean[] visited,int sv,int ev)
    {
        if(sv>=edgges.length) return null;
       visited[sv]=true;
        if(sv==ev)
        {
            ArrayList<Integer> list=new ArrayList<>();
            list.add(ev);
            return list;
        }

        for(int i=0;i<edgges.length;i++)
        {
            if(edgges[sv][i]==1&&!visited[i])
            {
                ArrayList<Integer> ans=getPathDFS(edgges,visited,i,ev);
                if(ans!=null)
                {
                    ans.add(sv);
                    return ans;
                }
            }
        }

        return null;
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

        int sk = s.nextInt();
        int ek = s.nextInt();
        boolean[] visited=new boolean[n];
        ArrayList<Integer> ans=getPathDFS(edges,visited,sk,ek);
        if(ans!=null){
            for(int num:ans)
            {
                System.out.print(num+" ");
            }
        }
    }

}
