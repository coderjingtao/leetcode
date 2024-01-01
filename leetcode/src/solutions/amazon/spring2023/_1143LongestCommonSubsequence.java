package solutions.amazon.spring2023;

/**
 * 1143 Longest Common Subsequence
 * Keywords: LCS, DP, Classic
 * Difficulty: Medium
 * Company: Amazon
 */
public class _1143LongestCommonSubsequence {
    /**
     * [DP definition]
     *      dp[i][j] : the longest common subsequence between text1[0:i] and text2[0:j]
     * [DP state]
     *      i is processing the i-th char in text1 : XXXXXX i
     *      j is processing the j-th char in text2 : YYYY j
     * [DP equation]
     *      if text1[i] == text2[j] :
     *          dp[i][j] = dp[i-1][j-1] + 1;
     *      else :
     *          dp[i][j] = max(dp[i-1][j], dp[i][j-1])
     * [DP equation explanation]
     *      1. if the last character is equal:
     *      LCS("abcde","ace") = LCS("abcd","ac") + 1;
     *      2. if the last character is not equal:
     *      LCS("abcd","aec") = max(LCS("abcd","ae"), LCS("abc","aec"))
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];//dp要存储的数据长度，总要比text的长度多一位
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];//dp要存储的数据长度，总要比text的长度多一位
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        _1143LongestCommonSubsequence s = new _1143LongestCommonSubsequence();
        String text1 = "abcde";
        String text2 = "ace";
        int res = s.longestCommonSubsequence(text1, text2);
        System.out.println("res = " + res);
    }
}
