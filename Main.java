public class Main {
  public static void main(String[] args) {
    BinaryTreeLL tree = new BinaryTreeLL();
    tree.insert("N1");
    tree.insert("N2");
    tree.insert("N3");
    tree.insert("N4");
    tree.insert("N5");
    tree.insert("N6");
    tree.levelOrder();
    tree.delete("N6");
    tree.levelOrder();
    tree.deleteTree();
  }
}