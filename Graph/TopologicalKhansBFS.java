package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//count indgree of nodes
//put all node with indgree =0 in quere
// remove the node from queue and reduce indgree or its neighbouot
// if neighbour indgreee =0 put them in quere
//the order in which we are removing from queue in topological
//u - v
//if u is independent mean indgree 0 then first remove it

public class TopologicalKhansBFS {

    public static List<Integer> bfs(int n, GraphList g) {
        int[] indgree = new int[n];
        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int key : g.neighbour(i)) {
                indgree[key]++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (indgree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            list.add(u);
            for (int k : g.neighbour(u)) {
                indgree[k]--;
                if (indgree[k] == 0) {
                    q.add(k);
                }
            }
        }

        if (list.size() != n) {// if list size less then n then cycle detected
            return new ArrayList<>();
        }

        return list;

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

        List<Integer> list = bfs(n, g);

        if (list.isEmpty()) {
            System.out.println("Cycyle detected");
        } else {
            System.out.println("Topological" + list);
        }

    }
}

// Alien Dictionary