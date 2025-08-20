package Graph;

//dfs with recursion stack
//back edge to active node= cycle(edge that goes from a node back to one of its ancestors in the DFS tree)
//during dfs you hit the node that is alreade present in recursion stack
// make two array visited[], inStack[]
// if inStack[]==true mean back edge=cycle

// instead of using two separate visited arrays (visitedd[] for general DFS and inStack[] for cycle detection), you can combine them into a single visited[] array with three states:
// 0: Not visited
// 1: In progress (currently in DFS recursion stack)
// 2: Fully processed

//recursion backtrack

public class CycleDirected {

    public static boolean isCycle(int src, boolean[] visited, boolean[] inStack, GraphList g) {
        visited[src] = true;
        inStack[src] = true;
        for (int k : g.neighbour(src)) {
            if (!visited[k] && isCycle(k, visited, inStack, g)) {
                return true;
            } else if (inStack[k]) // back edge
                return true;
        }
        inStack[src] = false; // backtrack
        return false;
    }

    public static void main(String[] args) {
        int n = 6;
        GraphList g = new GraphList(n);

        g.addEdge(5, 0, true);
        g.addEdge(5, 2, true);
        g.addEdge(4, 0, true);
        g.addEdge(4, 1, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 1, true);

        g.display();

        boolean[] visited = new boolean[n];
        boolean[] inStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                if (isCycle(i, visited, inStack, g)) {
                    System.out.println("is Cycle");
                } else {
                    System.out.println("No cycle");
                }
            }
        }
    }
}
