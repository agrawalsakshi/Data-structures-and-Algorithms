import java.util.Arrays;

public class groupSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int [] arr= {1,3};// 3
		int[] arr={3,1,2,5}; //6
		//int[] arr ={2,4,6}; // 12
		boolean result=groupSum(arr,12);
		System.out.println(result);
	}
	//1,2,3,5 //2,4,8 
	public static boolean groupSum(int [] arr, int target){
		//Arrays.sort(arr);
		//int sum =0;
			int start =0;
			
			int sum = arr[0];
			
			for(int i=1;i<arr.length;i++){
				
				 if (sum == target) {
					 return true;
				 }
				 
				 if(i<arr.length){
					 sum =sum+arr[i];
				 }
				 
				 while(sum>target ){
						sum = sum - arr[start];
		                start++;
					}
				 if (sum == target) {
					 return true;
				 }
			}
			
			return false;
	}
}
//		            {
//			}
//			while(i<=j){
//				if(r==target){
//					return true;
//				}
//				if(r<target){
//					
//				}
//			}
//		
//		
//		
////		for(int i=0;i<arr.length;i++){
////			sum =sum+ arr[i];
////			if(sum <target){
////				continue;
////			}
////			else if(sum == target){
////				return true;
////			}
////			else {
////				return false;
////				
////			}
////			
////		}
////		return false;
////	}
//
//}

