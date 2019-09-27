import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class checkPallindrome {
	public static Set<Character> invalidchars = new HashSet<Character>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner scan = new Scanner(System.in);
		
		String str = "a b c , de f g h x x xa b ,  a xxx     hg f e d c b  a";
		
		//scan.close();
		
		invalidchars.add(' ');
		invalidchars.add(',');
		invalidchars.add('\'');
		invalidchars.add('.');
		char[] chArray = str.toLowerCase().toCharArray();
		
		
		boolean result =check(chArray,0,str.length()-1);
		System.out.println(result);
		
		
	}

	
	public static boolean check(char[] str, int left,int right){
		
		
		while((invalidchars.contains(str[left])) && left<right){
			left++;
		}
		
		while((invalidchars.contains(str[right])) && (right>left)){
			right--;
		}
		
		if(left==right || right-left==1){
			return true;
		}
		
		if(str[left] == str[right]){
			 return check(str,left+1,right-1);
		}
		
			return false;
		
		
	}
}
