package solutions.amazon.spring2023;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 2405 Optimal Partition of String
 * Keywords: sliding window
 * Difficulty: Medium
 * Company: Amazon
 */
public class _2405OptimalPartitionOfString {

    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        List<String> res = new ArrayList<>();
        int left = 0, right = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            if(!set.contains(c)){
                set.add(c);
                right++;
            }else{
                res.add(s.substring(left,right));
                left = right;
                set.clear();
            }
        }
        res.add(s.substring(left,right));
        return res.size();
    }

    public static void main(String[] args) {
        _2405OptimalPartitionOfString solution = new _2405OptimalPartitionOfString();
        String s = "ssssss";
        int res = solution.partitionString(s);
        System.out.println("res = " + res);
    }
}
