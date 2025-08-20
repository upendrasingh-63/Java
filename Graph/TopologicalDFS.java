package Graph;

import java.util.Stack;

//using dfs

//directed asyclic graph DAG a linear ordering of its vertices such that for every directed edge u → v, node u appears before node v in the ordering.

//when it exits
//only in  DAG, not in cyclic graph

//concept
//do dfs traversal
//after vising all the neighbouring node of vertex push it into stack
//print stack it will give topological order

public class TopologicalDFS {

    public static void dfs(int i, GraphList g, boolean[] visited, Stack<Integer> stack) {
        visited[i] = true;

        for (int k : g.neighbour(i)) {
            if (!visited[k]) {
                dfs(k, g, visited, stack);
            }
        }
        stack.push(i);
    }

    public static void main(String[] args) {
        int n = 2;
        GraphList g = new GraphList(n);

        g.addEdge(0, 1, true);
        g.addEdge(1, 0, true);
        // g.addEdge(1, 3, true);
        // g.addEdge(2, 3, true);
        // g.addEdge(2, 3, true);
        // g.addEdge(3, 1, true);

        g.display();

        boolean[] visited = new boolean[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, g, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}

// class Solution {
// public int[] findOrder(int n, int[][] arr) {
// List<List<Integer>> graph = new ArrayList<>();

// for (int i = 0; i < n; i++) {
// graph.add(new ArrayList<>());
// }

// for (int[] edge : arr) {
// graph.get(edge[1]).add(edge[0]); // build the graph
// }

// boolean[] visited = new boolean[n]; // Visited states: 0 = unvisited, 1 =
// visiting, 2 = visited
// Stack<Integer> stack = new Stack<>();

// for (int i = 0; i < n; i++) {
// if (visited[i] == false) {
// if (isCycle(i, graph, visited, stack)) {
// return new int[]{}; // Cycle detected
// }
// }
// }

// // Convert the stack to the result array (topologically sorted order)
// int[] result = new int[stack.size()];
// int idx = 0;
// while (!stack.isEmpty()) {
// result[idx++] = stack.pop();
// }
// return result;
// }

// // DFS-based cycle detection and topological sort
// private boolean isCycle(int node, List<List<Integer>> graph, boolean[]
// visited, Stack<Integer> stack) {
// // If it's in the "visiting" state, it means we've encountered a cycle
// if (visited[node] == 1) {
// return true;
// }

// // Mark as visiting
// visited[node] = 1;

// for (int neighbor : graph.get(node)) {
// if (visited[neighbor] == 0) { // Unvisited
// if (isCycle(neighbor, graph, visited, stack)) {
// return true;
// }
// }
// }

// // After all neighbors processed, mark it as fully visited
// visited[node] = 2;

// // Push the node to the stack (after processing all its neighbors)
// stack.push(node);
// return false;
// }
// }
