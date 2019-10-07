package linkedList;

public class SwapNodes {

	Node head;

	public void push(int data) {

		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
	}

	public void printList() {

		if (head == null)
			return;

		Node node = head;

		while (node != null) {
			System.out.println("Node data: " + node.data);
			node = node.next;
		}
	}

	public void swapNodes(int data1, int data2) {
		Node node1 = head;
		Node prev1 = null, prev2 = null, node2 = head;
		Node temp;

		while (node1.data != data1 && node1 != null) {
			prev1 = node1;
			node1 = node1.next;
		}

		while (node2.data != data2 && node2 != null) {
			prev2 = node2;
			node2 = node2.next;
		}

		if (node1 == null || node2 == null) {
			System.out.println("input data does not exists in list");
			return;
		}

		if (node1.data == head.data) {
			prev2.next = node1;
			temp = node1.next;
			node1.next = node2.next;
			node2.next = temp;
			head = node2;
		}

		else if (node2.data == head.data) {
			prev1.next = node2;
			temp = node1.next;
			node1.next = node2.next;
			node2.next = temp;
			head = node1;
		}

		else {
			prev1.next = node2;
			prev2.next = node1;
			temp = node1.next;
			node1.next = node2.next;
			node2.next = temp;
		}

	}

	public static void main(String[] args) {

		SwapNodes swapNodes = new SwapNodes();

		swapNodes.push(14);
		swapNodes.push(20);
		swapNodes.push(13);
		swapNodes.push(12);
		swapNodes.push(15);
		swapNodes.push(10);

		swapNodes.printList();

		swapNodes.swapNodes(10, 20);

		System.out.println("List after swapping nodes:");
		swapNodes.printList();
	}

}


//Need to check : https://www.geeksforgeeks.org/add-the-given-digit-to-a-number-stored-in-a-linked-list-using-recursion/