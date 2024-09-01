package lecture_23_graph_1;

import java.util.*;

/*
Problem statement
Given an undirected graph G(V, E) and two vertices v1 and v2 (as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.

Find the path using BFS and print the shortest path available.

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
Sample Input 1 :
4 4
0 1
0 3
1 2
2 3
1 3
Sample Output 1 :
3 0 1
Sample Input 2 :
6 3
5 3
0 1
3 4
0 3
Sample Output 2 :

 */
public class Get_Path_BFS {

    public static void getPath(int edges[][], int start, int end) {
        boolean[] visited = new boolean[edges.length];
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> predecessors = new HashMap<>();
        boolean flag =false;


        q.add(start);
        visited[start] = true;
        predecessors.put(start, null);

        while (!q.isEmpty()) {
            int front = q.poll();

            if (front == end) {

                flag=true;
                break;
            }

            for (int i = 0; i < edges.length; i++) {
                if (edges[front][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    predecessors.put(i, front);
                }
            }
        }

        if(!flag) return;

        List<Integer> path = new ArrayList<>();
        for (Integer at = end; at != null; at = predecessors.get(at)) {
            path.add(at);
        }

        for (int node : path) {
            System.out.print(node + " ");
        }
    }
}
