package lecture_24_graph_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prism_Algorithm {
    ArrayList<Edge> edges;
    int vertices;
    int[] weight;
    int[] parent;
    boolean[] visited;
    ArrayList<Edge> output;


    Prism_Algorithm(int n)
    {
        this.vertices=n;
        edges=new ArrayList<>();
        output=new ArrayList<>();
        parent=new int[n];
        weight=new int[n];
        Arrays.fill(parent,-1);
        Arrays.fill(weight,Integer.MAX_VALUE);
        parent[0]=-1;
        weight[0]=0;
        visited=new boolean[n];
    }

    public void getMST(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, start, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.src;

            if (visited[u]) continue;
            visited[u] = true;

            if (parent[u] != -1) {
                output.add(new Edge(parent[u], u, edge.weight));
            }

            for (Edge e : edges) {
                if (e.src == u || e.des == u) {
                    int v = (e.src == u) ? e.des : e.src;

                    if (!visited[v] && weight[v] > e.weight) {
                        weight[v] = e.weight;
                        parent[v] = u;
                        pq.add(new Edge(v, u, e.weight));
                    }
                }
            }
        }
    }

    public void printMST(){
        int totalWeight = 0;
        for (Edge edge : output) {
            System.out.println(edge.src + " - " + edge.des + " : " + edge.weight);
            totalWeight += edge.weight;
        }
        System.out.println("Total Weight of MST: " + totalWeight);
    }

        public static void main (String[]args){
            int n, e;
            Scanner s = new Scanner(System.in);

            // Read number of vertices and edges
            n = s.nextInt();
            e = s.nextInt();

            // Create an instance of Kruskals_Algorithm
            Prism_Algorithm p = new Prism_Algorithm(n);

            // Read the edges (src, des, weight) and add them to the edge list
            for (int i = 0; i < e; i++) {
                int src = s.nextInt();
                int des = s.nextInt();
                int weight = s.nextInt();
                p.edges.add(new Edge(src, des, weight));
            }

            p.getMST(0);
            p.printMST();


        }
    }

