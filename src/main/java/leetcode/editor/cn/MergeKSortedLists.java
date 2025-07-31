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

        // 定义：合并 lists[start..end] 为一个有序链表
        ListNode mergeKLists3(ListNode[] list, int start, int end) {
            // 特殊判断
            if (start == end) {
                return list[start];
            }
            int mid = start + (end - start) / 2;
            // 合并左半边 lists[start..mid] 为一个有序链表
            ListNode left = mergeKLists3(list, start, mid);
            // 合并右半边 lists[start..mid] 为一个有序链表
            ListNode right = mergeKLists3(list, mid + 1, end);

            // 合并左右两个有序链表
            return mergeTwoLists(left, right);
        }

        // 双指针技巧合并两个有序链表
        ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1), p = dummy;
            ListNode p1 = l1, p2 = l2;
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