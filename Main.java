public class Main {
  public static void main(String[] args) {
		CircularQueue queue = new CircularQueue(3);
    System.out.println(queue.isFull());
    queue.enQueue(10);
    queue.enQueue(20);
    queue.enQueue(30);
    queue.enQueue(40);
    System.out.println(queue.peek());
    System.out.println(queue.deQueue());
    System.out.println(queue.deQueue());
    System.out.println(queue.deQueue());
    System.out.println(queue.deQueue());
  }
}