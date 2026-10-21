import java.util.*;

public class Task58_MaxAreaOfIsland {
    public static int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    int area = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{r, c});
                    visited[r][c] = true;

                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        area++;
                        for (int[] d : directions) {
                            int nr = cell[0] + d[0], nc = cell[1] + d[1];
                            if (nr >= 0 && nr < rows && nc >= 0 && nc < cols
                                    && grid[nr][nc] == 1 && !visited[nr][nc]) {
                                visited[nr][nc] = true;
                                queue.offer(new int[]{nr, nc});
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt(), cols = sc.nextInt();
        int[][] grid = new int[rows][cols];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                grid[r][c] = sc.nextInt();
        System.out.println(maxAreaOfIsland(grid));
        sc.close();
    }
}
