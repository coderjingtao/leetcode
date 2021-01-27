package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * NO.205 Isomorphic Strings
 * Keywords:   HashMap
 * Difficulty: Easy
 * Company:    Linkedin
 */
public class _205IsomorphicStrings {
    /**
     * 思路与NO.290 Word Pattern思路一致
     * 用两个map分别记录s和t中的字符和对应的索引赋值
     * 1.用一个指针同时遍历两个字符串，分别取得的当前的索引对应的字符
     * 2.根据字符来分别取得其在map中的索引值
     * 3.当索引值不同，则肯定不是同构字符串，返回即可
     * 4.当索引值相同，则把它们现在的索引值分别放到map中，继续向后查找，即使覆盖了之前相同的索引值也没有关系
     */
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character,Integer> mapS = new HashMap<Character,Integer>();
        Map<Character,Integer> mapT = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++){
            int indexS = mapS.getOrDefault(s.charAt(i), -1);
            int indexT = mapT.getOrDefault(t.charAt(i), -1);
            if(indexS != indexT)
                return false;
            mapS.put(s.charAt(i), i);
            mapT.put(t.charAt(i), i);
        }
        return true;
    }

    public static void main(String[] args) {
        _205IsomorphicStrings is = new _205IsomorphicStrings();
        String s = "paper";
        String t = "title";
        System.out.println(is.isIsomorphic(s, t));
    }
}
