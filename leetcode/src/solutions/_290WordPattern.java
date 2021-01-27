package solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * NO.290 Word Pattern
 * Keywords:   HashMap
 * Difficulty: Easy
 * Company:    Uber, Dropbox
 */
public class _290WordPattern {
    //先记录pattern:HashMap{'a':[0,3,7] , 'b': [1,2]}
    //再根据pattern 去判断str
    public boolean wordPattern(String pattern, String str) {

        String[] strs = str.split(" ");
        if(pattern.length() != strs.length)
            return false;
        Map<Character,ArrayList<Integer>> dictPattern = new HashMap<Character,ArrayList<Integer>>();
        for(int i = 0; i < pattern.length() ; i++){
            char c = pattern.charAt(i);
            if(dictPattern.containsKey(c))
            {
                ArrayList<Integer> indexList = dictPattern.get(c);
                indexList.add(i);
                dictPattern.put(c, indexList);
            }
            else
            {
                ArrayList<Integer> indexList = new ArrayList<Integer>();
                indexList.add(i);
                dictPattern.put(c, indexList);
            }
        }
        String first="";
        for(Map.Entry<Character,ArrayList<Integer>> entry: dictPattern.entrySet()){

            ArrayList<Integer> indexList = entry.getValue();
            if(first.equals(strs[indexList.get(0)]))
                return false;
            first = strs[indexList.get(0)];
            for(int i=1; i< indexList.size(); i++){
                String other = strs[indexList.get(i)];
                if(!first.equals(other))
                    return false;
            }
        }
        return true;
    }

    /**
     * 用一个指针同时遍历 pattern 和 words 只要他们存在索引不一致，则返回false, 否则符合模式
     * 分别建立2个map，分别存储pattern和words及对应的索引值,格式是{char:index} 和 {word: index}
     * 注意：不要把元素一次性都放到map中，索引一致再同时放入，这时即使覆盖也没有关系
     */
    public boolean wordPattern2(String pattern, String str) {
        String[] words = str.split(" ");
        if(pattern.length() != words.length)
            return false;
        Map<Character,Integer> map1 = new HashMap<Character,Integer>();
        Map<String, Integer> map2 = new HashMap<String, Integer>();
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String word = words[i];
            int pIndex = map1.getOrDefault(c, -1);
            int wIndex = map2.getOrDefault(word, -1);

            if(pIndex != wIndex)
                return false;

            map1.put(c, i);
            map2.put(word, i);
        }
        return true;
    }

    public static void main(String[] args) {
        _290WordPattern w = new _290WordPattern();
        String pattern = "abba", str = "dog cat cat dog";
        System.out.println(w.wordPattern2(pattern, str));
    }
}
