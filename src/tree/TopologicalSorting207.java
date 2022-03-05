package tree;

import org.junit.jupiter.api.Test;

import java.util.*;

public class TopologicalSorting207 {
    /**
     * 拓扑排序，按照图中每个节点的入度为0,继续出队列
     *
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int[] item : prerequisites) {
            indegree[item[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int top = queue.poll();
            result.add(top);
            for (int[] item : prerequisites) {
                if (item[1] == top) {
                    if (--indegree[item[0]] == 0) {
                        queue.offer(item[0]);
                    }
                }
            }
        }
        return result.size() == numCourses;
    }


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        for (int[] item : prerequisites) {
            indegree[item[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int top = queue.poll();
            result.add(top);
            for (int[] item : prerequisites) {
                if (item[1] == top) {
                    if (--indegree[item[0]] == 0) {
                        queue.offer(item[0]);
                    }
                }
            }
        }
        if (result.size() == numCourses){
            return new int[0];
        }
        int num [] = new int[numCourses];
        for (int i = 0; i < result.size(); i++) {
            num[i] = result.get(i);
        }
        return num;
    }

    /* 示例 1：

     输入：numCourses = 2, prerequisites = [[1,0]]
     输出：true
     解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
     示例 2：

     输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
     输出：false
     解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 */
    @Test
    void testCanFinish() {
        System.out.println(canFinish(2, new int[][]{{1, 0}}));
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
