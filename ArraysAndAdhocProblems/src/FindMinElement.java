//There is an sorted array and this array is rotated at some unknown point
//Now we need to find the min element

//approach: arr[5,6,1,2,3,4]    // the min element is the one whose previous element is greater then it. i,e, here 6>1     so one minimum.
// check mid element with its previous if it is obeying above condition , it is smallest, break
// else if mid element is greater than last [ 0,1,2,3,4,6,7]  check in left half else in right half
public class FindMinElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 // int [] input = {1, 2, 3, 4};
		int[] input ={0,1};
  
  findmin(input,0,input.length-1);
	}
	
	
	public static void findmin(int [] input,int start, int end){
		int low=start;
		int high = end;
		int mid = low+(high-low)/2;
		
		if(low <= 0 && high <= 0){
			System.out.println(input[low]);
			return;
		}
		if((mid-1)>=0 && input[mid]<input[mid-1]){
			System.out.println(input[mid]); 
			return;
		}
		
		else if(input[mid]<input[high]){
			findmin(input,low,mid-1);
		}
		else{
			findmin(input,mid+1,high);
		}
		
		
	}

}
