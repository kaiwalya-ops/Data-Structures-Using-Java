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
    GraphAM graph = new GraphAM(nodeList);
    graph.addUndirectedEdge(0, 1);
    graph.addUndirectedEdge(0, 2);
    graph.addUndirectedEdge(1, 3);
    graph.addUndirectedEdge(1, 6);
    graph.addUndirectedEdge(2, 3);
    graph.addUndirectedEdge(2, 4);
    graph.addUndirectedEdge(3, 5);
    graph.addUndirectedEdge(4, 5);
    graph.addUndirectedEdge(5, 6);
    System.out.println(graph.toString()); 
    graph.dfs();
    graph.bfs();
    //Only for directed edges
    // graph.topologicalSort(); 
    graph.BFSforSSSP(nodeList.get(0));
  }
}