

public class Atoi {
	public static void main (String[] args) throws java.lang.Exception
	{
		String str = "-3924    8fc";
		str = str.trim();
		int num = convertToInteger (str);
		System.out.println(num);
	}
	
	public static Integer convertToInteger(String str){
	    
		int index = 0;
	    String sign = "";
	    StringBuilder sb = new StringBuilder();
	  //  boolean flag 
	    for(int i=0;i<str.length();i++){
	     
	        if(index == 0 && (str.charAt(0) == '+' || str.charAt(0) == '-')){
	            sign = sign+str.charAt(0);
	            index++;
	        }
	        else if(str.charAt(i) >='0' && str.charAt(i)<='9'){
	            sb.append(str.charAt(i));
	        }
	        else if (str.charAt(i) ==' '){
	        	  continue;
	        }
	        else
	            break;
	        }
	    
	    if(sb.length()>0 ){
	        String output = sign+sb.toString();
	        return Integer.valueOf(output);
	    }
	    else 
	     return 0;
	    
	}

}
