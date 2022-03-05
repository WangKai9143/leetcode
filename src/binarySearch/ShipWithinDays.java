package binarySearch;

/**
 * Created by Administrator on 2020/4/21.
 */
public class ShipWithinDays {
    public int shipWithinDays(int[] weights, int D) {
        // 最小负载能力
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int current = i;
            boolean flag = true;
            int days = D;
            for (int j = 0; j < weights.length; j++) {
                // 无法运载
                if (i<weights[j]){
                    flag = false;
                }
                // 需要再加一天
                if (current<weights[j]){
                    current = i;
                    days--;
                }
                current-=weights[j];
            }
            if(flag && days>0){
                return i;
            }
        }
        return -1;
    }
}
