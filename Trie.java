public class Trie {
    private TrieNode root;

    public Trie(){
        root = new TrieNode();
        System.out.println("Trie has been created");
    }

    public void insert(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = curr.children.get(c);
            if(node == null){
                node = new TrieNode();
                curr.children.put(c,node);
            }
            curr = node;
        }
        curr.endOfString = true;
        System.out.println(word+" has been successfully inserted");
    }

    public boolean search(String word){
        TrieNode curr = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = curr.children.get(c);
            if(node == null){
                System.out.println("The word does not exist in the Trie");
                return false;
            }
            curr = node;
        }
        if(curr.endOfString == true){
            System.out.println("The word exists in the Trie");
            return true;
        }
        System.out.println("The word does not exist in the Trie but is a substring of another string");
        return false;
    }

    public void delete(String word){
        if(search(word) == true)
            delete(root,word,0);
    }
    private boolean delete(TrieNode parent, String word, int index){
        char c = word.charAt(index);
        TrieNode curr = parent.children.get(c);
        boolean canBeDeleted;

        if(curr.children.size()>1){
            delete(curr,word,index+1);
            return false;
        }
        if(index == word.length()-1){
            if(curr.children.size()>=1){
                curr.endOfString = false;
                return false;
            }
            else{
                parent.children.remove(c);
                return true;
            }
        }
        if(curr.endOfString == true){
            delete(curr,word,index+1);
            return false;
        }
        canBeDeleted = delete(curr,word,index+1);
        if(canBeDeleted == true){
            parent.children.remove(c);
            return true;
        }
        else return false;
    }
}
