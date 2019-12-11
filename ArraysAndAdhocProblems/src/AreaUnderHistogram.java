import java.util.Stack;

public class AreaUnderHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   int [] arr={6,2,5,4,5,1,6};
   
   
   //This is O(n2)solution
  // findArea(arr);
   
   //This is O(n) solution
   //Using stack
   getMaxArea(arr);
	   
   
	}
	// push indexes intead of elements in stack
// Strategy 1: Always put the histogram bar with least height in stack bottom, if found greater then it, push it in stack else start popping till found 
//	some histogram of less height or stack is empty.
	// 2: while poping, 2 equations: 
	// stack is empty : element at top of stack * index i 
	// else element at top of stack * (i-stack.peek-1)
	// i.e., element at top of stack*(count of bars to the right -count to the left-1)
	public static void getMaxArea(int[] arr){
		Stack<Integer> stack =new Stack<Integer>();
		int i=0;int area=0;int maxArea=Integer.MIN_VALUE;
		int top=0;
		for( i=0;i<arr.length;){
			if(stack.isEmpty() || arr[i]>arr[stack.peek()]){
				stack.push(i);
				i++;
			}
			else{
				top=stack.pop();
				if(stack.isEmpty()){
					area= arr[top]*i;
				}
				else{
					area = arr[top]*(i-stack.peek()-1);
				}
				if(area>maxArea){
					maxArea= area;
				}
			}
		}
		while(!stack.isEmpty()){
			top = stack.pop();
			if(stack.isEmpty()){
				area=arr[top]*i;
				
			}
			else{
				area= arr[top]*(i-stack.peek()-1);
			}
			
			if(area>maxArea){
				maxArea=area;
			}
		}
		System.out.println("Max Area= "+maxArea);
	}
	
	public static void findArea(int [] arr){
		int i=0;
		   int j=0;
		   int count=0;
		   int area=0; int MaxArea=0;
		   
		   for( i=0;i<arr.length;i++){
			   count=1;j=i+1;
			  while(j<arr.length && arr[i]<=arr[j] ){
				  count++;
				  j++;
				  
			  }
			  j=i-1;
			  while(j>=0 && arr[i]<=arr[j] ){
				  count++;
				  j--;
				  
			  }
			  area= count * arr[i];
			  if(area>MaxArea){
				  MaxArea=area;
			  }
		   }
		   
		   System.out.println(MaxArea);
	}

}
