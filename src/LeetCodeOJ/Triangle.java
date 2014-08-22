package LeetCodeOJ;

import java.util.List;

/*Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.*/


/*从最小面一层开始往上计算，设dp[i][j]是以第i层j个元素为起点的最小路径和，动态规划方程如下

dp[i][j] = value[i][j] + max{dp[i-1][j], dp[i-1][j+1]}

因为每一层之和它下一层的值有关，因此只需要一个一位数组保存下层的值*/
  
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		int res=0;
		if(triangle==null||triangle.size()==0)return res;
		int rows=triangle.size();
		int[] dp =new int[rows]; 
		for (int i = 0; i < rows; i++) {
			dp[i]=triangle.get(rows-1).get(i);//initialize dp with the  values of the bottom layer 
		}
		for (int i=rows-2;i>=0;i--) {
			List<Integer> list=triangle.get(i);
			for (int j = 0; j <= i; j++) {
				// Find the lesser of its two children, and sum the current value in the triangle with it.--**
				dp[j]=list.get(j)+Math.min(dp[j], dp[j+1]);
			}
		}
		res=dp[0];
		return res;

	}
}
