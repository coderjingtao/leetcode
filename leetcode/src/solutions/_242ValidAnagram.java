package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * NO.242 Valid Anagram
 * Keywords:   HashMap, Array
 * Difficulty: Easy
 * Company:    Amazon, Uber, Yelp
 */
public class _242ValidAnagram {

    //Idea1: Sort and Compare

    //Idea2: Anagram要求字符一样，且数量相等，所以需要用到Map{ 字符：数量  }的特性
    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;
        Map<Character,Integer> dictS = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int count = dictS.getOrDefault(c, 0);
            dictS.put(c, count+1);
        }
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(!dictS.containsKey(c))
                return false;
            else if(dictS.get(c) <= 0)
                return false;
            else
                dictS.put(c, dictS.get(c)-1);
        }
        return true;
    }

    //Idea3: Use array instead of map
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] dictS = new int[128]; //题目中只有小写字母，如果大小写都有，需要256
        for(int i = 0; i < s.length(); i++)
            dictS[s.charAt(i)]++;
        for(int i = 0; i < t.length(); i++){
            dictS[t.charAt(i)]--;
            if(dictS[t.charAt(i)] < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        _242ValidAnagram v = new _242ValidAnagram();
        String s = "aabb";
        String t = "abcd";
        System.out.println(v.isAnagram2(s, t));
    }
}
