public class SingleLinkedList{
	public Node head;
	public Node tail;
	public int size;

	public Node create(int nodeValue){
		Node node = new Node();
		node.next = null;
		node.value = nodeValue;
		head = node;
		tail = node;
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
		else if(location == 0){
			node.next = head;
			head = node;
		}
		else if(location >= size){
			node.next = null;
			tail.next = node;
			tail = node;
		}
		else{
			Node temp = head;
			int index = 0;
			while(index < location-1){
				temp = temp.next;
				index++;
			}
			Node nextNode = temp.next;
			temp.next = node;
			node = nextNode;
		}
		size++;
	}

	public void traverse(){
		if(head == null)
			System.out.println("SLL has no elements");
		else{
			Node temp = head;
			for(int i=0;i<size;i++){
				System.out.print(temp.value);
				if(i!=size-1)
					System.out.print(" --> ");
				temp=temp.next;
			}
		}
		System.out.println("\n");
	}

	public boolean search(int value){
		if(head!=null){
			Node temp = head;
			for(int i=0;i<size;i++){
				if(temp.value == value){
					System.out.println("Found the node at locaition : "+i);
					return true;
				}
				temp = temp.next;
			}
			System.out.println("Node isn't in the list");
		}
		else
			System.out.println("The list is emplty");
		return false;
	}

	public void delete(int location){
		if(head == null){
			System.out.println("The List is Emplty");
			return;
		}
		if(location == 0){
			head = head.next;
			size--;
			if(size ==0)
				tail = null;
		}
		else if(location >= size){
			Node temp = head;
			for(int i=0;i<size-1;i++)
				temp = temp.next;
			if(temp == head){
				tail = head = null;
				size--;
				return;
			}
			temp.next = null;
			tail = temp;
			size--;
		}
		else{
			Node temp = head;
			for(int i=0;i<location-1;i++)
				temp = temp.next;
			temp.next = temp.next.next;
			size--;
		}
	}
	public void deleteSLL(){
		head = null;
		tail = null;
		System.out.println("SLL Deleted Successfully");
	}
}