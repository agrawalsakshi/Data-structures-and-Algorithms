import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindShortestpath {

	int V;
	LinkedList<Integer> adjList[];
	
	
	FindShortestpath(int v){
		this.V=v;
		adjList= new LinkedList[V];
		
		for(int i=0;i<V;i++){
			adjList[i]=new LinkedList<Integer>();
		}
	}
	
	public void addEdge(int src,int dest){
		adjList[src].add(dest);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindShortestpath fds=new FindShortestpath(5);
		fds.addEdge(0, 1);
		//    g.addEdge(0, 2);
		fds.addEdge(4, 3);
		//fds.addEdge(1, 2);
		fds.addEdge(0, 2);
		fds.addEdge(3, 2);
		fds.addEdge(1, 4);
		 
		
		fds.findshortestDistance(1,2);
	}
	
	public void findshortestDistance(int start, int end){
		Set<Integer> visited = new HashSet<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		Map<Integer,Integer> parent =new HashMap<Integer, Integer>();
		ArrayList<Integer> ar = new ArrayList<Integer>();
		int cur=0;
		queue.add(start);
		visited.add(start);
		parent.put(start, null);
		while(queue.size()>0){
			cur = queue.poll();
			
			if(cur==end){
				Integer at =cur;
				while(at!=null){
				//System.out.print(at+"  ");
					ar.add(at);
					at=parent.get(at);
				}
				for(int i=ar.size()-1;i>=0;i--){
					System.out.print(ar.get(i)+"  ");
				}
				//break;
			}
			
			for(int i: adjList[cur]){
				if(!visited.contains(i)){
				queue.add(i);
				parent.put(i, cur);
				visited.add(i);
				}
			}
			
			
		}
		if(cur!=end){
			System.out.println("No path");
		}
		
	}

}
