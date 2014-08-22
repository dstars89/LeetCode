package LeetCodeOJ;

/*Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
 (ie, buy one and sell one share of the stock multiple times). 
 However, you may not engage in multiple transactions at the same time 
 (ie, you must sell the stock before you buy again).
 */
/*
 把数组中所有差价为正的值加起来就是最大利润了。因为只有递增区间内的差价是正数，
 并且同一递增区间内所有差价之和  = 区间最大价格 - 区间最小价格*/
public class BestTimetoBuyandSellStockII {
	public int maxProfit(int[] prices) {
		int len = prices.length;
		if (len <= 1)return 0;
		int res=0;
		for (int i = 0; i < len-1; i++) {
			if(prices[i+1]-prices[i]>0) 
				res += prices[i+1] - prices[i];
		}
		return res;

	}
}
