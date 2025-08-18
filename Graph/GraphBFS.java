package Graph;
//lever order traversal for graph

import java.util.LinkedList;
import java.util.Queue;

//best for unweighted shortes path
// uses a queue
//keep track of visited node to avoid cycle

public class GraphBFS {

    public static void bfs(int n, int src, GraphList g) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        visited[src] = true;
        q.add(src);

        System.out.println("bfs starts...");
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int l : g.neighbour(node)) {
                if (!visited[l]) {
                    visited[l] = true;
                    q.add(l);
                }
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int n = 5;
        GraphList g = new GraphList(n);

        g.addEdge(0, 1, false);
        g.addEdge(1, 2, false);
        g.addEdge(2, 3, false);
        g.addEdge(3, 4, false);
        g.addEdge(1, 4, false);

        g.display();
        System.out.println();

        bfs(n, 0, g);
    }
}
