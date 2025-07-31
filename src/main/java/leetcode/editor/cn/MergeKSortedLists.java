package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class MergeKSortedLists {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            return mergeKLists3(lists, 0, lists.length - 1);
        }

        private ListNode mergeKLists3(ListNode[] lists, int start, int end) {
            if (start == end) {
                return lists[start];
            }
            int mid = start + (end - start) / 2;
            ListNode left = mergeKLists3(lists, start, mid);
            ListNode right = mergeKLists3(lists, mid + 1, end);
            return mergeTwoList(left, right);
        }

        private ListNode mergeTwoList(ListNode l1, ListNode l2) {
            // create the dummy
            ListNode dummy = new ListNode(-1), p = dummy;
            ListNode p1 = l1, p2 = l2;
            // loop and compare
            while (p1 != null && p2 != null) {
                // compare
                if (p1.val < p2.val) {
                    p.next = p1;
                    p1 = p1.next;
                } else {
                    p.next = p2;
                    p2 = p2.next;
                }
                // p -> next
                p = p.next;
            }
            if (p1 != null) {
                p.next = p1;
            }
            if (p2 != null) {
                p.next = p2;
            }
            return dummy.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        // put your test code here
        // 创建三个有序链表
        ListNode l1 = ListNode.createHead(new int[]{1, 4, 5});
        ListNode l2 = ListNode.createHead(new int[]{1, 3, 4});
        ListNode l3 = ListNode.createHead(new int[]{2, 6});

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        ListNode result = solution.mergeKLists(lists);

        ListNode.print(result);

    }
}