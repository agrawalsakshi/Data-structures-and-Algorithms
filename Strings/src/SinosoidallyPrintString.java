
public class SinosoidallyPrintString {

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		//String str ="Google Worked";
//		String str = "Hello World";
//		int n=3;
//		
//		char[] ch1= new char[str.length()];
//		char[] ch2= new char[str.length()];
//		char[] ch3= new char[str.length()];
//		
//		//int i=0;
//		for(int j=0;j<str.length();j++){
//			if(str.charAt(j)==' '){
//				ch3[j]='~';
//			}
//			else ch3[j]=str.charAt(j);
//			j=j+n;
//		}
//		for(int j=1;j<str.length();j++){
//			if(str.charAt(j)==' '){
//				ch2[j]='~';
//			}
//			else ch2[j]=str.charAt(j);
//			j=j+n-2;
//		}
//		for(int j=2;j<str.length();j++){
//			if(str.charAt(j)==' '){
//				ch1[j]='~';
//				
//			}
//			else
//				ch1[j]=str.charAt(j);
//			j=j+n;
//		}
//
//		for(int i=0;i<str.length();i++){
//			if(ch1[i]=='\u0000'){
//				System.out.print(" ");
//			}
//			else
//				System.out.print(ch1[i]);
//			
//		}
//		//System.out.print(sb1.toString());
//		System.out.println();
//		for(int i=0;i<str.length();i++){
//			if(ch2[i]=='\u0000'){
//				System.out.print(" ");
//			}
//			else
//			System.out.print(ch2[i]);
//		}
//		System.out.println();
//
//		for(int i=0;i<str.length();i++){
//			if(ch3[i]=='\u0000'){
//				System.out.print(" ");
//			}
//			else
//			System.out.print(ch3[i]);
//		}
//		System.out.println();
//
//	}
	public static void main (String[] args) throws java.lang.Exception
	{
		String str = "Google Worked";
		String input = str.replace(" ","-");
		
	  char[][] output = new char[3][input.length()];
	//  int rows =output.length;
	  int cols = output[0].length;
	  int row = 2, col = 0;
	  int i=0;
	  while(i<cols){
	      while(i<cols && row>=0){
	          output[row][col] = input.charAt(i);
	          row--;
	          col++;
	          i++;
	      }
	      row = row+2;
	      while(i<cols && row<3){
	          output[row][col] = input.charAt(i);
	          row++;
	          col++;
	          i++;
	      }
	      row = row-2;
	  }
	  
	  for(int j=0;j<output.length;j++){
	      for(int k=0;k<output[0].length;k++){
	    	      if(!Character.isLetter(output[j][k]) && (int)output[j][k] != 45 ){
	    	    	     System.out.print(" ");
 	    	      }
	    	      else{
	           System.out.print(output[j][k]);
	    	      }
	      }
	      System.out.println();
	  }
	  
	}
	}



//