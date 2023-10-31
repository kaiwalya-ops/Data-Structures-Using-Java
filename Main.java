public class Main {
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree(9);
    tree.insert("N1");
    tree.insert("N2");
    tree.insert("N3");
    tree.insert("N4");
    tree.insert("N5");
    tree.insert("N6");
    tree.insert("N7");
    tree.insert("N8");
    tree.insert("N9");
    tree.preOrder();
    tree.inOrder();
    tree.postOrder();
    tree.levelOrder();
    tree.delete("N5");
    tree.levelOrder();
    tree.deleteTree();
  }
}