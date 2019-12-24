

class Node<K extends Comparable<K>> implements Comparable<K>  {
    K key;

    Node left;
    Node right;
    int height;

    Node(K key){
        this.key=key;
        this.height=1;
        this.left=null;
        this.right=null;
    }


    @Override
    public int compareTo(K o) {
        return  o.compareTo(key);
    }
}

public class AVLTree<K extends Comparable> {

    Node root=null;


    int height(Node node){
        if(node==null){
            return 0;
        }
        else{
            return node.height;
        }
    }


    int max(int a, int b){
        if(a>b){
            return a;
        }else{
            return b;
        }
    }


    public int balancefactor(Node n){
        if(n==null){
            return 0;
        }
        return height(n.left)-height(n.right);
    }


    public Node inserthelp(Node root, K key){
        if(root==null){
            root=new Node(key);
            return root;
        }else{
            if(key.compareTo((K)root.key)<0){
                root.left=inserthelp(root.left,key);
            }
            else if(key.compareTo((K)root.key)>0){
                root.right=inserthelp(root.right,key);
            }else {
                return root;
            }

            root.height= 1+max(height(root.left),height(root.right));
            int balancefactor=balancefactor(root);


            if (balancefactor > 1 && key.compareTo((K)root.left.key)<0)
                return rightRotate(root);

            if (balancefactor< -1 && key.compareTo((K)root.right.key)>0)
                return leftRotate(root);


            if (balancefactor > 1 && key.compareTo((K)root.left.key)>0) {
                root.left = leftRotate(root.left);
                return rightRotate(root);
            }


            if (balancefactor < -1 && key.compareTo((K)root.right.key)<0) {
                root.right = rightRotate(root.right);
                return leftRotate(root);
            }




        }
        return root;

    }



    private Node rightRotate(Node node){
        Node leftchild=node.left;
        Node leftrightgrandc=leftchild.right;
        leftchild.right=node;
        node.left=leftrightgrandc;

        node.height=1+max(height(node.left),height(node.right));
        leftchild.height=1+max(height(leftchild.left),height(leftchild.right));

        return leftchild;
    }

    private Node leftRotate(Node node){

        Node rightchild=node.right;
        Node rightleftgrandc=rightchild.left;
        rightchild.left=node;
        node.right=rightleftgrandc;

        node.height=1+max(height(node.left),height(node.right));
        rightchild.height=1+max(height(rightchild.right),height(rightchild.left));

        return rightchild;
    }


    public boolean insert(K key){
        root=inserthelp(root,key);
        return true;
    }






    public Node searchhelp(Node root, K key){

        if (root==null || key.compareTo((K)root.key )== 0) {

            return root;
        }
        if(key.compareTo(root.key)<0){

            return  searchhelp(root.left,key);
        }
        else if(key.compareTo(root.key)>0){
            return searchhelp(root.right,key);
        }else {
            return root;
        }
    }

    public K get(K key)
    {  Node node=searchhelp(root,key);
        if(node!=null){
            return (K)node.key;
        }else{
            return null;
        }

    }



    public void inOrderhelper(Node root, Array<K> array){

        Node node=root;
        if(node!=null){
            array.add((K)node.key);
            inOrderhelper(node.left,array);
            inOrderhelper(node.right,array);
        }

    }

    public Array<K> inOrder(Node root){
        Array<K> array=new Array<>();
        inOrderhelper(root,array);
        return array;
    }



}
