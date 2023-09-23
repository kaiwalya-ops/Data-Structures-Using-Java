public class DoubleLinkedList{
	DoubleNode head;
	DoubleNode tail;
	int size;

	public DoubleNode create(int value){
		DoubleNode node = new DoubleNode();
		node.value = value;
		node.next = null;
		node.prev = null;
		head = node;
		tail = node;
		size = 1;
		return head;
	}

	public void insert(int value,int location){
		if(head == null){
			create(value);
			return;
		}
		DoubleNode node = new DoubleNode();
		node.value = value;
		if(location==0){
			node.prev = null;
			node.next = head;
			head.prev = node;
			head = node;
		}
		else if(location >= size){
			node.next = null;
			node.prev = tail;
			tail.next = node;
			tail = node;
		}
		else{
			DoubleNode temp = head;
			for(int i=0;i<location-1;i++)
				temp=temp.next;
			node.prev = temp;
			node.next = temp.next;
			temp.next = node;
			node.next.prev = node;
		}
		size++;
	}
	public void traverse(){
		if(head == null){
			System.out.println("The Double Linked List is Empty");
			return;
		}
		DoubleNode temp = head;
		while(temp != null){
			System.out.print(temp.value);
			if(temp.next != null)
				System.out.print(" --> ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void reverseTraverse(){
		if(tail == null){
			System.out.println("The Double Linked List is Empty");
			return;
		}
		DoubleNode temp = tail;
		while(temp != null){
			System.out.print(temp.value);
			if(temp.prev != null)
				System.out.print(" --> ");
			temp = temp.prev;
		}
		System.out.println();
	}

	public boolean search(int value){
		DoubleNode temp = head;
		for(int i=0;i<size;i++){
			if(temp.value == value){
				System.out.println("The Node is found at "+i);
				return true;
			}
			temp = temp.next;
		}
		System.out.println("The Node is not found");
		return false;
	}

	public void delete(int location){
		if(head == null){
			System.out.println("The Double Linked List is Empty");
			return;
		}
		if(size == 1){
			head = null;
			tail = null;
			size = 0;
			return;
		}
		if(location == 0){
			head = head.next;
			head.prev = null;
		}
		else if(location >= size){
			tail = tail.prev;
			tail.next = null;
		}
		else{
			DoubleNode temp = head;
			for(int i=0;i<location-1;i++)
				temp = temp.next;
			temp.next.next.prev = temp;
			temp.next = temp.next.next;
		}
		size--;
	}

	public void deleteDLL(){
		DoubleNode temp = head;
		while(temp != tail){
			tail.prev = null;
			tail = tail.next;
		}
		head.next = null;
		head = null;
		tail = null;
		size = 0;
	}
}