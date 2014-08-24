package LeetCodeOJ;

import java.util.ArrayList;
import java.util.List;

/*Given an index k, return the kth row of the Pascal's triangle.

 For example, given k = 3,
 Return [1,3,3,1].

 Note:
 Could you optimize your algorithm to use only O(k) extra space?*/

public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> res=new ArrayList<Integer>(rowIndex+1);
		if(rowIndex<0)return res;
		res.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			res.add(1);
			int temp=res.get(0);
			for (int j = 1; j < i; j++) {
				int temp1=res.get(j);
				res.set(j, temp1+temp);
				temp=temp1;
			}
		}
		return res;

	}
}
