import java.util.*;
public class WeightedGraph{
    ArrayList<WeightedGraphNode> nodeList = new ArrayList<>();

    public WeightedGraph(ArrayList<WeightedGraphNode> nodeList){
        this.nodeList = nodeList;
    }

    public void addWeightedDirectedEdge(int i, int j, int weight){
        nodeList.get(i).neighbors.add(nodeList.get(j));
        nodeList.get(i).weightMap.put(nodeList.get(j), weight);
    }

    public static void pathPrint(WeightedGraphNode curr){
        if(curr.parent != null)
            pathPrint(curr.parent);
        System.out.print(curr+" ");
    }

    void dijkstra(WeightedGraphNode node){
        PriorityQueue<WeightedGraphNode> queue = new PriorityQueue<>();
        node.distance = 0;
        queue.addAll(nodeList);
        while(!queue.isEmpty()){
            WeightedGraphNode curr = queue.remove();
            for(WeightedGraphNode neighbor: curr.neighbors){
                if(queue.contains(neighbor)){
                    if(neighbor.distance > curr.distance + curr.weightMap.get(neighbor)){
                        neighbor.distance = curr.distance + curr.weightMap.get(neighbor);
                        neighbor.parent = curr;
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        for(WeightedGraphNode curr: nodeList){
            System.out.print("Node: "+curr+", distance: "+curr.distance+" Path:");
            pathPrint(curr);
            System.out.println();
            curr.distance = Integer.MAX_VALUE;
        }
    }

    public void bellmanFord(WeightedGraphNode node){
        node.distance = 0;
        for(int i=0; i<nodeList.size();i++){
            for(WeightedGraphNode curr: nodeList){
                for(WeightedGraphNode neighbor: curr.neighbors){
                    if(neighbor.distance > curr.distance + curr.weightMap.get(neighbor)){
                        neighbor.parent = curr;
                        neighbor.distance = curr.distance + curr.weightMap.get(neighbor);
                    }
                }
            }
        }
        System.out.println("Checking for negative cycle");
        for(WeightedGraphNode curr: nodeList){
            for(WeightedGraphNode neighbor: curr.neighbors){
                if(neighbor.distance > curr.distance + curr.weightMap.get(neighbor)){
                    System.out.println("Negative Cycle Found!!\n");
                    return;
                }
            }
        }
        System.out.println("Negative Cycle not found");
        for(WeightedGraphNode curr: nodeList){
            System.out.print("Node: "+curr+", distance: "+curr.distance+" Path:");
            pathPrint(curr);
            System.out.println();
            curr.distance = Integer.MAX_VALUE;
        }
    }
}