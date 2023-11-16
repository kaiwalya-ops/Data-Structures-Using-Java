public class Main {
  public static void main(String[] args) {
    LinearProbing linearProbing = new LinearProbing(13);
    linearProbing.insert("The");
    linearProbing.insert("quick");
    linearProbing.insert("brown");
    linearProbing.insert("fox");
    linearProbing.insert("over");
    linearProbing.display();
    linearProbing.search("fox");
    linearProbing.delete("fox");
    linearProbing.search("fox");
    linearProbing.display();
  }
}