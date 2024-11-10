package lecture_24_graph_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Kruskals_Algorithm {

    ArrayList<Edge> edges;
    int vertices;
    int[] parent;
    int[] rank;  // Array to store the rank of each node

    Kruskals_Algorithm(int n) {
        this.vertices = n;
        edges = new ArrayList<>();
        parent = new int[n];
        rank = new int[n];  // Initialize the rank array

        // Initially, each node is its own parent, and the rank is 0
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;  // Initial rank is 0 for all nodes
        }
    }

    // Find with path compression
    public int findParent(int i) {
        if (parent[i] != i) {
            parent[i] = findParent(parent[i]);  // Path compression
        }
        return parent[i];
    }

    // Union by rank
    public void union(int x, int y) {
        int xRoot = findParent(x);
        int yRoot = findParent(y);

        if (xRoot != yRoot) {
            // Union by rank: Attach the smaller tree under the larger tree
            if (rank[xRoot] < rank[yRoot]) {
                parent[xRoot] = yRoot;
            } else if (rank[xRoot] > rank[yRoot]) {
                parent[yRoot] = xRoot;
            } else {
                // If ranks are the same, we can attach one to the other and increase the rank
                parent[xRoot] = yRoot;
                rank[yRoot]++;  // Increment rank
            }
        }
    }

    // Get the Minimum Spanning Tree (MST)
    public ArrayList<Edge> getMST() {
        Collections.sort(this.edges);  // Sort edges by weight

        int count = 0;
        int i = 0;
        ArrayList<Edge> output = new ArrayList<>();

        while (count != this.vertices - 1) {
            Edge currentEdge = edges.get(i);
            int src = currentEdge.src;
            int des = currentEdge.des;

            int srcParent = findParent(src);
            int desParent = findParent(des);

            // If the two vertices are not in the same set, include this edge in the MST
            if (srcParent != desParent) {
                output.add(currentEdge);
                count++;
                union(srcParent, desParent);  // Perform union
            }

            i++;
        }

        return output;
    }

    // Print the edges in the MST
    public void printMST(ArrayList<Edge> output) {
        for (int j = 0; j < this.vertices - 1; j++) {
            if (output.get(j).src < output.get(j).des) {
                System.out.println(output.get(j).src + "  " + output.get(j).des + "  " + output.get(j).weight);
            } else {
                System.out.println(output.get(j).des + "  " + output.get(j).src + "  " + output.get(j).weight);
            }
        }
    }

    public static void main(String[] args) {
        int n, e;
        Scanner s = new Scanner(System.in);

        // Read number of vertices and edges
        n = s.nextInt();
        e = s.nextInt();

        // Create an instance of Kruskals_Algorithm
        Kruskals_Algorithm k = new Kruskals_Algorithm(n);

        // Read the edges (src, des, weight) and add them to the edge list
        for (int i = 0; i < e; i++) {
            int src = s.nextInt();
            int des = s.nextInt();
            int weight = s.nextInt();
            k.edges.add(new Edge(src, des, weight));
        }

        // Get the Minimum Spanning Tree (MST)
        ArrayList<Edge> output = k.getMST();

        // Print the MST
        k.printMST(output);
    }
}
