import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {
    private Node root;
    
    public BinaryTree() {
        this.root = null;
    }
    
    public BinaryTree(Node raiz) {
        this.root = raiz;
    }
      
    public Node getRaiz() {
        return root;
    }
    public void setRaiz(Node raiz) {
        this.root = raiz;
    }
          
    public boolean isEmpty(){
        return root == null;
    }
    
    public int getDegree() {
       if(root.getLeft() == null && root.getRight() == null){
            return 0;
        }
        if( root.getLeft() != null && root.getRight() == null || root.getLeft() == null && root.getRight() != null ){
            return 1;
        }
        return 2;
        
    }
    
    
    public int getHeight(Node root){
        Node head = root;
        int h_left = 0;
        int h_right = 0;
        if(head.getLeft() != null){
            h_left = getHeight(head.getLeft());
        }
        if(head.getRight()!= null){
            h_right = getHeight(head.getRight());
        }
        if (h_right > h_left){
            return h_right +1;
        }
        return h_left+1;
    }
    
    //Esquerda -> No -> Direita
    public  void inOrderTraversal(Node root){
        Node head = root;
        if (head == null){
            System.out.println("Null");
        }
        if(head.getLeft() != null){
            inOrderTraversal(head.getLeft());
        }
        System.out.print(head.getData() + " ");
        if(head.getRight() != null){
            inOrderTraversal(head.getRight());
        }
    }
    
    //No -> esquerda -> Direita
    public void preOrderTraversal(Node root){
        Node head = root;
         if (head == null){
            System.out.println("Null");
        }
         System.out.print(head.getData() + " ");
         if(head.getLeft() != null){
            preOrderTraversal(head.getLeft());
         }
         if(head.getRight() != null){
             preOrderTraversal(head.getRight());
         }
    }
    
    
    //Esquerda -> Direita -> No
    public void postOrderTraversal(Node root){
        Node head = root;
        if(head.getLeft() != null){
            postOrderTraversal(head.getLeft());
        }
        if(head.getRight()!= null){
            postOrderTraversal(head.getRight());
        }
        System.out.print (head.getData() + " ");
    }
    
   
    public void levelOrderTraversal(Node root){
        Node head = root;
        Queue<Node> fila = new LinkedList<>();
        fila.add(head);
        while(!fila.isEmpty()){
           head = fila.remove();
           System.out.print(head.getData() + " ");
           if(head.getLeft() != null){
               fila.add(head.getLeft());
           }
           if (head.getRight() != null){
               fila.add(head.getRight());
           }
        }
    }
    
 

}
