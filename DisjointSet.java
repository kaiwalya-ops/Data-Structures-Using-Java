import java.util.ArrayList;
public class DisjointSet {

    private ArrayList<WeightedGraphNode> nodeList = new ArrayList<>();
    
    public static void makeSet(ArrayList<WeightedGraphNode> nodeList){
        for(WeightedGraphNode node: nodeList){
            DisjointSet set = new DisjointSet();
            set.nodeList.add(node);
            node.set = set;
        }
    }

    public static DisjointSet findSet(WeightedGraphNode node){
        return node.set;
    }

    public static DisjointSet union(WeightedGraphNode node1, WeightedGraphNode node2){
        if(node1.set.equals(node2.set)) return null;
        DisjointSet set1 = node1.set;
        DisjointSet set2 = node2.set;

        if(set1.nodeList.size() > set2.nodeList.size()){
            for (WeightedGraphNode node: set2.nodeList){
                node.set = set1;
                set1.nodeList.add(node);
            }
            return set1;
        }
        else for(WeightedGraphNode node: set1.nodeList){
            node.set = set2;
            set2.nodeList.add(node);
        }
        return set2;
    }
    
    public void print(){
        System.out.println("Printing all nodes of set : ");
        for(WeightedGraphNode node: this.nodeList){
            System.out.print(node+" ");
        }
        System.out.println();
    }

}
