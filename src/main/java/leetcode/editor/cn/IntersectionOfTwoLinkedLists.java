package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class IntersectionOfTwoLinkedLists {

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            // 分别指向两个头节点
            ListNode p1 = headA, p2 = headB;
            while (p1 != p2) {
                if (p1 == null) {
                    p1 = headB;
                } else {
                    p1 = p1.next;
                }
                if (p2 == null) {
                    p2 = headA;
                } else {
                    p2 = p2.next;
                }
            }
            return p1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
        // put your test code here
        ListNode listA = ListNode.createHead(new int[]{4, 1, 8, 4, 5});
        ListNode listB = ListNode.createHead(new int[]{5, 6, 1, 8, 4, 5});
        ListNode res = solution.getIntersectionNode(listA, listB);
        ListNode.print(res);

    }
}