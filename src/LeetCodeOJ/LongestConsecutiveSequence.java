package LeetCodeOJ;

import java.util.HashMap;
import java.util.Map;

/*Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.*/


/*I have used a hashmap in my solution. The keyset of the map stores the number in the 
 * given array. The entryset stores the upper/lower end of sequence if the key is an 
 * lower/upper end of an existing consecutive sequence.

 For a new number ,we have four conditions 
 1) It will be a new lower end.-->Refresh both upper and lower end 
 2) It will be a new upper end.-->Refresh both upper and lower end 
 3) Neither-->It is both upper and lower end by itself-->Add the number to the keyset
  with the value as itself.
 4) Both-->It connects two existing sequence.Its own value is not important-->Refresh
  both upper and lower end.Add the number to the keyset with the value as itself.*/
public class LongestConsecutiveSequence {

	public int longestConsecutive(int[] num) {
		if(num==null||num.length==0)return 0;
		Map<Integer, Integer> sequence = new HashMap<Integer, Integer>();
		int longest = 0;
		for (int i = 0; i < num.length; i++) {
			if (sequence.containsKey(num[i]))
				continue;
			int lowerbound = num[i];
			int upperbound = num[i];
			if (sequence.containsKey(num[i] - 1)) // Get the lowerbound
				lowerbound = sequence.get(num[i] - 1);
			if (sequence.containsKey(num[i] + 1))// Get the Upperbound
				upperbound = sequence.get(num[i] + 1);
			longest = Math.max(longest, (upperbound - lowerbound) + 1);
			sequence.put(num[i], num[i]);// Handle 3 & 4
			sequence.put(lowerbound, upperbound);// Handle 1 2 & 4
			sequence.put(upperbound, lowerbound);// Handle 1 2 & 4
		}
		return longest;

	}
}
