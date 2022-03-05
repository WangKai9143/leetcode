package other;

/**
 * Created by Administrator on 2020/3/19.
 */
/*300. 最长上升子序列
        给定一个无序的整数数组，找到其中最长上升子序列的长度。

        示例:

        输入: [10,9,2,5,3,7,101,18]
        输出: 4
        解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
        说明:

        可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
        你算法的时间复杂度应该为 O(n2) 。
        进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
        */
public class LIS {
    //a[i]= max(a[j])+1,(j<i且nums[i]>nums[j]) ,a[i]代表以nums[i]为结尾的最长递增子序列长度
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = 1;
        int arr[] = new int[nums.length];
        arr[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxVal = Math.max(arr[j], maxVal);
                }
            }
            arr[i] = maxVal+1;
            result = Math.max(result,arr[i]);
        }
        return result;
    }

    /**
     * 方法二：贪心 + 二分查找
     思路与算法

     考虑一个简单的贪心，如果我们要使上升子序列尽可能的长，则我们需要让序列上升得尽可能慢，因此我们希望每次在上升子序列最后加上的那个数尽可能的小。

     基于上面的贪心思路，我们维护一个数组 d[i]d[i] ，表示长度为 ii 的最长上升子序列的末尾元素的最小值，用 \textit{len}len 记录目前最长上升子序列的长度，起始时 lenlen 为 11，d[1] = \textit{nums}[0]d[1]=nums[0]。

     同时我们可以注意到 d[i]d[i] 是关于 ii 单调递增的。因为如果 d[j] \geq d[i]d[j]≥d[i] 且 j < ij<i，我们考虑从长度为 ii 的最长上升子序列的末尾删除 i-ji−j 个元素，那么这个序列长度变为 jj ，且第 jj 个元素 xx（末尾元素）必然小于 d[i]d[i]，也就小于 d[j]d[j]。那么我们就找到了一个长度为 jj 的最长上升子序列，并且末尾元素比 d[j]d[j] 小，从而产生了矛盾。因此数组 d[]d[] 的单调性得证。

     我们依次遍历数组 \textit{nums}[]nums[] 中的每个元素，并更新数组 d[]d[] 和 lenlen 的值。如果 \textit{nums}[i] > d[\textit{len}]nums[i]>d[len] 则更新 len = len + 1len=len+1，否则在 d[1 \ldots len]d[1…len]中找满足 d[i - 1] < \textit{nums}[j] < d[i]d[i−1]<nums[j]<d[i] 的下标 ii，并更新 d[i] = \textit{nums}[j]d[i]=nums[j]。

     根据 dd 数组的单调性，我们可以使用二分查找寻找下标 ii，优化时间复杂度。

     最后整个算法流程为：

     设当前已求出的最长上升子序列的长度为 \textit{len}len（初始时为 11），从前往后遍历数组 \textit{nums}nums，在遍历到 \textit{nums}[i]nums[i] 时：

     如果 \textit{nums}[i] > d[\textit{len}]nums[i]>d[len] ，则直接加入到 dd 数组末尾，并更新 \textit{len} = \textit{len} + 1len=len+1；

     否则，在 dd 数组中二分查找，找到第一个比 \textit{nums}[i]nums[i] 小的数 d[k]d[k] ，并更新 d[k + 1] = \textit{nums}[i]d[k+1]=nums[i]。

     以输入序列 [0, 8, 4, 12, 2][0,8,4,12,2] 为例：

     第一步插入 00，d = [0]d=[0]；

     第二步插入 88，d = [0, 8]d=[0,8]；

     第三步插入 44，d = [0, 4]d=[0,4]；

     第四步插入 1212，d = [0, 4, 12]d=[0,4,12]；

     第五步插入 22，d = [0, 2, 12]d=[0,2,12]。

     最终得到最大递增子序列长度为 33。
     *
     *
     * @param nums
     * @return
     */
    public int lengthOfLISGreed(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = 1; // 最长递增子序列长度
        int arr[] = new int[nums.length+1]; // 长度为i递增子序列的最小元素
        arr[len] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > arr[len]) { //要么直接跟新子序列长度
                arr[++len] = nums[i];
            }
            else{ // 要么更新递增子序列
                int left = 1;
                int right = len;
                int pos = 0; // 如果没有找到，则从零开始
                while (left<=right){
                    int middle = (left+right) >> 1;
                    if (arr[middle] < nums[i]){
                        pos = middle;
                        left = middle + 1; // 寻找左边比num[i]小，右边比它大的位置
                    }
                    else{
                        right = middle -1;
                    }
                }
                arr[pos + 1] = nums[i];
            }
        }
        return len;
    }
}
