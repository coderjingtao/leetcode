package solutions;

/**
 * NO.121 Best Time to Buy and Sell Stock
 * Keywords:   Array, Sliding window
 * Difficulty: Easy
 * Company:    Facebook, Microsoft, Amazon, Uber, Bloomberg
 */
public class _121BestTimeToBuyAndSellStock {

    /**
     * Solution 1:
     * 计算出所有右侧比左侧大的差值，取出差值的最大值
     * 时间复杂度 O(n^2)
     */
    public int maxProfit(int[] prices) {
        int maxBalance = 0;
        for(int i=0; i<prices.length; i++){
            for(int j=i+1; j < prices.length ; j++){
                if(prices[j]-prices[i] > maxBalance)
                    maxBalance = prices[j]-prices[i];
            }
        }
        return maxBalance;
    }

    /**
     * Solution 2:
     * 滑动窗口：
     * 初始指针：buy = 0, sell = 1,
     * 当卖的值比买的值小，则不进行交易，买的指针直接到当前卖的指针位置，卖的指针再向右移动一位
     * 当卖的值比买的值大，则记录一下该利润差,只有sell指针向右移动一位
     * 最后返回最大的利润差即可
     * 时间复杂度：O(n)
     */
    public int maxProfit2(int[] prices) {
        int maxBalance = 0;
        int buy = 0;
        int sell = 1;
        while(buy < prices.length && sell < prices.length){
            if(prices[buy] >= prices[sell]){
                buy = sell;
                sell++;
            }else{ //prices[buy] < prices[sell]
                maxBalance = Math.max(maxBalance, prices[sell] - prices[buy]);
                sell++;
            }
        }
        return maxBalance;
    }


    public static void main(String[] args) {
        _121BestTimeToBuyAndSellStock b = new _121BestTimeToBuyAndSellStock();
//        int[] prices = {7,1,5,3,6,4};
//        int[] prices = {7,6,5,4,3,1};
//        int[] prices = {2,4,1};
//        int[] prices = {2,4,1,2};
//        int[] prices = {};
        int[] prices = {1,2,4,2,5,7,2,4,9,0,9};
        System.out.println(b.maxProfit2(prices));
    }
}
