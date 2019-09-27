

	class Node
	{
	    int data;
	    Node left, right;
	 
	    public Node(int item)
	    {
	        data = item;
	        left = right = null;
	    }
	}
//	class Height
//	{
//	    int h;
//	}
	public class BinaryTree {
		Node root;
	public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(6);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(-5);
        tree.root.right.left= new Node(8);
        tree.root.right.left.right= new Node(-9);
 
        System.out.println("The diameter of given binary tree is : "
                           + tree.diameter());
    }
	
	int diameter()
    {
        
        return diameterOpt(root);
    }
	
	public int diameterOpt(Node node){
		if(node == null)
			return 0;
//		if(node.left == null && node.right==null){
//			return 1;//node.data;
//		}
		
		int lHeigth = height(node.left);
		int rHeight = height(node.right);
		
		int lDiameter = diameterOpt(node.left);
		int rDiameter = diameterOpt(node.right);
		
		return Math.max(lHeigth+rHeight+1, Math.max(lDiameter,rDiameter));
	}
	
	public int height(Node node){
		if(node == null) return 0;
//		if (node.left == null && node.right==null)
//			return 1;
		
		return 1+Math.max(height(node.left), height(node.right));
	}
}
