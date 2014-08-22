package LeetCodeOJ;

import java.util.*;


/*Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,

 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 Return
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 Note:
 All words have the same length.
 All words contain only lowercase alphabetic characters.*/

public class WordLadderII {
	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		HashMap<String, Queue<String>> adjMap = new HashMap<String, Queue<String>>();// marked the path
		int currLen = 0; //record the shortest Length of ladder
		boolean found = false;
		ArrayList<List<String>> res = new ArrayList<List<String>>();// results
		Queue<String> queue = new LinkedList<String>(); // queue for BFS
		Set<String> unVisited = new HashSet<String>(dict); // unvisited words
		Set<String> visitedThisLev = new HashSet<String>();// check words visited during same level
		unVisited.add(end);

		queue.offer(start);
		int currLev = 1;
		int nextLev = 0;

		for (String word : unVisited) {
			adjMap.put(word, new LinkedList<String>());
		}
		unVisited.remove(start);

		// BFS
		while (!queue.isEmpty()) {
			String currLadder = queue.poll();
			// for all unvisited words that are one character change from current word
			for (String nextLadder : getNextLadder(currLadder, unVisited)) {
				if (visitedThisLev.add(nextLadder)) {
					nextLev++;
					queue.offer(nextLadder);
				}
				adjMap.get(nextLadder).offer(currLadder);//important
				if (nextLadder.equals(end) && !found) {
					found = true;
					currLen += 2;
				}
			}

			if (--currLev == 0) {
				if (found)
					break;
				unVisited.removeAll(visitedThisLev);
				visitedThisLev.clear();
				currLev = nextLev;
				nextLev = 0;
				currLen++;
			}
		}

		if (found) {// find the path
			LinkedList<String> p = new LinkedList<String>();
			p.addFirst(end);
			getLadders(start, end, p, res, adjMap, currLen);
		}

		return res;
	}

	// get all unvisited words that are one character change from current word
	private ArrayList<String> getNextLadder(String currLadder,
			Set<String> unVisited) {
		ArrayList<String> nextLadders = new ArrayList<String>();
		StringBuilder replace = new StringBuilder(currLadder);
		for (int i = 0; i < currLadder.length(); i++) {
			char old = replace.charAt(i);
			for (char ch = 'a'; ch <= 'z'; ch++) {
				replace.setCharAt(i, ch);
				String replaced = replace.toString();
				if (ch != currLadder.charAt(i) && unVisited.contains(replaced)) {
					nextLadders.add(replaced);
				}
			}
			replace.setCharAt(i, old);//recover
		}
		return nextLadders;
	}

	// DFS to get all possible path from start to end
	private void getLadders(String start, String currLadder,
			LinkedList<String> p, ArrayList<List<String>> res,
			HashMap<String, Queue<String>> adjMap, int shortestLen) {
		if (currLadder.equals(start)) {
			res.add(new ArrayList<String>(p));
		} else if (shortestLen > 0) {
			Queue<String> adjs = adjMap.get(currLadder);
			for (String lad : adjs) {
				p.addFirst(lad);
				getLadders(start, lad, p, res, adjMap, shortestLen-1);
				p.removeFirst();
			}
		}
	}
}
