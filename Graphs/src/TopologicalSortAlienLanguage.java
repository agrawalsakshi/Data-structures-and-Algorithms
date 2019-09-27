import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class TopologicalSortAlienLanguage {

		int V;
		LinkedList<Integer> []adjList;

		public TopologicalSortAlienLanguage(int v){
			this.V =v;
			adjList=new LinkedList[V];
			for(int i=0;i<adjList.length;i++){
				adjList[i]=new LinkedList<Integer>();
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopologicalSortAlienLanguage t = new TopologicalSortAlienLanguage(4);
		
		String[] words={"baa", "abcd", "abca", "cab", "cad"};
		//String[] words={"caa","aaa","aab"};
		for(int i=0;i<words.length-1;i++){
			String word1= words[i];
			String word2= words[i+1];
			
			char[] charr1=word1.toCharArray();
			
			for(int j=0;j<Math.min(word1.length(),word2.length());j++){
				if(charr1[j]!=word2.charAt(j)){
					t.addEdge(charr1[j]-'a',word2.charAt(j)-'a');
					break;
				}
				
				
			}
		}
		
		Stack stack= t.topSort();
		
		while(!stack.isEmpty()){
			int i = (int)stack.pop();
			System.out.print((char)(i+'a')+" ");
		}
	}
	
	public Stack topSort(){
		Stack stack  = new Stack();
		Set visited = new HashSet();
		
		for(int i=0;i<V;i++){
			if(!visited.contains(i)){
				topSortUtil(i,stack,visited);
			}
		}
		return stack;
	}
	
	public void topSortUtil(int v, Stack stack, Set visited){
		if(visited.contains(v))return;
		
		visited.add(v);
		
		for(int i:adjList[v]){
			topSortUtil(i,stack,visited);
		}
		
		stack.push(v);
	}
	
	
	public void addEdge(int src, int dest){
		adjList[src].add(dest);
	}

}
