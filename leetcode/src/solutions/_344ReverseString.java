package solutions;

/**
 * NO.344 Reverse String
 * Keywords:   Array, two pointer, colliding pointer
 * Difficulty: Easy
 * Company:
 */
public class _344ReverseString {
    /**
     * 思路：逆序指针
     * 从右向左遍历字符，并存储到新开辟的空间
     * 算法复杂度：O(n),空间复杂度:O(n)
     */
    public String reverseString(String s) {
        char[] charArr = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for(int i=charArr.length-1; i>=0; i--)
            sb.append(charArr[i]);
        return sb.toString();
    }

    /**
     * 思路：对撞指针
     * 分别从左右两端取出元素并交换位置
     * 算法复杂度：O(n),空间复杂度:O(1)
     */
    public String reverseString2(String s) {
        char[] charArr = s.toCharArray();
        int left = 0, right = charArr.length-1;
        while(left < right){
            swap(charArr,left,right);
            left++;
            right--;
        }
        return String.valueOf(charArr);
    }

    public void swap(char[] nums, int i, int j){
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        _344ReverseString r = new _344ReverseString();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(r.reverseString2(s));

    }
}
