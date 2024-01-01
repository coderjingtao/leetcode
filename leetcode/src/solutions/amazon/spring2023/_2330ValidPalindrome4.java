package solutions.amazon.spring2023;

/**
 * 2330 Valid Palindrome 4
 * Keywords: Collision Two Pointers
 * Difficulty: Medium
 * Company: Amazon
 */
public class _2330ValidPalindrome4 {

    public boolean makePalindrome(String s) {
        int maxOperation = 2;
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                maxOperation--;
                if(maxOperation < 0){
                    break;
                }
                left++;
                right--;
            }
        }
        return maxOperation >= 0;
    }

    public static void main(String[] args) {
        _2330ValidPalindrome4 solution = new _2330ValidPalindrome4();
        String s = "abcdef";
        boolean res = solution.makePalindrome(s);
        System.out.println("res = " + res);
    }

}
