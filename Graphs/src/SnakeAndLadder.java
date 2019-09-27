import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakeAndLadder {

	static int V;
	static LinkedList<Integer> [] adjlist;
	
	public SnakeAndLadder(int v){
		this.V=v;
		adjlist=new LinkedList[V+1];
		
		for(int i=1;i<=V;i++){
			adjlist[i]=new LinkedList<Integer>();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[][] board = new int[6][6];
     SnakeAndLadder graph=new SnakeAndLadder(36);
//     for(int i=1;i<=36;i++){
//    	 for(int j=i+1;j<=i+6;j++){
//    		 graph.addedge(i,j);
//    	 }    	 
//     }
    // graph.addedge(1, 2);
     //ladders
     graph.addedge(2, 15);
     graph.addedge(5, 7);
     graph.addedge(9, 27);
     graph.addedge(18, 29);
     graph.addedge(25, 35);
     
     //snakes
     graph.addedge(32, 30);
     graph.addedge(34, 12);
     graph.addedge(24, 16);
     graph.addedge(20, 6);
     graph.addedge(17, 4);
     Set<Integer> visited = new HashSet<Integer>();
     int count=-1;
//     for(int v=1;v<=V;v++){
//    	 if(!visited.contains(v))
    	 count= countmoves(1,36,visited);
  //   }
     
	}
	
	public static int countmoves(int src, int dest, Set<Integer> visited){
		if(visited.contains(src)){
			return  0;
		}
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		Queue<Integer> queue =new LinkedList<Integer>();
		ArrayList ar = new ArrayList();
		queue.add(src);
		hm.put(src, null);
		int coun=-1;
		visited.add(src);
		while(queue.size()>0){
			int cur =queue.remove();
			if(cur==dest){
				Integer at=cur;
				while(at!=null){
					coun=coun+1;
					ar.add(at);
					at=hm.get(at);
					
					
				}
				System.out.println(coun);
				for(int i=0;i<ar.size();i++){
					System.out.print(ar.get(i)+" ");
				}
				
			}
			
			if(adjlist[cur].isEmpty()){
				int i=1;
				while(i<=6 && cur+i<=36){
					if(adjlist[cur+i].isEmpty() && !adjlist[cur].contains(cur+i))
						adjlist[cur].add(cur+i);
					else{
						adjlist[cur].addAll(adjlist[cur+i]);
					}
						i++;
				}
			}
			
			for(int neighbour:adjlist[cur]){
				if(!visited.contains(neighbour)){
					visited.add(neighbour);
					queue.add(neighbour);
					hm.put(neighbour, cur);
				}
				
			}
			
		}
		return coun;
	}
	public void addedge(int src, int dest){
		adjlist[src].add(dest);
	}

}
