package linkedList;

import java.util.HashMap;
import java.util.Map;

public class RemovesDuplicates {

	Node head;
	
	public void push(int data){
		
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}
	
	public void removeDuplicate(){
		Node node = head;
		Node prev = null;
		
		while(node.next != null){
			if(node.data == node.next.data){
				if(node == head){
					head = node.next;
					node = head;
				}
				else{
				prev.next = node.next;
				
				node.next = null;
				node = prev.next;
				}
			}
			else {
			prev = node;
			node = node.next;
			}
		}
		
	}
	
	public void printList(){
		
		if (head== null) return;
		
		Node node = head;
		
		while (node !=null){
			System.out.println("Node data: "+node.data);
			node = node.next;
		}
	}
	
	public void removeDuplicateUnsorted(){
		
		Node node = head;
		Node prev = null;
		Map<Integer,Integer> hm = new HashMap<Integer,Integer>();
		
		
		while(node != null){
			if(hm.containsKey(node.data)){
				prev.next = node.next;
				node = node.next;				
			}
			else{
				hm.put(node.data, 1);
				prev = node;
				node = node.next;
			}
		}
	}
	
	public static void main(String[] args) {
		
		RemovesDuplicates removesDuplicates = new RemovesDuplicates();
		
		// When linkedlist is sorted
		 /*removesDuplicates.push(1);
		removesDuplicates.push(1);
		removesDuplicates.push(2);
		removesDuplicates.push(3);
		removesDuplicates.push(3);
		removesDuplicates.push(4);
		removesDuplicates.push(4);
		
		removesDuplicates.printList();
		
		removesDuplicates.removeDuplicate();
		System.out.println("Data in list after removing duplicates");
		removesDuplicates.printList();*/
		
		
	//When Linkedlist is not sorted
		
		
		removesDuplicates.push(1);
		removesDuplicates.push(4);
		removesDuplicates.push(3);
		removesDuplicates.push(2);
		removesDuplicates.push(1);
		removesDuplicates.push(4);
		
		removesDuplicates.printList();
		
		removesDuplicates.removeDuplicateUnsorted();
		System.out.println("Data in list after removing duplicates");
		removesDuplicates.printList();
	}

}
