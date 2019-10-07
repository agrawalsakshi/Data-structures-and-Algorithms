package linkedList;
//https://www.geeksforgeeks.org/rotate-doubly-linked-list-n-nodes/
public class DLLRotateNTimes {
	NodeDLL head;

	public void push(int data) {

		NodeDLL newNode = new NodeDLL(data);
		if (head == null) {
			head = newNode;
		} else {
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

	public void rotateNtimes(int n) {

		NodeDLL temp = head;
		NodeDLL last = null;

		for (int i = 0; i < n; i++) {
			while (temp.next != null) {
				temp = temp.next;
			}

			last = temp;
			last.next = head;
			head.prev = last;
			last.prev.next = null;
			head = last;
		}
	}

	public static void main(String[] args) {
		DLLRotateNTimes dLLRotateNTimes = new DLLRotateNTimes();

		dLLRotateNTimes.push(6);
		dLLRotateNTimes.push(5);
		dLLRotateNTimes.push(4);
		dLLRotateNTimes.push(2);
		dLLRotateNTimes.push(1);

		dLLRotateNTimes.printList();

		dLLRotateNTimes.rotateNtimes(2);
		System.out.println("List after rotation");
		dLLRotateNTimes.printList();

	}

}
