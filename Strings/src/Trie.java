import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
//Inser to trie, Search word, Search prefix , get list of words with a prefix
class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    boolean isLeaf;
 
    public TrieNode() {}
 
    public TrieNode(char c){
        this.c = c;
    }

	
}

public class Trie {
	 private TrieNode root;
	static  List<String> words = new ArrayList<>();
     
	    public Trie() {
	        root = new TrieNode();
	    }
	    
	    public static void main(String[] args){
	    	Trie dict = new Trie();
	        dict.insert("are");
	        dict.insert("area");
	        dict.insert("base");
	        dict.insert("cat");
	        dict.insert("cater");
	        dict.insert("basement");
	        String input = "cat";
	        System.out.print(input + ":   ");
	        System.out.println(dict.search(input)); 
	        dict.getWords("b");
	        System.out.println(words);
	    }
	 
	    // Inserts a word into the trie.
	    public void insert(String word) {
	        HashMap<Character, TrieNode> children = root.children;
	 
	        for(int i=0; i<word.length(); i++){
	            char c = word.charAt(i);
	 
	            TrieNode t;
	            if(children.containsKey(c)){
	                    t = children.get(c);
	            }else{
	                t = new TrieNode(c);
	                children.put(c, t);
	            }
	 
	            children = t.children;
	 
	            //set leaf node
	            if(i==word.length()-1)
	                t.isLeaf = true;    
	        }
	    }
	    
	    List<String> getWords(String prefix) {
	        
	    	TrieNode t = searchNode(prefix);
	        if (t!=null) {
	            if (t.isLeaf) words.add(prefix);
	            getWordsRecurse(prefix, words,t);
	        }
	        return words;
	    }
	    
	 

	    // Get all words including and below this node, prefixed with given string,
	    // and add them to the given list.
	    private void getWordsRecurse(String prefix, List<String> words, TrieNode node) {
	    	HashMap<Character, TrieNode> children = node.children;
	    	Iterator<Character> itr = children.keySet().iterator();
	    			while(itr.hasNext()){
	    				char c = itr.next();
	    				String nodestring = prefix + c;
	    				TrieNode t = children.get(c);
	    				if(t.isLeaf)words.add(nodestring);
	    				if(t.children.size()>0) getWordsRecurse(nodestring, words,t);
	    				
	    			}
//	        for (TrieNode n : children) {
//	            String nodestring = prefix + n.key;
//	            if (n.isLeaf) words.add(nodestring);
//	            if (n.children.size()>0) n.getWordsRecurse(nodestring, words);
//	        }
	    }
	 
	    // Returns if the word is in the trie.
	    public boolean search(String word) {
	        TrieNode t = searchNode(word);
	 
	        if(t != null && t.isLeaf) 
	            return true;
	        else
	            return false;
	    }
	 
	    // Returns if there is any word in the trie
	    // that starts with the given prefix.
	    public boolean startsWith(String prefix) {
	        if(searchNode(prefix) == null) 
	            return false;
	        else
	            return true;
	    }
	 
	    public TrieNode searchNode(String str){
	        Map<Character, TrieNode> children = root.children; 
	        TrieNode t = null;
	        for(int i=0; i<str.length(); i++){
	            char c = str.charAt(i);
	            if(children.containsKey(c)){
	                t = children.get(c);
	                children = t.children;
	            }else{
	                return null;
	            }
	        }
	 
	        return t;
	    }

}
