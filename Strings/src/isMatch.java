//check if given word matches given pattern
public class isMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="cat";
		String pattern = "*tu";
		findMatch(str,pattern,0,0);
	}
	
	public static void findMatch(String str, String pattern,int patternIndex , int stringIndex){
		boolean ismatch= true;
		while(stringIndex<str.length() ){
			if(patternIndex==pattern.length()){
				ismatch=false;
				break;
			}
		
		if(pattern.charAt(patternIndex)=='.'){
			if(stringIndex<str.length()){
				patternIndex++;
				stringIndex++;
			}
			if(patternIndex>=pattern.length() && stringIndex>=str.length() ){
				break;
			}
			if(patternIndex==pattern.length() && stringIndex!=str.length() ){
				ismatch=false;
				break;
			}
		}
		
		if(pattern.charAt(patternIndex)=='*'){
			patternIndex++;
			while(stringIndex<=str.length()-1){
				stringIndex++;
				//continue;
			}
			if(stringIndex==str.length()){
				ismatch=true;
				break;
			}
		}
		
		if(stringIndex<str.length() || pattern.charAt(patternIndex)!='.' || pattern.charAt(patternIndex)!='*'){
			
			if(pattern.charAt(patternIndex)==str.charAt(stringIndex)){
				stringIndex++;
				patternIndex++;
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
