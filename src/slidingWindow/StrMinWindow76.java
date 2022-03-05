package slidingWindow;

/**
 * Created by Administrator on 2020/3/31.
 */
public class StrMinWindow76 {
    /*  如何判断滑动窗口包含了T的所有元素？
      我们用一个字典need来表示当前滑动窗口中需要的各元素的数量，一开始滑动窗口为空，用T中各元素来初始化这个need，当滑动窗口扩展或者收缩的时候，去维护这个need字典，例如当滑动窗口包含某个元素，我们就让need中这个元素的数量减1，代表所需元素减少了1个；当滑动窗口移除某个元素，就让need中这个元素的数量加1。
      记住一点：need始终记录着当前滑动窗口下，我们还需要的元素数量，我们在改变i,j时，需同步维护need。
      值得注意的是，只要某个元素包含在滑动窗口中，我们就会在need中存储这个元素的数量，如果某个元素存储的是负数代表这个元素是多余的。比如当need等于{'A':-2,'C':1}时，表示当前滑动窗口中，我们有2个A是多余的，同时还需要1个C。这么做的目的就是为了步骤二中，排除不必要的元素，数量为负的就是不必要的元素，而数量为0表示刚刚好。
      回到问题中来，那么如何判断滑动窗口包含了T的所有元素？结论就是当need中所有元素的数量都小于等于0时，表示当前滑动窗口不再需要任何元素。
  */
//    输入：s = "ADOBECODEBANC", t = "ABC"
//    输出："BANC"

    // 用这个输入模拟理解下map的元素为负数的场景
//    输入：s = "ABBBBBCA", t = "ABC"
//    输出："BCA"

    public String minWindow(String s, String t) {
        String result = "";
        if (s == null || t == null || s.isEmpty() || t.isEmpty()) {
            return result;
        }
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int l = 0;
        int r = 0;
        int hash[] = new int[256];
        for (int i = 0; i < t.length(); i++) {
            hash[tArray[i]]++;
        }
        int len = tArray.length;
        int count = Integer.MAX_VALUE;
        for (r = 0; r < sArray.length; r++) {
            // 如果匹配，则计数器减1
            if (hash[sArray[r]] > 0) {
                len--;
            }
            // 更新窗口的字符匹配情况
            hash[sArray[r]]--;
            // 找到解之后开始优化
            while (len == 0) {
                if (r - l + 1 < count) {
                    count = r - l + 1;
                    result = s.substring(l, r + 1);
                }
                // 移动窗口左区间
                // 恢复串口字符
                hash[sArray[l]]++;
                // 只有大于0的元素才是需要匹配的元素，才需要更新匹配计数器
                if (hash[sArray[l]]>0){
                    len++;
                }
                l++;
            }
        }
        return result;
    }
}
