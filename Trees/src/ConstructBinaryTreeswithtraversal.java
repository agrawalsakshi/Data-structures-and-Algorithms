import java.util.Stack;
class NNode{
	int data;
	NNode left, right;
	
	NNode(int data){
		this.data = data;
		left=null;
		right=null;
	}
}

class Index 
{
    int index;
}

//Inorder Traversal
//4  2  5  1  6  3  7  
//Preorder Traversal
//1  2  4  5  3  6  7  
//Postorder Traversal
//4  5  2  6  7  3  1  
public class ConstructBinaryTreeswithtraversal {
	NNode root;
	static int preIndex = 0;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       int [] inorderArr = {4,2,5,1,6,3,7};
       int [] preorderArr ={1,2,4,5,3,6,7};
       int [] postorderArr ={4,5,2,6,7,3,1};
       int n= inorderArr.length;
       //Construct tree with inorder and postorder travrsals
       NNode root =constructTree(inorderArr,postorderArr,n);
       System.out.println("Preorder of the constructed tree : ");
       preOrder(root);
       
       
       //Construct tree with inorder and preorder traversals
//       NNode root = constructTree(inorderArr,preorderArr,n);
//       System.out.println("Preorder of the constructed tree : ");
//       preOrder(root);
	}
	
	//Construct tree with inorder and preorder traversals
	public static NNode constructTree(int [] inorderArr, int [] preorderArr, int n){
		
		
		return constructTreeWithPreIn(inorderArr,preorderArr,0,n-1);
	}
	
	public static NNode constructTreeWithPreIn(int [] inorderArr, int [] preorderArr,int start,int end){
	
		if(start>end) return null;
		
		NNode node = new NNode(preorderArr[preIndex++]);
		
		if(start==end){
			return node;
		}
		
		int inIndex = search(inorderArr,node.data,start,end);
		
		
		node.left=constructTreeWithPreIn(inorderArr,preorderArr,start,inIndex-1);
		node.right = constructTreeWithPreIn(inorderArr,preorderArr,inIndex+1,end);
		
		return node;
	}
	//Construct tree with inorder and postorder travrsals
//	public static NNode constructTree(int [] inorderArr, int [] postorderArr, int n){
//		 Index pIndex = new Index();
//	        pIndex.index = n - 1;;
//		
//		return constructTreeUtil(inorderArr,postorderArr,0,n-1,pIndex);
//		
//		
//	}
	
	public static NNode constructTreeUtil(int [] inorderArr, int [] postorderArr,int start,int end, Index index){
		
		if(start>end)return null;
		
		NNode NNode = new NNode(postorderArr[index.index]);
		(index.index) --;
		if(start==end){
			return NNode;
		}
		
		int inIndex = search(inorderArr,NNode.data,start,end);
		NNode.right = constructTreeUtil(inorderArr,postorderArr,inIndex+1,end,index);
		NNode.left = constructTreeUtil(inorderArr,postorderArr,start,inIndex-1,index);
		
		return NNode;
	}
	
	public static int search(int [] inorderArr, int data ,int start,int end){
		
		int index =0;
		for(int i=start;i<=end;i++){
			if(inorderArr[i]==data){
				index=i;
				break;
			}
		}
		return index;
	}
	
	
	public static void preOrder(NNode root){
		if(root==null){
			return;
		}
		
		Stack stack = new Stack();
		NNode node = root;
		
		stack.push(node);
		
		while(stack.size()>0){
			node = (NNode) stack.pop();
			System.out.print(node.data+"  ");
			
			if(node.right!=null)
				stack.push(node.right);
			if(node.left!=null)
				stack.push(node.left);
		}
	}
	
}
