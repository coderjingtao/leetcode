package solutions;

/**
 * NO.344 Reverse String
 * Keywords:   Array, two pointer, colliding pointer
 * Difficulty: Easy
 * Company:    Google
 */
public class _345ReverseVowels {
    /**
     * 思路：对撞指针
     * 分别从左右两端取出元素,如果都为元音则交换位置
     * 算法复杂度：O(n),空间复杂度:O(1)
     */
    public String reverseVowels(String s) {
        char[] charArr = s.toCharArray();
        int left=0, right=charArr.length-1;
        while(left < right){
            if(!isVowel(charArr[left]))
                left++;
            if(!isVowel(charArr[right]))
                right--;
            if( isVowel(charArr[left]) && isVowel(charArr[right]) )
                swap(charArr,left++,right--);
        }
        return String.valueOf(charArr);
    }

    public boolean isVowel(char c){
        char ch = Character.toLowerCase(c);
        if(ch =='a'||ch =='e'||ch =='i'||ch =='o'||ch =='u')
            return true;
        return false;
    }

    public void swap(char[] nums, int i, int j){
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        _345ReverseVowels r = new _345ReverseVowels();
        String s = "helly";
        System.out.println(r.reverseVowels(s));

    }
}
