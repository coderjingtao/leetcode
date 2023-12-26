package solutions.amazon;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 2268 Minimum Number of Keypress
 * Keywords:
 * Difficulty: Medium
 * Company: Amazon
 */
public class _2268MinimumNumberOfKeypress {

    public int minimumKeypresses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character, Integer> charFrequencyMap = getCharFrequencyMap(s);
        int res = 0;
        int i = 0;
        for(Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet()){
            int multipleFactor = i++ / 9 + 1;
            Integer value = entry.getValue();
            res += value * multipleFactor;
        }
        return res;
    }

    private Map<Character,Integer> getCharFrequencyMap(String s){
        //key = char, value = number of appearance
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1, LinkedHashMap::new));
    }

    public static void main(String[] args) {
        _2268MinimumNumberOfKeypress s = new _2268MinimumNumberOfKeypress();
        int res = s.minimumKeypresses("abcdefghijkl");
        System.out.println("res = " + res);
    }
}
