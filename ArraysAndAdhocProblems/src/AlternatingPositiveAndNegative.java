
public class AlternatingPositiveAndNegative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  int []input={-2,-3,-4,-9,-1,-7,1,-5,-6};
  //{2,-4,3,-9,-1,-7,1,-5,-6} {-4,3,-9} {3,-9,-1
  int i=0;
  int j=1;
 // int first=input[i];
 // int second = input[j];
  
  rearrange(input,i,j);
  
  for(int k=0;k<input.length;k++){
	  System.out.print(input[k]+" ");
  }
	}

	
	public static void rearrange(int [] input, int firstIndex, int secondIndex){
		
		int first = input[firstIndex];
		int second=input[secondIndex];
		if(firstIndex>=input.length || secondIndex>=input.length-1){
			return;
		}
		
		
		if(first>=0 && second >=0){
			//return index
		 int index=findNextNegative(input,secondIndex+1);
		 if(index==-1){
			 return;
		 }
		 swap(input,secondIndex,index);
		 rearrange(input,firstIndex,secondIndex);
		}
		

		if(first>=0 && second <0 || second>=0 && first<0){
			rearrange(input,firstIndex+1,secondIndex+1 );
		}
		
		 if(first<0 && second <0){
			 int index = findNextPositive(input,secondIndex+1);
			 if(index ==-1){
				 return;
			 }
			 swap(input,secondIndex,index);
			rearrange(input,firstIndex,secondIndex);
		}
		
	}
	
	public static int findNextPositive(int []input, int index){
		int num=-1;
		while(index<input.length){
			if(input[index]>0){
				num=index;
				break;
			}
			index++;
		}
		return num;
	}
	
	public static int findNextNegative(int[] input, int index){
		int num=-1;
		while(index<input.length){
			if(input[index]<0){
				num=index;
				break;
			}
			index++;
		}
		return num;
	}
	
	
	public static void swap(int[] input, int i, int j){
		int temp=input[i];
		input[i]=input[j];
		input[j]=temp;
	}
}
