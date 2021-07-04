//21. Merge Two Sorted Lists
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // corner case
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? Integer.MAX_VALUE : l1.val;
            int y = l2 == null ? Integer.MAX_VALUE : l2.val;

            if (x < y) {
                curr.next = new ListNode(x);
                l1 = l1.next;
            } else {
                curr.next = new ListNode(y);
                l2 = l2.next;
            }
            curr = curr.next;
        }
        return dummy.next;

    }
}