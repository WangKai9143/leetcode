package other;

/**
 * Created by Administrator on 2020/3/20.
 */
/*面试题 17.08. 马戏团人塔
        有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。

        示例：

        输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
        输出：6
        解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
        提示：

        height.length == weight.length <= 10000*/
public class PersonTower {
    public static void main(String[] args) {
        int [] height = {65,70,56,75,60,68};
        int[]  weight = {100,150,90,190,95,110};
        System.out.println(bestSeqAtIndex(height, weight));
    }

    public static int bestSeqAtIndex(int[] height, int[] weight) {
        if (height == null || weight == null || height.length == 0 || weight.length == 0) {
            return 0;
        }
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length; j++) {
                if (height[i] > height[j]) {
                    swap(height, i, j);
                    swap(weight, i, j);
                }
            }
        }
        for (int i = 0; i < height.length; i++) {  // 身高相同，按照体重的递减顺序排序
            if (i + 1 < height.length && height[i] == height[i + 1] && weight[i] < weight[i + 1]) {
                swap(weight, i, i + 1);
            }
        }
        return lengthOfLIS(weight);
    }


    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }


    //a[i]= max(a[j])+1,(j<i且nums[i]>nums[j]) ,a[i]代表以nums[i]为结尾的最长递增子序列长度

    //a[i]= max(a[j])+1,(j<i且nums[i]>nums[j]) ,a[i]代表以nums[i]为结尾的最长递增子序列长度
    public static int lengthOfLIS1(int[] nums) {
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

    public static int lengthOfLIS(int[] nums) {
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
