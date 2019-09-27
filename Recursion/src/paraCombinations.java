import java.util.ArrayList;

public class paraCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int open =0;int close=0;
		printParentheses(3);
			//printBalancedPara(3,open,close,0);
	}
	
	public static void printParentheses(int n) {
		for(int i=1;i<=n;i++){
			Validparentheses(i, i, "");
		}
	//	Validparentheses(n / 2, n / 2, "");
	}
	
	public static void Validparentheses(int openP,int closeP, String exp){
		
		if(openP ==0 && closeP==0){
			System.out.println(exp);
		}
		if (openP > closeP) // means closing parentheses is more than open ones
			return;
		if (openP > 0)
			Validparentheses(openP - 1, closeP, exp + "("); // put ( and
																// reduce
																// the count by
																// 1
		if (closeP > 0)
			Validparentheses(openP, closeP - 1, exp + ")"); // put ) and

}
}
