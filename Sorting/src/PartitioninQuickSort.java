
public class PartitioninQuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public static  int partition(String [] arr, int start,int end){
        String pivotElement = arr[start];
		int left = start+1;
		int right = end;
		while(left<=right){
			while(left<=right && arr[left].compareToIgnoreCase(pivotElement)<=0){
				left++;
			}
			while(left<=right && arr[right].compareToIgnoreCase(pivotElement)>0){
				right--;
			}
			if(left<right){
				String swap =  arr[left];
				arr[left]=arr[right];
				arr[right]=swap;	
			}
		}
		
		String swap = arr[start];
		arr[start]=arr[right];
		arr[right]=swap;
	
		return right;
	}	
}
