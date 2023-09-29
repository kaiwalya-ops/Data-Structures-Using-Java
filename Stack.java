public class Stack{
	SingleLinkedList ll;
	public Stack(){
		this.ll = new SingleLinkedList();
		System.out.println("A new Stack is created");
	}

	public boolean isEmpty(){
		if(ll.head == null)
			return true;
		return false;
	}

	public void push(int value){
		ll.insert(value,0);
		System.out.println(value+" is pushed in the stack");
	}

	public int pop(){
		if(isEmpty()){
			System.out.println("The Stack is Empty");
			return -1;
		}
		int temp = ll.head.value;
		ll.delete(0);
		return temp;
	}

	public int peek(){
		if(isEmpty()){
			System.out.println("The Stack is Empty");
			return -1;
		}
		return ll.head.value;
	}

	public void deleteStack(){
		ll.deleteSLL();
		System.out.println("The Stack is Deleted");
	}
}