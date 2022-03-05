package divideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Administrator on 2020/4/25.
 */
public class SmallestK {

    // 暴力法
    /*public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length !=k){
            return new int[0];
        }
        Arrays.sort(arr);
        int [] result = Arrays.copyOf(arr,k);
        return result;
    }*/

    public static void main(String[] args) {
        int p [] = {62577,-220,-8737,-22,-6,59956,5363,-16699,0,-10603,64,-24528,-4818,96,5747,2638,-223,37663,-390,35778,-4977,-3834,-56074,7,-76,601,-1712,-48874,31,3,-9417,-33152,775,9396,60947,-1919,683,-37092,-524,-8,1458,80,-8,1,7,-355,9,397,-30,-21019,-565,8762,-4,531,-211,-23702,3,3399,-67,64542,39546,52500,-6263,4,-16,-1,861,5134,8,63701,40202,43349,-4283,-3,-22721,-6,42754,-726,118,51,539,790,-9972,41752,0,31,-23957,-714,-446,4,-61087,84,-140,6,53,-48496,9,-15357,402,5541,4,53936,6,3,37591,7,30,-7197,-26607,202,140,-4,-7410,2031,-715,4,-60981,365,-23620,-41,4,-2482,-59,5,-911,52,50068,38,61,664,0,-868,8681,-8,8,29,412};
        int k  = 131;
       /* int p [] = {1,2,3};
        int k  = 0;*/
        System.out.println(smallestK(p, k));
    }
    // 最小堆
 /*   public static int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length <k){
            return new int[0];
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            int len = priorityQueue.size();
            if (len <k){
                priorityQueue.add(arr[i]);
            }else if (priorityQueue.peek() != null && priorityQueue.peek().intValue()>arr[i]){
                priorityQueue.poll();
                priorityQueue.offer(arr[i]);
            }
        }
        int [] result = new int[k];
        int i = 0;
        for (Integer obj:priorityQueue) {
            result[i++] = obj;
        }
        return result;
    }*/

    // 快排序
    public static int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length <=k){
            return arr;
        }
        int left = 0;
        int right = arr.length-1; // 注意取值范围
        int [] result;
        while (left<right){
            int index = partition(arr,left,right);
            if (index == k-1){
                break;
            }else if(index>k-1){
                right = index-1;
            }else if(index<k-1){
                left = index+1;
            }
        }
        result = Arrays.copyOf(arr, k);
        return result;
    }

    // 分区函数
    private static int partition(int[] arr, int left, int right) {
        int flag = arr[left];
        while (left<right){ //当left==right事跳出，给分区位置赋值
            while (left<right && arr[right] >=flag){
                right--;
            }
            if (left<right){
                arr[left++] = arr[right];
            }
            while (left<right && arr[left] <=flag){
                left++;
            }
            if (left<right){
                arr[right--] = arr[left];
            }
        }
        arr[left]= flag;
        return left;
    }

}
