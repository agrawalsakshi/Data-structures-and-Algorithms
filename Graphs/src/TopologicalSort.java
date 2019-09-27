import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


// will use stack and dfs
public class TopologicalSort {
int V;
LinkedList<Integer> []adjList;

public TopologicalSort(int v){
	this.V =v;
	adjList=new LinkedList[V+1];
	for(int i=0;i<adjList.length;i++){
		adjList[i]=new LinkedList<Integer>();
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      TopologicalSort t = new TopologicalSort(5);
//      t.addEdge(1,3);
//      t.addEdge(1,2);
//      t.addEdge(6,2);
//      t.addEdge(6,7);
//      t.addEdge(3,5);
//      t.addEdge(3,4);
//      t.addEdge(2,4);
//      t.addEdge(5,4);
//     t.addEdge(7,4);
      t.addEdge(1,2);
      t.addEdge(1,4);
      t.addEdge(2,3);
      t.addEdge(4,3);
      t.addEdge(3,5);
    // Stack<Integer> stack= t.topSort();
      Queue queue = t.topSort();
      
     while(!queue.isEmpty()){
    	 System.out.println(queue.remove());
     }
	}
	
	public Queue<Integer> topSort(){
		Stack<Integer> stack = new Stack<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		for(int v=1;v<=V;v++){
			if(!visited.contains(v)){
				topUtil(v,visited,queue);
			}
		}
		return queue;
	}
	
	
	public void topUtil(int v , Set visited, Queue queue){
		if (visited.contains(v)){
			return;
		}
		visited.add(v);
		for(int i: adjList[v]){
			topUtil(i,visited,queue);
		}
		queue.add(v);
	}
	public void addEdge(int src, int dest){
		adjList[src].add(dest);
	}

}
