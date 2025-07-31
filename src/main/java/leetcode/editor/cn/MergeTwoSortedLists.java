package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class MergeTwoSortedLists {

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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            // 创建虚拟头节点
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            ListNode p1 = list1, p2 = list2;

            // 遍历比较
            while (p1 != null && p2 != null) {
                if (p1.val < p2.val) {
                    p.next = p1;
                    p1 = p1.next;
                } else {
                    p.next = p2;
                    p2 = p2.next;
                }
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
        Solution solution = new MergeTwoSortedLists().new Solution();
        // put your test code here
        ListNode head1 = ListNode.createHead(new int[]{1,2,4});
        ListNode head2 = ListNode.createHead(new int[]{1,3,4});
        ListNode result1 = solution.mergeTwoLists(head1, head2);
        ListNode.print(result1);

        System.out.println();

        ListNode head3 = ListNode.createHead(new int[]{});
        ListNode head4 = ListNode.createHead(new int[]{0});
        ListNode result2 = solution.mergeTwoLists(head3, head4);
        ListNode.print(result2);
    }
}