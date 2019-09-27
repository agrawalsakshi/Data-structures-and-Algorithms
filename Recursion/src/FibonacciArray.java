import java.util.ArrayList;

public class FibonacciArray {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4;
		 int [] res = new int [n];
			  res = findFibonacci(n);
			//  res.toArray();
			  System.out.println(res);
			  
			 
	}
	
	public static int[] findFibonacci(int n){
		 int [] res = new int [n];
		int i=0;
		res[i]=0;i++;
		res[i]=1;i++;
		for(int j=2;j<n;j++){
			
			int a = fib(i-1);
			int b= fib(i-2);
			int sum = a+b;
			res[i]=sum;i++;
		}
	//	findFibonacci(n-1);
	//	findFibonacci(n-2);
		
		return res;
	}
	
	public static int fib(int n){
		if (n==0 ){
			return (0);
		}
		if(n==1){
			return (1);
		}
		return fib(n-1)+fib(n-2);
	}
	
	

}
