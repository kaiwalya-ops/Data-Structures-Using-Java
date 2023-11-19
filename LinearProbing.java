import java.util.ArrayList;
public class LinearProbing {
    String[] hashTable;
    int userCellNumber;

    LinearProbing(int size){
        hashTable = new String[size];
        userCellNumber = 0;
    }

    private int modASCIIHashFunction(String word, int M){
        char ch[] = word.toCharArray();
        int i,sum;
        for(sum=0,i=0;i<word.length();i++){
            sum+=ch[i];
        }
        return sum%M;
    }

    private double getLoadFactor(){
        double loadFactor = userCellNumber * 1.0 / hashTable.length;
        return loadFactor;
    }

    // Rehash
    public void rehash(String word){
        ArrayList<String> data = new ArrayList<>();
        for (String s: hashTable)
            if(s != null) data.add(s);
        data.add(word);
        hashTable = new String[hashTable.length * 2];
        userCellNumber = 0;
        for (String s: data){
            insert(s);
        }
    }

    public void insert(String word){
        double loadFactor = getLoadFactor();
        if(loadFactor >= 0.75) {
            rehash(word);
            return;
        }
        int startIndex = modASCIIHashFunction(word,hashTable.length);
        for(int i=startIndex;i<startIndex+hashTable.length;i++){
            int index = i % hashTable.length;
            if(hashTable[index] == null) {
                hashTable[index] = word;
                System.out.println("The word "+word+" is successfully inserted");
                break;
            }
            System.out.println(index+" is already occupied. Looking for next empty cell");
        }
        userCellNumber++;
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
        int startIndex = modASCIIHashFunction(word,hashTable.length);
        for(int i=startIndex;i<startIndex+hashTable.length;i++){
            int index = i % hashTable.length;
            if(word.equals(hashTable[index])){
                System.out.println("The word "+word+" is found at "+index);
                return true;
            }
        }
        System.out.println("The word "+word+" is not found");
        return false;
    }
    
    public void delete(String word){
        int startIndex = modASCIIHashFunction(word,hashTable.length);
        for(int i=startIndex;i<startIndex+hashTable.length;i++){
            int index = i % hashTable.length;
            if(word.equals(hashTable[index])) {
                hashTable[index] = null;
                System.out.println("The word "+word+" has been deleted");
                userCellNumber--;
                return;
            }
        }
        System.out.println("The word "+word+" is not found");
    }
}
