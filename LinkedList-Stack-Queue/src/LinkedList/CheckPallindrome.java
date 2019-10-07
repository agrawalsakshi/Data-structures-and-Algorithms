package linkedList;

public class CheckPallindrome {

	NodeNew head;

	void push(char data) {

		NodeNew node = new NodeNew(data);
		node.next = head;
		head = node;

	}

	void printList() {

		NodeNew node = head;

		while (node != null) {
			System.out.println("Node data :" + node.data);
			node = node.next;
		}
	}

	public void checkPallindrome() {
		StringBuilder sb = new StringBuilder();

		NodeNew node = head;

		while (node != null) {
			sb.append(node.data);
			node = node.next;
		}

		System.out.println(checkPallindrome(sb.toString()));
	}

	boolean checkPallindrome(String str) {

		char[] charArr = str.toLowerCase().toCharArray();

		int i = 0, j = charArr.length - 1;

		while (i < j) {
			if (charArr[i] == charArr[j]) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		CheckPallindrome checkpallindrome = new CheckPallindrome();
		checkpallindrome.push('A');
		checkpallindrome.push('B');
		checkpallindrome.push('C');
		checkpallindrome.push('B');
		checkpallindrome.push('A');

		checkpallindrome.printList();

		checkpallindrome.checkPallindrome();

	}

}

class NodeNew {
	char data;
	NodeNew next;

	NodeNew(char data) {
		this.data = data;
		next = null;
	}
}
