public class Main {
  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("Api");
    trie.insert("Apis");
    trie.search("Api");
    trie.delete("Api");
    trie.search("Api");
  }
}