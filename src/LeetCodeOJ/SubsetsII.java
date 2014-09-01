package LeetCodeOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a collection of integers that might contain duplicates, S, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If S = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]*/


/*如果当前处理的元素没有出现过，则把前面得到的所有集合加上该元素；
 * 如果出现过，则只把上一轮处理的集合加上该元素。
 * 比如处理第二个2时（二叉树第三层），我们只把上一轮添加过数字的集合{1,2}、{2}再添加一个2加入结果中，
 * {1}、{}是从上一层直接继承下来的，所以不作处理。*/
public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		res.add(new ArrayList<Integer>());
		int oldval=num[0],opResNum =1;//上一个数字、即将要进行操作的子集数量
		for (int i = 0; i < num.length; i++) {
			int cur=num[i];
			if(oldval!=cur){
				oldval=cur;
				opResNum =res.size();
			}
			int size=res.size();
			for (int j =size-1; j >=size-opResNum; j--) {
				List<Integer> tmp=new ArrayList<Integer>(res.get(j));
				tmp.add(cur);
				res.add(tmp);
			}
		}
		return res;
	}
}
