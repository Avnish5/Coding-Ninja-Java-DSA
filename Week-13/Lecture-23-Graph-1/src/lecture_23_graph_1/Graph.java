package lecture_23_graph_1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

    private static void printDFSHelper(int[][] edges, int sv, boolean[] visited) {

        System.out.println(sv);
        visited[sv]=true;
        int n= edges.length;

        for(int i=0;i<n;i++)
        {
            if(edges[sv][i]==1&&!visited[i])
            {
                printDFSHelper(edges,i,visited);
            }
        }

    }
    public static void printDFS(int[][] edges)
    {
        int n= edges.length;
        boolean[] visited=new boolean[n];

        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                printDFSHelper(edges,i,visited);
            }
        }
    }

    private static void printBFSHelper(int[][] edges, int sv, boolean[] visited)
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(sv);
        visited[sv]=true;

        while(!q.isEmpty())
        {
            int front=q.poll();
            System.out.print(front+" ");

            for(int i=0;i< edges.length;i++)
            {
                if(edges[front][i]==1&&!visited[i])
                {
                    q.add(i);
                    visited[front]=true;
                }
            }
        }
    }
    public static void printBFS(int[][] edges)
    {
        int n= edges.length;
        boolean[] visited=new boolean[n];

        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                printDFSHelper(edges,i,visited);
            }
        }
    }



    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int e=s.nextInt();

        int[][] edges=new int[n][n];

        for(int i=0;i<e;i++)
        {
            int fv=s.nextInt();
            int sv=s.nextInt();

            edges[fv][sv]=1;
            edges[sv][fv]=1;
        }

        printBFS(edges);

    }
}
