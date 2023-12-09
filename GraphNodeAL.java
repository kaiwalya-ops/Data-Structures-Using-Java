import java.util.ArrayList;

public class GraphNodeAL {
    public String name;
    public int index;
    public boolean isVisited;

    public ArrayList<GraphNodeAL> neighbors;

    public GraphNodeAL(String name, int index){
        this.name = name;
        this.index = index;
        this.neighbors = new ArrayList<>();
        this.isVisited = false;
    }
}
