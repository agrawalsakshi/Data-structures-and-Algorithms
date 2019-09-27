import java.util.HashMap;
import java.util.Iterator;

//find number of basins || count of each basin|| print basin matrix

//Given a matrix with each cell representing elevation. Water will go to the neighbouring cell with or itself whichever is lowest.
//Find such basins.

public class PalantirProblem {
static int rows;
static int columns;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {
                {1,0,2,5,8},
                {2,3,4,7,9},
                {3,5,7,8,9},
                {1,2,5,4,3},
                {3,3,5,2,1}
                };
		rows=grid.length;
		columns=grid[0].length;
		String [][] basinMatrix=findBasins(grid);
		
		HashMap<String,Integer> hm = new HashMap<String,Integer>();
		
		for(int k=0;k<basinMatrix.length;k++){
			for(int l=0;l<basinMatrix[0].length;l++){
				if(hm.containsKey(basinMatrix[k][l])){
					hm.put(basinMatrix[k][l], hm.get(basinMatrix[k][l])+1);
				}
				else{
						hm.put(basinMatrix[k][l], 1);
					}
			}
		}

		Iterator itr = hm.keySet().iterator();
		while(itr.hasNext()){
			String key= (String) itr.next();
			System.out.print(hm.get(key)+" ");
				}
	}
				
	
	
  public static String[][] findBasins(int[][] grid){
	  String[][] basinMatrix = new String[rows][columns];
	  int[][] visitedMatrix = new int[rows][columns];
	  for(int row=0;row<rows;row++){
		  for(int column=0;column<columns;column++){
			  if(visitedMatrix[row][column]==0){
				  exhaust_cc(grid,row,column,basinMatrix,visitedMatrix);
			  }
		  }
	  }
	  return basinMatrix;
  }
  
  public static void exhaust_cc(int[][] grid,int row,int column,String[][] basinMatrix,int[][] visitedMatrix){
	  if(visitedMatrix[row][column]==1)return;
	  
	  visitedMatrix[row][column]=1; 
		String lowestPoint=  findMinNeighbours(grid,row,column,basinMatrix);
		basinMatrix[row][column]=lowestPoint;
	  
  }
  
  public static String findMinNeighbours(int[][] grid, int row, int column,String[][] basinMatrix){
	  if(null != basinMatrix[row][column] ){
		  return basinMatrix[row][column];
	  }
	  String lowestPoint = row+","+column;
	  int rowNbr[] = new int[] {-1,0,0,1};
      int colNbr[] = new int[] {0,-1,1,0};
     // int [][] neighbours= new int [4][2];
      int minValue=grid[row][column];
     int minX = row;
     int minY=column;
       for(int k=0;k<4;k++){
    	   if((row+rowNbr[k] >= 0) && (row+rowNbr[k] < rows) && (column+colNbr[k] >= 0) && (column+colNbr[k] < columns)){
    		  if(grid[row+rowNbr[k]][column+colNbr[k]] < minValue){
    			  minX = row+rowNbr[k];
    			  minY= column+colNbr[k];
    			  minValue=grid[row+rowNbr[k]][column+colNbr[k]];
    		  }
    	   }
       }
     if(minX==row && minY==column){
    	 
     }
     else{
    	 lowestPoint = findMinNeighbours(grid,minX,minY,basinMatrix);
     }
     return lowestPoint;
  }
}
