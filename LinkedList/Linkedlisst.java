package LinkedList;
class Node{
    int data;
    Node next;

    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class Linkedlisst {

    Node head;
    Node tail;
    int size=0;

    Linkedlisst(){
    }

    Linkedlisst(int data){
        push_Back(data);
    }

    void push_Front(int data){
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;

        if (tail == null) {
            tail = head;
        }

        size++;
    }

    void push_Back(int data){
        Node newTail = new Node(data);

        if (head == null) {
            head = newTail;
            tail = newTail;
        }
        else {
            tail.next = newTail;
            tail = newTail;
        }

        size++;
    }

    void printList(){
        Node current = head;

        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }

        System.out.println();
    }
    void pop_Front()

    
}
