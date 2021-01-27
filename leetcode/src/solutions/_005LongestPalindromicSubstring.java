package solutions;

/**
 * NO.5 Longest Palindromic Substring
 * Keywords:   Array
 * Difficulty: Medium
 * Company:    Microsoft, Amazon, Bloomberg
 * todo need a better solution
 */
public class _005LongestPalindromicSubstring {

    /**
     * Solution1:
     * 暴力法：依次从头尾两端进行循环截取子字符串，如果它是回文串，则记录下来，最后返回最长的回文串
     */
    public String longestPalindrome(String s){
        String ret = "";
        char[] chars = s.toCharArray();
        for(int i=0; i< chars.length; i++){
            for(int j=chars.length-1; j>=i; j--){
                if(isPalindromic(chars,i,j)){
                    ret = getLonger(ret,s.substring(i,j+1));
                }
            }
        }
        return ret;
    }

    private boolean isPalindromic(char[] chars, int left, int right){
        while(left <= right){
            if(chars[left] != chars[right])
                return false;
            else{
                left++;
                right--;
            }
        }
        return true;
    }

    private String getLonger(String s1, String s2){
        if(s1 == null)
            return s2;
        if(s2 == null)
            return s1;
        return s1.length() >= s2.length() ? s1:s2;
    }



    public static void main(String[] args) {
        _005LongestPalindromicSubstring l =  new _005LongestPalindromicSubstring();
        String s = "cbcdcbedcbc";
        System.out.println(l.longestPalindrome(s));
    }
}
