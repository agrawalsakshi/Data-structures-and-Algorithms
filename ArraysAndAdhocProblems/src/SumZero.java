import java.util.ArrayList;
import java.util.HashMap;

public class SumZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 // int [] arr={5,1,2,-3,7,-4};
		int [] arr={0,1,2,3,4,-10};
  HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
 int sum=0;
 ArrayList<String> str = new  ArrayList<String>();
// int k=0;
 for(int i=0;i<arr.length;i++){
	 
	 sum = sum+arr[i];
	 
	 if(arr[i]==0){
		str.add(getElements(arr,i,i).toString());
		//k++;
	 }
	 
	 else if(sum==0){
		str.add(getElements(arr,0,i).toString());
		//k++;
		// break;
	 }
	 else if(hm.containsKey(sum)){
		str.add(getElements(arr,hm.get(sum)+1,i).toString());
	//	k++;
	//	break;
	 }
	 hm.put(sum, i);
 } 
	 for(int m=0;m<str.size();m++){
		 System.out.print(str.get(m));
		 System.out.println();
	 }
 }
//  for(int i=0;i<arr.length;i++){
//	  sum=0;
//	  sum=sum +arr[i];
//	  for (int j=i+1;j<arr.length;j++){
//		  sum=sum+arr[j];
//		  if(sum ==0){
//			  System.out.print(arr[i]+" ");
//			  for(int k=i+1;k<=j;k++){
//				  System.out.print(arr[k]+" ");
//			  }
//			  break;
//		  }
//		  
//	  }
//	 
//  }
	
	
	static StringBuilder getElements(int[] arr, int start, int end){
	   String separator="";
	    StringBuilder sb = new StringBuilder();
	 //   String[] str= new String[end-start+1];
	    for(int j=start;j<=end;j++){
	    	sb.append(separator).append(arr[j]);
	    	separator=",";
	        
	    }
	    return sb;
	}
	
//	static void printArr(int[] arr, int start, int end){
//		for(int j=start;j<=end;j++){
//			System.out.print(arr[j]+" ");
//		}
//	}

}
