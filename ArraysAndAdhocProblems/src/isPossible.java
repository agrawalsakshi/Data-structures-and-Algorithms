/*Consider a pair of integers, (a, b). We can perform the following operations on(a, b) in any
order, zero or more times:
(a, b) → (a + b, b)
(a, b) → (a, a + b)
For example, you can start with (1, 4), perform the operation(1 + 4, 4)to get (5, 4), perform
the operation (5, 5 + 4) to get (5, 9), and perform the operation(5, 5 + 9) to get (5, 14).*/
public class isPossible {
	public static void main (String[] args) throws java.lang.Exception
	{
		
	 	String result = canPossible(1,2,3,6);//(1,4,5,9)
	 	System.out.println(result);
	}
	
	static String canPossible(int a, int b, int c, int d) {
	    
	    if(a>c || b>d) return "No";
	    else if(a==c && b==d) return "YES";
	    
	    String result1 =  canPossible(a+b,b,c,d);
	    String result2 = canPossible(a,a+b,c,d);
	    
	    a= a-b;
	    b= b-a;
	    
	    if(result1.equalsIgnoreCase("YES") || result2.equalsIgnoreCase("YES")) return "YES";
	    else return "No";
	}
}
