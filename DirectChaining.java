import java.util.ArrayList;
import java.util.LinkedList;
public class DirectChaining {
    LinkedList<String>[] hashTable;
    int maxSize = 5;
    DirectChaining(int size){
        hashTable = new LinkedList[size];
    }

    private int modASCIIHashFunction(String word, int M){
        char ch[] = word.toCharArray();
        int i,sum;
        for(sum=0,i=0;i<word.length();i++){
            sum+=ch[i];
        }
        return sum%M;
    }

    public void insert(String word){
        int index = modASCIIHashFunction(word,hashTable.length);
        if(hashTable[index] == null){
            hashTable[index] = new LinkedList<>();
        }
        hashTable[index].add(word);
    }

    public void display(){
        if(hashTable == null){
            System.out.println("HashTable Does Not Exist");
            return;
        }
        System.out.println("-----------------------------HashTable-----------------------------");
        for(int i=0;i<hashTable.length;i++){
            System.out.println("Index : "+i+"\tKey: "+hashTable[i]);
        }
    }

    public boolean search(String word){
        int index = modASCIIHashFunction(word,hashTable.length);
        if(hashTable[index] != null && hashTable[index].contains(word)){
            System.out.println("\""+word+"\""+" is found at location "+index);
            return true;
        }
        System.out.println("\""+word+"\" is not found in hash table");
        return false;
    }

    public void delete(String word){
        int index = modASCIIHashFunction(word,hashTable.length);
        if(search(word) == true){
            hashTable[index].remove(word);
            System.out.println("\""+word+"\" has been deleted");
        }
    }
}
