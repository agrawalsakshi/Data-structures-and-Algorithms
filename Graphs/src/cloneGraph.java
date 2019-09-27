import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Adjnode{
	
	int data;
	ArrayList<Adjnode> neighbors = new ArrayList<Adjnode>();
	
public Adjnode(int data2) {
	// TODO Auto-generated constructor stub
	
	this.data=data2;
}
}

public  class cloneGraph {
	


	public static void main(String[] args) {
		Adjnode node1 = new Adjnode(1);
		
		//node1.neighbors = new ArrayList<Adjnode>();

		Adjnode node2 = new Adjnode(2);
		
		node1.neighbors.add(node2);

		Adjnode node3 = new Adjnode(3);
		
		node1.neighbors.add(node3);
		Adjnode node4 = new Adjnode(4);
		
		node3.neighbors.add(node4);
		node4.neighbors.add(node3);
		
		bfsTraversal(node1);
		
		Adjnode newRoot = clone(node1, new HashMap<Integer, Adjnode>());
		System.out.println();
		System.out.println("After cloning");
		bfsTraversal(newRoot);
	}
	
	static void bfsTraversal(Adjnode i){
		Set<Adjnode> visited = new HashSet<Adjnode>();
		Queue<Adjnode> queue = new LinkedList<Adjnode>();
		queue.add(i);
		visited.add(i);
		while(queue.size()>0){
			Adjnode node = (Adjnode) queue.poll();
			System.out.print(node.data+"  ");
			for(Adjnode n: node.neighbors){
				if(!visited.contains(n)){
					queue.add(n);
					visited.add(n);
				}
			}
		}
	}
	
	static Adjnode clone(Adjnode i, Map<Integer, Adjnode> nodes) {
		Adjnode r = new Adjnode(i.data);
		//r.data = i.data;
		nodes.put(r.data, r);
		for(Adjnode n : i.neighbors) {
		Adjnode j = nodes.get(n.data);
			//Adjnode j = new Adjnode(n.data);
			if(j == null) {
				j = clone(n, nodes);
			}
			r.neighbors.add(j);
		}
		return r;
	}
	
	
}
