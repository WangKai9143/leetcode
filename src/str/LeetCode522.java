package str;

/**
 * Created by Administrator on 2020/5/4.
 */
public class LeetCode522 {
    public static void main(String[] args) {
        String[] strs = {"aba", "cdc", "eae"};
        System.out.println(findLUSlength(strs));
    }

    public static int findLUSlength(String[] strs) {
        if (strs == null || strs.length == 0){
            return -1;
        }
        int maxLUSLen = -1;
        for (int i = 0,j; i < strs.length; i++) {
            for (j = 0; j < strs.length; j++) {
                if (j == i) {
                    continue;
                }
                boolean res = isSubString(strs[i],strs[j]);
                if (res){
                    break;
                }
            }
            // strs[i]不是其他所有船的子串
            if (j == strs.length){
                maxLUSLen = Math.max(strs[i].length(),maxLUSLen);
            }
        }
        return maxLUSLen;
    }

    // 判断str是否是str2的子串
    private static boolean isSubString(String str, String str1) {
        int j = 0;
        for (int i = 0; i < str1.length() && j<str.length(); i++) {
            if (str1.charAt(i) == str.charAt(j)){
                j++;
            }
        }
        return  j == str.length();
    }


   /* public boolean isSubsequence(String x, String y) {
        int j = 0;
        for (int i = 0; i < y.length() && j < x.length(); i++)
            if (x.charAt(j) == y.charAt(i))
                j++;
        return j == x.length();
    }
    public int findLUSlength(String[] strs) {
        int res = -1;
        for (int i = 0, j; i < strs.length; i++) {
            for (j = 0; j < strs.length; j++) {
                if (j == i)
                    continue;
                if (isSubsequence(strs[i], strs[j]))
                    break;
            }
            if (j == strs.length)
                res = Math.max(res, strs[i].length());
        }
        return res;
    }*/
}
