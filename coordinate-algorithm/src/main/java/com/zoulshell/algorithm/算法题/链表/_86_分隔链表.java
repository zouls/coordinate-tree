package com.zoulshell.algorithm.算法题.链表;

//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
//
// 你应当保留两个分区中每个节点的初始相对位置。
//
// 示例:
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
//
// Related Topics 链表 双指针
public class _86_分隔链表 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode partition = new _86_分隔链表().partition(l1, 3);
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode partition(ListNode head, int x) {

        if (head == null) return null;

        // 思路:将链表拆分成两个链表,最后在合并起来;左边<x,右边>=x

        // 两对头尾指针
        // 两个虚拟头节点
        ListNode lDummyHead = new ListNode(0);
        ListNode rDummyHead = new ListNode(0);
        ListNode lTail = lDummyHead;
        ListNode rTail = rDummyHead;

        while (head != null) {
            if (head.val < x) {// 放入左链表
                lTail.next = head;
                lTail = lTail.next;
            } else {// 放入右链表
                rTail.next = head;
                rTail = rTail.next;
            }
            head = head.next;
        }
        // rTail处之后的值如果<x的话,就会全部放入到左链表中去,这个时候rTail的指针依然会指向那些<x的节点,所以这里必须设置为null
        rTail.next = null;

        // 合并链表
        lTail.next = rDummyHead.next;
        return lDummyHead.next;
    }
}
