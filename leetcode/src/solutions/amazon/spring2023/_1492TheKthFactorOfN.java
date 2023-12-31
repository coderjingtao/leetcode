package solutions.amazon.spring2023;

/**
 * 1492 The Kth Factor of n
 * Keywords:
 * Difficulty: Medium
 * Company: IBM, Amazon
 */
public class _1492TheKthFactorOfN {

    public int kthFactor(int n, int k) {
        int pos = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                pos++;
                if(pos == k){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        _1492TheKthFactorOfN s = new _1492TheKthFactorOfN();
        int i = s.kthFactor(4, 4);
        System.out.println("i = " + i);
    }
}
