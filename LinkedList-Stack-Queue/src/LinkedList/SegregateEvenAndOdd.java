package linkedList;

public class SegregateEvenAndOdd {

	Node head;

	public void add(int data) {
		Node node = head;
		Node newnode = new Node(data);

		if (head == null) {
			head = newnode;
		} else {
			while (node.next != null) {
				node = node.next;
			}
			node.next = newnode;
		}
	}

	public void printList() {
		Node node = head;

		while (node != null) {
			System.out.println("Node data: " + node.data);
			node = node.next;
		}
	}

	public void segregateEvenAndOdd() {
		Node prev = null;
		Node node = head;
		Node lastNode;
		int count = 0;
		while (node.next != null) {
			count++;
			node = node.next;

		}

		lastNode = node;
		node = head;
		while (count > 0) {
			if (node.data % 2 > 0 && node == head) {
				lastNode.next = node;

				lastNode = node;
				head = node.next;
				Node temp = node.next;

				node.next = null;
				node = temp;

			} else if (node.data % 2 > 0) {
				prev.next = node.next;
				lastNode.next = node;
				lastNode = node;
				Node temp = node.next;

				node.next = null;
				node = temp;
			} else {
				prev = node;
				node = node.next;
			}
			count--;

		}
	}

	public static void main(String[] args) {

		SegregateEvenAndOdd segregateEvenAndOdd = new SegregateEvenAndOdd();

		segregateEvenAndOdd.add(17);
		segregateEvenAndOdd.add(15);
		segregateEvenAndOdd.add(8);
		segregateEvenAndOdd.add(12);
		segregateEvenAndOdd.add(10);
		segregateEvenAndOdd.add(5);
		segregateEvenAndOdd.add(4);
		segregateEvenAndOdd.add(1);
		segregateEvenAndOdd.add(7);
		segregateEvenAndOdd.add(6);

		segregateEvenAndOdd.printList();

		segregateEvenAndOdd.segregateEvenAndOdd();
		System.out.println("list after segragation : ");
		segregateEvenAndOdd.printList();
	}

}
