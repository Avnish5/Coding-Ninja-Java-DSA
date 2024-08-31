package lecture_23_graph_1;
import java.util.ArrayList;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
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

    public static ArrayList<Integer> findPath(int edges[][],int start,int end,boolean visited[])
    {
        if(start==end)
        {
            ArrayList<Integer> ans=new ArrayList<>();
            ans.add(end);

            return ans;
        }

        visited[start]=true;
        for(int i=0;i<edges.length;i++)
        {
            if(edges[start][i]==1&& !visited[i])
            {
                ArrayList<Integer> ans=findPath(edges,i,end,visited);
                if(ans!=null)
                {
                    ans.add(start);
                    return ans;
                }

            }
        }

        return null;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {

        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int e=s.nextInt();

        int edges[][]=new int[n][n];

        for(int i=0;i<e;i++)
        {
            int fv=s.nextInt();
            int sv=s.nextInt();
            edges[fv][sv]=1;
            edges[sv][fv]=1;
        }

        boolean visited[]=new boolean[n];

        int start=s.nextInt();
        int end=s.nextInt();

        ArrayList<Integer> ans=findPath(edges,start,end,visited);

        if(ans!=null)
        {
            for(int i:ans)
            {
                System.out.print(i+" ");
            }
        }

    }
}