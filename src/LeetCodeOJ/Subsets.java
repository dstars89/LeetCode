package LeetCodeOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]*/

public class Subsets {
	public List<List<Integer>> subsets(int[] S) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(S);
		res.add(new ArrayList<Integer>());
		for (int i = 0; i < S.length; i++) {
			int cur=S[i];
			int size=res.size();
			for (int j = 0; j < size; j++) {
				List<Integer> tmp=new ArrayList<Integer>(res.get(j));
				tmp.add(cur);
				res.add(tmp);
			}
		}
		return res;

	}
	public List<List<Integer>> subsets2(int[] S) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		res.add(new ArrayList<Integer>());
		Arrays.sort(S);
		long bit = 1, maxBit = 1 << S.length;
		while (bit < maxBit) {
			List<Integer> tmp=new ArrayList<Integer>();
			long curbit=bit;
			for (int i = 0; i < S.length; i++) {
				if((curbit&1)==1)tmp.add(S[i]);
				curbit>>=1;
			}
			res.add(tmp);
			bit++;
		}
		return res;
	}
}
