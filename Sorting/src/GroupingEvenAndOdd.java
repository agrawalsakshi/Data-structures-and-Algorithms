
public class GroupingEvenAndOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr={12, 34, 45, 9, 8, 90, 3};
  
		groupElements(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(" "+arr[i]+" ");
		}
		//System.out.print(arr);
  
	}
	public static void groupElements(int[] arr){
	int start =0;
	int end = arr.length-1;
	while(start<=end){
		while(arr[start]%2==0){
			start++;
		}
		while(arr[end]%2!=0){
			end--;
		}
		if(start<=end)
			swap(arr,start,end);
		}
	}

	public static void swap(int[] arr, int start, int end){
		int temp =arr[start];
		arr[start]= arr[end];
		arr[end]=temp;
		start++;
		end--;
	}
}
