//Hashmap with <element,index>
//Arraylist

import java.util.*;

class MagicMap{
	private HashMap<Integer,Integer> hashmap;
	private ArrayList<Integer>  array;
	
	public int getArraySize(){
		return array.size();
	}
	public MagicMap(){
		hashmap = new HashMap<Integer,Integer>();
		array = new ArrayList<Integer>();
	}
	
	public void add(int element){
		if(!hashmap.containsKey(element)){
			array.add(element);
			int index= array.indexOf(element);
			hashmap.put(element, index);
		}
		else{
		System.out.println(element+" already exists");
		}
	}
	
	public void delete(int element){
		if(hashmap.containsKey(element)){
			//Get index from hashmap
			int index= hashmap.get(element);
			//replace the element in arraylist at index with last element
			int lastElement = array.get(getArraySize()-1);
			array.set(index, lastElement);
			//remove the last element
			array.remove(getArraySize()-1);
			//update the index of last element in hashmap
			hashmap.put(lastElement, index);
			hashmap.remove(element);
		}
		else{
			System.out.println(element+ " does not exists");
		}
	}
	
	public void contains(int element){
		if(hashmap.containsKey(element)){
			System.out.println(element+ " does exists");
		}else{
		System.out.println(element+ " does not exists");
		}
	}
	
	public int randomElement(){
		
		Random rand = new Random();
		
		int randindex = rand.nextInt(getArraySize()-1);
		return array.get(randindex);
	}
}

public class MagicMapImpl{

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MagicMap impl = new MagicMap();
        impl.add(3);
        impl.add(4);
        impl.add(5);
        impl.add(7);
        impl.add(7);
        impl.add(8);
        impl.add(2);
        impl.add(0);
        impl.add(6);
        impl.add(9);
        
        impl.delete(10);
        impl.delete(5);
        impl.delete(6);
        
        impl.contains(5);
        impl.contains(3);
        
        System.out.println("Random Elemnet  : " +impl.randomElement());
        System.out.println("Random Elemnet  : " +impl.randomElement());
        System.out.println("Random Elemnet  : " +impl.randomElement());
        System.out.println("Random Elemnet  : " +impl.randomElement());
        System.out.println("Random Elemnet  : " +impl.randomElement());
        
        
	}

}
