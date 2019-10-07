package Stack;

//https://www.geeksforgeeks.org/next-greater-element/

public class NextGreaterElement {

	public void findElement(int[] arr) {

		stack.push(arr[0]);
		int element;
		int next;
		for (int i = 1; i < arr.length; i++) {
			next = arr[i];
			
			if (!stack.isEmpty()) {
				element = stack.pop();

				while(element < next) {
					System.out.println("Pair :" + element + "-->" + next);
					if (stack.isEmpty())
						break;
					element = stack.pop();
				}

				if (element > next) {
					stack.push(element);
				}

				
			}
			stack.push(next);
		}

			if (!stack.isEmpty()) {
				while (!stack.isEmpty()) {
					System.out.println("Pair :" + stack.pop() + "--> -1");
				}
			}
		}
	

	public static void main(String[] args) {

		NextGreaterElement nextGreaterElement = new NextGreaterElement();

		// int[] arr = { 11, 13, 21, 3 };
		int[] arr = { 13, 7, 6, 12 };
		nextGreaterElement.findElement(arr);

	}

}

class stack {

	static int[] items = new int[100];
	static int top = -1;

	static void push(int x) {
		if (top >= 99) {
			System.out.println("Stack is full. cant push more elements");
		} else {
			items[++top] = x;
		}
	}

	static int pop() {
		int x;
		if (top == -1) {
			System.out.println("Stack is empty. ");
			return 0;
		} else {
			x = items[top--];

		}
		return x;
	}

	static boolean isEmpty() {

		return (top == -1) ? true : false;

	}
}
