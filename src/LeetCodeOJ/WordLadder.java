package LeetCodeOJ;

import java.util.HashSet;
import java.util.LinkedList;

/*Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,

 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.*/


/*这道题看似一个关于字符串操作的题目，其实要解决这个问题得用图的方法。
 * 我们先给题目进行图的映射，顶点则是每个字符串，然后两个字符串如果相差一个字符则我们进行
 * 连边。接下来看看这个方法的优势，注意到我们的字符集只有小写字母，而且字符串长度固定，
 * 假设是L。那么可以注意到每一个字符可以对应的边则有25个（26个小写字母减去自己），那么一个
 * 字符串可能存在的边是25*L条。接下来就是检测这些边对应的字符串是否在字典里，就可以得到一个
 * 完整的图的结构了。根据题目的要求，等价于求这个图一个顶点到另一个顶点的最短路径，一般我们
 * 用广度优先搜索（不熟悉搜索的朋友可以看看Clone Graph）即可。这个算法中最坏情况是把所有
 * 长度为L的字符串都看一下，或者把字典中的字符串都看一下，而长度为L的字符串总共有26^L，
 * 所以时间复杂度是O(min(26^L, size(dict))，空间上不需要额外空间，O(1)。*/

public class WordLadder {
	public int ladderLength(String start, String end, HashSet<String> dict) {
	    if(start==null || end==null || start.length()==0 || end.length()==0 || start.length()!=end.length())
	        return 0;
	    LinkedList<String> queue = new LinkedList<String>();
	    HashSet<String> visited = new HashSet<String>();
	    int level= 1;
	    int lastNum = 1;
	    int curNum = 0;
	    queue.offer(start);
	    visited.add(start);
	    while(!queue.isEmpty())
	    {
	        String cur = queue.poll();
	        lastNum--;
	        StringBuilder replace = new StringBuilder(cur);
	        for(int i=0;i<cur.length();i++)
	        {
	        	char old = replace.charAt(i);
	            for(char c='a';c<='z';c++)
	            {
	            	if(c==replace.charAt(i))continue;//itself
	            	replace.setCharAt(i, c);
	            	String replaced = replace.toString();
	                if(replaced.equals(end))
	                    return level+1;
	                if(dict.contains(replaced) && !visited.contains(replaced))
	                {
	                    curNum++;
	                    queue.offer(replaced);
	                    visited.add(replaced);
	                }
	            }
	            replace.setCharAt(i, old);
	        }
	        if(lastNum==0)
	        {
	            lastNum = curNum;
	            curNum = 0;
	            level++;
	        }
	    }
	    return 0;
	}
}
