//There is an sorted array and this array is rotated at some unknown point
//Now we need to find the min element

//approach: arr[5,6,1,2,3,4]    // the min element is the one whose previous element is greater then it. i,e, here 6>1     so one minimum.
// check mid element with its previous if it is obeying above condition , it is smallest, break
// else if mid element is greater than last [ 0,1,2,3,4,6,7]  check in left half else in right half
public class FindMinElementInRotatedArray {

	public static void main (String[] args) throws java.lang.Exception
	{
	    int [] arr = {6,7,1,2,3,4,5};
	    
	   int element =  findMin(arr,0,arr.length-1);
	   System.out.println(element);
	    
	}
	
	public static int findMin(int [] arr, int low, int high){
	    
	    if(low> high){
	        return arr[0];
	    }
	    if(low == high) return arr[low];
	    
	    int mid = low + (high-low)/2;
	    
	    if(mid+1<high && arr[mid]>arr[mid+1]) return arr[mid+1];
	    
	    if((mid-1)>=0 && arr[mid]< arr[mid-1]) return arr[mid];
	    
	    if(arr[high]<arr[mid]) return findMin(arr,mid+1,high);
	    else 
	    return findMin(arr,low,mid-1);
	}
}
