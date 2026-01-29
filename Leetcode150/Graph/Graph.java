package Leetcode150.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {
    HashMap<Integer, List<Integer>> graph;

    Graph(int n) {
        graph = new HashMap<>(5);
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    public void removeEdge(int u, int v) {
        graph.get(u).remove(v);
        graph.get(v).remove(u);
    }

    public void display() {
        for (int u : graph.keySet()) {
            System.out.println(u + "->");
            for (int v : graph.get(u)) {
                System.out.println(v + " ");
            }
            System.out.println();
        }
    }
}
