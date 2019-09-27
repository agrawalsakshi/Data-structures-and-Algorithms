import java.util.LinkedList;
import java.util.Queue;

public class TestQues1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    
		int [] inorder = new int[] {1 , 5,  7,  10,  40,  50 };
		int n= inorder.length;
		
		Node node =constructTree(inorder,n);
		 System.out.println("Preorder of the constructed tree : ");
	       preOrder(node);
	       System.out.println("Inorder of the constructed tree : ");
	       printbfs(node);
	       
	       
	}
	
	public static void printbfs(Node root){
	    
	    Queue queue = new LinkedList();
	    Node node =root;
	    queue.add(node);
	    int level=0;
	    int count=1;
	    System.out.print("Level "+level+": ");
	    while(queue.size()>0){
	        
	        node = (Node)queue.remove();
	        count--;
	      
	        System.out.print(node.data+ " ");
	      
	       
	        if(node.left!=null){
	        	queue.add(node.left);
	        }
	        if(node.right!=null){
	        	queue.add(node.right);
	        }
	        
	        if(count==0){
	        	
	        	System.out.println();
	        	
	        	count=queue.size();
	        	if(queue.size()>0){
	        		level=level+1;
	        		System.out.print("Level "+level+": ");
	        	}
	        }
	        
	    }
	    
	}
	
	public static void preOrder(Node node){
		
		if(node == null) return;
		
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static Node constructTree(int [] inorderArr, int n){
		
		return constructTreeUtil(inorderArr, 0,n-1);
	}
	
	public static Node constructTreeUtil(int [] inorderArr, int start,int end){
		 int pos = (start+end)/2;
		if( start>end){
			return null;
		}
		
		Node node =new Node(inorderArr[pos]);
		
		if(start==end)return node;
		
		node.left=constructTreeUtil(inorderArr,start,pos-1);
		node.right = constructTreeUtil(inorderArr,pos+1,end);
		
		return node;
		
	}

}
