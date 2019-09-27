import java.util.Scanner;

//Given an infinite steam of numbers, print k largest numbers at any time
public class kLargestElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int count =0;
		int k =4,i=0;
		int [] arr = new int[k];
		while(scan.hasNext()){	
			int Nextelement = scan.nextInt();
			count++;
			if(count<k){
				arr[i]=Nextelement;
				i++;
			}
			if(count ==k){
				arr[i]=Nextelement;
				i++;
				for(int j=k/2-1;j>=0;j--)
				minHeapify(arr,k,j);				
			}
				
			
			if(count>k){
				int minElement = findMin(arr);
				if(Nextelement >minElement ){
					arr[0]=Nextelement;
					minHeapify(arr,k,0);
				}
				
			}
			
			printKLargestElements(arr);
		}
	}
	
	
	public static void printKLargestElements(int [] arr){
		System.out.println("K largest Elements : ");
		for(int i=0;i<arr.length;i++){
			
			 System.out.print(arr[i]+" ");
		}
	}
	
	public static int findMin(int[] arr){
		int root = arr[0];
		return root;
	}
	
	public static void minHeapify(int[]arr, int k, int i){
		int smallest = i;
		int l = 2*i+1;
		int r = 2*i+2;
		
		if(l<k && arr[l]<arr[smallest]){
			smallest=l;
		}
		if(r<k && arr[r]<arr[smallest]){
			smallest=r;
		}
		if(smallest!=i){
			int temp = arr[i];
			arr[i]=arr[smallest];
			arr[smallest]=temp;
			minHeapify(arr,k,smallest);
		}
		
	}

}
