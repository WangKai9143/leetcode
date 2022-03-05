package slidingWindow;

// 长度为k的连续序列的最大和
public class MaxSumSubArray {
    // 暴力法
/*    public int maxSum(int [] arr,int k) {
        int sum = 0;

        for (int i = 0; i < arr.length-k+1; i++) {
            int curSum = 0;
            // 长度为k的窗口
            for (int j = 0; j < k; j++) {
                curSum+=arr[i+j];
            }
            sum = Math.max(curSum,sum);
        }
        return sum;
    }*/

    // 利用滑动窗口
    public int maxSum(int[] arr, int k) {
        int sum = 0;
        // 计算出第一个窗口的值
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        for (int i = k; i < arr.length; i++) {
            int curSum = sum + arr[i] - arr[i - k];
            sum = Math.max(curSum, sum);
        }
        return sum;
    }
}
