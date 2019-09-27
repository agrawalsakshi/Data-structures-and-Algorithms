import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;


//O(VE)
public class DetectCycle {
	//int flag=0;
	static int V;
	LinkedList<Integer> adj[];
	DetectCycle(int V)
	{
	this.V=V;
	adj=new LinkedList[V];
	for(int i=0;i<V;i++)
		adj[i]=new LinkedList<Integer>();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DetectCycle g=new DetectCycle(4);
	 	g.addEdge(0, 1);
	//    g.addEdge(0, 2);
	    g.addEdge(1, 3);
	    //g.addEdge(2, 1);
	    g.addEdge(0, 2);
	    g.addEdge(3, 2);
	    
	   boolean result= g.hasCycle(V);
	   System.out.println(result);
	}
	
	public boolean hasCycle(int V){
		
	//	Stack path =new Stack();
		for(int i=0;i<V;i++){
			Set path_set = new HashSet();
			if( hasCycle(i,path_set//,path
					)){
				return true;
			}
			
			}
		return false;
		}
		
		
		public boolean hasCycle(int v, Set path_set//, Stack path
				){
			if(path_set.contains(v)){
				return true;
			}
			//path.push(v);
			path_set.add(v);
			
			for(int i: adj[v]){
				if(hasCycle(i,path_set//,path
						)){
					return true;
				}
			}
			path_set.remove(v);
		//	path.pop();
			return false;
		}
	
	
	public void addEdge(int src,int dest){
		if(src>V || dest>V) return;
		
		if(!adj[src].contains(dest)){
			adj[src].add(dest);
		}
		else return;
	}
	
	

}
