public class CircularDoubleLinkedList{
	DoubleNode head;
	DoubleNode tail;
	int size;

	public DoubleNode create(int value){
		DoubleNode node = new DoubleNode();
		node.value = value;
		node.next = node;
		node.prev = node;
		head = node;
		tail = node;
		size = 1;
		return head;
	}

	public void insert(int value,int location){
		if(size == 0){
			create(value);
			return;
		}
		DoubleNode node = new DoubleNode();
		node.value = value;
		if(location == 0){
			node.prev = head.prev;
			node.next = head;
			head.prev = node;
			head = node;
		}
		else if(location >= size){
			node.next = tail.next;
			node.prev = tail;
			tail.next = node;
			tail = node;
		}
		else{
			DoubleNode temp = head;
			for(int i=0;i<location-1;i++)
				temp = temp.next;
			node.prev = temp;
			node.next = temp.next;
			node.next.prev = node;
			temp.next = node;
		}
		size++;
	}

	public void traverse(){
		if(head == null){
			System.out.println("The Circular Double Linked List is Empty");
			return;
		}
		DoubleNode temp = head;
		for(int i=0;i<size;i++){
			System.out.print(temp.value);
			if(i != size-1)
				System.out.print(" --> ");
			temp = temp.next;
		}
		System.out.println();
	}

	public void reverseTraverse(){
		if(tail == null){
			System.out.println("The Circular Double Linked List is Empty");
			return;
		}
		DoubleNode temp = tail;
		for(int i=0;i<size;i++){
			System.out.print(temp.value);
			if(i != size-1)
				System.out.print(" --> ");
			temp = temp.prev;
		}
		System.out.println();
	}

	public boolean search(int value){
		if(head == null){
			System.out.println("The Circular Double Linked List is Empty");
			return false;
		}
		DoubleNode temp = head;
		for(int i=0;i<size;i++){
			if(temp.value == value){
				System.out.println("The Element is found at "+i);
				return true;
			}
			temp = temp.next;
		}
		System.out.println("Element is not Found");
		return false;
	}

	public void delete(int location){
		if(size == 0){
			System.out.println("The Circular Double Linked List is Empty");
			return;
		}
		if(size == 1){
			head.next = null;
			head.prev = null;
			head = null;
			tail = null;
			size = 0;
			return;
		}
		if(location == 0){
			head = head.next;
			tail.next = head;
			head.prev = tail;
		}
		else if(location >= size){
			tail = tail.prev;
			head.prev = tail;
			tail.next = head;
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

	public void deleteCDLL(){
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