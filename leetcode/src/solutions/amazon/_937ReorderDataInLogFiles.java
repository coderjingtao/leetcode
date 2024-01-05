package solutions.amazon;

import java.util.*;
import java.util.stream.Collectors;

/**
 * NO.937 Reorder Data in Log Files
 * Keywords:
 * Difficulty: Medium
 * Company: Amazon
 */
public class _937ReorderDataInLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        //step1: convert logs to a list contains an 2-digit array [id,content]; note: id can be repeated
        List<String[]> logList = new ArrayList<>();
        for(String log : logs){
            logList.add(log.split(" ", 2));
        }
        //step2: divide the list into 2 types : letter log and digit log
        List<String[]> letterLogList = new ArrayList<>();
        List<String[]> digitLogList = new ArrayList<>();
        logList.forEach( logArr -> {
            if(Character.isDigit(logArr[1].charAt(0))){
                digitLogList.add(logArr);
            }else{
                letterLogList.add(logArr);
            }
        });
        //step3: sort the letter log list by content and id
        List<String[]> sortedLetterLogList = letterLogList.stream()
                .sorted((logArr1, logArr2) -> {
                    int compare = logArr1[1].compareTo(logArr2[1]);
                    if (compare == 0) {
                        compare = logArr1[0].compareTo(logArr2[0]);
                    }
                    return compare;
                })
                .collect(Collectors.toList());
        //step4: output result
        List<String> list = new ArrayList<>();
        sortedLetterLogList.forEach( logArr -> {
            String c = logArr[0] + " " + logArr[1];
            list.add(c);
        });
        digitLogList.forEach(logArr -> {
            String c = logArr[0] + " " + logArr[1];
            list.add(c);
        });
        String[] res = new String[list.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] logs = {"1 n u", "r 527", "j 893", "6 14", "6 82"};
        _937ReorderDataInLogFiles solution = new _937ReorderDataInLogFiles();
        String[] res = solution.reorderLogFiles(logs);
        System.out.println(Arrays.toString(res));
    }

    public String[] reorderLogFiles2(String[] logs) {
        Arrays.sort(logs, (s1, s2) -> {
            int idx1 = s1.indexOf(' ');
            int idx2 = s2.indexOf(' ');
            String l1 = s1.substring(idx1 + 1);
            String l2 = s2.substring(idx2 + 1);

            if (l1.charAt(0) <= '9'){
                if (l2.charAt(0) <= '9') return 0;
                else return 1;
            } else {
                if (l2.charAt(0) <= '9') return -1;
                else{
                    int cmpContent = l1.compareTo(l2);
                    if (cmpContent != 0) return cmpContent;
                    return s1.substring(0, idx1).compareTo(s2.substring(0, idx2));
                }
            }
        });
        return logs;
    }
}
