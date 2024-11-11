package lecture_24_graph_2;

import java.util.*;

public class Dijkastra_Algo {

    // Edge class to represent an edge between two vertices with a weight
    static class Edge {
        int dest;
        int weight;

        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    // Dijkstra's algorithm to find the shortest distance from source (vertex 0)
    public static void dijkstraAlgo(int V, List<List<Edge>> graph) {
        // Distance array to store the shortest distance from the source (vertex 0)
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // Distance to the source itself is 0

        // Min-heap (priority queue) to select the node with the minimum distance
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{0, 0}); // Start with the source node (vertex 0) with distance 0

        while (!pq.isEmpty()) {
            // Get the vertex with the minimum distance
            int[] current = pq.poll();
            int u = current[0]; // Node
            int currentDist = current[1]; // Current distance to the node

            // If the current distance is already greater than the shortest distance to u, skip it
            if (currentDist > dist[u]) continue;

            // Process all the neighbors of node u
            for (Edge e : graph.get(u)) {
                int v = e.dest;  // Neighbor vertex
                int weight = e.weight;  // Weight of the edge

                // If a shorter path to v is found, update dist[v] and add it to the priority queue
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{v, dist[v]});  // Add the neighbor v with its new distance
                }
            }
        }

        // Output the shortest distances from vertex 0 to all other vertices
        for (int i = 0; i < V; i++) {
            System.out.println(i + " " + dist[i]);
        }
    }

    // Main function to input the graph and call Dijkstra's algorithm
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();  // Number of vertices
        int E = s.nextInt();  // Number of edges

        // Initialize the graph as an adjacency list
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Read the edges and populate the graph (undirected graph)
        for (int i = 0; i < E; i++) {
            int u = s.nextInt();
            int v = s.nextInt();
            int w = s.nextInt();
            graph.get(u).add(new Edge(v, w));
            graph.get(v).add(new Edge(u, w));  // Since the graph is undirected
        }

        // Run Dijkstra's algorithm to find the shortest paths from vertex 0
        dijkstraAlgo(V, graph);
    }
}
