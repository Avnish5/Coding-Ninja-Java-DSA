package lecture_23_graph_1;

import java.util.*;

public class Graph {

    public static void printHelper(int edges[][],int sv,boolean visited[])
    {
        System.out.println(sv);
        visited[sv]=true;
        int n=edges.length;

        for(int i=0;i<n;i++)
        {
            if(edges[sv][i]==1&&!visited[i])
            {
                printHelper(edges,i,visited);
            }
        }
    }
    public static void print(int edges[][])
    {
        boolean visited[]=new boolean[edges.length];
        for(int i=0;i<edges.length;i++)
        {
            if(!visited[i])
            {
                printHelper(edges,i,visited);
            }
        }
    }

    public static void printBFSHelper(int edges[][],int sv,boolean visited[])
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(sv);
        int n=edges.length;

        visited[sv]=true;

        while(!q.isEmpty())
        {
            int front=q.poll();



             System.out.println(front);


            for(int i=0;i<n;i++)
            {
                if(edges[front][i]==1 && !visited[i] )
                {
                    q.add(i);
                    visited[i]=true;
                }
            }
        }
    }

    public static void printBFS(int edges[][])
    {
        boolean visited[]=new boolean[edges.length];
        for(int i=0;i<edges.length;i++)
        {
            if(!visited[i])
            {
                printBFSHelper(edges,i,visited);
            }
        }
    }

    public static void getPath(int edges[][],int start,int end)
    {
        boolean visited[]=new boolean[edges.length];
        Queue<Integer> q=new LinkedList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        hm.put(start,null);
        q.add(start);
        visited[start]=true;

        while(!q.isEmpty())
        {
            int front=q.poll();
            if(front==end)
            {
               break;
            }

            for(int i=0;i<edges.length;i++)
            {
                if(edges[front][i]==1&&!visited[i])
                {
                    q.add(i);
                    visited[i]=true;
                    hm.put(i,front);

                }
            }

        }

        List<Integer> path = new ArrayList<>();
        for (Integer at = end; at != null; at = hm.get(at)) {
            path.add(at);
        }


        // Print the path
        for (int node : path) {
            System.out.print(node + " ");
        }
    }
    public static void main(String[] args) {

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
        getPath(edges,start,end);

    }
}
