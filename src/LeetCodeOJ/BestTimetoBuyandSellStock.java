package LeetCodeOJ;

/*Say you have an array for which the ith element is the price of a given stock on day i.
 If you were only permitted to complete at most one transaction (ie, buy one and 
 sell one share of the stock), design an algorithm to find the maximum profit.*/



public class BestTimetoBuyandSellStock {
	
	public int maxProfit(int[] prices) {
		/*设dp[i]是[0,1,2...i]区间的最大利润，则该问题的一维动态规划方程如下

		dp[i+1] = max{dp[i], prices[i+1] - minprices}  ,minprices是区间[0,1,2...,i]内的最低价格

		我们要求解的最大利润 = max{dp[0], dp[1], dp[2], ..., dp[n-1]}*/
		/*if(prices==null||prices.length<=1)return 0;
		int res=prices[1]-prices[0],minPrice=prices[0];
		for (int i = 2; i < prices.length; i++) {
			minPrice=Math.min(minPrice, prices[i-1]);
			res=Math.max(res, prices[i]-minPrice);
		}
		if(res<0)return 0;
		else return res;*/
		
/*		按照股票差价构成新数组 prices[1]-prices[0], prices[2]-prices[1], 
 * prices[3]-prices[2], ..., prices[n-1]-prices[n-2]。求新数组的最大子段和
 * 就是我们求得最大利润，假设最大子段和是从新数组第 i 到第 j 项，那么子段和
 * = prices[j]-prices[j-1]+prices[j-1]-prices[j-2]+...+prices[i]-prices[i-1] = prices[j]-prices[i-1],
 *  即prices[j]是最大价格，prices[i-1]是最小价格，且他们满足前后顺序关系。*/
		int len = prices.length;
		if (len <= 1)return 0;
		int res = 0, currsum = 0;
		for (int i = 1; i < len; i++) {
			if (currsum <= 0)
				currsum = prices[i] - prices[i - 1];
			else
				currsum += prices[i] - prices[i - 1];
			if (currsum > res)
				res = currsum;
		}
		return res;
	}
	
	
}
