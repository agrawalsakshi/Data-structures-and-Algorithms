
public class printmatrixinsoiral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] [] matrix = new char[2][2];
		int i=0;int j=0;
				matrix[i][j]='A';
				matrix[i][j+1]='A';
				//matrix[i][j+2]='A';
				matrix[i+1][j]='A';
				matrix[i+1][j+1]='A';
//				matrix[i+1][j+2]='C';
//				matrix[i+2][j]='P';
//				matrix[i+2][j+1]='Q';
//				matrix[i+2][j+2]='R';

  String output = printMatrix(matrix);
  System.out.println(output);
	}

	
	public static String printMatrix(char[][] matrix){
		int i=-1;
		int row=0;
		int j =-1;
		int rowLength = matrix[0].length;
		int columnLength = matrix[1].length;
		int count=0;
		StringBuilder sb = new StringBuilder();
		do{
			i=i+1;
			j=j+1;
		for(;j<columnLength;j++){
			if(count==rowLength*columnLength){
				break;
			}
			sb.append(matrix[i][j]);
			count=count+1;
		}
		for(i=1;i<rowLength;i++){
			j=columnLength-1;
			if(count==rowLength*columnLength){
				break;
			}
			sb.append(matrix[i][j]);
			count=count+1;
		}
		for(j=columnLength-2;j>=0;j--){
			i=rowLength-1;
			if(count==rowLength*columnLength){
				break;
			}
			sb.append(matrix[i][j]);
			count=count+1;
		}
		for(i=rowLength-2;i>0;i--){
			j=0;
			if(count==rowLength*columnLength){
				break;
			}
			sb.append(matrix[i][j]);
			count=count+1;
		}
		
		}while(count!=rowLength*columnLength);
		//sb.append(matrix[1][1]);
		return sb.toString();
	}
	
}
