package solutions;

import java.util.HashMap;
import java.util.Map;

/**
 * NO.76 Minimum Window Substring
 * Keywords:   Array, two pointer, Sliding Window
 * Difficulty: Hard
 * Company:    Facebook, Linkedin, Uber, Snapchat
 */
public class _076MinimumWindowSubstring {
    /**
     * 思路：滑动窗口 Sliding Window
     * 给定一个子数组 substring[left,right]，初始值位于整个数组的左侧
     * s的右指针向右依次移动，直到窗口包含了所有t中的字符
     * s的左指针向右依次移动，看看是否还包含所有t中的字符，如果不包含则再次开始移动右指针，如果包含则继续移动左指针
     * 只要包含了所有t中的字符，则更新最短长度值
     *
     * 比较字符串中是否包含另一个字符串需要比较三个值：
     * 1. 单个字符都包含在两个字符串中
     * 2. 单个字符出现的数量/频率相等
     * 3. 出现的所有唯一字符的数量相等
     */
    public String minWindow(String s, String t) {

        //把t中的所有字符存放到字典中,具体形式是 <字符:数量>,所以这是字典的大小就是t中唯一字符的总数
        Map<Character,Integer> dictT = new HashMap<Character,Integer>();
        for(int i = 0; i < t.length(); i++){
            int n = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), n+1);
        }

        //滑动窗口的左右两个指针
        int L=0, R=0; // sliding window： s.substring[L ... R] 初始是不会取到任何值的
        //当前窗口中出现的t中的唯一字符数量
        //比如 t=abc, 当前窗口的字符串=aab, 那么这时currentMeetT=2，因为只符合了2个字符
        //这个变量是为了比较以上第三个条件
        int currentMeetT = 0;

        //当前窗口包含的字符，具体形式也是<字符:数量>
        Map<Character,Integer> window = new HashMap<Character,Integer>();
        //记录如果当前窗口全部包含t中字符时，窗口的大小和左右指针，具体的形式是{ window length, left, right}
        int[] record = {-1,L,R};

        while( R < s.length()){
            //把当前字符放到滑动窗口中
            char c = s.charAt(R);
            int count = window.getOrDefault(c, 0);
            window.put(c, count+1);
            //如果t中包含该字符，且当前窗口中该字符的频率和t中的也相同，则更新currentMeetT
            if(dictT.containsKey(c) && dictT.get(c).intValue() == window.get(c).intValue()){
                currentMeetT++;
            }

            //如果当前窗口中出现的t中的唯一字符总量和 t中的一致：更新记录值，并向左移动左指针
            while(L <= R && currentMeetT == dictT.size()){
                //如果当前窗口的长度为初始值，或比当前记录中的要小，则更新记录的最小值
                if(record[0] ==-1 || record[0] > R-L+1)
                {
                    record[0] = R-L+1;
                    record[1] = L;
                    record[2] = R;
                }

                c = s.charAt(L);
                window.put(c, window.get(c) - 1); //把左指针字符从当前窗口拿出去
                //如果t中包含该字符，且当前窗口中该字符的频率比t中的小，则让currentMeetT-1
                if(dictT.containsKey(c) && dictT.get(c).intValue() > window.get(c).intValue() ){
                    currentMeetT--;
                }
                L++; //如果唯一字符总量还一致，则继续移动 left pointer to contract
            }
            R++; //如果唯一字符总量不一致了，则继续移动 right pointer to expand
        }
        return record[0] == -1 ? "" : s.substring(record[1], record[2]+1);
    }


    public static void main(String[] args) {
        _076MinimumWindowSubstring m = new _076MinimumWindowSubstring();
        String s = "A";
        String t = "A";
        System.out.println(m.minWindow(s, t));
    }
}
