package linkedList;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParanthesis {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		for (int i = 0; i < t; i++) {
			String expression = in.next();
			System.out.println(isBalanced(expression) ? "YES" : "No");
		}

	}

	static boolean isBalanced(String expression) {
		boolean flag = true;
		Stack<Character> stack = new Stack<Character>();
		char[] charr = expression.toCharArray();
		for (int i = 0; i < charr.length; i++) {
			char c = charr[i];
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if ( (c == ')' || c == '}' || c == ']')) {
				if(!stack.isEmpty()){
				flag = check(c,stack);
				if(!flag){
					return flag;
				}
				}
				else{
					flag = false;
					return flag;
				}
			}
			else
				continue;
			
		}
		
		return flag;
	}
	
	static boolean check(char c, Stack<Character> stack){
		boolean isBalanced = false;
		char poppedItem = stack.pop();
		switch(c){
		
		case '}':
			if(poppedItem  == '{'){
				isBalanced = true;
			}
			else{
				isBalanced = false;
			}
			break;
		case ']' :
			if(poppedItem == '['){
				isBalanced = true;
			}
			else{
				isBalanced = false;
			}
			break;
		case ')' :
			if(poppedItem == '('){
				isBalanced = true;
			}
			else{
				isBalanced = false;
			}
			break;
		default : 
			isBalanced = false;
		
		
		}
		return isBalanced;
	}

}
