//The queue was implemented previously by myself in assignment2 on producer-comsumer problem. I have just modified he cose a bit to allow all objects to be stored.
public class Queue<V>{

    final class Node<V>{
        V data;
        Node<V> next;
        Node(V data){
            this.data=data;
        }
    }


    public int  currentSize;
    public Node<V> head;
    public Node<V> tail;

    public Queue() {

        currentSize=0;
        head=tail=null;

    }

    public int size() {
        return currentSize;
    }

    public boolean isEmpty() {
        if(currentSize==0){
            return true;
        }
        return false;
    }


   /* public boolean isFull() {
        if(currentSize==capacity){
            return true;
        }
        return false;
    }*/

    public void enqueue(V data) {
        Node<V> newnode=new Node<V>(data);
        if(currentSize==0){
            head=tail=newnode;
        }else{
            tail.next=newnode;
            tail=newnode;
        }
        currentSize++;
    }

    public V dequeue() {
        if(!isEmpty()){
            Node<V> node=head;
            head=head.next;
            currentSize--;
            return node.data;
        }else{
            tail=null;
            return null;
        }



    }

}

