package solutions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * NO.3 Longest Substring Without Repeating Characters
 * Keywords:   Array, two pointer, Sliding Window
 * Difficulty: Medium
 * Company:    Amazon, Adobe, Yelp, Bloomberg
 */
public class _003LongestSubstringWithoutRepeat {
    /**
     * 思路：滑动窗口 Sliding Window
     * 给定一个子数组 char[left,right]，初始值位于整个数组的左侧
     * 如果right右侧下一个字母没有重复过，则右侧指针向右移动，
     * 如果right右侧下一个字母发生过重复，则左侧指针向右一个一个移动，直到把这个重复元素剔除出该数组
     * 算法复杂度：O(n),空间复杂度:O(1)
     */
    public int lengthOfLongestSubstring(String s) {
        int left=0, right=-1; // char[left,right] 初始不包括任何元素
        int maxLength = 0;
        Map<Character,Integer> dict = new HashMap<Character,Integer>();
        char[] charArr = s.toCharArray();
        while(left < charArr.length){

            if(right+1 < charArr.length && dict.get(charArr[right+1]) == null){
                right++;
                dict.put(charArr[right], 0);
            }else{
                dict.put(charArr[left], null);
                left++;
            }
            maxLength = Math.max(maxLength , right-left+1);
        }
        return maxLength;
    }

    //Improvement1: Use Array instead of Map
    public int lengthOfLongestSubstring1(String s) {
        int left = 0, right = -1;
        int maxLength = 0;
        int[] dict = new int [256];
        while(left < s.length()){
            if(right + 1 < s.length() && dict[s.charAt(right+1)] == 0) // 字典中不存在右侧的字符
            {
                right++; //把右侧的字符纳入
                dict[s.charAt(right)]++; //在字典中给该字符值加1，表示字典中已有该字符
            }
            else // dict[s.charAt(right+1)] == 1 字典中存在右侧字符
            {
                //左侧指针向右一个一个移动，直到把这个重复元素剔除出该数组
                dict[s.charAt(left)] --; //把左侧字符移除字典
                left++; //把左侧指针右移一位
            }
            maxLength = Math.max(maxLength , right-left+1);
        }
        return maxLength;
    }

    //Improvement2: Use Array record the last occurrence of left pointer 记录字符最后一次出现的指针位置
    //右指针一直向右移动，遇到重复字符后，左指针移位到重复字符的下一个字符位置，最后计算字符串的长度
    public int lengthOfLongestSubstring2(String s) {
        int left = 0;
        int[] last = new int[256];
        Arrays.fill(last, -1); //全部置成无效指针位置 -1
        int maxLength = 0;
        for(int right=0 ; right < s.length(); right++){
            if(last[s.charAt(right)] != -1) //如果右侧的字符重复
                //取出该已重复字符的最后一次出现的指针位置，后移一位并赋值给左指针,
                //这时如果左指针已经比这个值大，即左指针已经越过了该位置，则还取现有的左指针值，即左指针不可以回头取值
                left = Math.max(left, last[s.charAt(right)] + 1);
            last[s.charAt(right)] = right; //遍历把字符的指针放到数组中
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        _003LongestSubstringWithoutRepeat l = new _003LongestSubstringWithoutRepeat();
        String s = "abba";
        System.out.println(l.lengthOfLongestSubstring2(s));
    }
}
