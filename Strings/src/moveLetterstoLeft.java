
public class moveLetterstoLeft {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 char[] input =new char[]{'0','a','1','9','3','z','b','r','6'};
 int j=0;int i=0;
 while(i<input.length){
	 if(input[i]>='a' && input[i] <='z' || input[i]>='A' && input[i] <='Z'){
		 char c=input[i];
		 input[i]=input[j];
		 input[j]=c;
		 j++;
	 }
	 else{
		 i++;
	 }
 }
 
 String str = String.valueOf(input);
 System.out.println(str);

	}

}
