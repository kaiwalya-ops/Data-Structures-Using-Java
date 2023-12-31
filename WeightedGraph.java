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

    // Floyd Warshall Algo for All pair Shortest path problem
    public void floydWarshall(){
        int size = this.nodeList.size();
        int[][] V = new int[size][size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(i==j) V[i][j] = 0;
                else if (nodeList.get(i).weightMap.containsKey(nodeList.get(j)))
                    V[i][j] = nodeList.get(i).weightMap.get(nodeList.get(j));
                else V[i][j] = Integer.MAX_VALUE / 10;
            }
        }

        for(int k=0; k<size; k++) for(int i=0; i<size; i++) for(int j=0; j<size; j++)
            if( V[i][j] > V[i][k] + V[k][j] ) V[i][j] = V[i][k] + V[k][j];
        
        for(int i=0; i<size; i++){
            System.out.print("Printing distance list for the node : "+nodeList.get(i)+" :");
            for(int j=0;j<size;j++)
                System.out.print(" "+V[i][j]);
            System.out.println();
        }
    }
}