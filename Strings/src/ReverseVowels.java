import java.util.HashSet;
import java.util.Set;


// To reverse the vowels in a string. Use Set to store vowels so that scanning of vowels become O(1)
public class ReverseVowels {
	static Set<Character> vowel =new HashSet();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str = "assassination";
		//{};
		vowel .add('a');
		vowel .add('e');
		vowel .add('i');
		vowel .add('o');
		vowel .add('u');
		char [] chArr = str.toLowerCase().toCharArray();
		int i=0;
		int j= chArr.length-1;
		String result =swapVowels(i,j,chArr);
		System.out.println(result);
	}
	
	public static String swapVowels(int i, int j, char[] chArr ){
		
		if(i>j) {
			String s= new String(chArr);
			return s;
		}
		if(vowel.contains(chArr[i]) && vowel.contains(chArr[j])){
			char temp =chArr[i];
			chArr[i]= chArr[j];
			chArr[j]=temp;
			i++;j--;
		}
		if(!vowel.contains(chArr[i])){
			i++;
		}
		if(!vowel.contains(chArr[j])){
			j--;
		}
		return swapVowels(i,j,chArr);
		
		
	}

}
