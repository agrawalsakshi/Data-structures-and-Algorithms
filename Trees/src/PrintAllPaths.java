import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintAllPaths {
  private static  Node root;
	public static void main(String[] args) {
		PrintAllPaths bst = new PrintAllPaths();
		   bst.insert(50);
		   bst.insert(30);
		   bst.insert(30);
		   bst.insert(20);
		   bst.insert(40);
		   bst.insert(70);
		   bst.insert(60);
		   bst.insert(80);
		   
		   System.out.println("inorder traversal of tree");
		   bst.inorderTraversal();
		   System.out.println();
		   Queue<Integer> queue = new LinkedList<Integer>();
		 //  queue.add(root.data);
		   bst.printPaths(root,queue);

	}
	
	public  void printPaths(Node node,Queue queue){
		
		if(node == null) {
			printQueue(queue);
			return;
		}
		
		
		queue.add(node.data);
		printPaths(node.left,queue);
		queue.remove(node.data);
		if(node.right!=null){
			queue.add(node.data);
			printPaths(node.right,queue);
			queue.remove(node.data);
		}
		else
			return;	
	}
	
	public void printQueue(Queue queue){
		Iterator<Integer> itr = queue.iterator();
		while(itr.hasNext()){
			System.out.print(itr.next()+"  ");
		}
		System.out.println();
	}
	
	public void inorderTraversal(){
		if(root==null){
			return;
		}
		Stack stack = new Stack();
		Node node =root;
		while(node!=null){
			stack.push(node);
			node=node.left;
		}
		
		while(stack.size()>0){
			 node = (Node) stack.pop();
			System.out.print(node.data+" ");
			
			if(node.right!=null){
				node=node.right;
				
			
			while(node!=null){
				stack.push(node);
				node = node.left;
			}
			}
		}
	}
	
	void insert(int key){
		root = insertRec(key,root);
	}
  
	
	public Node insertRec(int key, Node root){
		if(root == null){
			root = new Node(key);
			return root;
		}
		
		if(key<root.data){
			root.left = insertRec(key,root.left);
		}
		if(key>root.data){
			root.right =insertRec(key,root.right);
		}
		
		return root;
	}

}
