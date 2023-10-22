public class Main {
  public static void main(String[] args) {
		QueueArray queue = new QueueArray(3);
		System.out.println(queue.isEmpty());
		queue.enQueue(1);
		queue.enQueue(2);
		queue.enQueue(3);
		queue.enQueue(4);
		queue.deleteQueue();
  }
}