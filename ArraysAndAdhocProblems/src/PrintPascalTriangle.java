import java.util.Arrays;

/*
1  
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1 
1 5 10 10 5 1 
 */



public class PrintPascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  int n=6;
  
  printTriangleIteratively(n);
  System.out.println();
  System.out.println();
  System.out.println();
  printTriangleRecursively(n);
	}
	
	public static void printTriangleRecursively(int n){
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				System.out.print(printTriangleRecursivelyUtil(i,j)+" ");
			}
			System.out.println();
		}
	}
	
	
	public static int printTriangleRecursivelyUtil(int i, int j){
		if(j==1){
			return 1;
		}
		if(j==i){
			return 1;
		}
		return printTriangleRecursivelyUtil(i-1,j-1)+printTriangleRecursivelyUtil(i-1,j);
	}
	
	public static void printTriangleIteratively(int n){
		int k=0; int i=0;
		  int []arr_1 = new int[n];
		  int [] arr_2 = new int [n];
		  
		  arr_1[0]=1; arr_2[0]=1;
		  int j=0;
		  for( k=1;k<=6;k++){
			  System.out.print(arr_1[0]+" ");
		       j=0;
			  for(i=2;i<=k;i++){
				  System.out.print(arr_1[j]+arr_1[j+1]+" ");
				 
				  j++;
				  arr_2[j]=arr_1[j]+arr_1[j-1];
				  
				  
			  }

			  arr_1=  Arrays.copyOf(arr_2,n);
			  
			  System.out.println();
	}

}
}
