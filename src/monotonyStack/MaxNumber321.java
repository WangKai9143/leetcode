package monotonyStack;

public class MaxNumber321 {
//    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
//            return new int[0];
//        }
//        Stack<Integer> stackNum1 = new Stack<>();
//        Stack<Integer> stackNum2 = new Stack<>();
//
//        List<Integer> num1List = new ArrayList<>();
//        List<Integer> num2List = new ArrayList<>();
//
//        getMaxSeq(nums1, stackNum1, num1List);
//        getMaxSeq(nums2, stackNum2, num2List);
//        while (k>0){
//            k--;
//        }
//    }
//
//    private void getMaxSeq(int[] nums2, Stack<Integer> stackNum2, List<Integer> num2List) {
//        for (int i = 0; i < nums2.length; i++) {
//            int count = 0;
//            while (!stackNum2.isEmpty() && nums2[stackNum2.peek()]>nums2[i]){
//                int top = stackNum2.pop();
//                if (count == 0) {
//                    num2List.add(nums2[top]);
//                }
//                count++;
//            }
//            stackNum2.push(i);
//        }
//    }
}
