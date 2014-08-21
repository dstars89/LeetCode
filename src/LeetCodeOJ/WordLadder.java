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
	        for(int i=0;i<cur.length();i++)
	        {
	            char[] charCur = cur.toCharArray();
	            for(char c='a';c<='z';c++)
	            {
	                charCur[i] = c;
	                String temp = new String(charCur);
	                if(temp.equals(end))
	                    return level+1;
	                if(dict.contains(temp) && !visited.contains(temp))
	                {
	                    curNum++;
	                    queue.offer(temp);
	                    visited.add(temp);
	                }
	            }
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
