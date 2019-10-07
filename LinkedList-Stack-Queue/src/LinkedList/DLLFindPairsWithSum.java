package linkedList;

//https://www.geeksforgeeks.org/find-pairs-given-sum-doubly-linked-list/
public class DLLFindPairsWithSum {

	static NodeDLL head;

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

	public void findPairs(int sum) {

		NodeDLL j = null;
		NodeDLL temp = head;
		int count = 0;

		while (temp.next != null) {
			count++;
			temp = temp.next;

		}

		j = temp;

		for (NodeDLL i = head; i != temp; i = i.next) {
			j = temp;

			if (i.data + j.data > sum) {
				while (i.data + j.data > sum) {
					j = j.prev;
				}

			} else if (i.data + j.data < sum) {
				while (i.data + j.data < sum) {
					i = i.next;
				}
			}
			if (i.data + j.data == sum) {
				System.out.println("Pair : ( " + i.data + " ," + j.data + " )");

			}
		}

	}

	public static void main(String[] args) {
		DLLFindPairsWithSum dllFindPairsWithSum = new DLLFindPairsWithSum();

		dllFindPairsWithSum.push(9);
		dllFindPairsWithSum.push(8);
		dllFindPairsWithSum.push(6);
		dllFindPairsWithSum.push(5);
		dllFindPairsWithSum.push(4);
		dllFindPairsWithSum.push(2);
		dllFindPairsWithSum.push(1);

		dllFindPairsWithSum.printList();
		System.out.println("Printing pairs :");
		dllFindPairsWithSum.findPairs(10);
	}

}
