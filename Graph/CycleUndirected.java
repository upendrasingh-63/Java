package Graph;

//dfs with parent check
//visite & not parent cycle

public class CycleUndirected {

    public static boolean isCycle(int src, GraphList g, int parent, boolean[] visited) {
        visited[src] = true;

        for (int k : g.neighbour(src)) {
            if (!visited[k]) {
                if (isCycle(k, g, src, visited))
                    return true;
            } else if (k != parent)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 5;
        GraphList g = new GraphList(n);

        g.addEdge(0, 1, false);
        g.addEdge(1, 2, false);
        g.addEdge(2, 3, false);
        g.addEdge(3, 4, false);
        // g.addEdge(1, 4, false);

        g.display();

        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (isCycle(i, g, -1, visited)) {
                    System.out.println("has Cycle");
                } else {
                    System.out.println("not cycle");
                }
            }
        }
    }
}
