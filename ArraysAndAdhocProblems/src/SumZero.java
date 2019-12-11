import java.util.ArrayList;
import java.util.HashMap;


//Can be done by logic of getting subsets equal to a target sum in an array
public class SumZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 // int [] arr={5,1,2,-3,7,-4};
	//	int [] arr={0,1,2,3,4,-10};
		int [] arr={-8,-6,-1,0,1,2,4,7};
	//	int [] arr ={1, 4, -2, -2, 5, -4, 3};
  HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
 int sum=0;
 ArrayList<String> list = new  ArrayList<String>();
// int k=0;
 for(int i=0;i<arr.length;i++){
	 
	 sum = sum+arr[i];
	 
	 if(arr[i]==0){
		 list.add(getElements(arr,i,i).toString());
		//k++;
	 }
	 
	 else if(sum==0){
		 list.add(getElements(arr,0,i).toString());
		//k++;
		// break;
	 }
	 else if(hm.containsKey(sum)){
		 list.add(getElements(arr,hm.get(sum)+1,i).toString());
	//	k++;
	//	break;
	 }
	 hm.put(sum, i);
 } 
	 for(int m=0;m<list.size();m++){
		 System.out.print(list.get(m));
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
		int count =0;
	   String separator="";
	    StringBuilder sb = new StringBuilder();
	  	
	    for(int j=start;j<=end;j++){
	    	sb.append(separator).append(arr[j]);
	    	separator=",";
	    	count++;
	        
	    }
	    return sb;

	    
	}
	


}
