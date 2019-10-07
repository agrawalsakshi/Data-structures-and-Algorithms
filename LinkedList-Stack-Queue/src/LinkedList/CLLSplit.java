package linkedList;

public class CLLSplit {
	Node head;

	public void push(int data) {

		Node newnode = new Node(data);
		Node temp = head;
		if (head != null) {
			do {
				temp = temp.next;
			} while (temp.next != head);

			temp.next = newnode;
			newnode.next = head;
		} else {
			newnode.next = newnode;
		}

		head = newnode;
	}

	public void printList() {

		Node temp = head;
		if (head != null) {
			do {
				System.out.println("Data in CLL: " + temp.data);
				temp = temp.next;
			} while (temp != head);
		}

	}

	public void splitList() {

		Node temp = head;
		if (head != null) {
			do {

			} while (temp != head);
		}
	}

	public static void main(String[] args) {
		CLLSplit splitCLL = new CLLSplit();
		splitCLL.push(12);
		splitCLL.push(10);
		splitCLL.push(1);
		splitCLL.push(13);
		splitCLL.push(16);
		splitCLL.push(11);
		splitCLL.printList();

		splitCLL.splitList();

	}

}
