public class Main {
  public static void main(String[] args) {
		CircularSingleLinkedList csll = new CircularSingleLinkedList();
		csll.create(5);
		csll.insert(6,1);
		csll.insert(7,3);
		csll.insert(8,3);
		csll.insert(9,0);
		csll.traverse();
		csll.search(8);
		csll.search(10);
		csll.delete(3);
		csll.traverse();
		csll.deleteCSLL();
		csll.traverse();
  }
}