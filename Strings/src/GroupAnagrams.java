import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GroupAnagrams {

	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("ARMY");
		strings.add("TAB");
		strings.add("MARY");
		strings.add("SUM");
		strings.add("BAT");
		strings.add("MOON");

		Map<String, ArrayList<String>> hm = groupStrings(strings);
		
		for(String s : hm.keySet()){
			System.out.println(s +" "+hm.get(s));
		}

	}

	public static Map<String, ArrayList<String>> groupStrings(ArrayList<String> list) {
		Map<String, ArrayList<String>> hm = new HashMap<String, ArrayList<String>>();
		
		Set<String> wordsVisited = new HashSet<String>();
		for (int i = 0; i < list.size(); i++) {
			String s1 = list.get(i);
			if (!wordsVisited.contains(s1)) {
			char[] charrs1 = s1.toCharArray();
			for (int j = i; j < list.size(); j++) {
				String s2 = list.get(j);
				boolean flag = false;
				if (!wordsVisited.contains(s2)) {
					
					for (int k = 0; k < charrs1.length - 1; k++) {
						char c = charrs1[k];
						int index = s2.indexOf(String.valueOf(c));
						if (index == -1) {	
							flag = true;
							addInMap(s1,hm,s2,flag);							 
							 wordsVisited.add(s1);
							 
							break;
						}
					}
					if(!flag){
						addInMap(s1,hm,s2,flag);
						wordsVisited.add(s2);
						wordsVisited.add(s1);
					}
					}

				}

			}
		}
		return hm;
		}
		
	
	
	public static void addInMap(String s1, Map<String,ArrayList<String>> hm, String s2, Boolean flag){
		ArrayList<String> alist = new ArrayList<String>();
		
		if(flag){
			if(!hm.containsKey(s1)){
				alist.add(s1);
				//alist.add(s2);
				hm.put(s1, alist);
			}
		}
		else if (hm.containsKey(s1)) {
			alist = hm.get(s1);
			alist.add(s2);
			hm.put(s1, alist);
			
		} else {
			alist.add(s1);
			//alist.add(s2);
			hm.put(s1, alist);
			
		}
	}
}
