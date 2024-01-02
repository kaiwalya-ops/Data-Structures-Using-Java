import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Prim graph = new Prim();
    graph.addNode("A");
    graph.addNode("B");
    graph.addNode("C");
    graph.addNode("D");
    graph.addNode("E");
    graph.addEdge(0, 1, 5);
    graph.addEdge(0, 2, 13);
    graph.addEdge(0, 4, 15);
    graph.addEdge(1, 2, 10);
    graph.addEdge(1, 3, 8);
    graph.addEdge(2, 3, 6);
    graph.addEdge(2, 4, 20);
    graph.primsAlgo(4);
  }
}