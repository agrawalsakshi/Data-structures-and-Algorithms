import java.util.ArrayList;

public class Merge2BSTs {

 

	public static void main(String[] args) {
		int[] arr1 = {1,3,  5,  7,  9};
        Node node1 = arrayToBST(arr1, 0, arr1.length-1);
        printBST(node1);
        System.out.println();

        int[] arr2 = {2,4,  6,  8,  15};
        Node node2 = arrayToBST(arr2, 0, arr2.length-1);
        
        printBST(node2);
        System.out.println();


        Node node = merge(node1, node2);

       printBST(node);
        System.out.println();

	}
	
	public static Node merge(Node node1, Node node2){
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		//Do inorder traversal of each bst
		createInorderTraversalList(node1,list1);
		createInorderTraversalList(node2,list2);
		
		int[] mergedarr = new int[list1.size()+list2.size()];
		mergeList(list1,list2,mergedarr); // increasing order
		
		Node node = arrayToBST(mergedarr,0,mergedarr.length-1);
		
		return node;
		
	}
	
	public static void mergeList(ArrayList<Integer> list1, ArrayList<Integer> list2, int [] mergeArr){
		int i=0; int j=0;int k=0;
		
		while(j<list1.size() && k<list2.size()){
			if(list1.get(j)>list2.get(k)){
				mergeArr[i]=list2.get(k);
				k++;
			}
			else{
				mergeArr[i]=list1.get(j);
				j++;
			}
			i++;
		}
		
		while(j<list1.size()){
			mergeArr[i]=list1.get(j);
			i++;
			j++;
		}
		
		while(k<list2.size()){
			mergeArr[i]=list2.get(k);
			i++;
			k++;
		}
	}
	
	public static void createInorderTraversalList(Node node, ArrayList<Integer> list){
		if(node == null)return;
		
		createInorderTraversalList(node.left,list);
		list.add(node.data);
		createInorderTraversalList(node.right,list);
		
	}
	
	public static void printBST(Node node){
		if(node == null) return;
		
		System.out.println(node.data);
		printBST(node.left);
		printBST(node.right);
	}
	
	public static Node arrayToBST(int [] arr, int start, int end){
		
		if(end<start) return null;
		
		if(null == arr || arr.length==0) return null;
		
		int mid = start+(end-start)/2;
		Node node = new Node(arr[mid]);
		
		node.left= arrayToBST(arr,start,mid-1);
		node.right = arrayToBST(arr,mid+1,end);
		
		return node;
		
	}
	
	
	


}
