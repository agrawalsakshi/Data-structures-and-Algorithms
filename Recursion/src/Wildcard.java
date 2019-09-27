import java.util.Scanner;

public class Wildcard {

	public final static char WILDCARD = '?';
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		String num = scan.next();
		char[] chArray = num.toCharArray();
		
		printPossibleNums(chArray,0);
	}
	
	public static void printPossibleNums(char [] num, int start){
		if (start >= num.length){
			System.out.println(num);
			return;
		}		
		if(num[start]==WILDCARD){
			num[start]='0';
			printPossibleNums(num,start+1);
			
			num[start]='1';
			printPossibleNums(num,start+1);
            
			num[start]=WILDCARD;
		}
		else{
			printPossibleNums(num,start+1);
		}	
	}
}
