

/// Segment Trees : http://www.geeksforgeeks.org/segment-tree-set-1-range-minimum-query/ 
// http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/

// Given list of intervals and print all the conflicting intervals -- in notebook 
//Below is code for Interval trees
class IntervalNode{
	int start;
	int end;
	int maxEnd;
	IntervalNode left;
	IntervalNode right;
	
	IntervalNode(IntervalNode left, IntervalNode right,int start, int end, int maxEnd){
		this.left=left;
		this.right=right;
		this.start=start;
		this.end = end;
		this.maxEnd=maxEnd;
	}
}
public class IntervalTrees {
 private IntervalNode root;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntervalTrees tree= new IntervalTrees();
		
		tree.add(17, 19);
		tree.add(5, 8);
		tree.add(21, 24);
		tree.add(5, 8);
		tree.add(4, 8);
		tree.add(15, 18);
		tree.add(7, 10);
		tree.add(16, 22);
		
		System.out.println("Expected true,   Actual: " + tree.overlap(23, 25));
        System.out.println("Expected false,  Actual: " + tree.overlap(12, 14));
        System.out.println("Expected true,   Actual: " + tree.overlap(21, 23));
        // testing adjoint
        System.out.println("Expected false,  Actual: " + tree.overlap(10, 15));
        System.out.println("Expected false,  Actual: " + tree.overlap(10, 14));
        System.out.println("Expected false,  Actual: " + tree.overlap(11, 15));
        System.out.println("Expected false,  Actual: " + tree.overlap(17, 15));
	}
	
	public boolean overlap(int start, int end){
		if(start>=end) throw new IllegalArgumentException("The end " + end + " should be greater than start " + start);
		
		IntervalNode node =root;
		
		while(node!=null){
			if(start<node.end && end>node.start){
				return true;
			}
			if(goLeft(start,end,node.left)){
				node = node.left;
			}
			else{
				node = node.right;
			}
			
		}
		return false;
	}
	
	public boolean goLeft(int start, int end, IntervalNode nodeLeftTree){
		return (nodeLeftTree!=null && nodeLeftTree.maxEnd>start);
	}
	
	public void add(int start, int end){
		if(start>=end) throw new IllegalArgumentException("The end " + end + " should be greater than start " + start);
		
		IntervalNode node =root;
		while(node!=null){
			node.maxEnd =(end>node.maxEnd)?end:node.maxEnd;
			if(start<node.start){
				if(node.left==null){
					node.left=new IntervalNode(null,null,start,end,end);
					return;
				}
				node=node.left;
			}
			else{
				if(node.right == null){
					node.right = new IntervalNode(null,null,start,end,end);
					return;
				}
				node = node.right;
			}
		}
		
		root = new IntervalNode(null,null,start,end,end);
	}

}
