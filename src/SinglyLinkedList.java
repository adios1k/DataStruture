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

    public boolean find(ListNode head, int searchKey){
        if (head ==null){
            return false;
        }
        ListNode current = head;
        while(current!= null){
            if(current.data == searchKey){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public ListNode reverse(ListNode head){
        if(head == null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current =next;
        }
        return previous;
    }

    public ListNode getMiddleNode(){
        if(head ==null){
            return null;
        }
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while(fastPtr != null && fastPtr.next !=null){
            slowPtr = slowPtr.next;
            fastPtr= fastPtr.next.next;
        }
        return slowPtr;
    }

    public ListNode getNthNodeFromEnd(int n){
        if (head ==null){
            return null;
        }
        if (n <=0){
            throw new IllegalCallerException("Invalid value of n " + n);
        }
        ListNode masterPtr = head;
        ListNode refPtr = head;
        int count = 0;
        while(count <n){
            if (refPtr == null){
                throw new IllegalCallerException("Length input greater than length of the list " + n);
            }
            refPtr = refPtr.next;
            count ++;
        }
        while(refPtr != null){
            refPtr = refPtr.next;
            masterPtr = masterPtr.next;
        }
        return masterPtr;
    }

    public void removeDuplicates(){
        if (head == null){
            return;
        }
        ListNode current = head;
        while(current != null && current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }
            else{
                current = current.next;
            }
        }

    }
    public ListNode insertInSortedList(int value){
        ListNode newNode = new ListNode(value);
        if(head == null){
            return newNode;
        }
        ListNode current = head;
        ListNode temp = null;
        while(current!= null && current.data < newNode.data){
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return head;
    }

    public void deleteNode(int key){
        ListNode current = head;
        ListNode temp = null;
        if(current.data == key){
            head = current.next;
            return;
        }
        while(current!=null && current.data != key){
            temp = current;
            current =current.next;
        }
        if(current ==null){
            return;
        }
        temp.next = current.next;
    }

    public boolean containsLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while(fastPtr!=null && fastPtr.next !=null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr){
                return true;
            }
        }
        return false;
    }

    public void createALoopInLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;

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
        sll.display();
        ListNode nthnode= sll.getNthNodeFromEnd(3);
        System.out.println("3 rd node from list " + nthnode.data);

        SinglyLinkedList sll1 = new SinglyLinkedList();
        sll1.insertFirst(11);
        sll1.insertFirst(8);
        sll1.insertFirst(1);
        sll1.insertLast(55);
        sll1.display();
        System.out.println("Middle Node is " + sll1.getMiddleNode().data);
        sll1.insertLast(12);
        System.out.println("Middle Node is " + sll1.getMiddleNode().data);
        sll1.insertLast(25);
        System.out.println("Middle Node is " + sll1.getMiddleNode().data);
        System.out.println("Post reverse");
        SinglyLinkedList reversed = new SinglyLinkedList();
        reversed.head = sll1.reverse(sll1.head);
        reversed.display();


        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll2.insert(1,11); // 11--> null
        sll2.insert(1, 8); //8-->11-->null
        sll2.insert(2, 5); //8 -->5-->11-->null
        sll2.insert(3, 10);//8 -->5-->10-->11-->null
        sll2.display();
        System.out.println("Is 29 found in Linked list " + sll2.find(sll2.head, 29));
        System.out.println("Is 5 found in Linked list " + sll2.find(sll2.head, 5));
        System.out.println(sll2.deleteFirst().data);
        sll2.display();
        System.out.println(sll2.deleteLast().data);
        sll2.display();
        sll2.delete(2);
        sll2.display();


        SinglyLinkedList sll3 = new SinglyLinkedList();
        sll3.insertFirst(1);
        sll3.insertFirst(1);
        sll3.insertFirst(2);
        sll3.insertFirst(2);
        sll3.insertFirst(2);
        sll3.insertFirst(4);
        sll3.insertFirst(5);
        sll3.display();
        sll3.removeDuplicates();
        sll3.display();

        SinglyLinkedList sll4 = new SinglyLinkedList();
        sll4.insertFirst(16);
        sll4.insertFirst(10);
        sll4.insertFirst(8);
        sll4.insertFirst(6);
        sll4.insertFirst(4);
        sll4.insertFirst(3);
        sll4.insertFirst(1);
        sll4.display();
        sll4.insertInSortedList(7);
        sll4.display();
        sll4.deleteNode(7);
        sll4.display();

        SinglyLinkedList sll5 = new SinglyLinkedList();
        sll5.createALoopInLinkedList();
        System.out.println(sll5.containsLoop());
    }

}
