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

        List<List<String>> res = new ArrayList<List<String>>();
        Map<String,List<String>> map =  new HashMap<String,List<String>>();
        //Create one map to store the sorted word as anagram in memory
        for(String word: strs){
            String anagram = sort(word);
            List<String> group = map.getOrDefault(anagram, new ArrayList<String>());
            group.add(word);
            map.put(anagram, group);
        }
        for(List<String> group: map.values()){
            res.add(group);
        }
        return res;
    }

    private String sort(String str){
        char[] arrStr= str.toCharArray();
        Arrays.sort(arrStr);
        return String.valueOf(arrStr);
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        _049GroupAnagrams g = new _049GroupAnagrams();
        System.out.println(g.groupAnagrams(strs));
    }
}
