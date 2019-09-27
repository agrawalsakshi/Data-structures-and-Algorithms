//Input : [1, 2, 3, 4, 5]
//Output: [(2*3*4*5), (1*3*4*5), (1*2*4*5), (1*2*3*5), (1*2*3*4)]
//      = [120, 60, 40, 30, 24]




public class ArrayProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  int [] arr = {1,2,3,4,5};
  int n= arr.length;
  int[] product_below = new int[arr.length];
  
  int[] product_above = new int[arr.length];
  
  int [] product = new int[arr.length];
  int p=1;
  for(int i=0;i<n;i++){
	  product_below[i]=p;
	  p*=arr[i];
  }
  p=1;
  for(int i=n-1;i>=0;i--){
	  product_above[i]=p;
	  p*=arr[i];
  }
  
  for(int i=0;i<n;i++){
	  //product[i]=p;
	  
	  product[i]=product_below[i]*product_above[i];
  }
  
  for(int i=0;i<n;i++){
	  System.out.print(product[i]+" ");
  }
	}

}
