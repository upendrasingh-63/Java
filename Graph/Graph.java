package Graph;

public class Graph {
    public static void main(String[] args) {
        GraphList g = new GraphList(5);

        g.addEdge(0, 1, false);
        g.addEdge(1, 2, false);
        g.addEdge(2, 3, false);
        g.addEdge(3, 4, false);
        g.addEdge(1, 4, false);

        g.display();
        System.out.println();

        GraphMatrix gm = new GraphMatrix(5);
        gm.addEdge(0, 1, false);
        gm.addEdge(1, 2, false);
        gm.addEdge(2, 3, false);
        gm.addEdge(3, 4, false);
        gm.addEdge(1, 4, false);

        gm.display();

    }
}
