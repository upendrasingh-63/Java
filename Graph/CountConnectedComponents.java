package Graph;

//it is a set of vertices where each pair can react by some path

//in undirected graph, running bfs and dfs for a node will find all the reachable nodes in that component
//to find connected components, we can run bfs/dfs for each unvisited node and count how many times we had to do that

// In directed graphs, it’s called Strongly Connected Components (SCCs) (Kosaraju’s / Tarjan’s algo is used).

//Maintain visited[].
//For each node u, if not visited → start DFS/BFS → that’s one component.
//Count components.

public class CountConnectedComponents {

    public static void dfs(int src, GraphList g, boolean[] visited) {
        visited[src] = true;

        for (int l : g.neighbour(src)) {
            if (!visited[l]) {
                dfs(l, g, visited);
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        GraphList g = new GraphList(n);

        g.addEdge(0, 1, false);
        g.addEdge(1, 2, false);
        g.addEdge(3, 4, false);

        boolean[] visited = new boolean[n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, g, visited); // or bfs(i,visited)
                count++;
            }
        }

        System.out.println(count);
    }
}
