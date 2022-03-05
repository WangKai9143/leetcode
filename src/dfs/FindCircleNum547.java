package dfs;

public class FindCircleNum547 {
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null){
            return 0;
        }
        int num = 0;
        boolean [] isVisited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!isVisited[i]){
                dfs(isConnected,isVisited,i);
                num++;
            }
        }
        return num;
    }

    private void dfs(int[][] isConnected, boolean[] isVisited, int x) {
        // 找联通性
        isVisited[x] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[x][i] == 1 && !isVisited[i]){
                dfs(isConnected,isVisited,i);
            }
        }
    }

   /* public int findCircleNum(int[][] isConnected){
        if (isConnected == null){
            return 0;
        }
        int num = 0;
        boolean [] isVisited = new boolean[isConnected.length];
        Queue<Integer> list = new LinkedList<>();
        // 以多个点开始的起始位置，bfs
        for (int i = 0; i < isConnected.length; i++) {
            if (!isVisited[i]){
                list.offer(i);
                while (!list.isEmpty()){
                    int x = list.poll();
                    isVisited[x] = true;
                    for (int j = 0; j < isConnected.length; j++) {
                        if (isConnected[x][j]  == 1 && !isVisited[j]){
                            list.offer(j);
                        }
                    }
                }
                num++;
            }
        }
        return num;
    }*/
}
