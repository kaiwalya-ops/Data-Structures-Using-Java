import java.util.ArrayList;
import java.util.LinkedList;

public class GraphAL{
    ArrayList<GraphNodeAL> nodeList = new ArrayList<>();
    
    public GraphAL(ArrayList<GraphNodeAL> nodeList){
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i, int j){
        nodeList.get(i).neighbors.add(nodeList.get(j));
        nodeList.get(j).neighbors.add(nodeList.get(i));
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        for (int i=0;i<nodeList.size();i++){
            s.append(nodeList.get(i).name + ":");
            for(GraphNodeAL j : nodeList.get(i).neighbors)
                s.append(" --> "+j.name);
            s.append("\n");
        }
        return s.toString();
        
    }

    private void bfsVisit(GraphNodeAL node){
        LinkedList<GraphNodeAL> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            GraphNodeAL curr = queue.remove(0);
            curr.isVisited = true;
            System.out.print(curr.name+" ");
            for(GraphNodeAL neighbor : curr.neighbors)
                if(!neighbor.isVisited){
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    public void bfs(){
        for(GraphNodeAL node: nodeList)
            if(!node.isVisited)
                bfsVisit(node);
        System.out.println();
    }
            
            // DFS internal
    private void dfsVisit(GraphNodeAL node){
        LinkedList<GraphNodeAL> stack = new LinkedList<>();
        stack.push(node);
        while(!stack.isEmpty()){
            GraphNodeAL curr = stack.pop();
            System.out.print(curr.name+" ");
            curr.isVisited = true;
            for(GraphNodeAL neighbor : curr.neighbors)
                if(!neighbor.isVisited){
                    stack.push(neighbor);
                    neighbor.isVisited = true;
                }
        }
    }
    public void dfs(){
        for(GraphNodeAL node: nodeList)
            if(!node.isVisited)
                dfsVisit(node);
        System.out.println();
    }
}
