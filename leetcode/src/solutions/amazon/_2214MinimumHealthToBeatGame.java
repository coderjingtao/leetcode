package solutions.amazon;

import java.util.Arrays;

/**
 * NO.2214 Minimum Health to Beat Game
 * Keywords: Array Greedy Prefix Sum
 * Difficulty: Medium
 * Company: Amazon
 */
public class _2214MinimumHealthToBeatGame {
    public long minimumHealth(int[] damage, int armor) {
        Arrays.sort(damage);
        int max = damage[damage.length-1];
        damage[damage.length-1] = Math.max(max - armor, 0);
        //convert to a long integer
        return Arrays.stream(damage).asLongStream().sum() + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3};
        int armor = 0;
        _2214MinimumHealthToBeatGame s = new _2214MinimumHealthToBeatGame();
        long l = s.minimumHealth(nums, armor);
        System.out.println("res = " + l);
    }


}
