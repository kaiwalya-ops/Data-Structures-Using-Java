public class BinaryNode {
    public int value;
    public BinaryNode left;
    public BinaryNode right;
    public int height;
    public BinaryNode(){
        this.left = null;
        this.right = null;
        this.height = 0;
    }
    public BinaryNode(int value){
        this.value=value;
        this.left = null;
        this.right = null;
        this.height = 1;
    }
}
