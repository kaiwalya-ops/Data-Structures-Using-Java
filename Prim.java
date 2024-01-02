import java.util.*;
public class Prim {
    ArrayList<WeightedGraphNode> nodeList = new ArrayList<>();

    public Prim(ArrayList<WeightedGraphNode> nodeList){
        this.nodeList = nodeList;
    }
    public Prim(){}

    public void addNode(String name){
        nodeList.add(new WeightedGraphNode(name));
    }

    public void addEdge(int i, int j, int weight){
        WeightedGraphNode first = nodeList.get(i);
        WeightedGraphNode second = nodeList.get(j);
        first.neighbors.add(second);
        second.neighbors.add(first);
        first.weightMap.put(second, weight);
        second.weightMap.put(first, weight);
    }

    public void primsAlgo(int nodeIndex){
        for(WeightedGraphNode i: nodeList) i.distance = Integer.MAX_VALUE;

        nodeList.get(nodeIndex).distance = 0;
        PriorityQueue<WeightedGraphNode> queue = new PriorityQueue<>();
        queue.addAll(nodeList);
        while(!queue.isEmpty()){
            WeightedGraphNode curr = queue.remove();
            for(WeightedGraphNode neighbor: curr.neighbors){
                if(queue.contains(neighbor)){
                    if(neighbor.distance > curr.weightMap.get(neighbor)){
                        neighbor.distance = curr.weightMap.get(neighbor);
                        neighbor.parent = curr;
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        int cost = 0;
        for(WeightedGraphNode node: nodeList){
            System.out.println("Node: "+node+", key: "+node.distance+", Parent: "+node.parent);
            cost += node.distance;
        }        
        System.out.println("Total cost: "+cost);
    }
}
