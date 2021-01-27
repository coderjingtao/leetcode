package solutions;

import java.util.*;

/**
 * NO.347 Top K Frequent Elements
 * Keywords:   PriorityQueue
 * Difficulty: Medium
 * Company:    PocketGems, Yelp
 */
public class _347TopKFrequentElements {

    /**
     * Solution 1: 利用map记录每个数字出现的频次<num:frequency>，然后按照频次降序排序，输出前k个元素即可
     * Time complexity: O(nlogn) 有排序
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();//<num:frequency>
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //把map的entry组成list，并按照frequency进行降序排序
        List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList,(entry1,entry2) -> entry2.getValue() - entry1.getValue());
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<k; i++)
            res.add(entryList.get(i).getKey());
        return res;
    }

    /**
     * Solution 2: 维护一个含有k个元素的优先队列:最小堆 Min Heap
     * 如果遍历到的元素比队列中的最小频率元素的频率高，则取出队列中最小频率的元素，将新元素入队
     * 最终，队列中剩下的，就是前k个出现频率最高的元素
     * Time complexity: O(nlogk)
     */
    public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();//<num:frequency>
        for (int n : nums) {
            map.put(n, map.getOrDefault(n,0) + 1);
        }
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>(k);//<num:frequency>
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(pq.size()==k){
                Pair<Integer,Integer> pair = pq.peek();
                if(entry.getValue() > pair.value){
                    pq.poll();
                    pq.add(new Pair<>(entry.getKey(),entry.getValue()));
                }
            }else{
                pq.add(new Pair<>(entry.getKey(),entry.getValue()));
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty())
            res.add(pq.poll().key);
        //Collections.sort(res,Collections.reverseOrder()); //题目中不要求按频率从大到小的顺序输出
        return res;
    }

    private class Pair<K, V> implements Comparable<Pair<K,V>>{
        public K key;
        public V value;
        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
        @Override
        public int compareTo(Pair<K, V> o) {
            return Integer.compare((Integer)this.value,(Integer)o.value);
        }
    }

    public static void main(String[] args) {
        _347TopKFrequentElements t = new _347TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3,4,8,8,8,8};
        int k=3;
        System.out.println(t.topKFrequent2(nums,k).toString());
    }
}
