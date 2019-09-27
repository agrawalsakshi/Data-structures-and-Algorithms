import java.util.ArrayList;

public class printPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String act ="abcd";
		char [] chArray = act.toCharArray();
		//ArrayList  exp=new ArrayList();
		printPermute(chArray,0);
	}

	
	public static void printPermute(char [] chArray,int start){
		if(start >=chArray.length){
			System.out.println(chArray);
			return;
		}
		
		for(int i=start;i<chArray.length;i++){
			swap(chArray,start,i);
			//str=str+String.valueOf(chArray[start]);
			printPermute(chArray,start+1);
			swap(chArray,start,i);
		}
	}
	
	public static void swap(char[] arr, int i, int j){
		char temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}
