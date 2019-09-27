
// Java Program to convert a Binary Tree to a
// Circular Doubly Linked List
 
// Node class represents a Node of a Tree

 
// A class to represent a tree
public class BSTTOCircularLinkedList  {


	
	    static Node root;
	    public BSTTOCircularLinkedList()
	    {
	        root = null;
	    }
	 

	 
	    // Method converts a tree to a circular
	    // Link List and then returns the head
	    // of the Link List
	    public static Node bTreeToCListUtil(Node node)
	    {
	        if (node == null)
	            return node;
	        
	    //   Node head=null;
	     //  Node tail=null;
	       
	       if (node.left != null) 
	        {
	    	   Node left= bTreeToCListUtil(node.left);
	    	   while(left.right!=null){
	    		   left=left.right;
	    	   }
	    	   Node  prev= left;
	    	  
	    	  
	    		   prev.right=node;
	    		   node.left=prev;
	    		   
	    	 
	        }
	       if(node.right!=null){
	    	   
	    	   Node right = bTreeToCListUtil(node.right);
	    	   while(right.left!=null){
	    		   right = right.left;
	    	   }
	    	   Node prev=right;
	    	
	    		   prev.left=node;
	    		   node.right=prev;
	    	   
	       }  
	       return node; 
	    }
	 
	    // Display Circular Link List
	    public void display(Node head)
	    {
	        System.out.println("Circular Linked List is :");
	        Node itr = head;
	        do
	        {
	            System.out.print(itr.data+ " " );
	            itr = itr.right;
	        }
	        while (itr != head);
	        System.out.println();
	    }
	
	 public Node bTreeToCList(Node root){
		 Node node = bTreeToCListUtil(root);
		 
		 Node head=null;
		 Node tail =null;
		 while(node.left!=null){
			 node =node.left;
			 head=node;
		 }
		 
		 while(node.right!=null){
			 node =node.right;
			 tail = node;
		 }
		 
		 tail.right=head;
		 head.left=tail;
		 
		 return head;
	 }

	    public static void main(String args[])
	    {
	        // Build the tree
	    	BSTTOCircularLinkedList tree = new BSTTOCircularLinkedList();
	        tree.root = new Node(10);
	        tree.root.left = new Node(8);
	        tree.root.right = new Node(15);
	        tree.root.left.left = new Node(3);
	        tree.root.left.right = new Node(9);
	        tree.root.right.right = new Node(25);
	 
	        // head refers to the head of the Link List
	       // Node head =inorder(root);
	        Node head = tree.bTreeToCList(tree.root);
	 
	        // Display the Circular LinkedList
	        tree.display(head);
	    }
	}


