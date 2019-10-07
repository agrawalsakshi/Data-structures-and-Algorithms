package linkedList;

// https://www.geeksforgeeks.org/swap-kth-node-from-beginning-with-kth-node-from-end-in-a-linked-list/
public class SwapKthNode {

	Node head;

	void push(int data) {

		Node node = new Node(data);
		node.next = head;
		head = node;

	}

	void printList() {

		Node node = head;

		while (node != null) {
			System.out.println("Node data :" + node.data);
			node = node.next;
		}
	}

	public void swapNode(int n) {
		int count = 1;
		int yPos = 1;

		Node x = null, y, xPrev = null, yPrev;

		Node temp = head;
		Node prev = null;
		while (temp.next != null) {
			if (count == n) {
				x = temp;
				xPrev = prev;
			}
			prev = temp;
			temp = temp.next;
			count++;
		}

		yPos = count - n + 1;
		count = 1;
		temp = head;
		prev = null;
		if( yPos > 0 && yPos <= count){
		while(count != yPos){
			prev = temp;
			temp = temp.next;
			count ++;
		}	
		}
		
		y = temp;
		yPrev = prev;
		
		if ( x == null || y == null) {
			System.out.println("Node to be swapped is/are null");
			
		
		}
		else if ( x == y){
			System.out.println("Same node");
		}
		
		else if (xPrev == null){
			temp = x.next;
			yPrev.next = x;
			y.next = temp;
			x.next = null;
			head = y;
			
		}
		else{
		// Swapping nodes
		xPrev.next = y;
		yPrev.next = x;
		temp = x.next;
		x.next = y.next;
		y.next = temp;
		}

	}

	public static void main(String[] args) {
		SwapKthNode swapKthNode = new SwapKthNode();

		swapKthNode.push(4);
		swapKthNode.push(6);
		swapKthNode.push(7);
		swapKthNode.push(3);
		swapKthNode.push(2);
		swapKthNode.push(5);
//		swapKthNode.push(9);
//		swapKthNode.push(8);
//		swapKthNode.push(10);

		swapKthNode.printList();

		swapKthNode.swapNode(9);
		System.out.println("List after swapping:");
		swapKthNode.printList();

	}

}
