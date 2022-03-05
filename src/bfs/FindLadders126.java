package bfs;

import java.util.*;

public class FindLadders126 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordArray = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new ArrayList<>(Arrays.asList(wordArray));
        FindLadders126 findLadders126 = new FindLadders126();
        List<List<String>> answer = findLadders126.findLadders(beginWord, endWord, wordList);
        System.out.println(answer);
    }

/*
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> answer = new ArrayList<>();
        List<String> paths = new ArrayList<>();
        paths.add(beginWord);
        findLaddersHelper(answer, paths, wordList, beginWord, endWord);
        return answer;
    }

    private int minDistance = Integer.MAX_VALUE;
 */

/*  第一种方法，后面的用例超时
   private void findLaddersHelper(List<List<String>> answer, List<String> paths, List<String> wordList, String beginWord, String endWord) {
        if (beginWord.equals(endWord)) {
            if (paths.size() < minDistance) {
                answer.clear();
                minDistance = paths.size();
                answer.add(new ArrayList<>(paths));
            } else if (paths.size() == minDistance) {
                answer.add(new ArrayList<>(paths));
            }
            return;
        }
        // 如果当前路径长度大于最小距离还没到达终点，停止搜索
        if (paths.size() >= minDistance) {
            return;
        }
        // 遍历所有节点,寻找邻接点
        for (int i = 0; i < wordList.size(); i++) {
            String curWord = wordList.get(i);
            // 如果路径中包含该路径，则不添加节点，否则会死循环
            if (paths.contains(curWord)) {
                continue;
            }
            if (isNeighbour(curWord, beginWord)) {
                paths.add(curWord);
                findLaddersHelper(answer, paths, wordList, curWord, endWord);
                paths.remove(curWord);
            }
        }
    }*/


/*    private boolean isNeighbour(String curWord, String beginWord) {
        int count = 0;
        for (int i = 0; i < curWord.length(); i++) {
            if (beginWord.charAt(i) != curWord.charAt(i)) {
                count++;
            }
            if (count >= 2) {
                return false;
            }
        }
        return count == 1;
    }*/


    // 第二种方法,后面的用例超时
/*    private void findLaddersHelper(List<List<String>> answer, List<String> paths, List<String> wordList, String beginWord, String endWord) {
        if (beginWord.equals(endWord)) {
            if (paths.size() < minDistance) {
                answer.clear();
                minDistance = paths.size();
                answer.add(new ArrayList<>(paths));
            } else if (paths.size() == minDistance) {
                answer.add(new ArrayList<>(paths));
            }
            return;
        }
        // 如果当前路径长度大于最小距离还没到达终点，停止搜索
        if (paths.size() >= minDistance) {
            return;
        }
        // 遍历所有节点,寻找邻接点
        Set<String> dict = new HashSet<>(wordList);
        List<String> neighbours = isNeighbour(dict, beginWord);
        for (String neighbour : neighbours) {
            // 如果路径中包含该路径，则不添加节点，否则会死循环
            if (paths.contains(neighbour)) {
                continue;
            }
            paths.add(neighbour);
            findLaddersHelper(answer, paths, wordList, neighbour, endWord);
            paths.remove(neighbour);
        }
    }

    private List<String> isNeighbour(Set<String> dict, String beginWord) {
        List<String> result = new ArrayList<>();
        char[] beginWordArr = beginWord.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int j = 0; j < beginWord.length(); j++) {
                if (beginWordArr[j] == ch) {
                    continue;
                }
                char oldChar = beginWordArr[j];
                beginWordArr[j] = ch;
                System.out.println(String.valueOf(beginWordArr));
                if (dict.contains(String.valueOf(beginWordArr))) {
                    result.add(String.valueOf(beginWordArr));
                }
                beginWordArr[j] = oldChar;
            }
        }
        return result;
    }*/

    // 第三种方法,可以ac
/*    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 如果不含有结束单词，直接结束，不然后边会造成死循环
        List<List<String>> answer = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return answer;
        }
        Map<String, Integer> distanceMap = new HashMap<>();
        Map<String, List<String>> neighbourMap = new HashMap<>();
        bfs(distanceMap, neighbourMap, beginWord, endWord, wordList);
        List<String> paths = new ArrayList<>();
        paths.add(beginWord);
        findLaddersHelper(answer, paths, distanceMap, neighbourMap, beginWord, endWord);
        return answer;
    }

    private void findLaddersHelper(List<List<String>> answer, List<String> paths, Map<String, Integer> distanceMap, Map<String, List<String>> neighbourMap, String beginWord, String endWord) {
        if (beginWord.equals(endWord)) {
            answer.add(new ArrayList<>(paths));
            return;
        }
        // 得到所有的下一个的节点
        *//*
      "a"
      "c"
      ["a","b","c"]*//*
        //之所以是 map.getOrDefault 而不是 get，就是上边的情况 get 会出错
        List<String> neighbors = neighbourMap.getOrDefault(beginWord, new ArrayList<>());
        for (String neighbor : neighbors) {
            //判断层数是否符合
            if (distanceMap.get(beginWord) + 1 == distanceMap.get(neighbor)) {
                paths.add(neighbor);
                findLaddersHelper(answer, paths, distanceMap, neighbourMap, neighbor, endWord);
                paths.remove(neighbor);
            }
        }
    }

    private void bfs(Map<String, Integer> distanceMap, Map<String, List<String>> neighbourMap, String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distanceMap.put(beginWord, 0);
        boolean isFound = false;
        int depth = 0;
        Set<String> dict = new HashSet<>(wordList);
        while (!queue.isEmpty()) {
            depth++;
            int size = queue.size(); //注意这块需要提前获取，注意queue的尺寸一直在变
            for (int i = 0; i < size; i++) {
                String currNode = queue.poll();
                // 一次性得到所有的下一个的节点
                List<String> neighbors = getNeighbours(dict, currNode);
                neighbourMap.put(currNode, neighbors);
                for (String neighbor : neighbors) {
                    if (!distanceMap.containsKey(neighbor)) {
                        distanceMap.put(neighbor, depth);
                        if (neighbor.equals(endWord)) {
                            isFound = true;
                        }
                        queue.offer(neighbor);
                    }
                }
            }
            if (isFound) {
                break;
            }
        }
    }

    private List<String> getNeighbours(Set<String> dict, String beginWord) {
        List<String> result = new ArrayList<>();
        char[] beginWordArr = beginWord.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int j = 0; j < beginWord.length(); j++) {
                if (beginWordArr[j] == ch) {
                    continue;
                }
                char oldChar = beginWordArr[j];
                beginWordArr[j] = ch;
                if (dict.contains(String.valueOf(beginWordArr))) {
                    result.add(String.valueOf(beginWordArr));
                }
                beginWordArr[j] = oldChar;
            }
        }
        return result;
    }*/


    // 第四种方法,可以ac
    // 优化 不用 distance ，在 BFS 中，如果发现有邻接节点在之前已经出现过了，我们直接把这个邻接节点删除不去。这样的话，在 DFS 中就不用再判断了，直接取邻居节点就可以了。
    // 这里删除邻接节点需要用到一个语言特性，java 中遍历 List 过程中，不能对 List 元素进行删除。如果想边遍历边删除，可以借助迭代器。
/*    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // 如果不含有结束单词，直接结束，不然后边会造成死循环
        List<List<String>> answer = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return answer;
        }
        Map<String, List<String>> neighbourMap = new HashMap<>();
        bfs(neighbourMap, beginWord, endWord, wordList);
        List<String> paths = new ArrayList<>();
        paths.add(beginWord);
        findLaddersHelper(answer, paths, neighbourMap, beginWord, endWord);
        return answer;
    }

    private void findLaddersHelper(List<List<String>> answer, List<String> paths, Map<String, List<String>> neighbourMap, String beginWord, String endWord) {
        if (beginWord.equals(endWord)) {
            answer.add(new ArrayList<>(paths));
            return;
        }
        // 得到所有的下一个的节点
        *//*
      "a"
      "c"
      ["a","b","c"]*//*
        //之所以是 map.getOrDefault 而不是 get，就是上边的情况 get 会出错
        List<String> neighbors = neighbourMap.getOrDefault(beginWord, new ArrayList<>());
        for (String neighbor : neighbors) {
            //判断层数是否符合
            paths.add(neighbor);
            findLaddersHelper(answer, paths, neighbourMap, neighbor, endWord);
            paths.remove(neighbor);
        }
    }

    private void bfs(Map<String, List<String>> neighbourMap, String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        boolean isFound = false;
        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size(); //注意这块需要提前获取，注意queue的尺寸一直在变
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String currNode = queue.poll();
                // 一次性得到所有的下一个的节点
                List<String> neighbors = getNeighbours(dict, currNode);
                Iterator<String> iterator = neighbors.iterator();
                while (iterator.hasNext()) {
                    String neighbor = iterator.next();
                    if (!visited.contains(neighbor)) {
                        if (neighbor.equals(endWord)) {
                            isFound = true;
                        }
                        queue.offer(neighbor);
                        subVisited.add(neighbor);
                    }else {
                        iterator.remove();
                    }
                }
                neighbourMap.put(currNode, neighbors);
            }
           // 最短转化序列
            visited.addAll(subVisited);
            if (isFound) {
                break;
            }
        }
    }

    private List<String> getNeighbours(Set<String> dict, String beginWord) {
        List<String> result = new ArrayList<>();
        char[] beginWordArr = beginWord.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int j = 0; j < beginWord.length(); j++) {
                if (beginWordArr[j] == ch) {
                    continue;
                }
                char oldChar = beginWordArr[j];
                beginWordArr[j] = ch;
                if (dict.contains(String.valueOf(beginWordArr))) {
                    result.add(String.valueOf(beginWordArr));
                }
                beginWordArr[j] = oldChar;
            }
        }
        return result;
    }*/


    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        // 如果不含有结束单词，直接结束，不然后边会造成死循环
        if (!wordList.contains(endWord)) {
            return ans;
        }
        bfs(beginWord, endWord, wordList, ans);
        return ans;
    }

    public void bfs(String beginWord, String endWord, List<String> wordList, List<List<String>> ans) {
        // 存储所有路径
        Queue<List<String>> queue = new LinkedList<>();
        List<String> path = new ArrayList<>();
        path.add(beginWord);
        queue.offer(path);
        boolean isFound = false;
        Set<String> dict = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!queue.isEmpty()){
            int size = queue.size();
            Set<String> subVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String>  tmpPath = queue.poll();
                String tmpNode = tmpPath.get(tmpPath.size()-1);
                List<String> neighbours = getNeighbors(tmpNode, dict);
                for (String neighbour:neighbours) {
                    if (!visited.contains(neighbour)){
                        if (neighbour.equals(endWord)){
                            tmpPath.add(neighbour);
                            ans.add(new ArrayList<>(tmpPath));
                            tmpPath.remove(tmpPath.size()-1);
                            isFound = true;
                        }
                        subVisited.add(neighbour);
                        tmpPath.add(neighbour);
                        queue.offer(new ArrayList<>(tmpPath));
                        tmpPath.remove(tmpPath.size()-1);
                    }
                }
            }
            visited.addAll(subVisited);
            // 最短转化序列
            if (isFound){
                break;
            }
        }
    }

    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        char chs[] = node.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (chs[i] == ch)
                    continue;
                char old_ch = chs[i];
                chs[i] = ch;
                if (dict.contains(String.valueOf(chs))) {
                    res.add(String.valueOf(chs));
                }
                chs[i] = old_ch;
            }

        }
        return res;
    }

}
