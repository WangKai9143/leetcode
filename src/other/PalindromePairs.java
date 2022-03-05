package other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/3/15.
 */
public class PalindromePairs {

    public static void main(String[] args) {
        String[] words = {"a","abc","aba",""};
        List<List<Integer>> listList = palindromePairs(words);
        System.out.println(listList);
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        if (words == null || words.length == 0) {
            return null;
        }
        List<List<Integer>> listList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                int result = palindromePairs(words[i],words[j]);
                if (result == 2){
                    List<Integer> integerList = new ArrayList<>();
                    integerList.add(i);
                    integerList.add(j);
                    listList.add(integerList);
                    List<Integer> integerList2 = new ArrayList<>();
                    integerList2.add(j);
                    integerList2.add(i);
                    listList.add(integerList2);
                } else if (result == 1){
                    List<Integer> integerList = new ArrayList<>();

                    integerList.add(j);
                    integerList.add(i);
                    listList.add(integerList);
                } else if (result == 0){
                    List<Integer> integerList = new ArrayList<>();
                    integerList.add(i);
                    integerList.add(j);
                    listList.add(integerList);
                }else{
                    continue;
                }
            }
        }
        return listList;
    }

    public static int palindromePairs(String word,String word2) {
        if ((word == null || word.isEmpty()) && (word2 == null || word2.isEmpty())) {
            return  -1;
        }
        StringBuilder sb = new StringBuilder(word);
        sb.append(word2);
        char [] connectWord = sb.toString().toCharArray();
        boolean flag1 = true;
        boolean flag2 = true;
        for (int i = 0; i < connectWord.length / 2; i++) {
            if (connectWord[i] != connectWord[connectWord.length - 1 - i]) {
                flag1 = false;
                break;
            }
        }
        sb.replace(0,connectWord.length,"");
        sb.append(word2);
        sb.append(word);
        connectWord = sb.toString().toCharArray();
        for (int i = 0; i < connectWord.length / 2; i++) {
            if (connectWord[i] != connectWord[connectWord.length - 1 - i]) {
                flag2 = false;
                break;
            }
        }
        if (flag1 == true && flag2 == true){
            return 2;
        }
        else if (flag1 == false && flag2 == true){
            return 1;
        }
        else if (flag1 == true && flag2 == false){
            return 0;
        }else{
            return -1;
        }
    }
}
