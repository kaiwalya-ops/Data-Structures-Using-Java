public class Main {
  public static void main(String[] args) {
    BinaryTreeLL tree = new BinaryTreeLL();
    tree.insert(1);
    tree.insert(2);
    tree.insert(3);
    tree.insert(4);
    tree.insert(5);
    tree.insert(6);
    tree.insert(7);
    tree.insert(8);
    tree.insert(9);
    tree.preOrder();
    tree.inOrder();
    tree.postOrder();
    tree.levelOrder();
    tree.delete(5);
    tree.levelOrder();
    tree.deleteTree();
  }
}