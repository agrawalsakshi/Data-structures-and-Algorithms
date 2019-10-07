package linkedList;

public class DLLDeleteNode {

	static NodeDLL head;

	public void push(int data) {

		NodeDLL newNode = new NodeDLL(data);
		if (head == null) {
			head = newNode;
		}
		else{
		newNode.next = head;
		head.prev = newNode;

		head = newNode;
		}

	}

	public void printList() {

		NodeDLL node = head;

		while (node != null) {
			System.out.println("Data in DLL : " + node.data);
			node = node.next;

		}
	}
	
	public void deleteNode(NodeDLL node){
		
		if( node == null) return;
		
		else{
			if (node == head){
				NodeDLL temp = head.next;
				
				temp.prev = null;
				head.next = null;
				head = temp;
			}
			else{
				NodeDLL prev = node.prev;
				prev.next = node.next;
				node.next.prev = prev;
				node.next = null;
				node.prev = null;
				
			}
			
		}
		
		
	}

	public static void main(String[] args) {

		DLLDeleteNode deleteNodeDLL = new DLLDeleteNode();
		deleteNodeDLL.push(10);
		deleteNodeDLL.push(12);
		deleteNodeDLL.push(1);
		deleteNodeDLL.push(19);
		deleteNodeDLL.push(13);
		
		

		deleteNodeDLL.printList();
		System.out.println("DLL after deleting nodes");
		//First node
		deleteNodeDLL.deleteNode(head);
		deleteNodeDLL.printList();
		
		//second node from head
		deleteNodeDLL.deleteNode(head.next.next);
		System.out.println("DLL after deleting nodes");
		deleteNodeDLL.printList();
	}

}

class NodeDLL {
	int data;
	NodeDLL prev;
	NodeDLL next;

	NodeDLL(int data) {
		this.data = data;
	}
}
