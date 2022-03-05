package other;

/**
 * Created by Administrator on 2020/3/15.
 */

/*面试题 10.03. 搜索旋转数组
        搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。

        示例1:

        输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
        输出: 8（元素5在该数组中的索引）
        示例2:

        输入：arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 11
        输出：-1 （没有找到）
        提示:

        arr 长度范围在[1, 1000000]之间*/
public class RotatedArray {
    /*      *//*小心这种用例*//*
    输入：
            [5,5,5,1,2,3,4,5]
            5
    输出：
            7
    预期：
            0*/
    // 该题的思路主要是先找到拐点，在查找，都用的二分的思想。
    public int search(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            // 拐点在左边 小心21222这种用例，先从左边找拐点
            if (arr[middle] <= arr[right]) {
                right = middle;
            }
            // 拐点在右边,一定得找到拐点的第一个元素
            else if (arr[middle] >= arr[left]) {
                left = middle + 1;
            }
        }
        // 判断目标在前后那个半段
        if (target >= arr[0]) {
            left = 0;
            right = right - 1;
        } else {
            right = arr.length - 1;
        }
        while (left < right) {
            int middle = (left + right) / 2;
            // 得找到数组第一个等于目标值得元素
            if (arr[middle] >= target) {
                right = middle;
            } else if (arr[middle] < target) {
                left = middle + 1;
            }
        }
        return arr[right] != target ? -1 : right;
    }
}
