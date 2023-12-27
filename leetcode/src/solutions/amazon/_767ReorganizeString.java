package solutions.amazon;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 767 Reorganize String (same with 1054)
 * Keywords: Arrangement with stride
 * Difficulty: Medium+
 * Company: Amazon
 */
public class _767ReorganizeString {

    public String reorganizeString(String s) {
        if(s.length() <= 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Item> heap = buildMaxHeap(s);
        Item prev = null;
        while(!heap.isEmpty()){
            Item curr = heap.poll();
            sb.append(curr.c);
            curr.frequency--;
            if(prev != null && prev.frequency > 0){
                heap.offer(prev);
            }
            prev = curr;
        }
        return  sb.length() == s.length() ? sb.toString() : "";
    }

    private PriorityQueue<Item> buildMaxHeap(String s){
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        PriorityQueue<Item> maxHeap = new PriorityQueue<>(Comparator.comparingInt(item -> -item.frequency));
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            maxHeap.offer(new Item(entry.getKey(), entry.getValue()));
        }
        return maxHeap;
    }

    public static void main(String[] args) {
        _767ReorganizeString s = new _767ReorganizeString();
        String str = "aaab";
        String res = s.reorganizeString(str);
        System.out.println("res = " + res);
    }
}

class Item{
    char c;
    int frequency;
    Item(char c, int frequency){
        this.c = c;
        this.frequency = frequency;
    }
}
