public class BinaryTree {
    String[] arr;
    int lastUsedIndex;

    public BinaryTree(int size){
        arr = new String[size+1];
        this.lastUsedIndex = 0;
        System.out.println("Tree has been created of size "+size);
    }

    public boolean isFull(){
        if(arr.length == lastUsedIndex+1) return true;
        return false;
    }

    public void insert(String value){
        if(!isFull()){
            arr[lastUsedIndex+1] = value;
            lastUsedIndex++;
            System.out.println("The element has been inserted");
            return;
        }
        System.out.println("The Tree is full");
    }

    public void preOrder(){
        preOrder(1);
        System.out.println();
    }
    private void preOrder(int index){
        if(index>lastUsedIndex) return;
        System.out.print(arr[index]+" ");
        preOrder(2*index);
        preOrder(2*index+1);
    }

    public void inOrder(){
        inOrder(1);
        System.out.println();
    }
    private void inOrder(int index){
        if(index>lastUsedIndex) return;
        inOrder(2*index);
        System.out.print(arr[index]+" ");
        inOrder(2*index+1);
    }

    public void postOrder(){
        postOrder(1);
        System.out.println();
    }
    private void postOrder(int index){
        if(index>lastUsedIndex) return;
        postOrder(2*index);
        postOrder(2*index+1);
        System.out.print(arr[index]+" ");
    }

    public void levelOrder(){
        for(int i=1;i<=lastUsedIndex;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    public int search(String value){
        for(int i=1;i<=lastUsedIndex;i++)
            if(arr[i]==value){
                System.out.println("Value exists at "+i);
                return i;
            }
        System.out.println("The value doesn't exist in the tree");
        return -1;
    }

    public void delete(String value){
        int index = search(value);
        if(index == -1)
            return;
        arr[index] = arr[lastUsedIndex];
        lastUsedIndex--;
        System.out.println("The node has successfully been deleted");
    }

    public void deleteTree(){
        try{
            arr = null;
            System.out.println("Successfully Deleted Array");
        }
        catch(Exception e){
            System.out.println("Error Occured!");
        }
    }
}
