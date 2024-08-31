package lecture_23_graph_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
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
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/*
when a valid path is found in the recursive call.
This ensures that once a path is found,
the function exits early without checking unnecessary further paths.
*/


public class Has_Path {

    public static boolean check(int edges[][],int start,int end,boolean visited[])
    {
        if(start>=edges.length || end>=edges.length || start<0 || end<0  ) return false;
        if(start==end) return true;
        if(edges[start][end]==1) return true;
        visited[start]=true;
        for(int i=0;i<edges.length;i++)
        {
             if(edges[start][i]==1&&!visited[i])
             {
             	 if(check(edges, i, end,visited)){
             		 return true;
             	 }
             }
//            if(edges[start][i]==1&&!visited[i])
//                return check(edges, i, end, visited);
        }

        return false;
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

        int start=s.nextInt();
        int end=s.nextInt();



        boolean visited[]=new boolean[n];
        boolean ans=check(edges,start,end,visited);
        System.out.print(ans);

    }

}
