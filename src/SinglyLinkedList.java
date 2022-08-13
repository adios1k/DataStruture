public class SinglyLinkedList {
    private ListNode head;

    private static class ListNode{
        private int data ; //cane be generic type
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void display(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");

    }

    public int length(){
        if(head==null) {
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while(current !=null){
            count ++;
            current = current.next;
        }

        return count;
    }

    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if(head ==null) {
            head = newNode;
        }
        else {
            ListNode current = head;
            while(current.next != null){
                  current= current.next;
            }
            current.next = newNode;
        }
    }

    // Assumption position value is from 1 to length of the linked list
    public void insert(int position , int value ){
        ListNode newNode = new ListNode(value);
        if (position == 1){
            newNode.next = head;
            head= newNode;
        }
        else{
            ListNode previous = head;
            int count = 1;
            while(count <position-1){
                previous =previous.next;
                count++;
            }
            newNode.next = previous.next;
            previous.next = newNode;
        }

    }

    public ListNode deleteFirst(){
        if(head == null){
           return null;
        }
        else{
            ListNode temp = head;
            head = head.next;
            temp.next = null;
            return temp;
        }
    }

    public void delete(int position){
        //position is valid and starting from 1
        if (position ==1){
            head = head.next;
        }else{
            ListNode previous = head;
            int count = 1;
            while (count <position -1){
                previous = previous.next;
                count ++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
        }

    }


    public ListNode deleteLast(){
        if(head == null || head.next== null){
            return head;
        }
        else{
            ListNode current = head;
            ListNode previous = null;
            while(current.next !=null){
                previous = current;
                current = current.next;
            }
            previous.next = null;
            return current;
        }
    }

    public static void main (String[] args){
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        // Now we will connect them together to form a chain
        sll.head.next= second;
        second.next=third;
        third.next= fourth;

        sll.display();
        System.out.println("Length is - " + sll.length());

        SinglyLinkedList sll1 = new SinglyLinkedList();
        sll1.insertFirst(11);
        sll1.insertFirst(8);
        sll1.insertFirst(1);
        sll1.insertLast(55);
        sll1.display();

        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll2.insert(1,11); // 11--> null
        sll2.insert(1, 8); //8-->11-->null
        sll2.insert(2, 5); //8 -->5-->11-->null
        sll2.insert(3, 10);//8 -->5-->10-->11-->null
        sll2.display();
        System.out.println(sll2.deleteFirst().data);
        sll2.display();
        System.out.println(sll2.deleteLast().data);
        sll2.display();
        sll2.delete(2);
        sll2.display();
        sll2.delete(1);
        sll2.display();

    }
}
