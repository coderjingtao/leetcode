package solutions.amazon.spring2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1431 Kids With the Greatest Number of Candies
 * Keywords:
 * Difficulty: Easy
 * Company: Amazon
 */
public class _1431KidsWithTheGreatestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandy = Arrays.stream(candies).max().getAsInt();
        List<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            if(candy + extraCandies >= maxCandy){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}
