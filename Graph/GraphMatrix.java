package Graph;
// v*V mat[u][v] there is edge and we can store weights

// great for dense graph E~V^2 , constant time edge search

//space:O(v*v) (can be heavy)
//iterate neighbour of u:O(V)  scane row of u
// check if (v,u) exists: O(1)
// add/ remove edge: o(1)
// add vertex: constly( need to resize n*N)
//Algorithms like Floyd–Warshall, bitset tricks on dense graphs, or DP on subsets where matrices are convenient.

public class GraphMatrix {
    private final int n;
    private final boolean[][] mat;

    public GraphMatrix(int n) {
        this.n = n;
        mat = new boolean[n][n];
    }

    // add edge
    public void addEdge(int u, int v, boolean directed) {
        mat[u][v] = true;
        if (!directed) {
            mat[v][u] = true;
        }
    }

    // check edge
    public boolean hasEdge(int u, int v) {
        return mat[u][v];
    }

    // display graph
    public void display() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + " -> ");
            for (int j = 0; j < n; j++) {
                if (mat[i][j]) {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

    // size
    public int size() {
        return n;
    }
}
