package solutions.amazon;

/**
 * 2222 Number of Ways to Select Buildings
 * Keywords:
 * Difficulty: Medium
 * Company: Amazon
 */
public class _2222NumberOfWaysToSelectBuildings {
    /**
     * 合法的组合只有2种：0-1-0 和 1-0-1
     * 遍历字符串s，如果当前的数字是0，那么需要找到这个0左边的1的数量，以及右边的1的数量，然后把这2个数量相乘就是当前的方案数
     * 同理，如果当前的数字是1，则找到1两侧的0的数量，然后相乘，得到当前方案数
     * 最后累加方案数，就是最后的结果
     * @param s 字符串
     * @return 合法组合的方案总数
     */
    public long numberOfWays(String s) {
        int zeroTotal = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                zeroTotal++;
            }
        }
        int oneTotal = s.length() - zeroTotal;
        //由于从s的第二位索引进行遍历，所以s的第一位如果是'0'，那么当前'0'的数量是1；
        //同理，如果s的第一位是'1'，则当前'1'的数量是1
        int currZeroNum = s.charAt(0) == '0' ? 1 : 0;
        int currOneNum = s.charAt(0) == '1' ? 1 : 0;
        long res = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == '0'){
                //计算0两侧1的数量的乘积
                res += currOneNum * (oneTotal - currOneNum);
                currZeroNum++;
            }else{
                //计算1两侧0的数量的乘积
                res += currZeroNum * (zeroTotal - currZeroNum);
                currOneNum++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _2222NumberOfWaysToSelectBuildings s = new _2222NumberOfWaysToSelectBuildings();
        long l = s.numberOfWays("001101");
        System.out.println(l);
    }

}
