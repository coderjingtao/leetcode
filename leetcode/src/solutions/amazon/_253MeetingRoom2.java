package solutions.amazon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * NO.253 Meeting Room 2
 * Keywords: Interval
 * Difficulty: Medium
 * Company: Google, Facebook, Amazon
 */
public class _253MeetingRoom2 {
    public static void main(String[] args) {
        int[][] intervals = {
                {4,9},
                {4,17},
                {9,10},
        };
        _253MeetingRoom2 s = new _253MeetingRoom2();
        int num = s.minMeetingRooms2(intervals);
        System.out.println("num = " + num);
    }

    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) return 0;
        //把会议按照会议开始时间排序
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        //存放最早结束会议的最小结束时间堆
        PriorityQueue<Integer> minEndHeap = new PriorityQueue<>();
        //把最早开始会议的结束时间放入堆中
        minEndHeap.offer(intervals[0][1]);
        //按会议开始时间遍历会议
        for(int i = 1; i < intervals.length; i++){
            //如果当前会议的开始时间 >= 最早结束的时间，可以放到一个会议室中；所以修改当前堆中的最早结束时间
            if(intervals[i][0] >= minEndHeap.peek()){
                minEndHeap.poll();
            }
            minEndHeap.offer(intervals[i][1]);
        }
        return minEndHeap.size();
    }
    //扫描线算法
    public int minMeetingRooms2(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endIndex = 0;
        for(int i = 0; i < intervals.length; i++){
            if(starts[i] < ends[endIndex]){
                rooms++;
            }else{
                endIndex++;//结束时间更新为下一个结束时间
            }
        }
        return rooms;
    }

}
