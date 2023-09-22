public class Main {
  public static void main(String[] args) {
		SingleLinkedList sll = new SingleLinkedList();
		sll.create(5);
		sll.insert(6,1);
		sll.insert(7,3);
		sll.insert(8,3);
		sll.insert(9,0);
		sll.traverse();
		sll.search(8);
		sll.search(10);
		sll.delete(3);
		sll.traverse();
		sll.deleteSLL();
		sll.traverse();
  }
}