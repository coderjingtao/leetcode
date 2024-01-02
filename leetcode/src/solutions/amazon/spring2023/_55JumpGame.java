package solutions.amazon.spring2023;

/**
 * 55 Jump Game
 * Keywords: Greedy Classic
 * Difficulty: Medium
 * Company: Amazon
 */
public class _55JumpGame {

    public boolean canJump(int[] nums) {
        int farthest = 0;
        for(int i = 0; i < nums.length - 1; i++){
            farthest = Math.max(farthest, i + nums[i]);
            //如果当nums[i]的步数为0，且当前可跳跃的最远距离等于i时，说明无法越过该0的节点
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
