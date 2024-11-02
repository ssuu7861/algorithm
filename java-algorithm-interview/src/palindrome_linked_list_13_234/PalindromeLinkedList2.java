package palindrome_linked_list_13_234;

public class PalindromeLinkedList2 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(isPalindrome2(node1));
    }
    
    public static boolean isPalindrome2(ListNode head){

        ListNode fast = head, slow = head;

        // 빠른 러너가 끝까지 달릴 때 까지 느린 러너와 함께 진행
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 홀수 개일 때 느린 러너가 한 칸 더 앞으로 가도록 처리
        if(fast != null) {
            slow = slow.next;
        }

        // 중간에 도달한 느린 러너를 기준으로 하여 역순 연결 리스트 뽑기
        ListNode rev = null;
        while(slow != null) {
            ListNode next = slow.next;
            slow.next = rev;
            rev = slow;
            slow = next;
        } // 끝나면 rev는 LinkedList의 가장 끝에서 중간지점까지 반대로 오는 역순 LinkedList가 됨.

        while(rev != null){
            if(rev.val != head.val) return false;
            rev = rev.next;
            head = head.next;
        }

        return true;


    }    
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
