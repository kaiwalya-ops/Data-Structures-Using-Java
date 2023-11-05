import java.util.LinkedList;
import java.util.Queue;
public class BinarySearchTree {
    BinaryNode root;

    BinarySearchTree(){
        root=null;
    }
    
    public void insert(int value){
        root = insert(root,value);
    }
    private BinaryNode insert(BinaryNode curr, int value){
        if(curr == null){
            BinaryNode node = new BinaryNode(value);
            System.out.println("The value is successfully inserted");
            return node;
        }
        else if(value <= curr.value)
            curr.left = insert(curr.left,value);
        else
            curr.right = insert(curr.right,value);
        return curr;
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

    private static BinaryNode minimumNode(BinaryNode root){
        if(root.left == null)
            return root;
        return minimumNode(root.left);
    }

    public BinaryNode delete(int value){
        return delete(root,value);
    }
    private BinaryNode delete(BinaryNode root,int value){
        if(root == null){
            System.out.println("Value is not found in the BST");
            return null;
        }
        if(value < root.value)
            root.left = delete(root.left,value);
        else if(value > root.value)
            root.right = delete(root.right,value);
        else{
            if(root.left != null && root.right != null){
                BinaryNode temp = root;
                BinaryNode minNode = minimumNode(temp.right);
                root.value = minNode.value;
                root.right = delete(root.right,root.value);
            }
            else if(root.left!=null) root = root.left;
            else if(root.right!=null) root = root.right;
            else root=null;
        }
        return root;
    }

    public void deleteBST(){
        this.root = null;
        System.out.println("The tree has been deleted");
    }
}
