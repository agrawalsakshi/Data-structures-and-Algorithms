package com.sakshi;

public class FindMissingNum {

	
	public static void main(String [] args) {
		int [] arr= {1,2,3,4,5,7};
		//Approach 1
//		int missingNum =0;
//		int sum=0;
//		for (int i=0;i<arr.length;i++) {
//			sum =sum + arr[i];
//		}
//		int nums= arr.length+1;
//		int actualSum = nums*(nums+1)/2;
//		missingNum =actualSum-sum;
//		System.out.println(missingNum);
		
		//Approach 2
		int x1= arr[0];
		for(int i=0;i<arr.length;i++) {
			x1 = arr[i]^x1;
		}
		int nums =arr.length+1;
		int x2=1;
		for(int i=1;i<=nums;i++) {
			x2=x2^i;
		}
		int missingNum =x1^x2;
		System.out.println(missingNum);
		
		
	}
}
