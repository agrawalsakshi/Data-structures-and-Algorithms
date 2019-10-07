import java.util.Hashtable;



/// getKey()
// set(key,value)
// remove(key)
// size()
//private/protected evict()
class DLinkedNode {
		int key;
		int value;
		DLinkedNode pre;
		DLinkedNode post;
	}


public class LRUCache {

	
	private Hashtable<Integer, DLinkedNode> map = new Hashtable<Integer, DLinkedNode>();
	private int count;
	private int capacity;
	private DLinkedNode head, tail;

	public LRUCache(int capacity) {
		this.count = 0;
		this.capacity = capacity;

		head = new DLinkedNode();
		head.pre = null;
	
		tail = new DLinkedNode();
		tail.post = null;
	
		head.post = tail;
		tail.pre = head;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache lrucache= new LRUCache(5);
		lrucache.set(2, 10);
		lrucache.set(5, 30);
		lrucache.set(4, 30);
		int value= lrucache.get(2);
		System.out.println(value);
	}
	
public int get(int key) {
	    
		DLinkedNode node = map.get(key);
		if(node == null){
			return -1; // should raise exception here.
		}
		
		// move the accessed node to the head;
		this.moveToHead(node);
		
		return node.value;
	}


	public void set(int key, int value) {
		DLinkedNode node = map.get(key);
		
		if(node == null){
			
			DLinkedNode newNode = new DLinkedNode();
			newNode.key = key;
			newNode.value = value;
			
			this.map.put(key, newNode);
			this.addNode(newNode);
			
			++count;
			///  this is logic of evict()
			if(count > capacity){
				// pop the tail
				DLinkedNode tail = this.popTail();
				this.map.remove(tail.key);
				--count;
			}
		}else{
			// update the value.
			node.value = value;
			this.moveToHead(node);
		}
		
	}
	
	
	/// Helper functions
	/**
	 * Always add the new node right after head;
	 */
	private void addNode(DLinkedNode node){
		node.pre = head;
		node.post = head.post;
		
		head.post.pre = node;
		head.post = node;
	}

	/**
	 * Remove an existing node from the linked list.
	 */
	private void removeNode(DLinkedNode node){
		DLinkedNode pre = node.pre;
		DLinkedNode post = node.post;
		
		pre.post = post;
		post.pre = pre;
	}

	/**
	 * Move certain node in between to the head.
	 */
	private void moveToHead(DLinkedNode node){
		this.removeNode(node);
		this.addNode(node);
	}

	// pop the current tail. 
	private DLinkedNode popTail(){
		DLinkedNode res = tail.pre;
		this.removeNode(res);
		return res;
	}

	

	
}
