package Graph;

public class NumberOfIslands {
    public static void dfs(int i, int j, int[][] grid, boolean[][] visited) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0)
            return;

        visited[i][j] = true;

        dfs(i + 1, j, grid, visited);
        dfs(i - 1, j, grid, visited);
        dfs(i, j + 1, grid, visited);
        dfs(i, j - 1, grid, visited);
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 0, 0 },
                { 1, 0, 0, 1 },
                { 0, 0, 1, 1 },
                { 0, 0, 0, 0 } };

        int n = grid.length;

        boolean[][] visited = new boolean[n][n];

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, grid, visited); // or bfs(i,visited)
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
