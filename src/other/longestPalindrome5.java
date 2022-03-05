package other;

/**
 * Created by Administrator on 2020/4/9.
 */
public class longestPalindrome5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        char chs[] = s.toCharArray();
        int max = 0;
        String result = new String(chs[0] + "");
        for (int i = 0; i < chs.length; i++) {
            for (int j = i; j < chs.length; j++) {
                int left = i;
                int right = j;
                while (left <= right) {
                    if (chs[left] != chs[right]) {
                        break;
                    }
                    left++;
                    right--;
                }
                if (left > right && j - i > max) {
                    max = j - i;
                    result = s.substring(i, j+1);
                }
            }
        }
        return result;
    }
}
