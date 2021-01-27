package solutions;

import java.util.*;

/**
 * NO.127 Word Ladder
 * Keywords:   BFS Queue
 * Difficulty: Medium
 * Company:    Facebook, Amazon, Linkedin, Snapchat, Yelp
 * Correlation: NO.279, NO.126
 * todo: check whether has a better solution less than O(n*n)
 */
public class _127WordLadder {
    /**
     * Solution 1: BFS 无权图的最短路径
     * 1. 从开始词开始，依次查找和它只差一个字母的词，并将<单词:步数>压入队列
     * (注意重复单词的情况，需要用一个set过滤已经入队的元素，否则大量重复入队会导致内存溢出)
     * hit(1) --> hot(2)
     *           /    \
     *       dot(3)   lot(3)
     *          |      |
     *       dog(4)   log(4)
     *           \    /
     *           cog(5)
     * 2. 使用Queue和BFS方法求最短路径
     * Time complexity: O(n^2)
     * Space complexity: O(n)
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.size()==0)
            throw new IllegalArgumentException();
        if(!wordList.contains(endWord))
            return 0;
        HashSet<String> visitedSet = new HashSet<>();
        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord,1));
        while(!queue.isEmpty()){
            Pair<String,Integer> pair = queue.poll();
            String currWord = pair.key;
            Integer currStep = pair.value;
            if(currWord.equals(endWord))
                return currStep;
            for(String comparedWord: wordList){
                if(!visitedSet.contains(comparedWord) && isSimilar(currWord,comparedWord)){
                    queue.add(new Pair<>(comparedWord,currStep + 1));
                    visitedSet.add(comparedWord);
                }
            }
        }
        return 0;
    }

    /**
     * Improvement of Solution 1 for speeding up
     * 如果被比较的词和当前词相似，并且被比较词就等于结束词，直接返回，不用入队了,节省时间和内存
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || wordList.size()==0)
            throw new IllegalArgumentException();
        if(!wordList.contains(endWord))
            return 0;
        HashSet<String> visitedSet = new HashSet<>();
        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord,1));
        while(!queue.isEmpty()){
            Pair<String,Integer> pair = queue.poll();
            String currWord = pair.key;
            Integer currStep = pair.value;
            for(String comparedWord: wordList){
                if(!visitedSet.contains(comparedWord) && isSimilar(currWord,comparedWord)){
                    if(comparedWord.equals(endWord))
                        return currStep+1;
                    queue.add(new Pair<>(comparedWord,currStep + 1));
                    visitedSet.add(comparedWord);
                }
            }
        }
        return 0;
    }

    //如果word1和word2只有一个字符差别，则返回true，否则是false
    private boolean isSimilar(String word1,String word2){
        if(word1 == null || word1.length() == 0)
            throw new IllegalArgumentException();
        if(word2 == null || word2.length() == 0)
            throw new IllegalArgumentException();
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

    public static void main(String[] args) {
        _127WordLadder w = new _127WordLadder();
        String beginWord = "cet";
        String endWord = "ism";
        String[] arr = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
        List wordList = Arrays.asList(arr);
        System.out.println(w.ladderLength(beginWord,endWord,wordList));
    }


}
