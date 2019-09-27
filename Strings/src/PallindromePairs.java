import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
//Given a list of words , return list of words that can be joined together in any order to form pallindrome.
//Eb {bat,cat,tab} so, bat nad tab are words
//{ab,deedba} can be joined to to form pallindrome
import java.util.Set;


/*
 * Given a list of words, is there any pair of words, that can be
joined (in any order) to form a palindrome?
 */
public class PallindromePairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//	    Scanner scan = new Scanner(System.in);
//        int n= scan.nextInt();
//        scan.nextLine();
//        String[] words = new String[n];
//        for(int i=0;i<n;i++){
//            words[i]=scan.nextLine();
//        }
//        for(int i=0;i<n;i++){
//        System.out.println(words[i]);
//    }
		PallindromePairs pp= new PallindromePairs();
		//String [] words = {"bat","cat","tab","rat"};
		String [] words = {"deedba", "ab"};
		Set<Set<String>> ret =pp.palindromePairs(words);
		System.out.println(ret);

	}
	
	
	public Set<Set<String>> palindromePairs(String[] words) {
	    Set<Set<String>> ret = new HashSet<>(); 
	    if (words == null || words.length < 2) return ret;
	    Map<String, Integer> map = new HashMap<String, Integer>();
	    for (int i=0; i<words.length; i++) map.put(words[i], i);
	    for (int i=0; i<words.length; i++) {
	        // System.out.println(words[i]);
	        for (int j=0; j<=words[i].length(); j++) { // notice it should be "j <= words[i].length()"
	            String str1 = words[i].substring(0, j);
	            String str2 = words[i].substring(j);
	            if (isPalindrome(str1)) {
	                String str2rvs = new StringBuilder(str2).reverse().toString();
	                if (map.containsKey(str2rvs) && map.get(str2rvs) != i) {
	                    Set<String> list = new HashSet<String>();
	                    list.add(words[i]);
	                    list.add(str2rvs);
	                    ret.add(list);
	                    // System.out.printf("isPal(str1): %s\n", list.toString());
	                }
	            }
	            if (isPalindrome(str2)) {
	                String str1rvs = new StringBuilder(str1).reverse().toString();
	                // check "str.length() != 0" to avoid duplicates
	                if (map.containsKey(str1rvs) && map.get(str1rvs) != i && str2.length()!=0) { 
	                    Set<String> list = new HashSet<String>();
	                    list.add(words[i]);
	                    list.add(str1rvs);
	                    ret.add(list);
	                    // System.out.printf("isPal(str2): %s\n", list.toString());
	                }
	            }
	        }
	    }
	    return ret;
	}

	private boolean isPalindrome(String str) {
	    int left = 0;
	    int right = str.length() - 1;
	    while (left <= right) {
	        if (str.charAt(left++) !=  str.charAt(right--)) return false;
	    }
	    return true;
	}

}
