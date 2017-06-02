import java.util.Stack;

class PIndex{
	int postindex;
}

class PreIndex{
	int preindex;
}
public class ConstructBSTwithtraversals{

	//static int preIndex=0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  // Construct BST from Postorder
		
		 int [] postorderArr ={1, 7, 5, 50, 40, 10};
		 int n= postorderArr.length;
		 
		 //Constructing bst with postorder
		// Node root = constructTree(postorderArr,n);
		  
		// inorderTraversal(root); //1  5  7  10  40  50 
		 
		//Constructing bst with preorder
		 int [] preorderArr ={10, 5, 1, 7, 40, 50};
		 
		Node root = constructTreePre(preorderArr,n);
		 inorderTraversal(root);
	      
	}
	
	public static Node constructTreePre(int[] preorderArr, int size){
		PreIndex index = new PreIndex();
		return constructTreePreUtil(preorderArr,index,preorderArr[index.preindex],Integer.MAX_VALUE,Integer.MIN_VALUE,size);
	}
	
	public static Node constructTreePreUtil(int[] preorderArr,PreIndex preIndex,int key, int max, int min, int size){
		
		if(preIndex.preindex >=size)return null;
		Node node =null;
		if(key<max && key>min){
			 node = new Node(key);
			preIndex.preindex++;
			
			if(preIndex.preindex<size){
				
				node.left = constructTreePreUtil(preorderArr,preIndex,preorderArr[preIndex.preindex],key,min,size);
				node.right = constructTreePreUtil(preorderArr,preIndex,preorderArr[preIndex.preindex],max,key,size);
			}
		}
		return node;	
	}
	
	public static void inorderTraversal (Node root){
		
		if(root == null) return;
		
		Stack stack = new Stack();
		Node node= root;
		
		while(node!=null){
			stack.push(node);
			node=node.left;
		}
		
		while(stack.size()>0){
			node = (Node) stack.pop();
			System.out.print(node.data+"  ");
			
			if(node.right!=null){
				node = node.right;
				
				while(node!=null){
					stack.push(node);
					node= node.left;
				}
			}
		}
	}
	
	public static Node constructTree(int [] postorderArr, int n){
		PIndex index = new PIndex();
		index.postindex = n-1;
		return constructTreeUtil(postorderArr,index,postorderArr[index.postindex], Integer.MAX_VALUE,Integer.MIN_VALUE);
	}

	public static Node constructTreeUtil(int [] postorderArr , PIndex index, int key, int max, int min){
		
		if(index.postindex<0)
			return null;
		
		Node node =null;
		
		if(key>min && key<max){
			node = new Node(key);
		
		
		index.postindex--;
		
		if(index.postindex>0){
			
			node.right = constructTreeUtil(postorderArr,index,postorderArr[index.postindex],max,key);
			node.left= constructTreeUtil(postorderArr,index,postorderArr[index.postindex],key,min);
		}
		}
		return node;
	}
}
