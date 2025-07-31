package leetcode.editor.cn;

import java.util.*;

import leetcode.editor.common.*;

public class PartitionList {

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
        public ListNode partition(ListNode head, int x) {
            // 存放小于 x 的链表的虚拟头结点
            ListNode dummy1 = new ListNode(-1);
            // 存放大于 x 的链表的虚拟头结点
            ListNode dummy2 = new ListNode(-1);
            // p1, p2 指针负责生成结果链表
            ListNode p1 = dummy1, p2 = dummy2;
            // p 负责遍历原链表，类似合并两个有序链表的逻辑
            // 这里是将一个链表分解成两个链表
            ListNode p = head;
            // 开始遍历，比对
            while (p != null) {
                // 小于该值的放置在前面
                if (p.val < x) {
                    p1.next = p;
                    p1 = p1.next;
                } else { // 否则放置在后面
                    p2.next = p;
                    p2 = p2.next;
                }
                // 断开原链表中的每个节点的 next 指针，防止成环
                ListNode temp = p.next;
                // 置为空
                p.next = null;
                p = temp;
            }
            // 链接两个链表
            p1.next = dummy2.next;

            return dummy1.next;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)


    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        // put your test code here
        ListNode head = ListNode.createHead(new int[]{1,4,3,2,5,2});
        int x = 3;
        ListNode result = solution.partition(head, x);
        ListNode.print(result);
    }
}