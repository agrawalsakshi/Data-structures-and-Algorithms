package linkedList;

public class SplitAList {

	static NodeNew head;
	NodeNew head1;
	NodeNew head2;

	void push(char data) {

		NodeNew node = new NodeNew(data);
		node.next = head;
		head = node;

	}

	void printList(NodeNew node) {

		NodeNew start = node;

		while (start != null) {
			System.out.println("Node data :" + start.data);
			start = start.next;
		}
	}

	public void split() {
		NodeNew temp1 = head;
		// NodeNew temp2 = null;
		int count = 1;

		while (temp1 != null) {

			if (count % 2 > 0) {
				if (head1 == null) {
					head1 = new NodeNew(temp1.data);

				} else {
					NodeNew temp2 = head1;
					while (temp2.next != null) {
						temp2 = temp2.next;
					}
					temp2.next = new NodeNew(temp1.data);
					

				}
				temp1 = temp1.next;
				count++;
			} else {
				if (count % 2 == 0) {
					if (head2 == null) {
						head2 = new NodeNew (temp1.data);
						

					} else {
						NodeNew temp2 = head2;
						while (temp2.next != null) {
							temp2 = temp2.next;
						}
						temp2.next = new NodeNew(temp1.data);
						
					}
					temp1 = temp1.next;
					count++;
				}
			}
		}
		
		System.out.println("Printing list 1");
		printList(head1);
		
		System.out.println("Printing list 2");
		printList(head2);

	}

	public static void main(String[] args) {

		SplitAList splitAList = new SplitAList();
		splitAList.push('g');
		splitAList.push('f');
		splitAList.push('e');
		splitAList.push('d');

		splitAList.push('c');
		splitAList.push('b');
		splitAList.push('a');

		splitAList.printList(head);

		splitAList.split();

	}

}
