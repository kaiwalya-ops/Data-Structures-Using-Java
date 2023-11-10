public class BinaryHeap {
    int arr[];
    int sizeOfHeap;
    String heapType;
    
    public BinaryHeap(int size,String heapType){
        arr = new int[size+1];
        sizeOfHeap = 0;
        this.heapType = heapType;
        System.out.println(heapType+" Heap has been created");
    }

    public boolean isEmpty(){
        return sizeOfHeap == 0;
    }

    public Integer peek(){
        if(isEmpty()){
            System.out.println("Heap is Empty");
            return null;
        }
        return arr[1];
    }

    public int size(){
        return sizeOfHeap;
    }

    public void preOrder(){
        preOrder(1);
        System.out.println();
    }
    private void preOrder(int index){
        if(index>sizeOfHeap) return;
        System.out.print(arr[index]+" ");
        preOrder(2*index);
        preOrder(2*index+1);
    }

    public void inOrder(){
        inOrder(1);
        System.out.println();
    }
    private void inOrder(int index){
        if(index>sizeOfHeap) return;
        inOrder(2*index);
        System.out.print(arr[index]+" ");
        inOrder(2*index+1);
    }

    public void postOrder(){
        postOrder(1);
        System.out.println();
    }
    private void postOrder(int index){
        if(index>sizeOfHeap) return;
        System.out.print(arr[index]+" ");
        postOrder(2*index);
        postOrder(2*index+1);
    }

    public void levelOrder(){
        for(int i=1;i<=sizeOfHeap;i++) System.out.print(arr[i]+" ");
        System.out.println();
    }

    private void heapifyBottomToTop(int index){
        int parent = index/2;
        if(index <= 1) return;
        if(heapType == "Min"){
            if(arr[index]<arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }
        else if(heapType == "Max"){
            if(arr[index]>arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }
        heapifyBottomToTop(parent);
    }

    public void insert(int value){
        if(sizeOfHeap+1==arr.length){
            System.out.println("The tree is full");
            return;
        }
        arr[sizeOfHeap+1] = value;
        sizeOfHeap++;
        heapifyBottomToTop(sizeOfHeap);
        System.out.println("Value has been inserted");
    }
    
    private void heapifyTopToBottom(int index){
        int left = index*2;
        int right = index*2+1;
        int swap=0;
        if(sizeOfHeap<left) return;
        if(this.heapType == "Max"){
            if(sizeOfHeap == left){
                if(arr[index]<arr[left]){
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }
            if(arr[left]>arr[right]) swap=left;
            else swap = right;
            if(arr[index]<arr[swap]){
                int temp = arr[index];
                arr[index] = arr[swap];
                arr[swap] = temp;
            }
        }
        else if(this.heapType == "Min"){
            if(sizeOfHeap == left){
                if(arr[index]>arr[left]){
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }
            if(arr[left]<arr[right]) swap=left;
            else swap = right;
            if(arr[index]>arr[swap]){
                int temp = arr[index];
                arr[index] = arr[swap];
                arr[swap] = temp;
            }
        }
        heapifyTopToBottom(swap);
    }

    public int extract(){
        if(isEmpty()) return -1;
        int result = arr[1];
        arr[1] = arr[sizeOfHeap];
        sizeOfHeap--;
        heapifyTopToBottom(1);
        return result;
    }

    public void deleteHeap(){
        arr = null;
        System.out.println("Heap is deleted");
    }
}
