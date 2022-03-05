package binarySearch;

import java.util.Arrays;

/**
 * Created by Administrator on 2020/4/22.
 */
public class FindDuplicate {
    public int findDuplicate2(int[] nums) {
        if(nums == null){
            return -1;
        }
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
               if (nums[i] == nums[i-1]){
                   return nums[i];
               }
        }
        return -1;
    }

    /*给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
    假设只有一个重复的整数，找出这个重复的数。*/

    // 快慢指针
  /*  把nums想象成一根绳子，重复的值会在连接到前面的点（形成一些环），假设有一个环。
    环的入口为m（所求），周长为c, 快指针在绳上走2n步，慢指针走n步相遇了。
    快指针多走的n步是在环里转圈，且刚好转够整数圈，所以n%c=0, 这时候慢指针在环里走了 n-m 步，
    新建find指针从0开始走，走到环口为m步，而慢针刚好走了n-m+m=n步，环周长的整数倍（慢针进环是在结合点，转够整数圈一定还在结合点，也就是重复值）*/

    public int findDuplicate(int[] nums) {
        if(nums == null){
            return -1;
        }
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while (slow != fast);
        int find = 0;
        do {
            find = nums[find];
            slow = nums[slow];
        }while (slow != find);
        return find;
    }

}
