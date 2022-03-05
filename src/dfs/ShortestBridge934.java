package dfs;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge934 {

    public static void main(String[] args) {
//        int[][] grid = {{0,1},{1,0}};
        int[][] grid = {{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
//        int[][] grid = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
        ShortestBridge934 shortestBridge934 = new ShortestBridge934();
        System.out.println(shortestBridge934.shortestBridge(grid));
    }

    // 思路没有问题，但是超时了，先找第一个岛，然后遍历遍历岛上的所有点到底第二个岛的距离。
    /*int shortDistance = Integer.MAX_VALUE;

    public int shortestBridge(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        // 跳出双层循环
        boolean flipped = false;
        for (int i = 0; i < grid.length; i++) {
            if (flipped) {
                break;
            }
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, 2);
                    flipped = true;
                    break;
                }
            }
        }

        boolean[][] visited = new boolean[grid.length][grid[1].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 2 && (isValid( i+1, j,grid) || isValid( i-1, j,grid) || isValid( i, j+1,grid) || isValid( i, j-1,grid))) {
                    searchShortestDistance(grid, i, j, 0, visited);
                }
            }
        }
        return shortDistance - 1;
    }

    boolean isValid(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length) {
            return false;
        }
        if (grid[x][y] == 0) {
            return true;
        }
        return false;
    }

    private void searchShortestDistance(int[][] grid, int x, int y, int level, boolean[][] visited) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || visited[x][y]) {
            return;
        }
        if (grid[x][y] == 1) {
            shortDistance = level < shortDistance ? level : shortDistance;
            return;
        }
        visited[x][y] = true;
        searchShortestDistance(grid, x - 1, y, level + 1, visited);
        searchShortestDistance(grid, x + 1, y, level + 1, visited);
        searchShortestDistance(grid, x, y - 1, level + 1, visited);
        searchShortestDistance(grid, x, y + 1, level + 1, visited);
        visited[x][y] = false;
    }

    private void dfs(int[][] grid, int x, int y, int flag) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == 0 || grid[x][y] == flag) {
            return;
        }
        grid[x][y] = flag;
        dfs(grid, x - 1, y, flag);
        dfs(grid, x + 1, y, flag);
        dfs(grid, x, y - 1, flag);
        dfs(grid, x, y + 1, flag);
    }*/


    int[] direction = new int[]{-1, 0, 1, 0, -1};
    int shortDistance = 0;

    public int shortestBridge(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }
        // 1. 先 dfs 将找到的第一座桥的值全部赋值为2，并将第一座桥旁边的 0 全部插入队列中
        // 2. 再 while 循环判断队列是否为空，循环体里会判断是否发现了第二座桥；
        Queue<int[]> queue = new LinkedList();
        // 跳出双层循环
        boolean flipped = false;
        for (int i = 0; i < grid.length; i++) {
            if (flipped) {
                break;
            }
            // 先 dfs，将第一座岛上所有值都该为 2
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    flipped = true;
                    break;
                }
            }
        }
        // bfs 寻找下一座岛屿，遍历时将所有 0 值赋值为 2
        while (!queue.isEmpty()) {
            shortDistance++;
            int queueSize = queue.size();
            while (queueSize-- > 0) {
                int root[] = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = root[0] + direction[j];
                    int y = root[1] + direction[j + 1];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                        if (grid[x][y] == 1) {
                            return shortDistance;
                        }
                        if (grid[x][y] == 2) {
                            continue;
                        }
                        grid[x][y] = 2;
                        queue.add(new int[]{x, y});
                    }
                }
            }
        }

        return shortDistance;
    }

    private void dfs(int[][] grid, int x, int y, Queue<int[]> queue) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == 2) {
            return;
        }
        // 插入所有为 0 的值的坐标到队列中
        // 为 1 的值就改变为 2 并且继续遍历四个方向
        // 为 2 的值就直接退出
        if (grid[x][y] == 0) {
            queue.add(new int[]{x, y});
            return;
        }
        grid[x][y] = 2;
        dfs(grid, x - 1, y, queue);
        dfs(grid, x + 1, y, queue);
        dfs(grid, x, y - 1, queue);
        dfs(grid, x, y + 1, queue);
    }
}
