import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<WeightedGraphNode> nodeList = new ArrayList<>();
    nodeList.add(new WeightedGraphNode("A"));
    nodeList.add(new WeightedGraphNode("B"));
    nodeList.add(new WeightedGraphNode("C"));
    nodeList.add(new WeightedGraphNode("D"));
    WeightedGraph graph = new WeightedGraph(nodeList);
    graph.addWeightedDirectedEdge(0, 1, 8);
    graph.addWeightedDirectedEdge(0, 3, 1);
    graph.addWeightedDirectedEdge(1, 2, 1);
    graph.addWeightedDirectedEdge(2, 0, 4);
    graph.addWeightedDirectedEdge(3, 1, 2);
    graph.addWeightedDirectedEdge(3, 2, 9);

    graph.floydWarshall();
  }
}