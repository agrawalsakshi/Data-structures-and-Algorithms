import java.util.HashSet;
import java.util.Set;


///  Find substring of shortest length which has all characters of given set/String
//Approach: navigate through string array and find all substrings using 2 for loops 
//Now we need one more loop , to find substrings which have all elements of given set 
//Now we need one if condition to check the minimum among them  
public class FindAllSubstrings {
static Set<Character> charSet = new HashSet();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    // String str = "abcdabd";
	String str = "ADOBECODEBANC";//"aabdadaeb";
     String check ="ZYD";//"aab";
     char [] charr = str.toLowerCase().toCharArray();
     charSet.add('b');
     charSet.add('d');
   //  findSubStrings(charr); //O(n3)
   // findSubStrings2(charr); //O(n2)
  String result= smlSubStr(str,check);//O(n)
   //In this approach , wetake 2 pointer begin and end, initially both at 0, starting index
   //increment end till we reach the controlling set
   //now, start increasing begin index till we reach the window with minimum characters required to build the controlling set
   //calculate the length of minimum window and again start the end index incrementing till reach the end of the window to find
   //if there is any other substring with less length.
   System.out.println(result);
	}

	
	static String smlSubStr(String S,String T){
		if(S == null || S.length() < T.length()) return null;

		int sLen = S.length(), tLen = T.length(), minWindowBegin = 0,minWindowEnd = 0;
		//  needToFind stores the total count of a character in T and hasFound stores the total count of a character met so far
		int needToFind[] = new int[256];
		int hasFound[] = new int[256];
		
		for (int i = 0; i < tLen; i++)
			needToFind[T.charAt(i)]++;
		
		int minWindowLen = Integer.MAX_VALUE;
		int count = 0;

		for (int begin = 0, end = 0; end < sLen; end++) {
			// skip characters not in T
			if (needToFind[S.charAt(end)] == 0) continue;
			
			// char is present in T so u increment hasFound
			hasFound[S.charAt(end)]++;
			// to store the total characters in T that's met so far 
			//(not counting characters where hasFound[x] exceeds needToFind[x]).
			if (hasFound[S.charAt(end)] <= needToFind[S.charAt(end)])
				count++;

			// if window constraint is satisfied
			if (count == tLen) {
				// advance begin index as far right as possible, stop when advancing breaks window constraint.
				while (needToFind[S.charAt(begin)] == 0 || hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)]) {
					if (hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)])
						hasFound[S.charAt(begin)]--;
					begin++;
				}

				// update minWindow if a minimum length is met
				int windowLen = end - begin + 1;
				minWindowBegin = begin;
				minWindowEnd = end;
				System.out.println(S.substring(minWindowBegin,minWindowEnd+1));
				if (windowLen < minWindowLen) {
					minWindowBegin = begin;
					minWindowEnd = end;
					minWindowLen = windowLen;
				} // end if
			} // end if
		} // end for
		
		String result = S.substring(minWindowBegin,minWindowEnd+1);

		return (count == tLen) ? result : null;

	}
	
	//O(n2)
	public static void findSubStrings2(char[] charr){
		int min_length = Integer.MAX_VALUE;
		int min_start =-1;
		int min_end=-1;
		int j=0;
		for(int i=0;i<charr.length;i++){
			Set copy = new HashSet();
			copy.addAll(charSet);
			for( j=i;j<charr.length;j++){
				if(copy.contains(charr[j])){
					copy.remove(charr[j]);
				}
		
			if(copy.isEmpty()){
				if(j-i+1 < min_length){
					min_length = j-i+1;
					min_start=i;
					min_end=j;
				
			}
				break;
		
			}
	}
		}
		System.out.println("Min_length :" + min_length + " min_start: "+min_start + " min_end: "+min_end);
	}
	
	
	//O(n3)
	public static void findSubStrings(char[] charr){
		int min_length = Integer.MAX_VALUE;
		int min_start =-1;
		int min_end=-1;
		for(int i=0;i<charr.length;i++){
			for(int j=i;j<charr.length;j++){
				Set copy = new HashSet();
				copy.addAll(charSet);
				for(int k=i;k<=j;k++){
					if(copy.contains(charr[k])){
						copy.remove(charr[k]);
					}
				}
				if(copy.isEmpty()){
					if(j-i+1 < min_length){
						min_length = j-i+1;
						min_start=i;
						min_end=j;
					}
				}
				
			}
		}
		System.out.println("Min_length :" + min_length + " min_start: "+min_start + " min_end: "+min_end);
	}
}
