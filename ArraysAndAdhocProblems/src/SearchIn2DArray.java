
public class SearchIn2DArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] input = { 
						{10, 20, 30, 40},
						{15, 25, 35, 45},
						{27, 29, 37, 48},
						{32, 33, 39, 50}
						};
		
    //   int  target = 35;
	//	 int  target = 29;
		 int  target = 100;
		int i=0;
		int j=input[0].length-1;
		boolean result=false;
		while(i>=0 && i<input.length && j>=0 && j<input[0].length){
			j=input[0].length-1;
			
				
				while(target<input[i][j]){
					j--;
				}
				
				if(input[i][j]==target){
					result=true;
					break;
				}
				
				i++;
//				while( i<input.length && target>input[i][j]){
//					i++;
//				}
//				i=i-1;
//				while(j<input[0].length && target>input[i][j]){
//					j++;
//				
//			}
//				while(j>=0 && target<input[i][j]){
//					j--;
//				}
//				
				
		}
		System.out.println(result);
	}

}
