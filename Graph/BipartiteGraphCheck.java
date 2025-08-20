package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//A bipartite graph G is a graph whose vertex set V can be partitioned into two nonempty subsets A and B (i.e., A ∪ B=V and A ∩ B=Ø) such that each edge of G has one endpoint in A and one endpoint in B. The partition V=A ∪ B is called a bipartition of G. 

//A graph is bipartite if its vertices can be divided into 2 sets such that no two vertices in the same set are adjacent.
//Equivalent to: graph can be 2-colored without conflict.
//Example: Even cycle → bipartite; odd cycle → not bipartite.
//used in matching problems, scheduling,

//approach
//use bfs/dfs with coloring
//assign color[srd]=0;
//for each part (u,v)  color[u]=1-color[v]
//if(color[u]==color[v]) not bipartite

public class BipartiteGraphCheck {

    public static boolean isBipartite(int src, GraphList g, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        color[src] = 0;
        q.add(src);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g.neighbour(u)) {
                if (color[v] == -1) {
                    color[v] = 1 - color[u];
                    q.add(v);
                } else if (color[v] == color[u]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 5;
        GraphList g = new GraphList(n);

        g.addEdge(0, 1, false);
        g.addEdge(0, 2, false);
        g.addEdge(1, 2, false);
        g.addEdge(2, 3, false);
        g.addEdge(3, 4, false);
        g.addEdge(1, 4, false);

        g.display();

        int[] color = new int[n];
        Arrays.fill(color, -1);

        if (isBipartite(0, g, color)) {
            System.out.println("Yes it is bipartite");
        } else {
            System.out.println("no bipartite");
        }
    }
}
