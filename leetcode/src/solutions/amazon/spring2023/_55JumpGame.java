package solutions.amazon.spring2023;

/**
 * 55 Jump Game
 * Keywords: Greedy Classic
 * Difficulty: Medium
 * Company: Amazon
 */
public class _55JumpGame {
    /**
     * 能不能跳到数组nums最远的末端，取决与每个数组元素的可跳跃的[最远右边界]是否可以到达nums.length - 1
     * 遍历每个元素（除最后一个元素），并贪心地更新[最远右边界]为每个元素的可跳跃的最远距离
     * 如果当前的位置（除最后一个元素）已经到达最远右边界了，则说明卡住了，不能往下跳了，不可能达到nums的末端了
     * 否则一直更新最远右边界，最后判断最远右边界是否可到达nums.length - 1
     */
    public boolean canJump(int[] nums) {
        int farthest = 0;
        for(int i = 0; i < nums.length - 1; i++){
            farthest = Math.max(farthest, i + nums[i]);
            //如果当前位置i到达了最远右边界，则不能往下跳了
            if(i == farthest){
                return false;
            }
        }
        return farthest >= nums.length - 1;
    }

    public static void main(String[] args) {
        _55JumpGame s = new _55JumpGame();
        //int[] nums = {0,2,3,1};
        int[] nums = {3,2,1,0,4,5,6,7};
        boolean res = s.canJump(nums);
        System.out.println("res = " + res);
    }
}
