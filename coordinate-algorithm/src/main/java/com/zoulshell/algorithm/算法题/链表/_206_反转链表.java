package com.zoulshell.algorithm.算法题.链表;

//反转一个单链表。
//
// 示例:
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL
//
// 进阶:
//你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
// Related Topics 链表
public class _206_反转链表 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        new _206_反转链表().reverseList(l1);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
//        // 递归方式调用
//        // head之后的部分全部已经反转好了,就剩head了
//        ListNode newHead = reverseList(head.next);
//        head.next.next = head;// 将head.next也就是反转好的链表的最后一个节点的下一个节点指向head
//        head.next = null;// 这个时候head的next还是指向反转好的链表的最后一个节点,所以要设置为null,因为这个时候head已经成为了反转好的链表的最后一个节点了
//
//        return newHead;

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }
}
