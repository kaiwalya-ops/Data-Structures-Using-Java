public class Main {
  public static void main(String[] args) {
		DoubleLinkedList dll = new DoubleLinkedList();
		dll.create(1);
		dll.insert(2,0);
		dll.insert(3,1);
		dll.insert(4,10);
		dll.insert(0,0);
		dll.insert(0,4);
		dll.insert(0,10);
		dll.traverse();
		// dll.reverseTraverse();
		// dll.search(1);
		// dll.search(10);
		dll.delete(10);
		dll.traverse();
		dll.delete(4);
		dll.traverse();
		dll.delete(0);
		dll.traverse();
  }
}