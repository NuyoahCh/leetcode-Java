package leetcode.editor.cn;

import java.util.*;
import leetcode.editor.common.*;

public class MiddleOfTheLinkedList {

    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode middleNode(ListNode head) {
            // 快慢指针初始化指向 head
            ListNode slow = head, fast = head;
            // 快指针走到末尾时停止
            while (fast != null && fast.next != null) {
                // 慢指针走一步，快指针走两步
                slow = slow.next;
                fast = fast.next.next;
            }
            // 慢指针指向中点
            return slow;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    
    public static void main(String[] args) {
        Solution solution = new MiddleOfTheLinkedList().new Solution();
        // put your test code here
        ListNode head1 = ListNode.createHead(new int[]{1,2,3,4,5});
        ListNode result1 = solution.middleNode(head1);
        ListNode.print(result1);

        System.out.println();

        ListNode head2 = ListNode.createHead(new int[]{1,2,3,4,5,6});
        ListNode result2 = solution.middleNode(head2);
        ListNode.print(result2);
    }
}