package Graph;

import java.util.ArrayList;
import java.util.List;

public class PrintConnectedComponents {
    public static void dfs(int src, GraphList g, boolean[] visited, List<Integer> list) {
        visited[src] = true;
        list.add(src);

        for (int l : g.neighbour(src)) {
            if (!visited[l]) {
                dfs(l, g, visited, list);
            }
        }
    }

    public static void main(String[] args) {
        int n = 6;
        GraphList g = new GraphList(n);

        g.addEdge(0, 1, false);
        g.addEdge(1, 2, false);
        g.addEdge(2, 3, false);

        boolean[] visited = new boolean[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> list = new ArrayList<>();
                count++;
                dfs(i, g, visited, list); // or bfs(i,visited)
                System.out.println("Component " + count + ": " + list);
            }
        }

        // System.out.println(count);
    }
}
