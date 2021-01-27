package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * NO.438 Find All Anagrams in a String
 * Keywords: Array, two pointer
 * Difficulty: Easy
 * Company: Amazon
 */
public class _438FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret = new ArrayList<Integer>();
        for(int i=0; i+p.length() <= s.length(); i++)
            if(isAnagram1(s.substring(i,i+p.length()),p))
                ret.add(i);
        return ret;
    }

    //判断变位词的思路1：排序并比较是否相等，时间复杂度 O(nlogn)
    private static boolean isAnagram(String a, String b){
        if(a==null || b==null || a.length() != b.length())
            return false;
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        return Arrays.equals(x, y);
    }

    //判断变位词的思路2：用数组记录每个字符出现的频率,时间复杂度 O(n)
    private static boolean isAnagram1(String a, String b){
        if(a==null || b==null || a.length() != b.length())
            return false;
        int[] freq = new int[256];
        for(char c: a.toCharArray())
            freq[c]++;
        for(char c: b.toCharArray()){
            freq[c]--;
            if(freq[c] < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s= "cbaebabacd";
        String p= "abc";
        System.out.println(new _438FindAllAnagrams().findAnagrams(s, p));
        isAnagram(s,p);
//		System.out.println(isAnagram1(a,b));
    }
}
