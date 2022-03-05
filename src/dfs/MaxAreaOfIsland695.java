package dfs;

public class MaxAreaOfIsland695 {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null){
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                maxArea = Math.max(maxArea,dfs(grid,i,j));
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int x, int y) {
        if (x<0 || x>= grid.length || y<0 || y>=grid[x].length || grid[x][y] == 0){
            return 0;
        }
        // 代表已经访问,并且以后再也不会访问该岛屿
        grid[x][y] = 0;
        return 1+dfs(grid,x+1,y)+dfs(grid,x,y+1)+dfs(grid,x-1,y)+dfs(grid, x, y-1);
    }
}
