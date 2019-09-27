//Given a binary tree and we need to find the count of trees whose all nodes have same value: unival trees

//class Count 
//{
//    int count = 0;
//}
  
public class SingleValueTree {
	 static Node root;
	 static int ct=0; //= new Count();
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleValueTree tree = new SingleValueTree();
//		 tree.root = new Node(10);
//	        tree.root.left = new Node(4);
//	        tree.root.right = new Node(12);
//	        tree.root.left.left = new Node(2);
//	        tree.root.left.right = new Node(3);
//	        tree.root.right.right = new Node(14);
		
		tree.root = new Node(5);

		tree.root.left = new Node(4);

		tree.root.right = new Node(5);

		tree.root.left.left = new Node(4);

		tree.root.left.right = new Node(4);

		tree.root.right.right = new Node(5);
	        int count=0;
	        countSingle(root,count);
	        System.out.println(ct);
	        

	}
	
	
	public static boolean countSingle(Node node, int count){
		 if (node == null)
	            return true;
	          
	        // Recursively count in left and right subtrees also
	        boolean left = countSingle(node.left, ct);
	        boolean right = countSingle(node.right, ct);
	  
	        // If any of the subtrees is not singly, then this
	        // cannot be singly.
	        if (left == false || right == false)
	            return false;
	  
	        // If left subtree is singly and non-empty, but data
	        // doesn't match
	        if (node.left != null && node.data != node.left.data)
	            return false;
	  
	        // Same for right subtree
	        if (node.right != null && node.data != node.right.data)
	            return false;
	  
	        // If none of the above conditions is true, then
	        // tree rooted under root is single valued, increment
	        // count and return true.
	        count++;
	        ct++;
	        return true;
	}

}
