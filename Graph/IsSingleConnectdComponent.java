package Graph;

public class IsSingleConnectdComponent {
    public static void dfs(int src, GraphList g, boolean[] visited) {
        visited[src] = true;

        for (int l : g.neighbour(src)) {
            if (!visited[l]) {
                dfs(l, g, visited);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        GraphList g = new GraphList(n);

        g.addEdge(0, 1, false);
        g.addEdge(1, 2, false);
        g.addEdge(2, 3, false);

        boolean[] visited = new boolean[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, g, visited); // or bfs(i,visited)
                count++;
            }
            if (count > 1)
                break;
        }

        System.out.println(count);
        if (count == 1) {
            System.out.println("yeah");
        } else {
            System.out.println("Nope");
        }
    }
}
