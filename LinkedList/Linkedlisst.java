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
    void pop_Front(){
        if(head==null){
            return;
        }
        else if (head == tail){
            System.out.println(head.data);
            head=null;
            tail=null;
            size--;
            return;
        }
        else{
            System.out.println(head.data);
            head=head.next;
            size--;
        }
    }
    void pop_Back(){
        if(head==null){
            return;
        }
        else if(head==tail){
            System.out.println(head.data);
            head=null;
            tail=null;
            size--;
        }
        else{
            Node temp=head;
            while(temp.next!=tail){
                temp=temp.next;
            }
            System.out.println(temp.next.data);
            temp.next=null;
            tail=temp;
            size--;
            return;

        }
    }
    void insert_Middle(int data){
        if(head==null){
            push_Back(data);
            return;
        }

        if(head==tail){
                push_Front(data);
                return;
        }

        Node slow=head;

        Node speed=head;

        while(speed.next!=null && speed.next.next!=null){
            slow=slow.next;
            speed=speed.next.next;
        }

        Node temp =slow.next;
        slow.next=new Node(data);
        slow.next.next=temp;
        size++;
        return ;
    }
    void insert(int postion,int data){
        if(postion<0 || postion>size){
            return;
        }
        else if(postion==0){
            push_Front(data);
            return;
        }
        else if(postion==size){
           push_Back(data);
           return;
        }
        else{
            Node temp = head;
            for(int i=0;i<postion-1;i++){
                temp=temp.next;
            }
            Node s_temp=temp.next;
            Node newNode=new Node(data);
            temp.next=newNode;
            newNode.next=s_temp;
            size++;
        }
    }

    
}
