

// Given a matrix ,
// [0 1 0 1 1
//  0 1 1 0 0
//  0 1 0 0 1
//  1 1 1 0 1
//  0 0 0 0 0]
// Count the number of islands. Matrix itself surrounded with water.
// total 3 islands. Neighbours will be left, right, up and down elements.


public class IslandCountProblem {
	static int rows;
	static int columns;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] matrix = {
//				{0,1,0,1,1},
//                {0,1,1,0,0},
//                {0,1,0,0,1},
//                {1,1,1,0,1},
//                {0,0,0,0,0}
//                };
//		
		int[][] matrix = {
				{1,1,0,0,0},
                {0,1,0,0,1},
                {1,0,0,1,1},
                {0,0,0,0,0},
                {1,0,1,0,1}
                };
	
       rows=matrix.length;
       columns=matrix[0].length;
      int count=count_islands(matrix);
      System.out.println(count);
	}

	public static int  count_islands(int[] [] grid){
		int[] [] visited = new int[grid.length][grid[0].length];
		int count=0;
		 for(int row=0;row<rows;row++){
			  for(int column=0;column<columns;column++){
				  if(visited[row][column]==0 && grid[row][column]==1){
					  exhaust_cc(grid,row,column,visited);
					  count=count+1;
				  }
			  }
		  }
		return count;
	}
	

	
	public static void exhaust_cc(int[][] grid, int row, int column, int[] [] visited){
		if(visited[row][column]==1)return;
		visited[row][column]=1;
		int n=0;
		 int rowNbr[] = new int[] {-1,-1,-1,0,0,1,1,1};
	      int colNbr[] = new int[] {-1,0,1,-1,1,-1,0,1};
	      for(int k=0;k<8;k++){
	    	  if((row+rowNbr[k] >= 0) && (row+rowNbr[k] < rows) && (column+colNbr[k] >= 0) && (column+colNbr[k] < columns)){
	    		  if(grid[row+rowNbr[k]][column+colNbr[k]] ==1){
	    			  exhaust_cc(grid,row+rowNbr[k],column+colNbr[k],visited);
	    		  }
	    	  }
	      }	
	}

}
