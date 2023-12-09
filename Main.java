import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<GraphNodeAM> nodeList = new ArrayList<>();
    nodeList.add(new GraphNodeAM("A", 0));
    nodeList.add(new GraphNodeAM("B", 1));
    nodeList.add(new GraphNodeAM("C", 2));
    nodeList.add(new GraphNodeAM("D", 3));
    nodeList.add(new GraphNodeAM("E", 4));
    nodeList.add(new GraphNodeAM("F", 5));
    nodeList.add(new GraphNodeAM("G", 6));
    nodeList.add(new GraphNodeAM("H", 7));
    GraphAM graph = new GraphAM(nodeList);
    graph.addDirectedEdge(0,2);
    graph.addDirectedEdge(2,4);
    graph.addDirectedEdge(4,7);
    graph.addDirectedEdge(4,5);
    graph.addDirectedEdge(5,6);
    graph.addDirectedEdge(1,2);
    graph.addDirectedEdge(1,3);
    graph.addDirectedEdge(3,5);
    System.out.println(graph.toString()); 
    // graph.dfs();
    // graph.bfs();
    graph.topologicalSort();
  }
}