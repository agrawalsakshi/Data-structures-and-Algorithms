


class Node{
	int data;
	Node next,child;
	
	Node(int data){
		this.data=data;
		next=child=null;
	}
}
public class MultiLevelFlattenList {
  static Node head;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiLevelFlattenList list = new MultiLevelFlattenList();
        head = list.createList();
        list.flattenList(head);
        list.printList(head);
	}
	
	public void printList(Node node){
		
		Node temp=node;
		
		while(temp!=null){
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
	
	
	public void flattenList(Node node){
		Node cur=node;
		Node tail = node;
		Node temp=null;
		while(tail.next!=null){
			tail=tail.next;
		}
		while(cur!=tail){
			
			if(cur.child!=null){
				tail.next=cur.child;
				temp=cur.child;
				while(temp.next!=null){
					temp=temp.next;
				}
				tail=temp;
			}
			cur=cur.next;
		}
	}
	
	
	
	
	public Node createList(int[] arr, int length){
		Node n;
		Node head=new Node(arr[0]);
		Node cur=head;
		for(int i=1;i<length;i++){
			n= new Node(arr[i]);
			cur.next=n;
			cur=n;
		}
		
		return head;
		
	}
	public Node  createList(){
		int arr1[] = new int[]{10, 5, 12, 7, 11};
        int arr2[] = new int[]{4, 20, 13};
        int arr3[] = new int[]{17, 6};
        int arr4[] = new int[]{9, 8};
        int arr5[] = new int[]{19, 15};
        int arr6[] = new int[]{2};
        int arr7[] = new int[]{16};
        int arr8[] = new int[]{3};
 
        /* create 8 linked lists */
        Node head1 = createList(arr1, arr1.length);
        Node head2 = createList(arr2, arr2.length);
        Node head3 = createList(arr3, arr3.length);
        Node head4 = createList(arr4, arr4.length);
        Node head5 = createList(arr5, arr5.length);
        Node head6 = createList(arr6, arr6.length);
        Node head7 = createList(arr7, arr7.length);
        Node head8 = createList(arr8, arr8.length);
 
        /* modify child pointers to create the list shown above */
        head1.child = head2;
        head1.next.next.next.child = head3;
        head3.child = head4;
        head4.child = head5;
        head2.next.child = head6;
        head2.next.next.child = head7;
        head7.child = head8;
 
        /* Return head pointer of first linked list.  Note that all nodes are
         reachable from head1 */
        return head1;
		
	}

}
