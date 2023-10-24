public class QueueList {
    SingleLinkedList list;
    
    public QueueList(){
        list = new SingleLinkedList();
        System.out.println("A Queue is created!");
    }

    public boolean isEmpty(){
        return list.head==null?true:false;
    }

    public void enQueue(int value){
        list.insert(value,list.size);
        System.out.println("Successfully inserted "+value);
    }

    public int deQueue(){
        int value=-1;
        if(isEmpty())
            System.out.println("The Queue is Empty");
        else{
            value = list.head.value;
            list.delete(0);
        }
        return value;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("The Queue is Empty");
            return -1;
        }
        return list.head.value;
    }

    public void deleteQueue(){
        list.deleteSLL();
    }
}
