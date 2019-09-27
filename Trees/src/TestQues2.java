import java.util.Stack;

public class TestQues2 {
static Node root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestQues2 bst = new TestQues2();
		   bst.insert(50);
		   bst.insert(30);
		   bst.insert(30);
		   bst.insert(20);
		   bst.insert(40);
		   bst.insert(70);
		   bst.insert(60);
		   bst.insert(80);
		   int k=4;
		   findKSmallestElements(root,k );
	}
	
	public static void findKSmallestElements(Node node, int k){
		int count=0;
		Stack stack = new Stack();
		while(node!=null){
			stack.push(node);
			node =node.left;
		}
		while(count!=k){
			node=(Node)stack.pop();
			System.out.println(node.data);
			count++;
			if(node.right!=null){
				node=node.right;
				while(node!=null){
					stack.push(node);
					node =node.left;
				}
			}
		}
		
	}
	public void insert(int n){
		root = insertRec(n,root);
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
