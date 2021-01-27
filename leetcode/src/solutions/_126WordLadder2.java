package solutions;

import java.util.*;

/**
 * NO.126 Word Ladder II
 * Keywords:   BFS Queue
 * Difficulty: Hard
 * Company:    Amazon, Yelp
 * Correlation: NO.127
 */
public class _126WordLadder2 {

    /**
     * Solution 1: BFS 无权图的最短路径
     * 1. 从开始词开始，依次查找和它只差一个字母的词，并将<单词:步数>压入队列
     * (注意重复单词的情况，需要用一个set过滤已经入队的元素，否则大量重复入队会导致内存溢出)
     * hit --> hot
     *        /   \
     *      dot   lot
     *       |     |
     *      dog   log
     *        \   /
     *         cog
     * 2. 使用Queue和BFS方法求最短路径
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if(wordList == null || wordList.size()==0)
            throw new IllegalArgumentException();
        if(!wordList.contains(endWord))
            return res;
        HashSet<String> visitedSet = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        while(!queue.isEmpty()){
            String currWord = queue.poll();
            for(String comparedWord: wordList){
                if(!visitedSet.contains(comparedWord) && isSimilar(currWord,comparedWord)){
                    if(comparedWord.equals(endWord))
                        return null;
                    queue.add(comparedWord);
                    visitedSet.add(comparedWord);
                }
            }
        }
        return res;
    }

    private boolean isSimilar(String word1,String word2){
        if(word1.length() != word2.length() || word1.equals(word2))
            return false;
        int diff = 0;
        for(int i=0; i< word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i))
                diff++;
            if( diff > 1)
                return false;
        }
        return true;
    }

    private class Pair<K, V>{
        public K key;
        public V value;
        Pair(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
