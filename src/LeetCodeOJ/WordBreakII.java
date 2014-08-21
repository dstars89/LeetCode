package LeetCodeOJ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].*/

public class WordBreakII {
	private ArrayList<String> result = new ArrayList<String>();
	public List<String> wordBreak(String s, Set<String> dict) {
		if (dict==null||dict.isEmpty())
			return result;
		if (s == null || s.isEmpty())
			return result;
		boolean[] mark = new boolean[s.length()+1]; //default false 
		Map<Integer,ArrayList<Integer>> collection=new HashMap<Integer,ArrayList<Integer>>();
		mark[0] = true;  
	    for(int i=0;i<s.length();i++)  
	    {  
	        StringBuilder str = new StringBuilder(s.substring(0,i+1));  
	        for(int j=0;j<=i;j++)  
	        {  
	            if(mark[j] && dict.contains(str.toString()))  
	            {  
	            	
	            	if(collection.containsKey(i+1))collection.get(i+1).add(j);
	            	else {
	            		ArrayList<Integer> list=new ArrayList<Integer>();
	            		list.add(j);
	            		collection.put(i+1,list);
					}
	            	mark[i+1] = true;  
	               // break;  
	            }  
	            str.deleteCharAt(0);  //substring
	        }  
	    }  
	   // dfs(s, dict, "",mark.length-1,mark);
	    if(mark[s.length()])
	    dep(s,collection, mark.length-1, new StringBuilder());
		return result;
	}
	
	public void dep(String s,Map<Integer, ArrayList<Integer>> collection,int key,StringBuilder res){
		if(collection.get(key)==null){
			result.add(res.toString().trim());
			return ;
		}
		for (Integer i: collection.get(key)) {
			String subString=s.substring(i, key)+" ";
			int len=subString.length();
			res.insert(0, subString);
			dep(s,collection,i,new StringBuilder(res));
			res=res.delete(0, len);
		}
	}
	
/*    public void dfs(String s, Set<String> dict, String currentStr,int index,boolean[] mark){
    	if (index<=0){
    		result.add(currentStr);
    	}
    	for (int i=index-1; i>=0; i--){
    		if(!mark[i])continue;
    		String sub = s.substring(i,index);
    		if (dict.contains(sub)){
    			int subLen = currentStr.length();
    			if (!currentStr.equals("")){
    				currentStr = " "+currentStr;
    			}
    			currentStr= sub+currentStr;
    			dfs(s,dict,currentStr,i,mark);
    			currentStr = currentStr.substring(currentStr.length()-subLen);
    		}
    	}
    }*/
	/*public List<String> wordBreak(String s, Set<String> dict) {
	ArrayList<String> res = new ArrayList<String>();
	if (s == null || s.length() == 0)
		return res;
	helper(s, dict, 0, "", res);
	return res;
}

private void helper(String s, Set<String> dict, int start, String item,
		ArrayList<String> res) {
	if (start >= s.length()) {
		res.add(item);
		return;
	}
	StringBuilder str = new StringBuilder();
	for (int i = start; i < s.length(); i++) {
		str.append(s.charAt(i));
		if (dict.contains(str.toString())) {
			String newItem = item.length() > 0 ? (item + " " + str
					.toString()) : str.toString();
			helper(s, dict, i + 1, newItem, res);
		}
	}*/
}
