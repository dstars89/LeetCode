package LeetCodeOJ;

import java.util.Set;
/*Given a string s and a dictionary of words dict, determine if s can be 
 * segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".*/


/*首先我们要存储的历史信息res[i]是表示到字符串s的第i个元素为止能不能用字典中的词来表示，
 * 我们需要一个长度为n的布尔数组来存储信息。然后假设我们现在拥有res[0,...,i-1]的结果，
 * 我们来获得res[i]的表达式。思路是对于每个以i为结尾的子串，看看他是不是在字典里面以及他之前的
 * 元素对应的res[j]是不是true，如果都成立，那么res[i]为true*/

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		if (dict==null||dict.isEmpty())
			return false;
		if (s == null || s.isEmpty())
			return true;
		boolean[] mark = new boolean[s.length()+1]; //default false 
		mark[0] = true;  
	    for(int i=0;i<s.length();i++)  
	    {  
	        StringBuilder str = new StringBuilder(s.substring(0,i+1));  
	        for(int j=0;j<=i;j++)  
	        {  
	            if(mark[j] && dict.contains(str.toString()))  
	            {  
	            	mark[i+1] = true;  
	                break;  
	            }  
	            str.deleteCharAt(0);  //substring
	        }  
	    }  
	    return mark[s.length()];

	}
	
}
