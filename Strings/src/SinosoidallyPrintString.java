
public class SinosoidallyPrintString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String str ="Google Worked";
		String str = "Hello World";
		int n=3;
		
		char[] ch1= new char[str.length()];
		char[] ch2= new char[str.length()];
		char[] ch3= new char[str.length()];
		
		//int i=0;
		for(int j=0;j<str.length();j++){
			if(str.charAt(j)==' '){
				ch3[j]='~';
			}
			else ch3[j]=str.charAt(j);
			j=j+n;
		}
		for(int j=1;j<str.length();j++){
			if(str.charAt(j)==' '){
				ch2[j]='~';
			}
			else ch2[j]=str.charAt(j);
			j=j+n-2;
		}
		for(int j=2;j<str.length();j++){
			if(str.charAt(j)==' '){
				ch1[j]='~';
				
			}
			else
				ch1[j]=str.charAt(j);
			j=j+n;
		}

		for(int i=0;i<str.length();i++){
			if(ch1[i]=='\u0000'){
				System.out.print(" ");
			}
			else
				System.out.print(ch1[i]);
			
		}
		//System.out.print(sb1.toString());
		System.out.println();
		for(int i=0;i<str.length();i++){
			if(ch2[i]=='\u0000'){
				System.out.print(" ");
			}
			else
			System.out.print(ch2[i]);
		}
		System.out.println();

		for(int i=0;i<str.length();i++){
			if(ch3[i]=='\u0000'){
				System.out.print(" ");
			}
			else
			System.out.print(ch3[i]);
		}
		System.out.println();

	}

}

//