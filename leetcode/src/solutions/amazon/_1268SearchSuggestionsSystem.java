package solutions.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * NO.1268 Search Suggestions System
 * Keywords: System
 * Difficulty: Medium
 * Company: Salesforce, DoorDash, Amazon
 */
public class _1268SearchSuggestionsSystem {

    public static void main(String[] args) {
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord = "mouse";
        _1268SearchSuggestionsSystem s = new _1268SearchSuggestionsSystem();
        List<List<String>> res = s.suggestedProducts(products, searchWord);
        for(List<String> row : res){
            System.out.println(row);
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        List<String> productList = Arrays.stream(products).sorted().collect(Collectors.toList());
        for(int i = 0 ; i < searchWord.length(); i++){
            String currWord = searchWord.substring(0, i + 1);
            List<String> matchList = productList.stream().filter(x -> x.startsWith(currWord)).limit(3).collect(Collectors.toList());
            res.add(matchList);
        }
        return res;
    }
}
