public class Main {
  public static void main(String[] args) {
    BinaryHeap tree = new BinaryHeap(5,"Min");
    tree.peek();
    tree.insert(10);
    tree.insert(5);
    tree.insert(15);
    tree.insert(1);
    tree.insert(20);
    tree.insert(21);
    tree.preOrder();
    tree.inOrder();
    tree.postOrder();
    tree.levelOrder();
    System.out.println(tree.extract());
    tree.levelOrder();
    tree.deleteHeap();
  }
}