public class Main {
  public static void main(String[] args) {
    QuadraticProbing quadraticProbing = new QuadraticProbing(13);
    quadraticProbing.insert("The");
    quadraticProbing.insert("quick");
    quadraticProbing.insert("brown");
    quadraticProbing.insert("fox");
    quadraticProbing.insert("over");
    quadraticProbing.insert("lazy");
    quadraticProbing.display();
    quadraticProbing.search("fox");
    quadraticProbing.delete("fox");
    quadraticProbing.search("fox");
    quadraticProbing.display();
  }
}