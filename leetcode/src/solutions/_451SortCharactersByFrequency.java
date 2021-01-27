package solutions;

import java.util.*;

/**
 * NO.451 Sort Characters By Frequency
 * Keywords:   HashMap
 * Difficulty: Medium
 * Company:    Google, Amazon
 */
public class _451SortCharactersByFrequency {
    /**
     * 思路：把字符和其出现的频率放入map{char:freq}， 注意：HashMap缺点是无序性
     * 然后把map中的每个元素都放入list中，按照频率大小降序排列
     * 然后输出字符串即可
     */
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0; i < s.length(); i++)
            map.put( s.charAt(i), map.getOrDefault(s.charAt(i),0)+1 );
        List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>();
        for(Map.Entry<Character, Integer> entry : map.entrySet())
            list.add(entry);
        Collections.sort(list, new SortCondition());
        StringBuffer sb = new StringBuffer();
        for(Map.Entry<Character, Integer> entry: list){
            char c = entry.getKey();
            for(int i=0; i< entry.getValue(); i++)
                sb.append(c);
        }
        return sb.toString();
    }

    class SortCondition implements Comparator<Map.Entry<Character, Integer>>
    {

        @Override
        public int compare(Map.Entry<Character, Integer> arg0, Map.Entry<Character, Integer> arg1) {
            return arg1.getValue() - arg0.getValue() ;
        }

    }

    //对排序优化，省略排序类
    //代码虽然简化，但效率变慢了
    public String frequencySort2(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for( char c: s.toCharArray()) //优化1：减少使用 String.charAt(i) 十分消耗性能
            map.put( c, map.getOrDefault(c,0) + 1 );
        List<Character> list = new ArrayList<Character>(map.keySet());//优化2：list只存key值
        list.sort( (c1,c2) -> map.get(c2) - map.get(c1)); //优化3：倒叙排序
        StringBuffer sb = new StringBuffer();
        for( char c: list)
            for(int i=0; i<map.get(c);i++)
                sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        _451SortCharactersByFrequency s = new _451SortCharactersByFrequency();
        System.out.println(s.frequencySort2("tree"));
    }
}
