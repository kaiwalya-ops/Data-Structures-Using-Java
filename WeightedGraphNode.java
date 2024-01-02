import java.util.*;
public class WeightedGraphNode implements Comparable<WeightedGraphNode>{
    public static int length = 0;
    public String name;
    public ArrayList<WeightedGraphNode> neighbors = new ArrayList<>();
    public HashMap<WeightedGraphNode, Integer> weightMap = new HashMap<>();
    public boolean isVisited = false;
    public WeightedGraphNode parent;
    public int distance;
    public int index;
    public DisjointSet set;

    public WeightedGraphNode(String name){
        this.name = name;
        distance = Integer.MAX_VALUE;
        this.index = length;
        length++;
    }

    @Override
    public String toString(){
        return name;
    }

    @Override
    public int compareTo(WeightedGraphNode o){
        return this.distance-o.distance;
    }
}
