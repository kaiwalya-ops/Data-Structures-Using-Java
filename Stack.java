public class Stack{
	int arr[];
	int topOfStack;
	public Stack(int size){
		this.arr = new int[size];
		this.topOfStack = -1;
		System.out.println("A new Stack of size "+size+" is created");
	}

		public boolean isEmpty(){
		if(topOfStack == -1)
			return true;
		return false;
	}
	
	public boolean isFull(){
		if(topOfStack == arr.length-1)
			return true;
		return false;
	}

	public void push(int value){
		if(isFull())
			System.out.println("The Stack is Full");
		else
			arr[++topOfStack] = value;
	}

	public int pop(){
		if(isEmpty()){
			System.out.println("The Stack is Empty");
			return -1;
		}
		return arr[topOfStack--];
	}

	public int peek(){
		if(isEmpty()){
			System.out.println("The Stack is Empty");
			return -1;
		}
		return arr[topOfStack];
	}

	public void deleteStack(){
		arr = null;
		topOfStack = -1;
		System.out.println("The Stack is deleted");
	}
}