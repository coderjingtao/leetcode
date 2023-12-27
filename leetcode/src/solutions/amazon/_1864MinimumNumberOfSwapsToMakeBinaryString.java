package solutions.amazon;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1864 Minimum Number of Swaps to Make the Binary String Alternating
 * Keywords: Arrangement of String
 * Difficulty: Medium
 * Company: Amazon
 */
public class _1864MinimumNumberOfSwapsToMakeBinaryString {

    private boolean isEqualSize;

    public int minSwaps(String s) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Bit> maxHeap = buildMaxHeap(s);
        Bit prev = null;
        while(!maxHeap.isEmpty()){
            Bit curr = maxHeap.poll();
            sb.append(curr.c);
            curr.freq--;
            if(prev != null && prev.freq > 0){
                maxHeap.offer(prev);
            }
            prev = curr;
        }
        if(sb.length() != s.length()){
            return -1;
        }
        if(isEqualSize){
            String origin = sb.toString();
            System.out.println("origin = " + origin);
            String mutation = sb.reverse().toString();
            System.out.println("mutation = " + mutation);
            return Math.min(getDiffNum(s,origin),getDiffNum(s,mutation)) / 2;
        }
        return getDiffNum(s,sb.toString()) / 2;
    }

    private PriorityQueue<Bit> buildMaxHeap(String s){
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        if(map.getOrDefault('0',0).equals(map.getOrDefault('1',0))){
            isEqualSize = true;
        }
        PriorityQueue<Bit> maxHeap = new PriorityQueue<>(Comparator.comparing(bit -> -bit.freq));
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            maxHeap.offer(new Bit(entry.getKey(),entry.getValue()));
        }
        return maxHeap;
    }
    private int getDiffNum(String s, String str){
        int diff = 0;
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) != str.charAt(i)){
                diff++;
            }
        }
        return diff;
    }

    public static void main(String[] args) {
        String s = "1110";
        _1864MinimumNumberOfSwapsToMakeBinaryString so = new _1864MinimumNumberOfSwapsToMakeBinaryString();
        int res = so.minSwaps2(s);
        System.out.println("res = " + res);
    }

    /**
     * Simple Solution ： count the number of wrong character
     * step1: count the number of '0' and '1' separately
     * step2: if the difference of the number between '0' and '1' is greater than 1, return -1 (impossible)
     * step3: if the number of '0' is greater that '1', '0' should be the first character of the final result
     *        if the number of '1' is greater that '0', '1' should be the first character of the final result
     *        if the number of '1' is equal to '0', get the minimum number of swap both '1' and '0' as the first character
     * step4: count the number of wrong character
     *        e.g. s = "11001", the result must be "10101", the count of wrong char is 2, and the swap = count / 2
     * @param s
     * @return
     */
    public int minSwaps2(String s) {
        int zero = 0, one = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                zero++;
            }else{
                one++;
            }
        }
        if(Math.abs(zero - one) > 1){
            return -1;
        }
        if(zero > one){
            return countWrongChar(s,'0');
        }else if(zero < one){
            return countWrongChar(s,'1');
        }else{
            return Math.min(countWrongChar(s,'0'), countWrongChar(s,'1'));
        }
    }
    /**
     * count the number of wrong characters
     * @param s original string
     * @param correctChar the correct character of the final result
     * @return the swap number = count / 2
     */
    private int countWrongChar(String s, char correctChar){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != correctChar){
                count++;
            }
            //correctChar == '1' ? '0' : '1'
            correctChar ^= 1;
        }
        return count / 2;
    }
}

class Bit{
    char c;
    int freq;
    Bit(char c, int freq){
        this.c = c;
        this.freq = freq;
    }
}
