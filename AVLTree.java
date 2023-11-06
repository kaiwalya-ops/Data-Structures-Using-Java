import java.util.LinkedList;
import java.util.Queue;
public class AVLTree {
    BinaryNode root;

    AVLTree(){
        root=null;
    }
    
    public void preOrder(){
        preOrder(root);
        System.out.println();
    }
    private void preOrder(BinaryNode node){
        if(node == null)
            return;
        System.out.print(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
        System.out.println();
    }
    private void inOrder(BinaryNode node){
        if(node == null)
            return;
        inOrder(node.left);
        System.out.print(node.value+" ");
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(root);
        System.out.println();
    }
    private void postOrder(BinaryNode node){
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+" ");
    }

    public void levelOrder(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode curr = queue.remove();
            System.out.print(curr.value+" ");
            if(curr.left != null)
                queue.add(curr.left);
            if(curr.right != null)
                queue.add(curr.right);
        }
        System.out.println();
    }

    public BinaryNode search(int value){
        return search(root,value);
    }
    private BinaryNode search(BinaryNode node,int value){
        if(node == null){
            System.out.println("Value is not found in the tree");
            return null;
        }
        if(node.value == value){
            System.out.println("Value is present in the tree");
            return node;
        }
        if(value<=node.value)
            return search(node.left,value);
        return search(node.right,value);
    }

    public int getHeight(){
        return getHeight(root);
    }
    public int getHeight(BinaryNode node){
        if(node == null) return 0;
        return node.height;
    }

    private BinaryNode rotateRight(BinaryNode disbalancedNode){
        BinaryNode node = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        node.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left),getHeight(disbalancedNode.right));
        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));
        return node;
    }
    
    private BinaryNode rotateLeft(BinaryNode disbalancedNode){
        BinaryNode node = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        node.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left),getHeight(disbalancedNode.right));
        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));
        return node;
    }

    public int getBalance(){
        return getBalance(root);
    }
    public int getBalance(BinaryNode node){
        if(node == null) return 0;
        return (getHeight(node.left) - getHeight(node.right));
    }

    public void insert(int value){
        root = insert(root,value);
    }
    private BinaryNode insert(BinaryNode node,int value){
        if(node == null) return new BinaryNode(value);
        else if(value <= node.value) node.left = insert(node.left,value);
        else node.right = insert(node.right,value);
        node.height = 1 + Math.max(getHeight(node.left),getHeight(node.right));
        // LL Method
        if(getBalance(node)>1 && value <= node.left.value)  return rotateRight(node);
        // LR Method
        if(getBalance(node)>1){
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        // RR Method
        if(getBalance(node)<-1 && value>node.right.value) return rotateLeft(node);
        // RL Method
        if(getBalance(node)<-1){
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public static BinaryNode minimumNode(BinaryNode node){
        if(node.left == null) return node;
        return minimumNode(node.left);
    }
    
    public void delete(int value){
        root = delete(root,value);
    }
    private BinaryNode delete(BinaryNode node,int value){
        if(node == null){
            System.out.println("The value is not found in the AVL tree");
            return node;
        }
        if(value < node.value) node.left = delete(node.left,value);
        else if(value > node.value) node.right = delete(node.right,value);
        else{
            if(node.left != null && node.right != null){
                BinaryNode temp = node;
                BinaryNode min = minimumNode(temp.right);
                node.value = min.value;
                node.right = delete(node.right,node.value);
            }
            else if(node.left != null) node = node.left;
            else if(node.right != null) node = node.right;
            else node = null;
        }
        // LL Method
        if(getBalance(node)>1 && getBalance(node.left)>=0)  return rotateRight(node);
        // LR Method
        if(getBalance(node)>1){
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        // RR Method
        if(getBalance(node)<-1 && getBalance(node.right)<=0) return rotateLeft(node);
        // RL Method
        if(getBalance(node)<-1){
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    public void deleteAVL(){
        this.root = null;
        System.out.println("The tree has been deleted");
    }
}
