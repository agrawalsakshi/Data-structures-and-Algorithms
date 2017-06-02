import java.util.Stack;

/// isBST is a popular question 
//Finding diameter, height 

class Node{
	int data;
	Node left;
	Node right;
	
	Node(int data){
		this.data=data;
		left=null;
		right=null;
		
	}
}
public class RecursiveDFSTraversal {
  Node root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       //iterative inorder
		RecursiveDFSTraversal rdfs = new RecursiveDFSTraversal();
		rdfs.root = new Node(1);
		rdfs.root.left = new Node(2);
		rdfs.root.right = new Node(3);
		rdfs.root.left.left = new Node(4);
		rdfs.root.left.right =new Node(5);
		rdfs.root.right.left = new Node(6);
		rdfs.root.right.right = new Node(7);
		System.out.println("Inorder Traversal");
		rdfs.inorderTraversal();
		System.out.println();;
		System.out.println("Preorder Traversal");
		rdfs.preorderTraversal();
		System.out.println();;
		System.out.println("Postorder Traversal");
		rdfs.postorderTraversal();
	}
	
	void postorderTraversal(){
		if(root==null){
			return;
		}
		
		Stack stack1 = new Stack();
		Stack stack2 = new Stack();
		Node node = root;
		Node temp;
		stack1.push(node);
		//stack1 ;4,5
		//stack2: 1,3,7,6,2
		while(stack1.size()>0){
			temp=(Node) stack1.pop();
			stack2.push(temp);
			if(temp.left!=null){
				stack1.push(temp.left);
				
			}
			if(temp.right !=null){
				stack1.push(temp.right);
			}	
		}
		
		while(stack2.size()>0){
			node =(Node)stack2.pop();
			System.out.print(node.data+"  ");
		}
	}
	
	void preorderTraversal(){
		if(root==null){
			return;
		}
		
		Stack stack = new Stack();
		Node node = root;
		
		stack.push(node);
		
		while(stack.size()>0){
			node = (Node) stack.pop();
			System.out.print(node.data+"  ");
			
			if(node.right!=null)
				stack.push(node.right);
			if(node.left!=null)
				stack.push(node.left);
		}
	}
	
	void inorderTraversal(){
	
		if(root==null){
			return;
		}
		
		Stack stack = new Stack();
		Node node = root;
		
		while(node!=null){
			stack.push(node);
			node= node.left;
		}
		
		while(stack.size()>0){
			node = (Node) stack.pop();
			System.out.print(node.data+ "  ");
			
			if (node.right != null) {
                node = node.right;
                 
                // the next node to be visited is the leftmost
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
		}
	}


