

public class NextPallindromicNum {
	public static void main (String[] args) throws java.lang.Exception
	{
		findNextPallindrome(67);
	}
	
	public static void findNextPallindrome(int n){
	    boolean isPallindromic = false;
	    
	    int index =1;
	   int num =n;
	    while(!isPallindromic){
	    	   num = n+index;
	    	   if(isPallindrome(num)){
	    		  System.out.println(num); 
	    		  break;
	    	   }
	    	   else{
	    		   index++;
	    	   }
	  
	    }
	    
	}
	
	public static boolean isPallindrome(int num){
		int reverse =0;
	    int remainder = 0;
	    int originalNum = num;
	    boolean isPallindrome = false;
		while(num>0){
			remainder = num%10;
            reverse = remainder+10*reverse;
            num = num/10;
		}
		if(reverse == originalNum){
			isPallindrome = true;
		}
		return isPallindrome;
	}
}
