//To find if the given string is present in String A i.e. substring of String A
public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcxaabcdabcyabc";
        String subString = "abcdabcy";
        KMP ss = new KMP();
        boolean result = ss.substringSearch(str.toCharArray(), subString.toCharArray());
        System.out.println(result);
	}
	
	
	public boolean substringSearch(char[] text, char[] pattern){
		int len =0;
		// patternTable;
		 int []	patternTable = computePatternTable(pattern);
		 for(int k=0;k<patternTable.length;k++){
			 System.out.print(patternTable[k]+ " ");
		 }
		 System.out.println();
		 
		 int j=0;int i=0;
		 while(i<pattern.length && j<text.length){
			 if(pattern[i]==text[j]){
				 i++;
				 j++;
				 
			 }
			 else{
				 if(i!=0){
					 i=patternTable[i-1];
				 }
				 else{
					 j++;
				 }
			 }
		 }
		 
		 if (i== pattern.length){
			 System.out.println("Index "+ (j-pattern.length));
			 return true;
		 }
		return false;
	}
	
	public int[] computePatternTable(char[] pattern){
		int [] patternTable = new int [pattern.length];
		int i=1;int j=0;
		patternTable[0]=0;
		while(i<pattern.length){
			if(pattern[i]==pattern[j]){
				patternTable[i]=j+1;
				i++;
				j++;
			}
			else{
				if(j!=0){
					j=patternTable[j-1];
				}
				else{
					patternTable[i]=0;
					i++;
				}
			}
		}
		return patternTable;
	}

}
