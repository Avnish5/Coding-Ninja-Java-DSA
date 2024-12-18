package lecture_23_graph_1;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Graph {

    public static void printBFSHelper(int[][] edges,boolean[] visited,int sv){

        Queue<Integer> q=new LinkedList<>();
        q.add(sv);
        int n=edges.length;

        while(!q.isEmpty())
        {
            int top=q.poll();
            visited[top]=true;
            System.out.println(top);


            for(int i=0;i<n;i++){
                if(edges[top][i]==1&&!visited[i])
                {
                    q.add(i);

                }

            }


        }

    }
    public static void printBFS(int[][] edges){
        boolean[] visited=new boolean[edges.length];
        for(int i=0;i<edges.length;i++)
        {
            if(!visited[i])
            {
                printBFSHelper(edges,visited,i);
            }
        }
    }

    public static void main(String[] args) {
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

        printBFS(edges);
    }
}
