package solutions.amazon.spring2023;

/**
 * 45 Jump Game 2
 * Keywords: Greedy Classic
 * Difficulty: Medium
 * Company: Amazon
 */
public class _45JumpGame2 {

    public int jump(int[] nums) {
        int jump = 0;
        int left = 0, right = 0;
        while(left <= right && right < nums.length -1){
            int farthest = right;
            for(int i = left; i <= right; i++){
                farthest = Math.max(farthest,nums[i]+i);
            }
            jump++;
            left = right + 1;
            right = farthest;
        }
        return jump;
    }

    /**
     *  定义nums中索引范围为[left, right]的元素的可跳跃的[最远右边界]的索引位置为farthest
     *  当left == right时，重新划分left和right,并且jump的值加1
     *  left值由for循环决定，right值为[最远右边界]farthest
     */
    public int jump2(int[] nums) {
        int jump = 0;
        int right = 0;
        int farthest = 0;
        for(int left = 0; left < nums.length - 1 ; left++){
            farthest = Math.max(farthest,nums[left] + left);
            if(farthest >= nums.length - 1) return ++jump;
            if(left == right){
                jump++;
                right = farthest;
            }
        }
        return jump;
    }

    public static void main(String[] args) {
        _45JumpGame2 s = new _45JumpGame2();
        //int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        int[] nums = {1,2,1,1,1};
        int jump = s.jump2(nums);
        System.out.println("jump = " + jump);
    }

}
