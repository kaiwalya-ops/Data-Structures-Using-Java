public class Main {
  public static void main(String[] args) {
		CircularDoubleLinkedList cdll = new CircularDoubleLinkedList();
		cdll.create(1);
		cdll.insert(2,0);
		cdll.insert(3,1);
		cdll.insert(4,10);
		cdll.insert(0,0);
		cdll.insert(0,4);
		cdll.insert(0,10);
		cdll.traverse();
		cdll.reverseTraverse();
		cdll.search(1);
		cdll.search(10);
		cdll.delete(10);
		cdll.traverse();
		cdll.delete(4);
		cdll.traverse();
		cdll.delete(0);
		cdll.traverse();
  }
}