package solutions;

/**
 * NO.125 Valid Palindrome
 * Keywords:   Array, two pointer, colliding pointer
 * Difficulty: Easy
 * Company:    Facebook, Microsoft, Uber, Zenefits
 */
public class _125Palindrome {
    /**
     * 思路：对撞指针
     * 回文串的特征，就注定我们会分别从左右两端取出元素left和right，然后比较即可
     * 算法复杂度：O(n),空间复杂度:O(1)
     */
    public boolean isPalindrome(String s) {
        if(s==null)
            return false;
        if(s.isEmpty() || s.trim().length()==1)
            return true;

        char[] charArr = s.toCharArray();
        int left = 0;
        int right = charArr.length-1;
        while(left <= right){
            if(!Character.isLetterOrDigit(charArr[left])){
                left++;
            }
            else if(!Character.isLetterOrDigit(charArr[right])){
                right--;
            }
            else if(Character.toLowerCase(charArr[left]) != Character.toLowerCase(charArr[right]))
                return false;
            else if(Character.toLowerCase(charArr[left]) == Character.toLowerCase(charArr[right])){
                left++;
                right--;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        _125Palindrome p =  new _125Palindrome();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(p.isPalindrome(s));

    }
}
