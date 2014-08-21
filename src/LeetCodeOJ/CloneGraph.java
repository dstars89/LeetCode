package LeetCodeOJ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


 OJ's undirected graph serialization:
 Nodes are labeled uniquely.

 We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 As an example, consider the serialized graph {0,1,2#1,2#2,2}.

 The graph has a total of three nodes, and therefore contains three parts as separated by #.

 First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 Second node is labeled as 1. Connect node 1 to node 2.
 Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.*/

public class CloneGraph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) 
	        return null;

	    HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
	    LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
	    queue.offer(node);
	    UndirectedGraphNode curNode = null;

	    //FIFO
	    while (!queue.isEmpty()) {
	        curNode = queue.poll();
	        if (!map.containsKey(curNode.label)) 
	            map.put(curNode.label, new UndirectedGraphNode(curNode.label));         
	        if (null != curNode.neighbors) {
	            for (UndirectedGraphNode neighbor : curNode.neighbors) {
	                if (!map.containsKey(neighbor.label)) {
	                    queue.offer(neighbor);
	                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));       
	                }
	                map.get(curNode.label).neighbors.add(map.get(neighbor.label));
	            }
	        }
	    }  //end while
	    return map.get(node.label);

	}

	static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
}
