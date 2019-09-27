import java.util.ArrayList;

public class PallindromicDecomposition {

	static ArrayList<String> result = new ArrayList<String>();
	static ArrayList<String> partition = new ArrayList<String>();

	 static String[] result_array;
	public static void main(String[] args) {
		
		String s = "abracadabra";
		//String s ="racecar";
		
		String [] res;
		res=partition(s);
		for(int i=0;i<res.length;i++)
		System.out.println(String.valueOf(res[i]));
	}
	
	
	public static String[] partition(String s) {
		if (s == null || s.length() == 0) {
			return (String[]) result.toArray();
		}	 
		//track each possible partition
		addPalindrome(s, 0);
		result_array = result.toArray(new String[result.size()]);
		return result_array;
	}
	
	// Here the logic is scan the whole string and whenever a pallindrome is encountered 
	// add it to partition and scan further down
	// if pallindrome is encountered in middle , add it to partition and scan remaining char iteratively using for loop
	 
	private static void addPalindrome(String s, int start) {
		//stop condition
		if (start == s.length()) {
			ArrayList<String> temp = new ArrayList<String>(partition);
			StringBuilder sb = new StringBuilder();
			for(String str:temp){
				sb.append(str);
				sb.append("|");
			}
			result.add(sb.toString());			
			return;
		}
	 
		for (int i = start + 1; i <= s.length(); i++) {
			String str = s.substring(start, i);
			if (isPalindrome(str)) {
			partition.add(str); 			
			addPalindrome(s, i);		
			partition.remove(partition.size() - 1);
			}
		}
	}
	 
	private static boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
	 
		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
	 
			left++;
			right--;
		}
	 
		return true;
	}

}
