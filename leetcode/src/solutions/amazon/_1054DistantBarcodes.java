package solutions.amazon;

import java.util.*;

/**
 * 1054 Distant Barcode (same with 767)
 * Keywords: Arrangement with stride
 * Difficulty: Medium+
 * Company: Amazon
 */
public class _1054DistantBarcodes {

    public int[] rearrangeBarcodes(int[] barcodes) {
        if(barcodes.length <= 1){
            return barcodes;
        }
        int[] res = new int[barcodes.length];
        PriorityQueue<Barcode> maxHeap = buildMaxHeap(barcodes);
        Barcode prev = null;
        int i = 0;
        while(!maxHeap.isEmpty()){
            Barcode curr = maxHeap.poll();
            res[i] = curr.num;
            curr.frequency--;
            if(prev != null && prev.frequency > 0){
                maxHeap.offer(prev);
            }
            prev = curr;
            i++;
        }
        return res;
    }

    private PriorityQueue<Barcode> buildMaxHeap(int[] barcodes){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < barcodes.length; i++){
            map.put(barcodes[i], map.getOrDefault(barcodes[i],0) + 1);
        }
        PriorityQueue<Barcode> maxHeap = new PriorityQueue<>(Comparator.comparing(barcode -> -barcode.frequency));
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
                maxHeap.offer(new Barcode(entry.getKey(),entry.getValue()));
        }
        return maxHeap;
    }

    public static void main(String[] args) {
        _1054DistantBarcodes s = new _1054DistantBarcodes();
        int[] barcodes = {1,2};
        int[] res = s.rearrangeBarcodes(barcodes);
        System.out.println(Arrays.toString(res));
    }
}
class Barcode{
    int num;
    int frequency;
    Barcode(int num, int frequency){
        this.num = num;
        this.frequency = frequency;
    }
}