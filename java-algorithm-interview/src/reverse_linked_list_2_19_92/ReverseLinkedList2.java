package reverse_linked_list_2_19_92;

public class ReverseLinkedList2 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        int left = 2, right = 5;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode node = reverseBetween(node1, left, right);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode root = node;
        ListNode start, end;
        for(int i = 0 ; i < left - 1 ; i++) node = node.next;
        start = node.next;
        for(int i = 0 ; i < right - left ; i++) {
            end = start.next;
            
            start.next = end.next;
            end.next = node.next;
            node.next = end;
        }
        return root.next;
        
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
