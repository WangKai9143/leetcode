package bfs;

import java.util.*;

public class NumBusesToDestination815 {

    // 将每个路线看成一个点，如果线路有相同的点，则表示两个点之间相连（存在边）。只不过两个点之间存在多个边
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, List<Integer>> res = new HashMap<>();
        boolean edge[][] = new boolean[routes.length][routes.length];
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                List<Integer> list = res.getOrDefault(routes[i][j], new ArrayList<>());
                for (int k : list) {
                    edge[i][k] = edge[k][i] = true;
                }
                list.add(i);
                res.put(routes[i][j], list);
            }
        }

        int[] dis = new int[routes.length];
        Arrays.fill(dis, -1);
        Queue<Integer> queue = new ArrayDeque<>();
        // 头结点入队列
        for (int bus : res.getOrDefault(source, new ArrayList<>())) {
            dis[bus] = 1;
            queue.offer(bus);
        }
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int y = 0; y < routes.length; y++) {
                if (edge[x][y] && dis[y] == -1) {
                    dis[y] = dis[x] + 1;
                    queue.offer(y);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int bus : res.getOrDefault(target, new ArrayList<>())) {
            if (dis[bus] != -1) {
                result = Math.min(result, dis[bus]);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }

}
