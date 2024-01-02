import java.util.*;
public class Kruskal {
    ArrayList<WeightedGraphNode> nodeList = new ArrayList<>();
    ArrayList<UndirectedEdge> edgeList = new ArrayList<>();

    public Kruskal(ArrayList<WeightedGraphNode> nodeList){
        this.nodeList = nodeList;
    }
    public Kruskal(){}

    public void addNode(String name){
        nodeList.add(new WeightedGraphNode(name));
    }

    public void addEdge(int i, int j, int weight){
        WeightedGraphNode first = nodeList.get(i);
        WeightedGraphNode second = nodeList.get(j);
        edgeList.add(new UndirectedEdge(first, second, weight));
        first.neighbors.add(second);
        second.neighbors.add(first);
        first.weightMap.put(second, weight);
        second.weightMap.put(first, weight);
    }

    public void kruskalAlgo(){
        DisjointSet.makeSet(nodeList);

        Comparator<UndirectedEdge> comparator = new Comparator<>(){
            @Override
            public int compare(UndirectedEdge first, UndirectedEdge second){
                return first.weight - second.weight;
            }
        };

        Collections.sort(edgeList, comparator);
        int cost = 0;
        for(UndirectedEdge edge: edgeList){
            if(!DisjointSet.findSet(edge.first).equals(DisjointSet.findSet(edge.second))){
                DisjointSet.union(edge.first, edge.second);
                cost+=edge.weight;
                System.out.println("Taken: "+edge);
            }
        }

        System.out.println("Total Cost of MSP: "+cost);
    }
}
