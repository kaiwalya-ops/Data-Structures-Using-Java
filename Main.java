public class Main {
  public static void main(String[] args) {
    QueueList queue = new QueueList();
    System.out.println(queue.isEmpty());
    queue.enQueue(10);
    queue.enQueue(20);
    queue.enQueue(30);
    System.out.println(queue.deQueue());
    System.out.println(queue.peek());
    System.out.println(queue.deQueue());
    System.out.println(queue.deQueue());
    System.out.println(queue.peek());
    queue.deleteQueue();
  }
}