import java.util.Stack;

// maintaining a stack where push, pop, getmin are 0(1)

//doing this with 2 stack sis pretty strightforward
//doing it with 1 stack 

//here we are doing this with one stack,
//Everytime when we push element, we check it with minvalue: if it is less then we push minvalue in stack and also this new value and change minvalue to new value.
//else, we simply push new value
//in case of pop, if the poped value is equal to min value, we pop again from stack and make the new popped value as minvalue 
public class MinStack {
	Stack<Integer> stack = new Stack();
   int min =Integer.MAX_VALUE;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack minstack = new MinStack();
       minstack.push(7);
       minstack.push(5);
       minstack.push(8);
       minstack.push(7);
       minstack.push(5);
       minstack.push(4);
       minstack.pop();
       minstack.pop();
       System.out.println(minstack.getMin());
          
	}
	
	public void push(int value){
		if(value<min){
			stack.push(min);
			min=value;
		}
		stack.push(value);
	}
	
	public void pop(){
		if(!stack.isEmpty()){
			int x = stack.pop();
			if(x == min){
				stack.pop();
				
			}
		}
	}
	
	public int getMin(){
		return stack.peek();
	}

}
