package str;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/5/3.
 */
public class LeetCode7 {
    public String convert(String s, int numRows) {
        if(numRows < 2) return s;

        List<StringBuilder> result = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            result.add(new StringBuilder());
        }
        int flag = -1; // 控制下一个字符在哪一行上加,先向上加，再向下减的一个过程
        int i = 0;
        for(char c : s.toCharArray()) {
            result.get(i).append(c);
            if (i == 0 || i == numRows -1){
                flag = -flag;
            }
            i+=flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : result) res.append(row);
        return res.toString();
    }

}
