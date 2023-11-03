import java.util.LinkedList;
import java.util.Queue;
public class BinaryTreeLL {
    BinaryNode root;
    public BinaryTreeLL(){
        this.root = null;
    }

    public void preOrder(){
        preOrder(this.root);
        System.out.println();
    }
    private void preOrder(BinaryNode node){
        if(node == null) return;
        System.out.print(node.value+" ");
        preOrder(node.left);
        preOrder(node.right);   
    }

    public void inOrder(){
        inOrder(this.root);
        System.out.println();
    }
    private void inOrder(BinaryNode node){
        if(node == null) return;
        inOrder(node.left);
        System.out.print(node.value+" ");
        inOrder(node.right);
    }

    public void postOrder(){
        postOrder(this.root);
        System.out.println();
    }
    private void postOrder(BinaryNode node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+" ");
    }

    public void levelOrder(){
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
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
    
    public void search(int value){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode curr = queue.remove();
            if(curr.value == value){
                System.out.println("The element is found");
                return;
            }
            if(curr.left != null)
                queue.add(curr.left);
            if(curr.right != null)
            queue.add(curr.right);
        }
        System.out.println("The element is not found");
    }

    public void insert(int value){
        BinaryNode node = new BinaryNode(value);
        if(root == null){
            root = node;
            System.out.println("New node is inserted");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode curr = queue.remove();
            if(curr.left == null){
                curr.left = node;
                System.out.println("New node is inserted");
                return;
            }
            if(curr.right == null){
                curr.right = node;
                System.out.println("New node is inserted");
                return;
            }
            queue.add(curr.left);
            queue.add(curr.right);
        }
    }

    private BinaryNode getDeleteDeepestNode(){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        BinaryNode ans,curr = null;
        while(!queue.isEmpty()){
            curr = queue.remove();
            if(curr.left != null)
                queue.add(curr.left);
            if(curr.right != null)
            queue.add(curr.right);
        }
        ans = curr;
        queue.add(root);
        while(!queue.isEmpty()){
            curr = queue.remove();
            if(curr.left == ans){
                curr.left = null;
                break;
            }
            if(curr.right == ans){
                curr.right = null;
                break;
            }
            if(curr.left != null)
                queue.add(curr.left);
            if(curr.right != null)
                queue.add(curr.right);
        }
        return ans;
    }

    public void delete(int value){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryNode curr = queue.remove();
            if(curr.value == value){
                curr.value = getDeleteDeepestNode().value;
                System.out.println("The node is deleted");
                return;
            }
            if(curr.left != null)
                queue.add(curr.left);
            if(curr.right != null)
                queue.add(curr.right);
        }
        System.out.println("The node doesn't exist in the Binary Tree");
    }

    public void deleteTree(){
        root = null;
        System.out.println("The Tree is deleted");
    }
}