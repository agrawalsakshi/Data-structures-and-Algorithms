
public class printmatrixinsoiral {

	public static void main (String[] args) throws java.lang.Exception
	{
	   char [] [] input = {{'A','B','C'},
	                        {'L','M','D'},
	                        {'K','N','E'},
	                        {'J','O','F'},
	                        {'I','H','G'}
	   };
	                        
	 int row =0;
	 int col =0, rows= input.length, cols = input[0].length;
	 int rowPointer =0;
	 int colPointer =0;
	 int index =0;
	 StringBuilder sb = new StringBuilder();
	 while(index<rows*cols){
	     
	     while(col<(cols-colPointer)){
	         sb.append(input[row][col]);
	         index++;
	         col++;
	     }
	     col = col-1;
	     row++;
	     while(row<rows-rowPointer){
	         sb.append(input[row][col]);
	         index++;
	         row++;
	     }
	     row = row-1;
	     col = col-1;
	     
	     while(col>=colPointer){
	         sb.append(input[row][col]);
	         index++;
	         col--;
	     }
	     rowPointer = rowPointer+1;
	     col = col+1;
	     row = row-1;
	     while(index<rows*cols && row>=rowPointer){
	         sb.append(input[row][col]);
	         index++;
	         row--;
	     }
	     col++;
	     row++;
	     colPointer++;
	     //rowPointer++;
	     
	 }
	 System.out.println(sb.toString());
	}
}
