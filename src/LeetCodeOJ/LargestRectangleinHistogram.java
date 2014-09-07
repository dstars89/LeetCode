package LeetCodeOJ;

import java.util.Arrays;
import java.util.LinkedList;

/*Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given height = [2,1,5,6,2,3],
return 10.*/

public class LargestRectangleinHistogram {
	
	/*
	 * 可以通过分别枚举区间右边界和区间左边界，时间复杂度O(n^2)这样做大数据会超时。
	 * 枚举的过程中可以优化一下：可以很容易理解，如果height[i+1] > height[i],
	 * 那么区间[k…i]内的最大矩形肯定不会超过区间[k…i+1]内的最大矩形
	 */
	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int len=height.length;
		int res=0;
		int rBorder=0;
		while(rBorder<len){
			if(rBorder+1<len&&height[rBorder]<=height[rBorder+1])rBorder++;
			else {//找到了右边界
				int minVal = height[rBorder];
                //枚举左边界
                for(int lBorder = rBorder; lBorder >= 0; lBorder--)
                {
                    if(minVal > height[lBorder])
                        minVal = height[lBorder];
                    int tmpArea = minVal * (rBorder - lBorder + 1);
                    if(res < tmpArea)res = tmpArea;
                }
                rBorder++;
			}
		}
		return res;

	}

	public int largestRectangleArea2(int[] height) {
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int maxArea = 0;
		int[] h = new int[height.length + 1];
		h = Arrays.copyOf(height, height.length + 1);// 数组末尾插入dummy元素0
		for (int i = 0; i < h.length; i++) {
			if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty() && h[i] < h[stack.peek()]) {
					int top = stack.pop();
					maxArea = Math.max(maxArea, h[top]
							* (stack.isEmpty() ? i : i - stack.peek() - 1));// 注意为空
				}
				stack.push(i);
			}
		}
		return maxArea;
	}
}
