package solutions.amazon.spring2023;

import java.util.Arrays;

/**
 * 1151 Minimum Swaps to Group All 1's Together
 * Keywords: sliding window
 * Difficulty: Medium
 * Company: Amazon
 */
public class _1151MinimumSwapToGroupAllOnesTogether {

    public int minSwaps(int[] data) {
        int min = data.length;
        int oneTotal = (int)Arrays.stream(data).filter(x -> x == 1).count();
        int left = 0;
        int right = 0;
        int oneCount = 0;
        while(right < data.length){
            if(data[right] == 1){
                oneCount++;
            }
            if(right >= oneTotal){
                if(data[left] == 1){
                    oneCount--;
                }
                left++;
            }
            min = Math.min(min,oneTotal-oneCount);
            right++;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] data = {1,0,1,0,1};
        _1151MinimumSwapToGroupAllOnesTogether s = new _1151MinimumSwapToGroupAllOnesTogether();
        int res = s.minSwaps(data);
        System.out.println("res = " + res);
    }
}
