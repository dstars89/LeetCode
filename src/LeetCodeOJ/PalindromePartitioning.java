package LeetCodeOJ;

import java.util.ArrayList;
import java.util.List;

/*Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
/*采用DP来做。为了不重复计算palindrome， 使用一个collect 存储从[i,j]是否为palindrome， 是为1， 不是为-1，没有测试过为0.*/
public class PalindromePartitioning {
/*	List<List<String>> result = null;
	int[][] collect = null;

	public List<List<String>> partition(String s) {
		result = new ArrayList<List<String>>();
		if(s==null||s.length()==0)return result;
		collect = new int[s.length()][s.length()];
		getPartition(s, 0, new ArrayList<String>());
		return result;
	}

	public void getPartition(String s, int pos, ArrayList<String> row) {
		if (pos == s.length())
			result.add(row);// the condition of end 
		for (int i = pos; i < s.length(); i++) {
			if (collect[pos][i] == 0) {
				if (checkPartition(s, pos, i))
					collect[pos][i] = 1;
				else
					collect[pos][i] = -1;
			}
			if (collect[pos][i] == 1) {
				row.add(s.substring(pos, i + 1));
				getPartition(s, i + 1, new ArrayList<String>(row));
				row.remove(row.size() - 1);//restore to previous value
			}
		}
	}

	public boolean checkPartition(String s, int start, int end) {
		for (int i = 0; i < (end - start + 1) / 2; i++) {
			if (s.charAt(start + i) != s.charAt(end - i))
				return false;
		}
		return true;
	}*/
	public List<List<String>> partition(String s) {
		if (s == null || s.length() == 0)
			return new ArrayList<List<String>>();
		boolean[][] isPa = new boolean[s.length()][s.length()];
		//dp 
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j) && (j - i < 2)//j - i < 2 && str[i] == str[j] （即如果j - i == 1时，为两个字符相等，如果j - i == 0时，为同一个字符） 
						|| s.charAt(i) == s.charAt(j) && isPa[i + 1][j - 1])//表示sub(i+1,j-1)是满足回文字符串 && str[i] == str[j] 
					isPa[i][j] = true;
			}
		}
		return partitionHelper(s, 0, isPa);
	}

	public List<List<String>> partitionHelper(String s, int start,boolean[][] isPa) {
		ArrayList<List<String>> pa = new ArrayList<List<String>>();
		if (start == s.length()) {
			pa.add(new ArrayList<String>());
			return pa;
		}
		for (int i = start; i < s.length(); i++) {
			if (isPa[start][i])
				for (List<String> subPa : partitionHelper(s, i + 1, isPa)) {
					subPa.add(0, s.substring(start, i + 1));
					pa.add(subPa);
				}
		}
		return pa;
	}
}


