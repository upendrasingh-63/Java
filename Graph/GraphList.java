package Graph;

import java.util.ArrayList;
import java.util.List;

//for each vertex u, store its neighbour in list
//great for sparsh graphs --- E<<V^2

//space complexity: O(V+U)
//iterate neighbour of u: O(deg(u))  fast
// check if (u,v) exits:O(deg(u))  slower than matrix
//add edge:O(1) amortized
// remove edge:O(deg(u)) 
//when we are storing extra metadata with edges, this is the best choice

public class GraphList {
    private final int n;
    private final List<List<Integer>> adj;

    // initialized
    public GraphList(int n) {
        this.n = n;
        adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // add edges directed=true for directed graph else false for undirected
    public void addEdge(int u, int v, boolean directed) {
        adj.get(u).add(v);
        if (!directed) {
            adj.get(v).add(u);
        }
    }

    // remove edge
    public void removeEdge(int u, int v) {
        adj.get(u).remove(v);
        adj.get(v).remove(u);
    }

    // graph display
    public void display() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + " -> ");
            for (int nei : adj.get(i)) {
                System.out.print(nei + " ");
            }
            System.out.println();
        }
    }

    public List<Integer> neighbour(int u) {
        return adj.get(u);
    }

    public int size() {
        return n;
    }

}
