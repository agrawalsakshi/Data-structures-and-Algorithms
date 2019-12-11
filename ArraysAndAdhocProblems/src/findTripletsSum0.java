import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class findTripletsSum0 {
	public static void main (String[] args) throws java.lang.Exception
	{
		int [] arr ={0,-1,1,2,4,-6,7,-8};
		int n = arr.length;
		Set<Integer> input = new HashSet<Integer>();
		for(int i=0;i<arr.length;i++){
			input.add(arr[i]);
		}
		Set<Integer> output = new HashSet<Integer>();
		findTriplets(input,output); //space O(n2) time nlog n
		
//		space O(1) time nlogn + n2
//		int left = 0;
//		int right = n-1;
//		int sum =0;
//		Arrays.sort(arr);
//		for(int i=0;i<n-2;i++){
//		    left =i+1;
//		    right = n-1;
//		    sum = arr[i]+arr[left]+arr[right];
//		    
//		    
//		    while(sum != 0){
//		        if(sum<0){
//		            left++;
//		            
//		        }
//		       else if(sum>0){
//		            right--;
//		            
//		        }
//		        sum = arr[i]+arr[left]+arr[right];
//		    }
//		    if(sum == 0){
//		        System.out.println(arr[i]+","+arr[left]+","+arr[right]);
//		    }
//		   
//		}
	}
	
	public static void findTriplets(Set<Integer> input, Set<Integer> output){
		if(input.isEmpty() ){
			if(output.size()==3 && isSumValid(output)){
				System.out.println(output.toString());
				
		}
			return;	
		}
		Iterator<Integer> itr = input.iterator();
		int element = itr.next();
		input.remove(element);
		findTriplets(input,output);
		output.add(element);
		findTriplets(input,output);
		output.remove(element);
		input.add(element);
	}
	
	public static boolean isSumValid(Set<Integer> output){
		boolean flag = true;
		int sum =0;
		if(output.size() != 3) {
			flag = false;
			return flag;
		}
		else{
			Iterator<Integer> itr = output.iterator();
			while(itr.hasNext()){
				sum = sum + itr.next();
			}
			if(sum != 0){
				flag = false;
			}
		}
		return flag;
	}
}
