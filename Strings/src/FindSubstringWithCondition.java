import java.util.HashSet;
import java.util.Set;

// Find longest substring in given string with atmost 2 distinct characters.
public class FindSubstringWithCondition {
	//static 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="ecdsss";
		String foundSubstring = findLongestSubstring(str);
		System.out.println(foundSubstring);
	}

	
	static String findLongestSubstring(String input){
		int maxLength = Integer.MIN_VALUE;
		int beginIndex=0;
		int endIndex=0;
		String output="";
		int[] characterFound = new int [256];
		int count=1;
		int i=0,j=1;
		characterFound[input.charAt(i)]=1;
		while(j<input.length()){
			if(characterFound[input.charAt(j)]>0){
				characterFound[input.charAt(j)]++;
				
			}
			else{
				characterFound[input.charAt(j)]++;
				count =count+1;
				
			}
			if(count>2){
				characterFound[input.charAt(i)]--;
				i++;
				count = checkCount(i,j,input);
				//j=i+1;
				//break;
			}
			
			if(count<3){
				int windowLength = j-i+1;
				if(windowLength>maxLength){
					maxLength = windowLength;
					beginIndex=i;
					endIndex=j;	
							
				}
			}
			j++;
		}
		output = input.substring(beginIndex,endIndex+1);
		return output;
	}
	
	static int checkCount(int i, int j, String input){
		int count=0;
		Set set = new HashSet();
		for(int k=i;k<=j;k++){
			if(!set.contains(k)){
				set.add(input.charAt(k));
				count ++;
			}
		}
		return count;
	}
}
