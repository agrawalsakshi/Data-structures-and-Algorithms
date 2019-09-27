import java.util.ArrayList;
import java.util.Arrays;

public class FindTripletsSum0 {
	static ArrayList<String>  output = new ArrayList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] input = {0, -1, 2, -3, 1};
		 
		
		findTriplets(input,0);
	}
	//-3 -2 -1 0 1 2
	public static String[] findTriplets(int[] input,int sum){
		//String str="";
		//int add=0;
		Arrays.sort(input);
		//int start=0;
		//int end= input.length-1;
		for(int i=0;i<input.length-2;i++){
			int element = input[i];
			int l = i+1;
			int r= input.length-1;
		
		while(l<r){
			int add=element+input[l]+input[r];
			if(add==sum){
				System.out.println(element+" "+input[l]+" "+input[r]);
				String str=element+" "+input[l]+" "+input[r];
				output.add(str);
				l++;
				r--;
				//outpu
			}
			
			else if(add>sum){
				r--;
			}
			else
				l++;
		}
			
			
		}
		return   (String[]) output.toArray();
		
	}
}
