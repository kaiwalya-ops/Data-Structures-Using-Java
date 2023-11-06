public class Main {
  public static void main(String[] args) {
    AVLTree tree = new AVLTree();
    tree.insert(5);
    tree.insert(10);
    tree.insert(15);
    tree.insert(20);
    tree.levelOrder();
    tree.delete(5);
    tree.levelOrder();
    tree.deleteAVL();
  }
}