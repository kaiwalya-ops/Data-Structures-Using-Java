public class Main {
  public static void main(String[] args) {
    DirectChaining directChaining = new DirectChaining(13);
    directChaining.insert("The");
    directChaining.insert("quick");
    directChaining.insert("brown");
    directChaining.insert("fox");
    directChaining.insert("over");
    directChaining.display();
    directChaining.search("fox");
    directChaining.delete("fox");
    directChaining.search("fox");
    directChaining.display();
  }
}