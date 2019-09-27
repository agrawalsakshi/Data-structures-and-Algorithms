import java.io.BufferedInputStream;
import java.util.Scanner;

public class FindNextPallindrome {

	public static void main(String[] args) {
		
	//	int num[] = {9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2};
		 
	int num[] ={8,9,9,8};	 
	    generateNextPalindrome( num);
	 
	}

	private static void generateNextPalindrome(int[] num) {
		 int len = num.length; int i =len/2;
		 while(i>=0){
			 if(num[i]==9)num[i]=0;
			 else
			 { num[i]++;
			 break;
			 }i--;
			 
			 
		 }
		 
		 if(i==0 && num[i]==9)num[i]=10;
		 
		 for(int i1 =0; i1<len/2;i1++)
		    num[len-1-i1]= num[i1];
		 
		for(int j=0;j<len;j++)
			System.out.print(" "+num[j]);
	}
		
       //int num =23545;
//		int num =6789876;
//       String input = String.valueOf(num);
//       
//       int low = 0;
//       int high =input.length()-1;
//       int mid = low+(high-low)/2;
//       int midDigit=0;
//       int digits= input.length();
//       StringBuilder sb = new StringBuilder();
//       int carry=0;
//       int sum=0;
//       if(digits%2==0){
//    	   
//       }
//       else{
//    	   midDigit= Integer.parseInt(String.valueOf(input.charAt(mid))) +1;
//    	   sum=midDigit;
//    	   while(sum==10){
//    		   midDigit=0;
//    		   carry=1;
//    		   sum=Integer.parseInt(String.valueOf(input.charAt(mid-1))) +1;
//    	   }
//    	   sb.append(Integer.parseInt(String.valueOf(input.substring(0,mid))));
//    	   sb.append(midDigit);
//    	   int start=mid-1;
//    	   while(start>=0){
//    	   sb.append(Integer.parseInt(String.valueOf(input.charAt(start))));
//    	   start--;
//    	   }
//       }
//      System.out.println(sb.toString());
       
	}


