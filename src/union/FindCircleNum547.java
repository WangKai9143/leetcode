package union;

public class FindCircleNum547 {
    // 使用的是并查集
    public int findCircleNum(int[][] isConnected) {
        if (isConnected == null) {
            return 0;
        }
        int num = 0;

        int[] father = new int[isConnected.length];
        int[] rank = new int[isConnected.length];
        init(father);

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    merge(father,rank, i, j);
                }
            }
        }
        for (int i = 0; i < isConnected.length; i++) {
            if (father[i]==i){
                num++;
            }
        }
        return num;
    }

    private void merge(int[] father, int[] rank, int i, int j) {
        int x = find(father, i);
        int y = find(father, j);
        if (rank[x] <= rank[y]) {
            father[x] = y;
        } else {
            father[y] = x;
        }
        // 新的根树节点+1
        if (rank[x] == rank[y] && x != y) {
            rank[y]++;
        }
    }

    private int find(int[] father, int k) {
        return father[k] == k ? k : find(father, father[k]);
    }

    private void init(int[] father) {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

}
