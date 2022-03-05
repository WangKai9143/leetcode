package str;

/**
 * Created by Administrator on 2020/5/5.
 */
public class LeetCode528 {
    public int findLUSlength(String a, String b) {
        if (a == null || b == null){
            return -1;
        }
        int result = -1;
       if(!isSubSequence(a, b)){
           result = Math.max(result,a.length());
       }
        if (!isSubSequence(b, a)){
            result = Math.max(result,b.length());
        }
        return result;
    }

    // 判断a是否是b的子序列,需要遍历后面的字符串，子串是不变的
    private boolean isSubSequence(String a, String b) {
        int j=0;
        int i=0;
        for (i = 0; i < b.length() && j<a.length(); i++) {
            if(b.charAt(i) == a.charAt(j)){
                j++;
            }
        }
        return j == a.length();
    }
}
