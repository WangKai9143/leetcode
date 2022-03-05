package grath;

import java.util.Arrays;

/**
 * Created by Administrator on 2020/5/3.
 */
public class ShortestPath {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int d [] = new int[n];
        Arrays.fill(d,Integer.MAX_VALUE);
        int nodes [] = new int[n];
        Arrays.fill(nodes,0);
        d[src] = 0;
        for (int [] flight:flights) {
            d[flight[1]] = Math.min(d[flight[1]],d[flight[0]]+flights[0][1]);
        }
        return -1;
    }
}
