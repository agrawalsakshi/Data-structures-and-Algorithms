import java.util.Random;

// Write a program to shuffle an array in O(n) time such that it is uniformly distributed



//rand.nextInt(n) will return any number between 0 to n-1.(n is exclusive)
//this method is picks num in a uniformly distributed way
public class ShuffleArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    int [] arr = {1,3,5,7,2,6,9,4,8};
    
   int [] res= randomise(arr);
    
   for(int i=0;i<res.length;i++){
	   System.out.print(res[i]+" ");
   }
    
	}

	public static int[] randomise(int[] arr){
		int k=0;
		for(int i=arr.length-1;i>=1;i--){
			int length=arr.length-k;
			Random rand = new Random();
			//int j= (int) Math.random()*length;
			int j= rand.nextInt(i+1);
			k++;
			swap(i,j,arr);
		}
		
		return arr;
	}
	
	public static void swap(int i,int j, int[] arr){
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	
}
