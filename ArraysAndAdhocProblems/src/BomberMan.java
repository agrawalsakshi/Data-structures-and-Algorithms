
public class BomberMan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//wall =1 enemy=2 //cannot place bomb on wall but can placeon enemy
		
  int [][] grid ={
		  {0,0, 0, 1,0,2},
		  {0,0, 2, 0,0,1},
		  {1,0, 2, 2,0,0},
		  {0,1, 2, 2,0,1}
  };
  
  int [] rows = new int[grid.length];
  int [] cols = new int[grid[0].length];
  int m=0,n=0,killcount=0;
  int maxKill =Integer.MIN_VALUE;
  for(int i=0;i<grid.length;i++){
	  for(int j=0;j<grid[0].length;j++){
		  if(grid[i][j]==0 || grid[i][j]==2){
			 //scan right of pos
			  m=i;n=j;killcount=0;
			  while(n<cols.length && grid[m][n]!=1){
				  if(grid[m][n]==2){
					  killcount++;
				  }
				 
				  n++;
			  }
			  //scan left of pos
			  m=i;n=j-1;
			  while(n>=0 && grid[m][n]!=1){
				  if(grid[m][n]==2){
					  killcount++;
				  }
				  n--;
			  }
			  
			 //scan above pos
			  m=i-1;n=j;
			  while(m>=0 && grid[m][n]!=1){
				  if(grid[m][n]==2){
					  killcount++;
				  }
				  m--;
			  }
			  //scan below pos
			  m=i+1;n=j;
			  while(m<rows.length && grid[m][n]!=1){
				  if(grid[m][n]==2){
					  killcount++;
				  }
				  m++;
			  }
		  }
		  if(killcount>maxKill){
			  maxKill=killcount;
		  }
		  
	  }
  }
  
  System.out.println(maxKill);
	}
}
  
//  for(int i=0;i<row.length;i++){
//	  if(row[i]==1){
//		  for(int j=0;j<col.length;j++){
//		  grid[i][j]=1;
//	  }
//  }
//	}
//  
//  for(int i=0;i<col.length;i++){
//	  if(col[i]==1){
//		  for(int j=0;j<row.length;j++){
//			  grid[j][i]=1;
//		  }
//	  }
//  }
//  
//  for(int i=0;i<grid.length;i++){
//	  for(int j=0;j<grid[0].length;j++){
//		  System.out.print(grid[i][j]+" ");
//	  }
//	  System.out.println();
//  }
//	}
//
//}
