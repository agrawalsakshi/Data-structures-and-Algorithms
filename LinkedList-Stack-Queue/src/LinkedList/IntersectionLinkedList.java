package linkedList;

public class IntersectionLinkedList {

	static Node head1;
	static Node head2;
	static Node intersectHead;

	public Node push(Node head, int data) {

		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		return head;
	}

	public void printList(Node head) {

		if (head == null)
			return;

		Node node = head;

		while (node != null) {
			System.out.println("Node data: " + node.data);
			node = node.next;
		}
	}

	public Node createIntersectList() {
		Node node2 = head2;
		Node node1;
		int count = 0;
		while (node2 != null) {
			count++;
			node2 = node2.next;
		}
		node2 = head2;
		for (int i = 0; i < count; i++) {
			node1 = head1;
			while (node1.next != null && node1.data != node2.data) {
				node1 = node1.next;

			}
			if (node1.data == node2.data) {
				intersectHead = push(intersectHead, node1.data);
			}

			node2 = node2.next;
		}
		
		return intersectHead;

	}

	public static void main(String[] args) {

		IntersectionLinkedList intersectionLinkedList = new IntersectionLinkedList();

		// Create list1 1,2,3,4,6
		head1 = intersectionLinkedList.push(head1, 6);
		head1 = intersectionLinkedList.push(head1, 4);
		head1 = intersectionLinkedList.push(head1, 3);
		head1 = intersectionLinkedList.push(head1, 2);
		head1 = intersectionLinkedList.push(head1, 1);

		// Create list2 2, 4,6,8

		head2 = intersectionLinkedList.push(head2, 8);
		head2 = intersectionLinkedList.push(head2, 6);
		head2 = intersectionLinkedList.push(head2, 4);
		head2 = intersectionLinkedList.push(head2, 2);

		// Print List1
		System.out.println("List 1: ");
		intersectionLinkedList.printList(head1);

		// Print List2
		System.out.println("List 2: ");
		intersectionLinkedList.printList(head2);

		intersectHead = intersectionLinkedList.createIntersectList();
		
		System.out.println("Intersected List : ");
		intersectionLinkedList.printList(intersectHead);
	}

}
