package solutions.amazon;

import java.util.*;
import java.util.stream.Collectors;

/**
 * NO.1152 Analyze User Website Visit Pattern
 * Keywords:
 * Difficulty: Medium
 * Company: Amazon
 */
public class _1152AnalyzeUserWebsiteVisitPattern {

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        //step1: integrate into a Map<username,List<List<time,website>>
        Map<String,List<List<Object>>> map = new HashMap<>();
        for(int i = 0; i < username.length; i++){
            List<Object> tuple = new ArrayList<>();
            tuple.add(timestamp[i]);
            tuple.add(website[i]);
            List<List<Object>> tupleList = map.getOrDefault(username[i], new ArrayList<>());
            tupleList.add(tuple);
            map.put(username[i],tupleList);
        }
        //step2:
        Map<String,Integer> visitScore = new TreeMap<>();
        map.forEach( (user,tupleList) -> {
            //each user count one time for a pattern
            Set<String> patternSet = new HashSet<>();
            List<String> webList = tupleList.stream().sorted(Comparator.comparingInt(x -> (Integer) x.get(0))).map(x -> (String)x.get(1)).collect(Collectors.toList());
            for(int i = 0; i < webList.size()-2; i ++){
                for(int j = i+1; j < webList.size()-1; j++){
                    for(int k = j+1; k < webList.size(); k++){
                        String pattern = webList.get(i) + "," + webList.get(j) + "," + webList.get(k);
                        if(!patternSet.contains(pattern)){
                            visitScore.put(pattern,visitScore.getOrDefault(pattern,0) + 1);
                            patternSet.add(pattern);
                        }

                    }
                }
            }
        });
        Map.Entry<String, Integer> entry = visitScore.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get();
        System.out.println(entry.getKey() + " : " + entry.getValue());
        return Arrays.asList(entry.getKey().split(","));
    }

    public static void main(String[] args) {
        String[] username = {"h","eiy","cq","h","cq","txldsscx","cq","txldsscx","h","cq","cq"};
        int[] timestamp = {527896567,334462937,517687281,134127993,859112386,159548699,51100299,444082139,926837079,317455832,411747930};
        String[] website = {"hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","hibympufi","yljmntrclw","hibympufi","yljmntrclw"};
        _1152AnalyzeUserWebsiteVisitPattern solution = new _1152AnalyzeUserWebsiteVisitPattern();
        List<String> max_website = solution.mostVisitedPattern(username, timestamp, website);
        System.out.println("result: " + max_website);
    }
}
