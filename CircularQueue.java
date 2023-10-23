public class CircularQueue {
    int arr[];
    int topOfQueue;
    int beginningOfQueue;
    int size;

    public CircularQueue(int size){
        this.arr = new int[size];
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        this.size = size;
        System.out.println("The Circular Queue is created with size of "+size);
    }

    public boolean isEmpty(){
        if(topOfQueue == -1 )
            return true;
        return false;
    }

    public boolean isFull(){
        if(topOfQueue+1 == beginningOfQueue)
            return true;
        else if(beginningOfQueue == 0 && topOfQueue == size-1)
            return true;
        return false;
    }

    public void enQueue(int value){
        if(isFull())
            System.out.println("The Circular Queue is Full");
        else if(isEmpty()){
            this.arr[0] = value;
            this.beginningOfQueue = 0;
            this.topOfQueue++;
            System.out.println("Successfully inserted "+value);
        }
        else{
            if(topOfQueue == size-1 )
            topOfQueue = 0;
            else
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println("Successfully inserted "+value);
        }
    }

    public int deQueue(){
        if(isEmpty()){
            System.out.println("The Circular Queue is Empty");
            return -1;
        }
        int res = arr[beginningOfQueue];
        arr[beginningOfQueue] = 0;
        if(beginningOfQueue == topOfQueue)
            beginningOfQueue = topOfQueue = -1;
        else if(beginningOfQueue == size-1)
            beginningOfQueue = 0;
        else 
            beginningOfQueue++;
        return res;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("The Circular Queue is Empty");
            return -1;
        }
        return arr[beginningOfQueue];
    }

    public int deleteQueue(){
        arr = null;
        System.out.println("The Queue is deleted");
    }
}
