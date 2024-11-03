package reverse_linked_list_15_206;

public class ReverseLinkedList2 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode node = reverseList(node1);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    public static ListNode reverse(ListNode node, ListNode prev){
        if(node == null) return prev;
        
        ListNode next = node.next;
        node.next = prev;
        return reverse(next, node);
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
