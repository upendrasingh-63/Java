package Graph;

public class LargestComponentSize {
    public static int dfs(int src, GraphList g, boolean[] visited) {
        visited[src] = true;
        int size = 1;
        for (int l : g.neighbour(src)) {
            if (!visited[l]) {
                size += dfs(l, g, visited);
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int n = 5;
        GraphList g = new GraphList(n);

        g.addEdge(0, 1, false);
        g.addEdge(1, 2, false);
        g.addEdge(3, 4, false);

        boolean[] visited = new boolean[n];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int size = dfs(i, g, visited); // or bfs(i,visited)
                ans = Math.max(size, ans);
            }
        }
        System.out.println(ans);
    }
}
