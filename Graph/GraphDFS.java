package Graph;

import java.util.Stack;

//go deep along a path until not neighbour then backtrack
//using call stack recursion
//best for detecting cycle, connected componets, topological sort

//Iterative DFS may give different order than recursive because stack processes neighbors in LIFO order. Both are valid.
public class GraphDFS {

    public static void dfsRecursion(int src, GraphList g, boolean[] visited) {
        visited[src] = true;
        System.out.print(src + " ");
        for (int l : g.neighbour(src)) {
            if (!visited[l]) {
                dfsRecursion(l, g, visited);
            }
        }
    }

    // using explicit stack, more controll
    public static void dfsIterative(int src, int n, GraphList g) {
        boolean[] visited = new boolean[n];
        Stack<Integer> s = new Stack<>();
        s.push(src);

        System.out.println("DFS begin iterative...");
        while (!s.isEmpty()) {
            int node = s.pop();
            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");
                for (int l : g.neighbour(node)) {
                    if (!visited[l]) {
                        s.push(l);
                    }
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

        boolean[] visited = new boolean[n];

        dfsRecursion(0, g, visited);
        System.out.println();

        dfsIterative(0, n, g);
    }
}
