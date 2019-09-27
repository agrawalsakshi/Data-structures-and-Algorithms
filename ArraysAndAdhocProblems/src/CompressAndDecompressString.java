
public class CompressAndDecompressString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		
		//String input="BAAAB";
		String input="A5AAAA";
		//String input="AB3AB";
		StringBuilder sb = new StringBuilder();
		int count=1;
		int i=0;
		while(i<input.length()){
			while((i+1)<input.length() && input.charAt(i)==input.charAt(i+1)){
				count++;
				i++;
			}
			if(count==1){
				sb.append(input.charAt(i));
			}
			else if(count>1){
				sb.append(count);
				sb.append(input.charAt(i));
			}
			count=1;
			i++;
			
		}
		System.out.println(sb.toString());
		//String str=decompress(sb.toString());
		//System.out.println(str);
	}

	
	public static String decompress(String input){
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<input.length();i++){
			if(input.charAt(i)>='0' && input.charAt(i)<='9'){
				int num = Integer.parseInt(String.valueOf(input.charAt(i)));
				char nextchar= input.charAt(i+1);
				for(int j=1;j<=num;j++){
					sb.append(nextchar);
				}
				i++;
			}
			else
				sb.append(input.charAt(i));
		}
		
		return sb.toString();
	}
}
