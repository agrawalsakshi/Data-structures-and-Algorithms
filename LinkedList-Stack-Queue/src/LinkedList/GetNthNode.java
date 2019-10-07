package linkedList;

public class GetNthNode {

	static Node head;
	
	void push(int data){
				
		 Node node = new Node(data);
		 node.next = head;
		 head = node;
		
	}
	
	void printList(){
		
		Node node = head;
		
		while(node != null){
			System.out.println("Node data :"+ node.data);
			node = node.next;
		}
	}
	
	public void getNthNode (int n){
		
		Node node = head;
		
		if (n == 0){
			System.out.println("Nth Node : "+ n +" Value is ;"+ node.data);
		}
		
		for(int i=0;i<n;i++){
			if(node == null){
				System.out.println("n > length of list");
			}
			node = node.next;
		}
		System.out.println("Nth Node : "+ n +" Value is ;"+ node.data);
	}
	
	public void printMiddleElement(){
		Node slowPointer = head;
		Node fastPointer = head;
		
		if(head != null){
		while(fastPointer != null && fastPointer.next != null){
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
		}
		}
		
		System.out.println("MiddleElement : "+ slowPointer.data);
	}
	
	
	static void printReverse( int n) 
    { 
           int j = 0; 
           Node current = head; 
           while (current != null) { 
              
              // For each node, print proper number  
              // of spaces before printing it  
              for (int i = 0; i < 2 * (n - j); i++) 
                   System.out.print(" "); 

              // use of carriage return to move back  
              // and print. 
              System.out.print("\r" + current.data); 

              current = current.next; 
              j++;  
           } 
    } 
	
	public static void main(String args[]){
		GetNthNode getNthNode = new GetNthNode();
		getNthNode.push(1);
		getNthNode.push(2);
		getNthNode.push(5);
		getNthNode.push(9);
		getNthNode.push(10);
		
		getNthNode.printList();
		
//		getNthNode.getNthNode(4);
//		getNthNode.getNthNode(0);
//		getNthNode.getNthNode(1);
//		getNthNode.getNthNode(3);
		
//		getNthNode.printMiddleElement();
//		getNthNode.push(18);
//		getNthNode.printList();
//		getNthNode.printMiddleElement();
		GetNthNode.printReverse(5);
	}
}

 class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
		next = null;
	}
}