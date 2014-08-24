package LeetCodeOJ;

import java.util.ArrayList;
import java.util.List;

/*Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/

public class PascalsTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		if(numRows<=0)return res;
		List<Integer> list=new ArrayList<Integer>(1),temp = list;
		list.add(1);
		res.add(list);
		for (int i = 1; i <numRows; i++) {
			 list=new ArrayList<Integer>(i+1);
			 list.add(1);
			 for (int j = 1; j < i; j++) {
				list.add(temp.get(j-1)+temp.get(j));
			}
			 list.add(1);
			 temp=list;
			res.add(list);
		}
		return res;

	}
}
