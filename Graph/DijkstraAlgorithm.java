package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//used to find sortest path of all node from the source for non negative weight

//use priority queue
// Maintain a distance array dist[] where dist[v] = minimum distance from source → v.
// Initially, dist[source] = 0, and all others are ∞.
// Use a PriorityQueue (min-heap) to always pick the node with the smallest distance.
// Relax all edges of the picked node:
// If dist[u] + weight(u,v) < dist[v], update dist[v].

//always choose the current smallest distance

class Pair {
    int node;
    int weight;

    public Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

}

public class DijkstraAlgorithm {

    public static void dijkstra(int src, int n, List<List<Pair>> list) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // min heap based on distance for shortest path
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;
            int d = curr.weight;

            if (d > dist[u])
                continue; // skip outdated entries

            for (Pair key : list.get(u)) {
                int v = key.node;
                int w = key.weight;
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.add(new Pair(v, dist[v]));
                }
            }
        }

        // print the all the sortest distances
        System.out.println("Shortest distance from the " + src + " is:");
        for (int i = 0; i < n; i++) {
            System.out.println(i + " -> " + dist[i]);
        }
    }

    public static void main(String[] args) {
        List<List<Pair>> list = new ArrayList<>();

        int n = 5;

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        // add u v w
        list.get(0).add(new Pair(1, 2));
        list.get(0).add(new Pair(2, 4));
        list.get(1).add(new Pair(2, 1));
        list.get(1).add(new Pair(3, 7));
        list.get(2).add(new Pair(4, 3));
        list.get(3).add(new Pair(4, 1));

        dijkstra(0, n, list);
    }
}
