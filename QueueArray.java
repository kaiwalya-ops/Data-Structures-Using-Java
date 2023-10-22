class QueueArray {
	int arr[];
	int topOfQueue;
	int beginningOfQueue;

	public QueueArray(int size) {
		this.arr = new int[size];
		this.topOfQueue = -1;
		this.beginningOfQueue = -1;
		System.out.println("The queue of size " + size + " is created");
	}

	public boolean isFull() {
		if (topOfQueue == arr.length - 1)
			return true;
		return false;
	}

	public boolean isEmpty() {
		if ((beginningOfQueue == -1) || (beginningOfQueue == arr.length))
			return true;
		return false;
	}

	public void enQueue(int value) {
		if (isFull())
			System.out.println("The queue is full");
		else if (isEmpty()) {
			beginningOfQueue = 0;
			topOfQueue++;
			arr[topOfQueue] = value;
			System.out.println("Successfully Inserted " + value + " in the Queue");
		} else {
			topOfQueue++;
			arr[topOfQueue] = value;
			System.out.println("Successfully Inserted " + value + " in the Queue");
		}
	}

	public int deQueue() {
		if (isEmpty()) {
			System.out.println("The queue is Empty");
			return -1;
		}
		int result = arr[beginningOfQueue];
		beginningOfQueue++;
		if (beginningOfQueue > topOfQueue)
			beginningOfQueue = topOfQueue = -1;
		return result;
	}

	public int peek() {
		if (!isEmpty())
			return arr[beginningOfQueue];
		System.out.println("The queue is Empty");
		return -1;
	}

	public void deleteQueue(){
		arr = null;
		System.out.println("The Queue is successfully deleted");
	}
}