import java.util.ArrayList;
import java.util.LinkedList;

public class GraphAM {
    ArrayList<GraphNodeAM> nodeList = new ArrayList<>();
    int [][] adjMat;
    
    public GraphAM(ArrayList<GraphNodeAM> nodeList){
        this.nodeList = nodeList;
        adjMat = new int[nodeList.size()][nodeList.size()];
    }

    public void addUndirectedEdge(int i, int j){
        adjMat[i][j] = 1;
        adjMat[j][i] = 1;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("   ");
        for(int i=0; i<nodeList.size(); i++)
            s.append(nodeList.get(i).name + "  ");
        s.append("\n");
        for(int i=0; i<nodeList.size(); i++){
            s.append(nodeList.get(i).name + "  ");
            for(int j: adjMat[i])
                s.append((j) + "  ");
            s.append("\n");
        }
        return s.toString();
    }        

    // To Get Neigbours
    private ArrayList<GraphNodeAM> getNeighbors(GraphNodeAM node){
        ArrayList<GraphNodeAM> neighbors = new ArrayList<>();
        int nodeIndex = node.index;
        for(int i=0;i<adjMat.length;i++){
            if(adjMat[nodeIndex][i] == 1)
                neighbors.add(nodeList.get(i));
        }
        return neighbors;
    }
    // bfs internal
    private void bfsVisit(GraphNodeAM node){
        LinkedList<GraphNodeAM> queue = new LinkedList<GraphNodeAM>();
        queue.add(node);
        while(!queue.isEmpty()){
            GraphNodeAM curr = queue.remove(0);
            curr.isVisited = true;
            System.out.print(curr.name+" ");
            ArrayList<GraphNodeAM> neighbors = getNeighbors(curr);
            for(GraphNodeAM neighbor : neighbors){
                if(!neighbor.isVisited){
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }
    public void bfs(){
        for(GraphNodeAM node: nodeList)
            if(!node.isVisited)
                bfsVisit(node);
        System.out.println();
    }

    // DFS Internal
    private void dfsVisit(GraphNodeAM node){
        LinkedList<GraphNodeAM> stack = new LinkedList<>();
        stack.push(node);
        while(!stack.isEmpty()){
            GraphNodeAM curr = stack.pop();
            curr.isVisited = true;
            System.out.print(curr.name+" ");
            ArrayList<GraphNodeAM> neighbors = getNeighbors(curr);
            for(GraphNodeAM neighbor : neighbors){
                if(!neighbor.isVisited){
                    stack.push(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }
    public void dfs(){
        for(GraphNodeAM node: nodeList)
            if(!node.isVisited)
                dfsVisit(node);
        System.out.println();
    }
}
