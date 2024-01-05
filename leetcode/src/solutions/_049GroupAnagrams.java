package solutions;

import java.util.*;

/**
 * NO.49 Group Anagrams
 * Keywords:   HashMap
 * Difficulty: Medium
 * Company:    Facebook, Amazon, Uber, Yelp, Bloomberg
 */
public class _049GroupAnagrams {
    /**
     * Thought: 遍历数组，把他们存放在一个map中，map< anagram : [word1,word2 ...] >
     * 其中anagram是word排序后的结果
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String word : strs){
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, list -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        _049GroupAnagrams g = new _049GroupAnagrams();
        System.out.println(g.groupAnagrams(strs));
    }
}
