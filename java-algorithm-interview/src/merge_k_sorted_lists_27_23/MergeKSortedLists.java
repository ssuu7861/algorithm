package merge_k_sorted_lists_27_23;

import java.util.PriorityQueue;

public class MergeKSortedLists {

  public static void main(String[] args) {
      ListNode node1 = new ListNode(1);
      ListNode node2 = new ListNode(4);
      ListNode node3 = new ListNode(5);
      ListNode node4 = new ListNode(1);
      ListNode node5 = new ListNode(3);
      ListNode node6 = new ListNode(4);
      ListNode node7 = new ListNode(2);
      ListNode node8 = new ListNode(7);
      
      node1.next = node2;
      node2.next = node3;
      node4.next = node5;
      node5.next = node6;
      node7.next = node8;
      ListNode[] nodes = new ListNode[]{node1, node4, node7};
      ListNode result = mergeKLists(nodes);
      while (result != null) {
        System.out.println(result.val);
        result = result.next;
      }
  }

  public static ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((n1, n2) -> {return n1.val - n2.val;});
    ListNode root = new ListNode(0);
    ListNode tmp = root;
    
    for(ListNode node : lists) if(node != null) priorityQueue.add(node);
    while (!priorityQueue.isEmpty()) {
      tmp.next = priorityQueue.poll();
      tmp = tmp.next;
      if(tmp.next != null) priorityQueue.add(tmp.next);
    }

    return root.next;
  }
}

class ListNode {
  int val;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  ListNode next;
}