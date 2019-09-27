import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


//Need to find solution of creating graph with vertex as word or some other
public class ConvertStringAToB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] words ={"CAT","BAT","BAD","HIT","HAT","HAD"};
		HashMap<String, ArrayList<String>> keyTowords=populatekeyTowordsMap(words);
		
		convert("CAT","HAD",keyTowords);
		
	}
	
	public static void convert(String src, String dest,HashMap<String, ArrayList<String>> keyTowords){
		Set<String> visited = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		Map<String,String> parent =new HashMap<String,String>();
		ArrayList<String> path = new ArrayList<String>();
		
		queue.add(src);
	//	visited.add(src);
		parent.put(src, null);
		while(queue.size()>0){
			
			String cur = queue.poll();
			if(cur.equals(dest)){
				String at = cur;
				while(at!=null){
					path.add(at);
					at=parent.get(at);
				}
				for(int i=path.size()-1;i>=0;i--)
				System.out.print(path.get(i)+" ");
				break;
			}
		ArrayList<String> listofkeys=	findKeysInkeyTowords(cur,keyTowords);
		
		
		for(String key:listofkeys){
			if(!visited.contains(key)){
			ArrayList<String> list = keyTowords.get(key);
			if(list.size()>1 && !visited.contains(key)){
				for(String word:list){
					if(!word.equals(cur)){
						visited.add(key);
						queue.add(word);
						parent.put(word, cur);
					}
				}
			}
		}
		}
			
		}
		}
	
	public static ArrayList<String> findKeysInkeyTowords(String cur,HashMap<String, ArrayList<String>> keyTowords ){
		
		ArrayList<String> listOfKeys = new ArrayList<String>();
		
		Iterator itr = keyTowords.keySet().iterator();
		while(itr.hasNext()){
			String key=(String) itr.next();
			if(keyTowords.get(key).contains(cur)){
				listOfKeys.add(key);
			}
		}
		return listOfKeys;
		
	}
	
	
	public static HashMap<String, ArrayList<String>> populatekeyTowordsMap(String[] words){
		
		HashMap<String, ArrayList<String>> keyTowords = new HashMap<String, ArrayList<String>>();
		
		for(int i=0;i<words.length;i++){
			String word= words[i];
			for(int j=0;j<word.length();j++){
				String key=word.replace(word.charAt(j), '_');
				ArrayList<String> list = new  ArrayList<String>();
				//list.add(word);
				if(!keyTowords.containsKey(key) ){
					list.add(word);
					keyTowords.put(key,list);
				}
				else if(!keyTowords.get(key).contains(word)){
					list=keyTowords.get(key);
					list.add(word);
					keyTowords.put(key,list);
				}
			}
		}
		
		
		return keyTowords;
	}
}