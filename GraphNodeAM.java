public class GraphNodeAM {
    public String name;
    public int index;
    boolean isVisited;

    public GraphNodeAM(String name, int index){
        this.name = name;
        this.index = index;
        this.isVisited = false;
    }
}