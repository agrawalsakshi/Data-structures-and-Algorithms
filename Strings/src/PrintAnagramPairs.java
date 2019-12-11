import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrintAnagramPairs {
	public static void main (String[] args) throws java.lang.Exception
	{
	   String [] input = {"cat", "dog", "tac", "god", "act"};
	   
	   printAnagramPairs(input);
	}
	
	public static void printAnagramPairs(String [] input){
	    Map<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
	    
	    for(int i=0;i<input.length;i++){
	        String word = input[i];
	        char [] charr = word.toCharArray();
	        Arrays.sort(charr);
	        String newWord = new String(charr);
	        if(hm.containsKey(newWord)){
	            hm.get(newWord).add(word);
	        }
	        else{
	            ArrayList<String> list = new ArrayList<String>();
	            list.add(word);
	            hm.put(newWord,list);
	        }
	    }
	    
	    for(String key: hm.keySet()){
	        ArrayList<String> list = hm.get(key);
	        System.out.println("key: "+key+" words: "+list.toString());
	    }
	}
}
