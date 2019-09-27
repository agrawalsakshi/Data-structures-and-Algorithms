import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

//  learn regular expression with dp
class TrieNNode {
    char c;
    HashMap<Character, TrieNNode> childrenMap = new HashMap<Character, TrieNNode>();
    boolean isLeaf;
 
    public TrieNNode() {}
 
    public TrieNNode(char c){
        this.c = c;
    }

	
}
public class TrieSearchWordsWithPattern {
	private TrieNNode root;
	static  List<String> words = new ArrayList<>();
     
	    public TrieSearchWordsWithPattern() {
	        root = new TrieNNode();
	    }
	    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrieSearchWordsWithPattern dict = new TrieSearchWordsWithPattern();
		dict.insert("date");
		dict.insert("eat");
		dict.insert("at");
		dict.insert("bat");
		dict.insert("aan");
		
		dict.insert("ban");
		dict.insert("cut");
		dict.insert("cot");
		dict.insert("cat");
		dict.insert("cab");
		dict.insert("can");
		
		dict.insert("cater");
		// dict.getWords(".an");
		dict.getWords(".a*");
		 System.out.println(words);
	}
	
	public void insert(String word){
		  HashMap<Character, TrieNNode> childrenMap = root.childrenMap;
			 
	        for(int i=0; i<word.length(); i++){
	            char c = word.charAt(i);
	 
	            TrieNNode t;
	            if(childrenMap.containsKey(c)){
	                    t = childrenMap.get(c);
	            }else{
	                t = new TrieNNode(c);
	                childrenMap.put(c, t);
	            }
	 
	            childrenMap = t.childrenMap;
	 
	            //set leaf node
	            if(i==word.length()-1)
	                t.isLeaf = true;    
	        }
	}
	
	public void getWords(String pattern){
	StringBuilder	OutputWord=new StringBuilder();
		//HashMap<Character,TrieNNode> children = root.children;
//		for(int i=0;i<pattern.length();i++){
//			char c = pattern.charAt(i);
//			OutputWord= OutputWord+c;
			getWordsRecurse(0,pattern,OutputWord,root);
			
		
	}
	
	private void getWordsRecurse(int index, String pattern, StringBuilder outputWord, TrieNNode node){
		//|| pattern.contains("*")
		if (index>=pattern.length() ){
			//System.out.println("char : "+pattern.charAt(index));
			if(node.isLeaf){
				words.add(outputWord.toString());
				return;
			}
			
		}
		HashMap<Character,TrieNNode> HMap = node.childrenMap;
		Iterator<Character> itr = HMap.keySet().iterator();
		if( index<pattern.length() && pattern.charAt(index)!='.' && pattern.charAt(index)!='*' ){
			
//			if(HMap.size()<=0){
//				return;
//			}
			
			outputWord.append(pattern.charAt(index));
			if(HMap.containsKey(pattern.charAt(index))){
			getWordsRecurse(index+1,pattern,outputWord,HMap.get(pattern.charAt(index)));
			}
			outputWord.deleteCharAt(index);
		}
		else if(index>=pattern.length() && pattern.contains("*")){
			while(itr.hasNext()){
				char c = itr.next();
				outputWord.append(c);
				TrieNNode t = HMap.get(c);
				getWordsRecurse(index+1, pattern,outputWord,t);
				outputWord.deleteCharAt(index);
			}
		}
		else if(pattern.charAt(index)=='.'){
			while(itr.hasNext()){
				char c = itr.next();
				//if(pattern.charAt(index)==c ){
				outputWord.append(c);
				
				TrieNNode t = HMap.get(c);
				
				getWordsRecurse(index+1, pattern,outputWord,t);
				outputWord.deleteCharAt(index);
				}
		
	}
		else if(pattern.charAt(index)=='*'){
			while(itr.hasNext()){
				char c = itr.next();
				outputWord.append(c);
				TrieNNode t= HMap.get(c);
//				if(t.isLeaf && t.childrenMap.size()>0){
//					words.add(outputWord.toString());
//					
//					 getWordsRecurse(index+1, pattern,outputWord,t.childrenMap.get(c).);
//					}
				getWordsRecurse(index+1,pattern,outputWord,t);
				getWordsRecurse(index,pattern,outputWord,t);
				outputWord.deleteCharAt(index);
			}
		}
	}
}


