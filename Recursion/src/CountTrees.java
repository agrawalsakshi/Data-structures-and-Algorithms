import java.util.Scanner;
//this is problem to count trees given nodes.
public class CountTrees {

	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		int nodes = scan.nextInt();
		int count = countTrees(nodes);
		System.out.println(count);
		

	}
		public static int countTrees(int nodes) {

			  if (nodes <=1) { 
			    return(1); 
			  } 
			  else { 
			    // there will be one value at the root, with whatever remains 
			    // on the left and right each forming their own subtrees. 
			    // Iterate through all the values that could be the root... 
				  
				  // loop is how much we want to put in right and how much we want to put in left
			    int sum = 0; 
			    int left, right, root;

			    for (root=1; root<=nodes; root++) { 
			    	//iterating through the numofnode and fixing the left subtrees
			      left = countTrees(root - 1); 
			      right = countTrees(nodes - root);

			      // number of possible trees with this root == left*right 
			      sum += left*right; 
			    }

			    return(sum); 
			  } 
			} 
	

}


