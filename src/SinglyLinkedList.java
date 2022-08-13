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
}
