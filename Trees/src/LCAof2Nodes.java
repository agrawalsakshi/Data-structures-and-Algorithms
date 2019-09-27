//Given a binary tree (not a binary search tree) and two values say n1 and n2, write a program to find the least common ancestor.

//The LCA of n1 and n2 in T is the shared ancestor of n1 and n2 that is located farthest from the root.
public class LCAof2Nodes {
static Node root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LCAof2Nodes tree = new LCAof2Nodes();
		tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);
        
        Node node =findAncestor(25,15);
        System.out.println(node.data);
        
	}
	
	public static Node findAncestor(int n1, int n2){
		return findAncestor(root,n1,n2);
	}

	public static Node findAncestor(Node node, int n1, int n2){
		if(node == null){
			return null;
			
		}
		 if (node.data == n1 || node.data == n2)
	            return node;
		Node left_ancestor = findAncestor(node.left,n1,n2);
		Node right_ancestor = findAncestor(node.right,n1,n2);
		
		if(left_ancestor!=null && right_ancestor!=null){
			return node;
		}
		return left_ancestor!=null?left_ancestor:right_ancestor;
	}
}
