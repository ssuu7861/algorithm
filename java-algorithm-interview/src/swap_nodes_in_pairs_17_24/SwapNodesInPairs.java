package swap_nodes_in_pairs_17_24;

public class SwapNodesInPairs {
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

        ListNode result = swapPairs(node1);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    public static ListNode swapPairs(ListNode head){
        ListNode node = new ListNode(0);
        ListNode root = node;
        node.next = head;
        while(node.next != null && node.next.next != null) {
            ListNode x = node.next;
            ListNode y = node.next.next;
            x.next = y.next;
            node.next = y;
            node.next.next = x;
            node = node.next.next;
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
