import java.util.Stack;

public class BinarySearchTree {

	 Node root;
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
   BinarySearchTree bst = new BinarySearchTree();
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
  // deleting leaf node
   bst.delete(20);
   System.out.println("inorder traversal of tree after deleting 20");
   bst.inorderTraversal();
   System.out.println();
   
   bst.delete(30);
   System.out.println("inorder traversal of tree after deleting 30");
   bst.inorderTraversal();
   System.out.println();
   
   bst.delete(50);
   System.out.println("inorder traversal of tree after deleting 50");
   bst.inorderTraversal();
   System.out.println();
	}
	
	public void delete(int key){
		root = deleteRec(root, key);
	}
	
	public Node deleteRec(Node root, int key){
		if(root == null)return root;
		
		if(key<root.data){
			root.left=deleteRec(root.left,key);
		}
		else if(key>root.data){
			root.right = deleteRec(root.right,key);
		}
		else{
			//node with one or no child
			if(root.left==null){
				return root.right;
			}
			else if(root.right == null){
				return root.left;
			}
			
			// node with 2 child
			root.data = minValue(root.right);
			root.right = deleteRec(root.right, root.data);
		}
		return root;
	}
	
	static int minValue(Node node){
		
	    {
	        int minv = node.data;
	        while (node.left != null)
	        {
	            minv = node.left.data;
	            node = node.left;
	        }
	        return minv;
	    }
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
