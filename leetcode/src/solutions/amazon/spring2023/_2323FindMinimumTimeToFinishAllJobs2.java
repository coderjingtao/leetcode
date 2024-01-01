package solutions.amazon.spring2023;

import java.util.Arrays;

/**
 * 2323 Find Minimum Time to Finish All Jobs 2
 * Keywords: Greedy
 * Difficulty: Medium
 * Company: Amazon
 */
public class _2323FindMinimumTimeToFinishAllJobs2 {

    public int minimumTime(int[] jobs, int[] workers) {
        Arrays.sort(jobs);
        Arrays.sort(workers);
        int minDay = 0;
        for(int i = 0; i < jobs.length; i++){
            int day = (int)Math.ceil((double)jobs[i]/workers[i]);
            minDay = Math.max(minDay,day);
        }
        return minDay;
    }

    public static void main(String[] args) {
        _2323FindMinimumTimeToFinishAllJobs2 s = new _2323FindMinimumTimeToFinishAllJobs2();
        int[] jobs = {5};
        int[] workers = {2};
        int day = s.minimumTime(jobs, workers);
        System.out.println("day = " + day);
    }
}
