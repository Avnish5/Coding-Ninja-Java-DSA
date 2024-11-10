package adj_list_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {

    List<List<Integer>> adjList;

    Graph(int vertices)
    {
        adjList=new ArrayList<>();
        for(int i=0;i<vertices;i++)
        {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src,int des)
    {
        if (src >= adjList.size() || des >= adjList.size() || src < 0 || des < 0) {
            System.out.println("Invalid edge: " + src + " -> " + des);
            return;
        }

        adjList.get(src).add(des);
        adjList.get(des).add(src);
    }

    public void print(){
        for(int i=0;i<adjList.size();i++)
        {
            System.out.print("Vertex "+i+" :");
            for(int neighbour:adjList.get(i)){
                System.out.print(neighbour+",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g=new Graph(7);
        int n;
        Scanner s=new Scanner(System.in);
        n=s.nextInt();

        for(int i=0;i<n;i++)
        {
            int src=s.nextInt();
            int des=s.nextInt();
            g.addEdge(src,des);
        }

        g.print();

    }

}
