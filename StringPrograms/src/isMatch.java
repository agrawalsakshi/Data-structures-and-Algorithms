//check if given word matches given pattern
public class isMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="catr";
		String pattern = "*tu";
		findMatch(str,pattern,0,0);
	}
	
	public static void findMatch(String str, String pattern,int indexPattern , int indexString){
		boolean ismatch= true;
		while(indexString<str.length() ){
			if(indexPattern==pattern.length()){
				ismatch=false;
				break;
			}
		
		if(pattern.charAt(indexPattern)=='.'){
			if(indexString<str.length()){
				indexPattern++;
				indexString++;
			}
			if(indexPattern>=pattern.length() && indexString>=str.length() ){
				break;
			}
			if(indexPattern==pattern.length() && indexString!=str.length() ){
				ismatch=false;
				break;
			}
		}
		
		if(pattern.charAt(indexPattern)=='*'){
			indexPattern++;
			while(indexString<=str.length()-1){
				indexString++;
				//continue;
			}
			if(indexString==str.length()){
				ismatch=true;
				break;
			}
		}
		
		if(indexString<str.length() || pattern.charAt(indexPattern)!='.' || pattern.charAt(indexPattern)!='*'){
			
			if(pattern.charAt(indexPattern)==str.charAt(indexString)){
				indexString++;
				indexPattern++;
			}
			else{
				ismatch= false;
				break;
			}
			
		}
		
		}
		
		
		System.out.println("isMatch: "+ismatch);
		
		
		
	}

}
