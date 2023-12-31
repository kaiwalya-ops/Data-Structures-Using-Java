import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<WeightedGraphNode> nodeList = new ArrayList<>();
    nodeList.add(new WeightedGraphNode("A"));
    nodeList.add(new WeightedGraphNode("B"));
    nodeList.add(new WeightedGraphNode("C"));
    nodeList.add(new WeightedGraphNode("D"));
    nodeList.add(new WeightedGraphNode("E"));
    nodeList.add(new WeightedGraphNode("F"));
    nodeList.add(new WeightedGraphNode("G"));
    WeightedGraph graph = new WeightedGraph(nodeList);
    graph.addWeightedDirectedEdge(0,1,2);
    graph.addWeightedDirectedEdge(0,2,5);
    graph.addWeightedDirectedEdge(1,2,6);
    graph.addWeightedDirectedEdge(1,3,1);
    graph.addWeightedDirectedEdge(1,4,3);
    graph.addWeightedDirectedEdge(2,5,8);
    graph.addWeightedDirectedEdge(3,4,4);
    graph.addWeightedDirectedEdge(4,6,9);
    graph.addWeightedDirectedEdge(5,6,7);

    System.out.println("Printing Dijkstra from source A");
    graph.dijkstra(nodeList.get(0));
    graph.bellmanFord(nodeList.get(0));
  }
}