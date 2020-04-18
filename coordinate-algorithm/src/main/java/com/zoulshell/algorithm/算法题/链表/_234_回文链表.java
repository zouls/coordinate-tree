package com.zoulshell.algorithm.算法题.链表;

//请判断一个链表是否为回文链表。
//
// 示例 1:
//
// 输入: 1->2
//输出: false
//
// 示例 2:
//
// 输入: 1->2->2->1
//输出: true
//
//
// 进阶：
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
// Related Topics 链表 双指针
public class _234_回文链表 {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;


        System.out.println(l1);
        new _234_回文链表().isPalindrome(l1);

        System.out.println(l1);


    }

    public boolean isPalindrome(ListNode head) {

        // 只有一个节点的时候返回true,如果为null的时候也为true
        if (head == null || head.next == null) return true;

        // 只有两个节点的时候判断一下这两个节点是否相等,相等则为true,否则则为false
        if (head.next.next == null) return head.val == head.next.val;

        // 思路: 找到中心点,然后将右侧的链表进行翻转,
        // 然后分别从左右链表的头节点开始遍历,
        // 然后对比是否相等,如果不等返回false,如果一直遍历到右边链表的尾节点为null都是相等的,那么就返回true

        ListNode midNode = findMidNode(head);

        // 返回右边链表的头节点,其实就是整个原来的链表的尾节点
        ListNode rHead = reverseList(midNode.next);
        ListNode lHead = head;

        // 用于恢复原链表
        ListNode recoverHead = rHead;

        boolean result = true;
        while (rHead != null) {
            if (lHead.val != rHead.val) {
                result = false;
                break;
            }
            lHead = lHead.next;
            rHead = rHead.next;
        }

        // 如果要求不破坏原来的链表的话,这里可以再次翻转链表
        reverseList(recoverHead);

        return result;
    }

    /**
     * 翻转单向链表(递归方法)
     */
    private ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * 找出链表的中心点
     */
    private ListNode findMidNode(ListNode head) {

        // 思路:使用快慢指针

        // 规律:
        // 如果链表的节点个数为奇数
        // fast每次走两个,slow走一个
        // F.next为null的时候slow正好在mid上面
        // 如果链表的节点的个数为偶数
        // F.next.next为null的时候,slow正好在mid上面

        if (head == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "->" + next;
        }
    }
}
