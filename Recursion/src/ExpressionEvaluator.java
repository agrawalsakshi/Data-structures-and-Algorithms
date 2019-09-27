import java.util.ArrayList;
import java.util.Stack;

// generate the expressions
// evaluate the expression

public class ExpressionEvaluator {

	public static final String[] operatorArray = { "+", "*", "" };
	public static StringBuilder sb = new StringBuilder("1*2*3");
	public static ArrayList<String> expCreated = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String digits = "1234";
		String digits = "222";
		int target = 24;
		expCreator(digits, 0, target);
	}

	public static void expCreator(String digits, int start, int target) {
		if (start >= digits.length() - 1) {
			//System.out.println("expCreatedression created:" + "passing for evaluation   " + expCreated);
			sb = new StringBuilder();
			for (String str : expCreated) {
				sb.append(str);
			}
			System.out.println(sb);
			return;
		}
		for (int i = 0; i < operatorArray.length; i++) {
			if (expCreated.size() == 0) {
				expCreated.add(digits.substring(0, 1));
			}

			expCreated.add(operatorArray[i] + digits.substring(start + 1, start + 2));
			expCreator(digits, start + 1, target);
			int result = expCreatedEvaluator(sb.toString());
			if (result == target) {
				System.out.println("The expression equal to target is : " + sb.toString());
			}
			expCreated.remove(expCreated.size() - 1);
		}

	}

	// algorithm from geeksforgeeks
	public static int expCreatedEvaluator(String expression) {

		char[] tokens = expression.toCharArray();
		Stack<Integer> values = new Stack<Integer>();
		Stack<Character> operators = new Stack<Character>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] == ' ')
				continue;
			if (tokens[i] >= '0' && tokens[i] <= '9') {
				StringBuffer buffer = new StringBuffer();
				while (i<tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
					buffer.append(tokens[i]);
					i++;
				}
			values.push(Integer.parseInt(buffer.toString()));
			}
			if (i<tokens.length && (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/')) {
				
				while (!operators.isEmpty() && hasPrecedence(tokens[i], operators.peek())) {
					values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
				}
					operators.push(tokens[i]);
				
			} else if (i<tokens.length && tokens[i] == '(') {
				operators.push(tokens[i]);
			}
			else if (i<tokens.length && tokens[i] == ')') {
				while (operators.peek() != '(') {
					values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
					operators.pop();
				}
			} 
		}

		while (!operators.isEmpty()) {
			values.push(applyOperation(operators.pop(), values.pop(), values.pop()));
		}
		return values.pop();
	}

	public static boolean hasPrecedence(char token, char operator) {
		if (operator == '(' || operator == ')')
			return false;
		if ((token == '*' || token == '/') && (operator == '+' || operator == '-'))
			return false;
		else
			return true;
	}

	public static int applyOperation(char operator, int value1, int value2) {

		switch (operator) {

		case '+':
			return value2 + value1;
		case '-':
			return value2 - value1;
		case '*':
			return value2 * value1;
		case '/':
			return value2 / value1;
		}
		return 0;
	}
}
