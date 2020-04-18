package com.zoulshell.algorithm.算法题.链表;

//删除链表中等于给定值 val 的所有节点。
//
// 示例:
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
//
// Related Topics 链表
public class _203_移除链表元素 {

    //    public ListNode removeElements(ListNode head, int val) {
//
//        // 新链表的头尾节点指针
//        ListNode newHead = null;
//        ListNode newTail = null;
//
//        while (head != null) {
//
//            if (head.val != val) {// 不是要删除的元素则放入到新的链表中去
//                if (newTail == null) {// 说明之前的值全是等于val的,head是第一个不等于val的
//                    newHead = head;// 直接初始化newHead和newTail
//                    newTail = head;
//                } else {
//                    newTail.next = head;// tail指向的后继指针指向当前head指向的符合要求的元素
//                    newTail = newTail.next;// tail指针后移
//                }
//            }
//            head = head.next;
//
//        }
//
//        if (newTail == null) {// 说明上面的while循环完全没有执行,链表为null或者所有元素都等于val
//            return null;
//        } else {
//            // 新链表的结尾的后继指针要设置为null,否则会忽略最后一个元素
//            newTail.next = null;
//        }
//
//        return newHead;
//    }

    /**
     * 虚拟头节点方法
     */
    public ListNode removeElements(ListNode head, int val) {

        // 新链表的头尾节点指针
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;

        while (head != null) {
            if (head.val != val) {// 不是要删除的元素则放入到新的链表中去
                newTail.next = head;// tail指向的后继指针指向当前head指向的符合要求的元素
                newTail = newTail.next;// tail指针后移
            }
            head = head.next;
        }
        // 新链表的结尾的后继指针要设置为null,否则会忽略最后一个元素
        newTail.next = null;

        return newHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
