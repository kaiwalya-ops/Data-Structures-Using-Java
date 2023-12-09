import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<GraphNodeAM> nodeList = new ArrayList<>();
    nodeList.add(new GraphNodeAM("A", 0));
    nodeList.add(new GraphNodeAM("B", 1));
    nodeList.add(new GraphNodeAM("C", 2));
    nodeList.add(new GraphNodeAM("D", 3));
    nodeList.add(new GraphNodeAM("E", 4));
    GraphAM graph = new GraphAM(nodeList);
    graph.addUndirectedEdge(0,1);
    graph.addUndirectedEdge(0,2);
    graph.addUndirectedEdge(0,3);
    graph.addUndirectedEdge(1,4);
    graph.addUndirectedEdge(2,3);
    graph.addUndirectedEdge(4,3);
    System.out.println(graph.toString());
    graph.dfs();
    // graph.bfs();
  }
}