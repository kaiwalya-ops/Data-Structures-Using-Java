public class CircularSingleLinkedList{
	public Node head;
	public Node tail;
	public int size;
	public Node create(int value){
		Node node = new Node();
		node.value = value;
		head = node;
		tail = node;
		node.next = node;
		size = 1;
		return head;
	}
	public void insert(int value, int location){
		Node node = new Node();
		node.value = value;
		if(head == null){
			create(value);
			return;
		}
		if(location  == 0){
			node.next = head;
			head = node;
			tail.next = node;
		}
		else if(location >= size){
			tail.next = node;
			node.next = head;
			tail = node;
		}
		else{
			Node temp = head;
			for(int i=0;i<location-1;i++)
				temp = temp.next;
			node.next = temp.next;
			temp.next = node;
		}
		size++;
	}
	public void traverse(){
		if(head != null){
			Node temp = head;
			for(int i=0;i<size;i++){
				System.out.print(temp.value);
				temp = temp.next;
				if(i!=size-1)
					System.out.print(" --> ");
			}
			System.out.println();
		}
		else{
			System.out.println("The CSLL is Empty");
		}
	}
	public boolean search(int value){
		if(head != null){
			Node temp = head;
			for(int i=0;i<size;i++){
				if(temp.value == value){
					System.out.println("The value is found at "+i);
					return true;
				}
				temp = temp.next;
			}
		}
		System.out.println("Node not found");
		return false;
	}
	public void delete(int location){
		if(head == null){
			System.out.println("The CSLL is Empty");
			return;
		}
		if(size == 1){
			head.next = null;
			head = null;
			tail = null;
			size = 0;
			return;
		}
		if(location == 0){
			head = head.next;
			tail.next = head;
		}
		else if(location >= size){
			Node temp = head;
			for(int i=0;i<size-1;i++)
				temp = temp.next;
			temp.next = head;
			tail = temp;
		}
		else{
			Node temp = head;
			for(int i=0;i<location-1;i++)
				temp = temp.next;
			temp.next = temp.next.next;
		}
		size--;
	}
	public void deleteCSLL(){
		if(head == null){
			System.out.println("The CSLL is already Empty");
			return;
		}
		head = null;
		tail.next = null;
		tail = null;
	}
}