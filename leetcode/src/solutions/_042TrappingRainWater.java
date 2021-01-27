package solutions;

/**
 * NO.42 Trapping Rain Water
 * Keywords:   Array, Sliding window
 * Difficulty: Hard
 * Company:    Google, Amazon, Apple, Bloomberg
 * todo not finished
 */
public class _042TrappingRainWater {


    /**
     * Idea:
     * 只有相邻两侧的高度比它本身高才能蓄水
     * 依次查找数字，看是否其两侧高度是否比其高，如果有按较低高度计算面积后，加入总和之中，并把其本身高度上升到两侧的较低高度
     * 继续查找是否还有蓄水池
     */
    public int trap(int[] height) {
        int left=0, right=-1; // height[left,right] 初始不包括任何元素
        int maxLength = 0;
        boolean switch_open = false;
        while(left < height.length){

            if(right+1 < height.length && height[right+1] < height[left] ){
                right++;
                switch_open = true;
            }else{
                switch_open = false;
                left++;
            }
            maxLength = Math.max(maxLength , right-left+1);
        }
        return maxLength;
    }

}
